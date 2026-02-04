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
    RepositorioAcademia repositorioAcademia = new RepositorioAcademia();

    @Override
    public String gerarRelatorioTudo() {
        return "Total: " + (repositorioAcademia.getAlunos().size() + repositorioAcademia.getInstrutores().size()) +
                "\n-----------------------------------\n" +
                gerarRelatorioAluno() +
                "\n-----------------------------------\n" +
                gerarRelatorioInstrutor();
    }

    @Override
    public String gerarRelatorioAluno() {
        return gerarRelatorioGenerico("Aluno", repositorioAcademia.getAlunos());
    }

    @Override
    public String gerarRelatorioInstrutor() {
        return gerarRelatorioGenerico("Instrutor", repositorioAcademia.getInstrutores());
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
        if (year < 2014 || year > LocalDate.now().getYear()) { // registro mais antigo -> 2014
            throw new IllegalArgumentException("Ano inválido!");
        }

        //1. Ele entrou antes ou durante aquele ano.
        // 2. E (ele ainda está ativo OU ele cancelou depois daquele ano).
        return calcularDiferencaComFiltragem(
                a -> a.getDataDeInclusao().getYear() <= year &&
                        (!a.isCancelouMatricula() || a.getDataDeCancelamento().getYear() > year),
                i -> i.getDataDeInclusao().getYear() <= year &&
                        (!i.isCancelouMatricula() || i.getDataDeCancelamento().getYear() > year)
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
        BigDecimal totalAlunos = repositorioAcademia.getAlunos().stream()
                .filter(filterParamAluno)
                .map(Aluno::getPlano)
                .map(PlanoTreino::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalInstrutor = repositorioAcademia.getInstrutores().stream()
                .filter(filterParamInstrutor)
                .map(Instrutor::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalAlunos.subtract(totalInstrutor);
    }
}
