package dominio.enums;

public enum Sexo {
    MASCULINO("MASCULINO"),
    FEMININO("FEMININO");

    private final String nome;

    Sexo(String nome) {
        this.nome = nome;
    }

    public static Sexo sexoPorString(String nome) {
        for (Sexo sexo : values()) {
            if (sexo.getNome().equalsIgnoreCase(nome)) {
                return sexo;
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Sexo{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
