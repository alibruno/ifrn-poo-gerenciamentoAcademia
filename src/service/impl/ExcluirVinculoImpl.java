package service.impl;

import dominio.Contrato;
import repositorio.RepositorioAcademia;
import service.ExcluirVinculoService;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public class ExcluirVinculoImpl implements ExcluirVinculoService {
    private final RepositorioAcademia repositorio;

    public ExcluirVinculoImpl(RepositorioAcademia repositorio) {
        this.repositorio = repositorio;
    }

    private <T extends Contrato> void excluirVinculo(String CPF, Map<String, T> contratoMap) {
        if (!contratoMap.containsKey(CPF)) {
            throw new IllegalArgumentException("CPF inválido ou não encontrado.");
        }
        contratoMap.remove(CPF);
    }

    @Override
    public void excluirVinculoAluno(String CPF) {
        excluirVinculo(CPF, repositorio.getAlunos());
    }

    @Override
    public void excluirVinculoInstrutor(String CPF) {
        excluirVinculo(CPF, repositorio.getInstrutores());
    }
}
