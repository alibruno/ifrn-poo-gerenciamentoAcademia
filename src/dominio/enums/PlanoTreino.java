package dominio.enums;

import dominio.exceptions.PlanoTreinoInvalidoException;

import java.math.BigDecimal;

public enum PlanoTreino {
    BASIC(new BigDecimal("100.00")),
    ELITE(new BigDecimal("120.00")),
    PREMIUM(new BigDecimal("150.00"));

    private final BigDecimal valor;

    PlanoTreino(BigDecimal valor) {
        this.valor = valor;
    }

    public static PlanoTreino planoTreinoPorString(String nome) {
        for (PlanoTreino planoTreino : values()) {
            if (planoTreino.name().equalsIgnoreCase(nome)) {
                return planoTreino;
            }
        }
        throw new PlanoTreinoInvalidoException("Plano Treino inválido: " + nome);
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + name() + '\'' +
                ", valor=" + valor +
                '}';
    }
}