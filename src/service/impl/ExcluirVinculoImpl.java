package service.impl;

import repositorio.RepositorioAcademia;
import service.ExcluirVinculoService;

public class ExcluirVinculoImpl implements ExcluirVinculoService {
    private final RepositorioAcademia repositorio;

    public ExcluirVinculoImpl(RepositorioAcademia repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void excluirVinculoAluno(String CPF) {
        if (!repositorio.existeAluno(CPF)) {
            throw new IllegalArgumentException("Aluno não encontrado.");
        }
        repositorio.deletarAluno(CPF);
    }

    @Override
    public void excluirVinculoInstrutor(String CPF) {
        if (!repositorio.existeInstrutor(CPF)) {
            throw new IllegalArgumentException("Instrutor não encontrado.");
        }
        repositorio.deletarInstrutor(CPF);
    }
}
