package dominio;

import dominio.enums.ModalidadeTreino;
import dominio.enums.Sexo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Instrutor extends Contrato {
    private String ID;
    private int cargaHoraria;
    private ModalidadeTreino modalidadeTreino;
    private BigDecimal salario;

    // Instrutor novo
    public Instrutor(String nome, String CPF, Sexo sexo, String telefone, int idade, LocalDate dataDeInclusao, String ID, int cargaHoraria, ModalidadeTreino modalidadeTreino, BigDecimal salario) {
        super(nome, CPF, sexo, telefone, idade, dataDeInclusao, false, null);
        this.ID = ID;
        this.cargaHoraria = cargaHoraria;
        this.modalidadeTreino = modalidadeTreino;
        this.salario = salario;
    }

    // Instrutor que já está inativo
    public Instrutor(String nome, String CPF, Sexo sexo, String telefone, int idade, LocalDate dataDeInclusao, boolean cancelouMatricula, LocalDate dataDeCancelamento, String ID, int cargaHoraria, ModalidadeTreino modalidadeTreino, BigDecimal salario) {
        super(nome, CPF, sexo, telefone, idade, dataDeInclusao, cancelouMatricula, dataDeCancelamento);
        this.ID = ID;
        this.cargaHoraria = cargaHoraria;
        this.modalidadeTreino = modalidadeTreino;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Instrutor{" +
                super.toString() +
                ", ID='" + ID + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", modalidadeTreino=" + modalidadeTreino +
                ", salario=" + salario +
                '}';
    }

    public String getID() {
        return ID;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public ModalidadeTreino getModalidade() {
        return modalidadeTreino;
    }

    public void setModalidade(ModalidadeTreino modalidadeTreino) {
        this.modalidadeTreino = modalidadeTreino;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
