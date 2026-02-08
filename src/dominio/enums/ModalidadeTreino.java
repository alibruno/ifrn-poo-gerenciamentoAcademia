package dominio.enums;

import dominio.exceptions.ModalidadeTreinoInvalidoException;

public enum ModalidadeTreino {
    MUSCULACAO,
    DANCA,
    CROSSFIT,
    FUNCIONAL,
    SPINNING;

    public static ModalidadeTreino modalidadeTreinoPorString(String nome) {
        for (ModalidadeTreino modalidadeTreino : values()) {
            if (modalidadeTreino.name().equalsIgnoreCase(nome)) {
                return modalidadeTreino;
            }
        }
        throw new ModalidadeTreinoInvalidoException("Modalidade Treino inválida: " + nome);
    }

    @Override
    public String toString() {
        return '\'' + name() + '\'';
    }
}
