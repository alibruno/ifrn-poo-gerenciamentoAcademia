package service.impl;

import dominio.Aluno;
import dominio.Instrutor;
import dominio.enums.FrequenciaPagamento;
import dominio.enums.ModalidadeTreino;
import dominio.enums.PlanoTreino;
import dominio.enums.Sexo;
import repositorio.RepositorioAcademia;
import service.CadastroContratoService;
import service.ValidarAtributos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CadastroContratoImpl implements CadastroContratoService {
    private final RepositorioAcademia repositorio;

    public CadastroContratoImpl(RepositorioAcademia repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void cadastrarAluno(String nome, String CPF, String sexoString, String telefone, int idade, String matricula, String planoString, String frequenciaString) {
        LocalDate dataDeInclusao = LocalDate.now();
        if (repositorio.temCpfCadastrado(CPF)) {
            throw new IllegalArgumentException("CPF já cadastrado.");
        }
        if (ValidarAtributos.isCPFinvalido(CPF)) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        if (ValidarAtributos.isTelefoneInvalido(telefone)) {
            throw new IllegalArgumentException("Telefone inválido.");
        }
        if (ValidarAtributos.isIdadeInvalida(idade)) {
            throw new IllegalArgumentException("Idade inválida.");
        }

        Sexo sexo = ValidarAtributos.validarSexo(sexoString);
        PlanoTreino plano = ValidarAtributos.validarPlanoTreino(planoString);
        FrequenciaPagamento frequencia = ValidarAtributos.validarFrequenciaPagamento(frequenciaString);

        repositorio.getAlunos().put(CPF, new Aluno(nome, CPF, sexo, telefone, idade, dataDeInclusao, matricula, plano, frequencia));
    }

    @Override
    public void cadastrarInstrutor(String nome, String CPF, String sexoString, String telefone, int idade, String ID, int cargaHoraria, String modalidadeTreinoString, String salarioString) {
        LocalDate dataDeInclusao = LocalDate.now();
        if (repositorio.temCpfCadastrado(CPF)) {
            throw new IllegalArgumentException("CPF já cadastrado.");
        }
        if (ValidarAtributos.isCPFinvalido(CPF)) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        if (ValidarAtributos.isTelefoneInvalido(telefone)) {
            throw new IllegalArgumentException("Telefone inválido.");
        }
        if (ValidarAtributos.isIdadeInvalida(idade)) {
            throw new IllegalArgumentException("Idade inválida.");
        }

        Sexo sexo = ValidarAtributos.validarSexo(sexoString);
        ModalidadeTreino modalidadeTreino = ValidarAtributos.validarModalidadeTreino(modalidadeTreinoString);
        BigDecimal salario = new BigDecimal(salarioString);

        repositorio.getInstrutores().put(CPF, new Instrutor(nome, CPF, sexo, telefone, idade, dataDeInclusao, ID, cargaHoraria, modalidadeTreino, salario));
    }

}
