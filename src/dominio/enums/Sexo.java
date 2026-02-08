package dominio.enums;

import dominio.exceptions.SexoInvalidoException;

public enum Sexo {
    MASCULINO,
    FEMININO;

    public static Sexo sexoPorString(String nome) {
        for (Sexo sexo : values()) {
            if (sexo.name().equalsIgnoreCase(nome)) {
                return sexo;
            }
        }
        throw new SexoInvalidoException("Sexo inválido: " + nome);
    }

    @Override
    public String toString() {
        return '\'' + name() + '\'';
    }
}
