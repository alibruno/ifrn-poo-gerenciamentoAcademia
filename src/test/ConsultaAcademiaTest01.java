package test;


import repositorio.RepositorioAcademia;
import service.impl.ConsultaAcademiaImpl;
import service.ConsultaAcademiaService;

public class ConsultaAcademiaTest01 {
    public static void main(String[] args) {
        RepositorioAcademia repositorioAcademia = new RepositorioAcademia();
        ConsultaAcademiaService consultaAcademiaService = new ConsultaAcademiaImpl(repositorioAcademia);
        System.out.println(consultaAcademiaService.gerarRelatorioTudo());
        System.out.println(consultaAcademiaService.gerarRelatorioAluno());
        System.out.println(consultaAcademiaService.gerarRelatorioInstrutor());
        System.out.println("Lucro: R$" + consultaAcademiaService.getLucro());
        System.out.println("Lucro atingido no ano " + 2026 + ": R$" + consultaAcademiaService.lucroPorAno(2026));
        System.out.println("Lucro atingido no ano " + 2025 + ": R$" + consultaAcademiaService.lucroPorAno(2025));




    }
}
