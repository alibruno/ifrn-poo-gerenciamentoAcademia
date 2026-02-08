package test;


import repositorio.RepositorioAcademia;
import service.impl.ConsultaContratoImpl;
import service.ConsultaContratoService;

public class ConsultaAcademiaTest01 {
    public static void main(String[] args) {
        RepositorioAcademia repositorioAcademia = new RepositorioAcademia();
        ConsultaContratoService consultaContratoService = new ConsultaContratoImpl(repositorioAcademia);
        System.out.println(consultaContratoService.listarRelatorioAlunos());
        System.out.println(consultaContratoService.listarRelatorioInstrutores());
        System.out.println("Lucro: R$" + consultaContratoService.getLucro());
        System.out.println("Lucro atingido no ano " + 2026 + ": R$" + consultaContratoService.lucroPorAno(2026));
        System.out.println("Lucro atingido no ano " + 2025 + ": R$" + consultaContratoService.lucroPorAno(2025));
    }
}
