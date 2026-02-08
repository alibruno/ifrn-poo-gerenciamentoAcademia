package view;

import java.util.Scanner;

public class ClasseUtilitariaEntrada {
    private static final Scanner scanner = new Scanner(System.in);

    public static String lerTexto(String mensagem) {
        System.out.print(mensagem + ": ");
        return scanner.nextLine().trim();
    }

    public static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem + ": ");
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número inteiro válido.");
            }
        }
    }

    // Lê double/BigDecimal como String para o Service converter
    public static String lerDecimalString(String mensagem) {
        System.out.print(mensagem + ": ");
        String entrada = scanner.nextLine().trim().replace(",", ".");
        try {
            Double.parseDouble(entrada); // Apenas valida se é numero
            return entrada;
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite um valor numérico válido (ex: 150.00).");
            return lerDecimalString(mensagem); // Tenta de novo
        }
    }

    public static void aguardarEnter() {
        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }
}