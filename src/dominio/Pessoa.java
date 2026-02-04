package dominio;

import dominio.enums.Sexo;

public abstract class Pessoa {
    protected String nome;
    protected String CPF;
    protected Sexo sexo;
    protected String telefone;
    protected int idade;

    public Pessoa(String nome, String CPF, Sexo sexo, String telefone, int idade) {
        this.nome = nome;
        this.CPF = CPF;
        this.sexo = sexo;
        this.telefone = telefone;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", sexo=" + sexo +
                ", telefone=" + telefone +
                ", idade=" + idade +
                '}';
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

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
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
