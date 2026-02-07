package dominio.exceptions;

public class ModalidadeTreinoInvalidoException extends RuntimeException {
    public ModalidadeTreinoInvalidoException() {
        super("Modalidade Treino inválido.");
    }

    public ModalidadeTreinoInvalidoException(String message) {
        super(message);
    }
}
