package dominio.exceptions;

public class FrequenciaPagamentoInvalidoException extends RuntimeException {
    public FrequenciaPagamentoInvalidoException() {
        super("Frequencia pagamento inválido.");
    }

    public FrequenciaPagamentoInvalidoException(String message) {
        super(message);
    }
}
