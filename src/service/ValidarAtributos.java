package service;

import dominio.enums.FrequenciaPagamento;
import dominio.enums.ModalidadeTreino;
import dominio.enums.PlanoTreino;
import dominio.enums.Sexo;
import dominio.exceptions.FrequenciaPagamentoInvalidoException;
import dominio.exceptions.ModalidadeTreinoInvalidoException;
import dominio.exceptions.PlanoTreinoInvalidoException;
import dominio.exceptions.SexoInvalidoException;

import java.util.Optional;

public class ValidarAtributos {
    public static boolean isIdadeInvalida(int idade) {
        if (idade < 0 || idade > 100) {
            return true;
        }
        return false;
    }

    public static boolean isCPFinvalido(String cpf) {
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) {
            return true;
        }

        // Verifica se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return true;
        }

        try {
            int soma = 0;
            int peso = 10;

            // Cálculo do primeiro dígito verificador
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * peso--;
            }

            int digito1 = 11 - (soma % 11);
            if (digito1 >= 10) digito1 = 0;

            // Cálculo do segundo dígito verificador
            soma = 0;
            peso = 11;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * peso--;
            }

            int digito2 = 11 - (soma % 11);
            if (digito2 >= 10) digito2 = 0;

            // Verifica se os dígitos calculados são iguais aos informados
            return digito1 != (cpf.charAt(9) - '0') ||
                    digito2 != (cpf.charAt(10) - '0');

        } catch (Exception e) {
            return true;
        }
    }

    public static boolean isTelefoneInvalido(String telefone) {
        telefone = telefone.replaceAll("\\D", "");

        // Telefone com DDD (10 ou 11 dígitos)
        if (telefone.length() == 10) {
            // Fixo: DDD (2) + número (8)
            return !(validarDDD(telefone.substring(0, 2)) &&
                    validarFixo(telefone.substring(2)));
        }

        if (telefone.length() == 11) {
            // Celular: DDD (2) + número (9)
            return !(validarDDD(telefone.substring(0, 2)) &&
                    validarCelular(telefone.substring(2)));
        }

        return true;
    }

    private static boolean validarDDD(String ddd) {
        int d = Integer.parseInt(ddd);
        return d >= 11 && d <= 99;
    }

    private static boolean validarCelular(String numero) {
        // Celular começa com 9
        return numero.charAt(0) == '9';
    }

    private static boolean validarFixo(String numero) {
        char primeiro = numero.charAt(0);
        // Fixo começa com 2 a 5
        return primeiro >= '2' && primeiro <= '5';
    }

    public static Sexo validarSexo(String sexoString) {
        return Optional.ofNullable(Sexo.sexoPorString(sexoString)).orElseThrow(SexoInvalidoException::new);
    }

    public static PlanoTreino validarPlanoTreino(String planoTreinoString) {
        return Optional.ofNullable(PlanoTreino.planoTreinoPorString(planoTreinoString)).orElseThrow(PlanoTreinoInvalidoException::new);
    }

    public static FrequenciaPagamento validarFrequenciaPagamento(String frequenciaPagamentoString) {
        return Optional.ofNullable(FrequenciaPagamento.frequenciaPagamentoPorString(frequenciaPagamentoString)).orElseThrow(FrequenciaPagamentoInvalidoException::new);
    }

    public static ModalidadeTreino validarModalidadeTreino(String modalidadeTreinoString) {
        return Optional.ofNullable(ModalidadeTreino.modalidadeTreinoPorString(modalidadeTreinoString)).orElseThrow(ModalidadeTreinoInvalidoException::new);
    }


}
