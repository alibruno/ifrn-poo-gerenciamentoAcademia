package dominio;

import dominio.enums.FrequenciaPagamento;
import dominio.enums.Sexo;
import dominio.enums.PlanoTreino;

import java.time.LocalDate;

public class Aluno extends Contrato {
    private String matricula;
    private PlanoTreino plano;
    private FrequenciaPagamento frequencia;

    // Aluno novo
    public Aluno(String nome, String CPF, Sexo sexo, String telefone, int idade, LocalDate dataDeInclusao, String matricula, PlanoTreino plano, FrequenciaPagamento frequencia) {
        super(nome, CPF, sexo, telefone, idade, dataDeInclusao, false, null);
        this.matricula = matricula;
        this.plano = plano;
        this.frequencia = frequencia;
    }

    // Aluno que já está inativo
    public Aluno(String nome, String CPF, Sexo sexo, String telefone, int idade, LocalDate dataDeInclusao, boolean cancelouMatricula, LocalDate dataDeCancelamento, String matricula, PlanoTreino plano, FrequenciaPagamento frequencia) {
        super(nome, CPF, sexo, telefone, idade, dataDeInclusao, cancelouMatricula, dataDeCancelamento);
        this.matricula = matricula;
        this.plano = plano;
        this.frequencia = frequencia;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula='" + matricula + '\'' +
                ", plano=" + plano +
                ", frequencia=" + frequencia +
                ", dataDeInclusao=" + dataDeInclusao +
                ", cancelouMatricula=" + cancelouMatricula +
                ", dataDeCancelamento=" + dataDeCancelamento +
                ", nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", sexo=" + sexo +
                ", telefone='" + telefone + '\'' +
                ", idade=" + idade +
                '}';
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public PlanoTreino getPlano() {
        return plano;
    }

    public void setPlano(PlanoTreino plano) {
        this.plano = plano;
    }

    public FrequenciaPagamento getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(FrequenciaPagamento frequencia) {
        this.frequencia = frequencia;
    }
}
