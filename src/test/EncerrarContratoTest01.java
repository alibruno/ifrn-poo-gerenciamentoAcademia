package test;

import repositorio.RepositorioAcademia;
import service.ConsultaContratoService;
import service.EncerrarContratoService;
import service.impl.ConsultaContratoImpl;
import service.impl.EncerrarContratoImpl;

public class EncerrarContratoTest01 {
    public static void main(String[] args) {
        RepositorioAcademia repositorioAcademia = new RepositorioAcademia();
        ConsultaContratoService consultaContratoService = new ConsultaContratoImpl(repositorioAcademia);
        EncerrarContratoService encerrarContratoService = new EncerrarContratoImpl(repositorioAcademia);

        System.out.println(consultaContratoService.listarRelatorioAlunos());
        encerrarContratoService.encerrarContratoAluno("654.456.789-44");
        System.out.println(consultaContratoService.listarRelatorioAlunos());

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
