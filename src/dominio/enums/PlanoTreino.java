package dominio.enums;

import java.math.BigDecimal;

public enum PlanoTreino {
    BASIC("BASIC", new BigDecimal("100.00")),
    ELITE("ELITE", new BigDecimal("120.00")),
    PREMIUM("PREMIUM", new BigDecimal("150.00"));

    private final String nome;
    private final BigDecimal valor;

    PlanoTreino(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public static PlanoTreino planoTreinoPorString(String nome) {
        for (PlanoTreino planoTreino : values()) {
            if (planoTreino.getNome().equals(nome)) {
                return planoTreino;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "PlanoTreino{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }
}