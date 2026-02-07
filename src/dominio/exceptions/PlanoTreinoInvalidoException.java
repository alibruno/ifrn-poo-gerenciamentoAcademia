package dominio.exceptions;

public class PlanoTreinoInvalidoException extends RuntimeException {
    public PlanoTreinoInvalidoException() {
        super("Plano Treino inválido.");
    }

    public PlanoTreinoInvalidoException(String message) {
        super(message);
    }
}
