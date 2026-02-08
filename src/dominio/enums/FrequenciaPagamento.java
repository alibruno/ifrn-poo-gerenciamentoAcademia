package dominio.enums;

import dominio.exceptions.FrequenciaPagamentoInvalidoException;

public enum FrequenciaPagamento {
    DIARIA,
    MENSAL,
    TRIMESTRAL,
    SEMESTRAL,
    ANUAL;

    public static FrequenciaPagamento frequenciaPagamentoPorString(String nome) {
        for (FrequenciaPagamento frequenciaPagamento : values()) {
            if (frequenciaPagamento.name().equalsIgnoreCase(nome)) {
                return frequenciaPagamento;
            }
        }
        throw new FrequenciaPagamentoInvalidoException("Frequencia Pagamento inválida: " + nome);
    }

    @Override
    public String toString() {
        return '\'' + name() + '\'';
    }
}
