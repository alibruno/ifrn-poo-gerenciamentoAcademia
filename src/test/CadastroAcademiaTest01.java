package test;

import repositorio.RepositorioAcademia;
import service.CadastroContratoService;
import service.ConsultaContratoService;
import service.impl.CadastroContratoImpl;
import service.impl.ConsultaContratoImpl;

public class CadastroAcademiaTest01 {
    public static void main(String[] args) {
        RepositorioAcademia repositorioAcademia = new RepositorioAcademia();
        ConsultaContratoService consultaContratoService = new ConsultaContratoImpl(repositorioAcademia);
        CadastroContratoService cadastroContratoService = new CadastroContratoImpl(repositorioAcademia);

        // CPF válido -> funciona!
        // CPFs válidos mas iguais, seja para Aluno e Aluno, Instrutor e Instrutor, Aluno e Instrutor -> exception
        // Telefone inválido -> exception

        // TESTE DE INSERÇÃO
        //cadastroContratoService.cadastrarAluno("Goku", "cpf válido", "Masculino",
        //        "telefone válido", 20, "AB0123", "BASIC", "MENSAL");

        System.out.println(consultaContratoService.listarRelatorioAlunos()); // Goku foi inserido!
    }
}
