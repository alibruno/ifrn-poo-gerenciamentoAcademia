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
        if (repositorio.existeAluno(CPF)) {
            throw new IllegalArgumentException("CPF já cadastrado.");
        }
        if (ValidarAtributos.isIdadeInvalida(idade)) {
            throw new IllegalArgumentException("Idade inválida.");
        }

        String cpfFormatado = ValidarAtributos.formatarCPF(CPF);
        String telefoneFormatado = ValidarAtributos.formatarTelefone(telefone);
        Sexo sexo = ValidarAtributos.validarSexo(sexoString);
        PlanoTreino plano = ValidarAtributos.validarPlanoTreino(planoString);
        FrequenciaPagamento frequencia = ValidarAtributos.validarFrequenciaPagamento(frequenciaString);

        Aluno novoAluno = new Aluno(nome, cpfFormatado, sexo, telefoneFormatado, idade, dataDeInclusao, matricula, plano, frequencia);
        repositorio.salvarAluno(novoAluno);
    }

    @Override
    public void cadastrarInstrutor(String nome, String CPF, String sexoString, String telefone, int idade, String ID, int cargaHoraria, String modalidadeTreinoString, String salarioString) {
        LocalDate dataDeInclusao = LocalDate.now();
        if (repositorio.existeInstrutor(CPF)) {
            throw new IllegalArgumentException("CPF já cadastrado.");
        }
        if (ValidarAtributos.isIdadeInvalida(idade)) {
            throw new IllegalArgumentException("Idade inválida.");
        }

        String cpfFormatado = ValidarAtributos.formatarCPF(CPF);
        String telefoneFormatado = ValidarAtributos.formatarTelefone(telefone);
        Sexo sexo = ValidarAtributos.validarSexo(sexoString);
        ModalidadeTreino modalidadeTreino = ValidarAtributos.validarModalidadeTreino(modalidadeTreinoString);
        BigDecimal salario = new BigDecimal(salarioString);

        Instrutor novoInstrutor = new Instrutor(nome, cpfFormatado, sexo, telefoneFormatado, idade, dataDeInclusao, ID, cargaHoraria, modalidadeTreino, salario);
        repositorio.salvarInstrutor(novoInstrutor);
    }

}
