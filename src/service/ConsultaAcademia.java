package service;

import dominio.Aluno;
import dominio.Contrato;
import dominio.Instrutor;
import dominio.enums.PlanoTreino;
import interfaces.ConsultaAcademiaInterface;
import repositorio.RepositorioAcademia;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ConsultaAcademia implements ConsultaAcademiaInterface {

    @Override
    public String gerarRelatorioTudo() {
        return "Total: " + (RepositorioAcademia.alunos.size() + RepositorioAcademia.instrutores.size()) +
                "\n-----------------------------------\n" +
                gerarRelatorioAluno() +
                "\n-----------------------------------\n" +
                gerarRelatorioInstrutor();
    }

    @Override
    public String gerarRelatorioAluno() {
        return gerarRelatorioGenerico("Aluno", RepositorioAcademia.alunos);
    }

    @Override
    public String gerarRelatorioInstrutor() {
        return gerarRelatorioGenerico("Instrutor", RepositorioAcademia.instrutores);
    }

    @Override
    public BigDecimal getLucro() {
        return calcularDiferencaComFiltragem(
                a -> !a.isCancelouMatricula(),
                i -> !i.isCancelouMatricula()
        );
    }

    @Override
    public BigDecimal lucroPorAno(int year) {
        if (year < 2014 && year > LocalDate.now().getYear()) { // registro mais antigo -> 2014
            throw new IllegalArgumentException("Ano inválido!");
        }

        return calcularDiferencaComFiltragem(
                a -> !a.isCancelouMatricula() && a.getDataDeInclusao().getYear() <= year,
                i -> !i.isCancelouMatricula() && i.getDataDeInclusao().getYear() <= year
        );
    }

    private <T> String formatarLista(List<T> list) {
        return list.stream()
                .map(T::toString)
                .collect(Collectors.joining("\n"));
    }

    private <T extends Contrato> Map<Boolean, List<T>> gerarMapaCancelouOuNao(List<T> list) {
        Map<Boolean, List<T>> mapa = list.stream()
                .collect(Collectors.partitioningBy(Contrato::isCancelouMatricula));
        return mapa;
    }

    private <T extends Contrato> String gerarRelatorioGenerico(String nome, List<T> list) {
        Map<Boolean, List<T>> mapa = gerarMapaCancelouOuNao(list);
        return "Total de " + nome + ": " + list.size() +
                "\n" + nome + " ativos (" + mapa.get(false).size() + "):\n" + formatarLista(mapa.get(false)) +
                "\n\n" + nome + " inativos (" + mapa.get(true).size() + "):\n" + formatarLista(mapa.get(true));
    }

    private BigDecimal calcularDiferencaComFiltragem(Predicate<? super Aluno> filterParamAluno, Predicate<? super Instrutor> filterParamInstrutor) {
        int totalAlunosInt = RepositorioAcademia.alunos.stream()
                .filter(filterParamAluno)
                .map(Aluno::getPlano)
                .mapToInt(PlanoTreino::getValor)
                .sum();

        BigDecimal totalAlunos = BigDecimal.valueOf(totalAlunosInt);

        BigDecimal totalInstrutor = RepositorioAcademia.instrutores.stream()
                .filter(filterParamInstrutor)
                .map(Instrutor::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalAlunos.subtract(totalInstrutor);
    }
}
