package test;

import repositorio.RepositorioAcademia;
import service.ConsultaAcademiaService;
import service.EncerrarContratoService;
import service.impl.ConsultaAcademiaImpl;
import service.impl.EncerrarContratoImpl;

public class EncerrarContratoTest01 {
    public static void main(String[] args) {
        RepositorioAcademia repositorioAcademia = new RepositorioAcademia();
        EncerrarContratoService encerrarContratoService = new EncerrarContratoImpl(repositorioAcademia);
        ConsultaAcademiaService consultaAcademiaService = new ConsultaAcademiaImpl(repositorioAcademia);

        System.out.println(consultaAcademiaService.gerarRelatorioAluno());
        encerrarContratoService.encerrarContratoAluno("654.456.789-44");
        System.out.println(consultaAcademiaService.gerarRelatorioAluno());

        // Teste CPF inválido
        try {
            encerrarContratoService.encerrarContratoAluno("000.000.000-11");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Teste de pessoa com contrato já encerrado
        try {
            encerrarContratoService.encerrarContratoAluno("654.456.789-44");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
