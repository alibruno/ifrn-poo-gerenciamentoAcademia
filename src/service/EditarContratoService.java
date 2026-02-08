package service;

public interface EditarContratoService {
    void editarCampoAluno(String CPF, String campo, String alteracao);

    void editarCampoInstrutor(String CPF, String campo, String alteracao);
}
