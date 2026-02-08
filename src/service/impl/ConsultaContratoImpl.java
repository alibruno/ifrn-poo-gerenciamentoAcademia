package service.impl;

import dominio.Aluno;
import dominio.Contrato;
import dominio.Instrutor;
import dominio.enums.PlanoTreino;
import repositorio.RepositorioAcademia;
import service.ConsultaContratoService;
import service.dto.RelatorioAlunoDTO;
import service.dto.RelatorioInstrutorDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ConsultaContratoImpl implements ConsultaContratoService {
    private final RepositorioAcademia repositorio;

    public ConsultaContratoImpl(RepositorioAcademia repositorio) {
        this.repositorio = repositorio;
    }

    // As listas estão ordenadas por nome

    @Override
    public List<RelatorioAlunoDTO> listarRelatorioAlunos() {
        return repositorio.listarAlunos().stream()
                .map(RelatorioAlunoDTO::fromEntity)
                .sorted(Comparator.comparing(RelatorioAlunoDTO::nome))
                .collect(Collectors.toList());
    }

    @Override
    public List<RelatorioInstrutorDTO> listarRelatorioInstrutores() {
        return repositorio.listarInstrutores().stream()
                .map(RelatorioInstrutorDTO::fromEntity)
                .sorted(Comparator.comparing(RelatorioInstrutorDTO::nome))
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal getLucro() {
        return calcularLucroComFiltragem(
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
        return calcularLucroComFiltragem(
                a -> a.getDataDeInclusao().getYear() <= year &&
                        (!a.isCancelouMatricula() || a.getDataDeCancelamento().getYear() > year),
                i -> i.getDataDeInclusao().getYear() <= year &&
                        (!i.isCancelouMatricula() || i.getDataDeCancelamento().getYear() > year)
        );
    }

    private BigDecimal calcularLucroComFiltragem(Predicate<? super Aluno> filterParamAluno, Predicate<? super Instrutor> filterParamInstrutor) {
        BigDecimal totalAlunos = repositorio.listarAlunos().stream()
                .filter(filterParamAluno)
                .map(Aluno::getPlano)
                .map(PlanoTreino::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalInstrutor = repositorio.listarInstrutores().stream()
                .filter(filterParamInstrutor)
                .map(Instrutor::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalAlunos.subtract(totalInstrutor);
    }
}
