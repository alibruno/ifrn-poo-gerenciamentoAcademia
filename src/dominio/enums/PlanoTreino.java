package dominio.enums;

import java.math.BigDecimal;

public enum PlanoTreino {
    BASIC(new BigDecimal("100.00")),
    ELITE(new BigDecimal("120.00")),
    PREMIUM(new BigDecimal("150.00"));

    private final BigDecimal valor;

    PlanoTreino(BigDecimal valor) {
        this.valor = valor;
    }
    public BigDecimal getValor() { return valor; }
}