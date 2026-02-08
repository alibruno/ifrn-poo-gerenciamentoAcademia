package test;

import repositorio.RepositorioAcademia;
import service.ConsultaContratoService;
import service.ExcluirVinculoService;
import service.impl.ConsultaContratoImpl;
import service.impl.ExcluirVinculoImpl;

public class ExcluirVinculoTest01 {
    public static void main(String[] args) {
        RepositorioAcademia repositorioAcademia = new RepositorioAcademia();
        ConsultaContratoService consultaContratoService = new ConsultaContratoImpl(repositorioAcademia);
        ExcluirVinculoService excluirVinculoService = new ExcluirVinculoImpl(repositorioAcademia);

        consultaContratoService.listarRelatorioAlunos();

        System.out.println(consultaContratoService.listarRelatorioAlunos());
        excluirVinculoService.excluirVinculoAluno("654.456.789-44");
        System.out.println(consultaContratoService.listarRelatorioAlunos());

        // Teste CPF inválido
        try {
            excluirVinculoService.excluirVinculoAluno("000.000.000-11");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Teste de pessoa já excluida
        try {
            excluirVinculoService.excluirVinculoAluno("654.456.789-44");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
