package dominio.enums;

public enum PlanoTreino {
    BASIC(100),
    ELITE(120),
    PREMIUM(150);

    private final int valor;

    PlanoTreino(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}