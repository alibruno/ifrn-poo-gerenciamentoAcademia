package test;

import repositorio.RepositorioAcademia;
import service.ConsultaAcademiaService;
import service.EditarContratoService;
import service.EncerrarContratoService;
import service.impl.ConsultaAcademiaImpl;
import service.impl.EditarContratoImpl;
import service.impl.EncerrarContratoImpl;

public class EditarContratoTest01 {
    public static void main(String[] args) {
        RepositorioAcademia repositorioAcademia = new RepositorioAcademia();
        ConsultaAcademiaService consultaAcademiaService = new ConsultaAcademiaImpl(repositorioAcademia);
        EditarContratoService editarContratoService = new EditarContratoImpl(repositorioAcademia);

        System.out.println(consultaAcademiaService.gerarRelatorioAluno());
            editarContratoService.editarCampoAluno("990.001.112-99", "Frequencia Pagamento", "Trimestral");
        System.out.println(consultaAcademiaService.gerarRelatorioAluno());
    }

}
