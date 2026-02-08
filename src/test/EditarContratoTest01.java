package test;

import repositorio.RepositorioAcademia;
import service.ConsultaContratoService;
import service.EditarContratoService;
import service.impl.ConsultaContratoImpl;
import service.impl.EditarContratoImpl;

public class EditarContratoTest01 {
    public static void main(String[] args) {
        RepositorioAcademia repositorioAcademia = new RepositorioAcademia();
        ConsultaContratoService consultaContratoService = new ConsultaContratoImpl(repositorioAcademia);
        EditarContratoService editarContratoService = new EditarContratoImpl(repositorioAcademia);

        System.out.println(consultaContratoService.gerarRelatorioAluno());
        editarContratoService.editarCampoAluno("990.001.112-99", "Frequencia Pagamento", "Trimestral");
        System.out.println(consultaContratoService.gerarRelatorioAluno());
    }

}
