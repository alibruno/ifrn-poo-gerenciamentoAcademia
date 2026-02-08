package dominio;

import dominio.enums.Sexo;

import java.time.LocalDate;

public abstract class Contrato extends Pessoa {
    protected LocalDate dataDeInclusao;
    protected boolean cancelouMatricula;
    protected LocalDate dataDeCancelamento;

    public Contrato(String nome, String CPF, Sexo sexo, String telefone, int idade, LocalDate dataDeInclusao, boolean cancelouMatricula, LocalDate dataDeCancelamento) {
        super(nome, CPF, sexo, telefone, idade);
        this.dataDeInclusao = dataDeInclusao;
        this.cancelouMatricula = cancelouMatricula;
        this.dataDeCancelamento = dataDeCancelamento;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "dataDeInclusao=" + dataDeInclusao +
                ", cancelouMatricula=" + cancelouMatricula +
                ", dataDeCancelamento=" + dataDeCancelamento +
                ", nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", sexo=" + sexo +
                ", telefone='" + telefone + '\'' +
                ", idade=" + idade +
                '}';
    }

    public LocalDate getDataDeInclusao() {
        return dataDeInclusao;
    }

    public boolean isCancelouMatricula() {
        return cancelouMatricula;
    }

    public void setCancelouMatricula(boolean cancelouMatricula) {
        this.cancelouMatricula = cancelouMatricula;
    }

    public LocalDate getDataDeCancelamento() {
        return dataDeCancelamento;
    }

    public void setDataDeCancelamento(LocalDate dataDeCancelamento) {
        this.dataDeCancelamento = dataDeCancelamento;
    }
}
