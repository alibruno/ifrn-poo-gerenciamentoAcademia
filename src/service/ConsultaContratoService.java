package service;

import java.math.BigDecimal;

public interface ConsultaContratoService {
    String gerarRelatorioTudo();

    String gerarRelatorioAluno();

    String gerarRelatorioInstrutor();

    BigDecimal getLucro();

    BigDecimal lucroPorAno(int year);
}
