package service;

import java.math.BigDecimal;

public interface ConsultaAcademiaService {
    String gerarRelatorioTudo();
    String gerarRelatorioAluno();
    String gerarRelatorioInstrutor();

    BigDecimal getLucro();
    BigDecimal lucroPorAno(int year);
//    String lucroPorMes(int month, int year);


}
