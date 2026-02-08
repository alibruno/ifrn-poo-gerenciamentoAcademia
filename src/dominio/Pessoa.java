package dominio;

import dominio.enums.Sexo;

import java.util.Objects;

public abstract class Pessoa {
    private String nome;
    private String CPF;
    private Sexo sexo;
    private String telefone;
    private int idade;

    public Pessoa(String nome, String CPF, Sexo sexo, String telefone, int idade) {
        this.nome = nome;
        this.CPF = CPF;
        this.sexo = sexo;
        this.telefone = telefone;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", sexo=" + sexo +
                ", telefone=" + telefone +
                ", idade=" + idade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(CPF, pessoa.CPF);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(CPF);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
