package test;

import repositorio.RepositorioAcademia;
import service.CadastroAcademiaService;
import service.ConsultaAcademiaService;
import service.impl.CadastroAcademiaImpl;
import service.impl.ConsultaAcademiaImpl;

public class CadastroAcademiaTest01 {
    public static void main(String[] args) {
        RepositorioAcademia repositorioAcademia = new RepositorioAcademia();
        CadastroAcademiaService cadastroAcademiaService = new CadastroAcademiaImpl(repositorioAcademia);
        ConsultaAcademiaService consultaAcademiaService = new ConsultaAcademiaImpl(repositorioAcademia);

        // CPF válido -> funciona!
        // CPFs válidos mas iguais, seja para Aluno e Aluno, Instrutor e Instrutor, Aluno e Instrutor -> exception
        // Telefone inválido -> exception

        // TESTE DE INSERÇÃO
        //cadastroAcademiaService.cadastrarAluno("Goku", "cpf válido", "Masculino",
        //        "telefone válido", 20, "AB0123", "BASIC", "MENSAL");

        System.out.println(consultaAcademiaService.gerarRelatorioAluno()); // Goku foi inserido!

    }
}
