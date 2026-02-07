package dominio.enums;

public enum ModalidadeTreino {
    MUSCULACAO("MUSCULACAO"),
    DANCA("DANCA"),
    CROSSFIT("CROSSFIT"),
    FUNCIONAL("FUNCIONAL"),
    SPINNING("SPINNING");

    private final String nome;

    ModalidadeTreino(String nome) {
        this.nome = nome;
    }

    public static ModalidadeTreino modalidadeTreinoPorString(String nome) {
        for (ModalidadeTreino modalidadeTreino : values()) {
            if (modalidadeTreino.getNome().equalsIgnoreCase(nome)) {
                return modalidadeTreino;
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "ModalidadeTreino{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
