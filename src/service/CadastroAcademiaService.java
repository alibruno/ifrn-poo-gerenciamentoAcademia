package service;

public interface CadastroAcademiaService {
    void cadastrarAluno(String nome, String CPF, String sexoString, String telefone, int idade, String matricula, String planoString, String frequenciaString);
    void cadastrarInstrutor(String nome, String CPF, String sexoString, String telefone, int idade, String ID, int cargaHoraria, String modalidadeTreinoString, String salarioString);
}