package service.impl;

import dominio.Aluno;
import dominio.Instrutor;
import repositorio.RepositorioAcademia;
import service.EditarContratoService;
import service.ValidarAtributos;

import java.math.BigDecimal;

public class EditarContratoImpl implements EditarContratoService {
    private final RepositorioAcademia repositorio;

    public EditarContratoImpl(RepositorioAcademia repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void editarCampoAluno(String CPF, String campo, String alteracao) {
        Aluno aluno = repositorio.buscarAluno(CPF)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado."));

        switch (campo.toUpperCase()) {
            case "NOME" -> aluno.setNome(alteracao);

            case "TELEFONE" -> aluno.setTelefone(ValidarAtributos.formatarTelefone(alteracao));

            case "PLANO", "PLANO TREINO" -> aluno.setPlano(ValidarAtributos.validarPlanoTreino(alteracao));

            case "FREQUENCIA", "FREQUENCIA PAGAMENTO" ->
                    aluno.setFrequencia(ValidarAtributos.validarFrequenciaPagamento(alteracao));

            default -> throw new IllegalArgumentException("Campo inválido para edição: " + campo);
        }
    }

    @Override
    public void editarCampoInstrutor(String CPF, String campo, String alteracao) {
        Instrutor instrutor = repositorio.buscarInstrutor(CPF)
                .orElseThrow(() -> new IllegalArgumentException("Instrutor não encontrado."));

        switch (campo.toUpperCase()) {
            case "NOME" -> instrutor.setNome(alteracao);

            case "TELEFONE" -> instrutor.setTelefone(ValidarAtributos.formatarTelefone(alteracao));

            case "CARGA HORARIA" -> instrutor.setCargaHoraria(Integer.parseInt(alteracao));

            case "MODALIDADE", "MODALIDADE TREINO" ->
                    instrutor.setModalidade(ValidarAtributos.validarModalidadeTreino(alteracao));

            case "SALARIO" -> instrutor.setSalario(new BigDecimal(alteracao));

            default -> throw new IllegalArgumentException("Campo inválido para edição: " + campo);
        }
    }
}
