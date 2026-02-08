package service;

import service.dto.RelatorioAlunoDTO;
import service.dto.RelatorioInstrutorDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ConsultaContratoService {
    List<RelatorioAlunoDTO> listarRelatorioAlunos();

    List<RelatorioInstrutorDTO> listarRelatorioInstrutores();

    BigDecimal getLucro();

    BigDecimal lucroPorAno(int year);
}
