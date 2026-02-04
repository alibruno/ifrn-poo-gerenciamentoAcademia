package test;


import service.ConsultaAcademia;
import interfaces.ConsultaAcademiaInterface;

public class AcademiaTest01 {
    public static void main(String[] args) {
        ConsultaAcademiaInterface consultaAcademiaInterface = new ConsultaAcademia();
        System.out.println(consultaAcademiaInterface.gerarRelatorioTudo());
        System.out.println(consultaAcademiaInterface.gerarRelatorioAluno());
        System.out.println(consultaAcademiaInterface.gerarRelatorioInstrutor());
        System.out.println("Lucro: R$" + consultaAcademiaInterface.getLucro());
        System.out.println("Lucro atingido no ano " + 2026 + ": R$" + consultaAcademiaInterface.lucroPorAno(2026));
        System.out.println("Lucro atingido no ano " + 2025 + ": R$" + consultaAcademiaInterface.lucroPorAno(2025));




    }
}
