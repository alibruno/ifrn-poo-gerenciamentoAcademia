package service.impl;

import dominio.Aluno;
import dominio.Contrato;
import repositorio.RepositorioAcademia;
import service.EncerrarContratoService;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class EncerrarContratoImpl implements EncerrarContratoService {
    private final RepositorioAcademia repositorio;

    public EncerrarContratoImpl(RepositorioAcademia repositorio) {
        this.repositorio = repositorio;
    }

    private <T extends Contrato> void encerrarContrato(String CPF, Map<String, T> contratoMap) {
        T t = Optional.ofNullable(contratoMap.get(CPF)).orElseThrow(() -> new IllegalArgumentException("CPF inválido."));
        if (t.isCancelouMatricula()) {
            throw new IllegalArgumentException("Pessoa com contrato já encerrado.");
        }
        t.setCancelouMatricula(Boolean.TRUE);
        t.setDataDeCancelamento(LocalDate.now());
    }

    @Override
    public void encerrarContratoAluno(String CPF) {
        encerrarContrato(CPF, repositorio.getAlunos());
    }

    @Override
    public void encerrarContratoInstrutor(String CPF) {
        encerrarContrato(CPF, repositorio.getInstrutores());
    }
}
