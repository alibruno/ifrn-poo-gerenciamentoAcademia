package test;

import repositorio.RepositorioAcademia;
import service.ConsultaAcademiaService;
import service.EncerrarContratoService;
import service.ExcluirVinculoService;
import service.impl.ConsultaAcademiaImpl;
import service.impl.ExcluirVinculoImpl;

public class ExcluirVinculoTest01 {
    public static void main(String[] args) {
        RepositorioAcademia repositorioAcademia = new RepositorioAcademia();
        ExcluirVinculoService excluirVinculoService = new ExcluirVinculoImpl(repositorioAcademia);
        ConsultaAcademiaService consultaAcademiaService = new ConsultaAcademiaImpl(repositorioAcademia);
        
        consultaAcademiaService.gerarRelatorioAluno();
        
        System.out.println(consultaAcademiaService.gerarRelatorioAluno());
        excluirVinculoService.excluirVinculoAluno("654.456.789-44");
        System.out.println(consultaAcademiaService.gerarRelatorioAluno());

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
