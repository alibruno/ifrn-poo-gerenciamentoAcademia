package service.impl;

import dominio.Aluno;
import dominio.Contrato;
import dominio.Instrutor;
import dominio.enums.PlanoTreino;
import repositorio.RepositorioAcademia;
import service.ConsultaContratoService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ConsultaContratoImpl implements ConsultaContratoService {
    private final RepositorioAcademia repositorio;

    public ConsultaContratoImpl(RepositorioAcademia repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public String gerarRelatorioTudo() {
        return "Total: " + (this.repositorio.getAlunosValues().size() + this.repositorio.getInstrutoresValues().size()) +
                "\n-----------------------------------\n" +
                gerarRelatorioAluno() +
                "\n-----------------------------------\n" +
                gerarRelatorioInstrutor();
    }

    @Override
    public String gerarRelatorioAluno() {
        return gerarRelatorioGenerico("Aluno", this.repositorio.getAlunosValues());
    }

    @Override
    public String gerarRelatorioInstrutor() {
        return gerarRelatorioGenerico("Instrutor", this.repositorio.getInstrutoresValues());
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

    private <T> String formatarLista(Collection<T> list) {
        return list.stream()
                .map(T::toString)
                .collect(Collectors.joining("\n"));
    }

    private <T extends Contrato> Map<Boolean, List<T>> gerarMapaCancelouOuNao(Collection<T> list) {
        return list.stream()
                .collect(Collectors.partitioningBy(Contrato::isCancelouMatricula));
    }

    private <T extends Contrato> String gerarRelatorioGenerico(String nome, Collection<T> list) {
        Map<Boolean, List<T>> mapa = gerarMapaCancelouOuNao(list);
        return "Total de '" + nome + "': " + list.size() +
                "\n'" + nome + "' ativos (" + mapa.get(false).size() + "):\n" + formatarLista(mapa.get(false)) +
                "\n\n'" + nome + "' inativos (" + mapa.get(true).size() + "):\n" + formatarLista(mapa.get(true));
    }

    private BigDecimal calcularDiferencaComFiltragem(Predicate<? super Aluno> filterParamAluno, Predicate<? super Instrutor> filterParamInstrutor) {
        BigDecimal totalAlunos = this.repositorio.getAlunosValues().stream()
                .filter(filterParamAluno)
                .map(Aluno::getPlano)
                .map(PlanoTreino::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalInstrutor = this.repositorio.getInstrutoresValues().stream()
                .filter(filterParamInstrutor)
                .map(Instrutor::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalAlunos.subtract(totalInstrutor);
    }
}
