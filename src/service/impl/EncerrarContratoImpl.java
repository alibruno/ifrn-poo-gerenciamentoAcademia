package service.impl;

import dominio.Aluno;
import dominio.Contrato;
import dominio.Instrutor;
import repositorio.RepositorioAcademia;
import service.EncerrarContratoService;

import java.time.LocalDate;

public class EncerrarContratoImpl implements EncerrarContratoService {
    private final RepositorioAcademia repositorio;

    public EncerrarContratoImpl(RepositorioAcademia repositorio) {
        this.repositorio = repositorio;
    }

    private <T extends Contrato> void encerrarContrato(T contratado) {
        if (contratado.isCancelouMatricula()) {
            throw new IllegalArgumentException("Pessoa com contrato já encerrado.");
        }
        contratado.setCancelouMatricula(Boolean.TRUE);
        contratado.setDataDeCancelamento(LocalDate.now());
    }

    @Override
    public void encerrarContratoAluno(String CPF) {
        Aluno aluno = repositorio.buscarAluno(CPF)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado."));
        encerrarContrato(aluno);
    }

    @Override
    public void encerrarContratoInstrutor(String CPF) {
        Instrutor instrutor = repositorio.buscarInstrutor(CPF)
                .orElseThrow(() -> new IllegalArgumentException("Instrutor não encontrado."));
        encerrarContrato(instrutor);
    }
}
