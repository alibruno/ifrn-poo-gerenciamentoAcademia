package dominio.exceptions;

public class SexoInvalidoException extends RuntimeException {
    public SexoInvalidoException() {
        super("Sexo inválido.");
    }

    public SexoInvalidoException(String message) {
        super(message);
    }
}
