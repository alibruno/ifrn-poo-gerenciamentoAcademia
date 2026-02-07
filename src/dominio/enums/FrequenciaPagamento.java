package dominio.enums;

public enum FrequenciaPagamento {
    DIARIA("DIARIA"),
    MENSAL("MENSAL"),
    TRIMESTRAL("TRIMESTRAL"),
    SEMESTRAL("SEMESTRAL"),
    ANUAL("ANUAL");

    private final String nome;

    FrequenciaPagamento(String nome) {
        this.nome = nome;
    }

    public static FrequenciaPagamento frequenciaPagamentoPorString(String nome) {
        for (FrequenciaPagamento frequenciaPagamento : values()) {
            if (frequenciaPagamento.getNome().equalsIgnoreCase(nome)) {
                return frequenciaPagamento;
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "FrequenciaPagamento{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
