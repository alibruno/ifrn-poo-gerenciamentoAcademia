package service.dto;

import dominio.Instrutor;

import java.time.format.DateTimeFormatter;

public record RelatorioInstrutorDTO
        (
                String nome,
                String ID,
                String modalidade,
                int cargaHoraria,
                String status,
                String dataEntrada
        ) {
    // Metodo estático para converter a Entidade em DTO
    public static RelatorioInstrutorDTO fromEntity(Instrutor instrutor) {
        // Formatação da Data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = instrutor.getDataDeInclusao().format(formatter);

        // Formatação do status
        String statusTexto = instrutor.isCancelouMatricula() ? "Inativo" : "Ativo";

        return new RelatorioInstrutorDTO(
                instrutor.getNome(),
                instrutor.getID(),
                instrutor.getModalidade().name(),
                instrutor.getCargaHoraria(),
                statusTexto,
                dataFormatada
        );
    }
}