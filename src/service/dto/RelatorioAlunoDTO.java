package service.dto;

import dominio.Aluno;

import java.time.format.DateTimeFormatter;

public record RelatorioAlunoDTO
        (
                String nome,
                String matricula,
                String plano,
                String status,
                String dataEntrada
        ) {
    // Metodo estático para converter a Entidade em DTO
    public static RelatorioAlunoDTO fromEntity(Aluno aluno) {
        // Formatação da Data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = aluno.getDataDeInclusao().format(formatter);

        // Formatação do status
        String statusTexto = aluno.isCancelouMatricula() ? "Inativo" : "Ativo";

        return new RelatorioAlunoDTO(
                aluno.getNome(),
                aluno.getMatricula(),
                aluno.getPlano().name(),
                statusTexto,
                dataFormatada
        );
    }
}
