package service.impl;

import dominio.Contrato;
import dominio.enums.FrequenciaPagamento;
import dominio.enums.ModalidadeTreino;
import dominio.enums.PlanoTreino;
import repositorio.RepositorioAcademia;
import service.EditarContratoService;
import service.ValidarAtributos;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

public class EditarContratoImpl implements EditarContratoService {
    private final RepositorioAcademia repositorio;

    public EditarContratoImpl(RepositorioAcademia repositorio) {
        this.repositorio = repositorio;
    }

    private static <T extends Contrato> void editarCampoContrato(Map<String, T> contratoMap, String CPF, String campo, String alteracao) {
        if (campo.equalsIgnoreCase("Nome")) {
            contratoMap.get(CPF).setNome(alteracao);
            return;
        }
        if (campo.equalsIgnoreCase("Telefone")) {
            if (ValidarAtributos.isTelefoneInvalido(alteracao)) {
                throw new IllegalArgumentException("Telefone inválido.");
            }
            contratoMap.get(CPF).setTelefone(alteracao);
            return;
        }
        if (campo.equalsIgnoreCase("Idade")) {
            int alteracaoInt = Integer.parseInt(alteracao);
            if (ValidarAtributos.isIdadeInvalida(alteracaoInt)) {
                throw new IllegalArgumentException("Idade inválida.");
            }
            contratoMap.get(CPF).setIdade(alteracaoInt);
            return;
        }
        throw new IllegalArgumentException("Campo inválido.");
    }

    @Override
    public void editarCampoAluno(String CPF, String campo, String alteracao) {
        if (!repositorio.getAlunos().containsKey(CPF)) {
            throw new IllegalArgumentException("CPF inválido ou não encontrado.");
        }
        if (campo.equalsIgnoreCase("Plano Treino")) {
            PlanoTreino planoTreino = ValidarAtributos.validarPlanoTreino(alteracao);
            repositorio.getAlunos().get(CPF).setPlano(planoTreino);
            return;
        }
        if (campo.equalsIgnoreCase("Frequencia Pagamento")) {
            FrequenciaPagamento frequenciaPagamento = ValidarAtributos.validarFrequenciaPagamento(alteracao);
            repositorio.getAlunos().get(CPF).setFrequencia(frequenciaPagamento);
            return;
        }
        editarCampoContrato(repositorio.getAlunos(), CPF, campo, alteracao);
    }

    @Override
    public void editarCampoInstrutor(String CPF, String campo, String alteracao) {
        if (!repositorio.getInstrutores().containsKey(CPF)) {
            throw new IllegalArgumentException("CPF inválido ou não encontrado.");
        }
        if (campo.equalsIgnoreCase("Carga Horaria")) {
            int cargaHorariaInt = Integer.parseInt(alteracao);
            repositorio.getInstrutores().get(CPF).setCargaHoraria(cargaHorariaInt);
            return;
        }
        if (campo.equalsIgnoreCase("Modalidade Treino")) {
            ModalidadeTreino modalidadeTreino = ValidarAtributos.validarModalidadeTreino(alteracao);
            repositorio.getInstrutores().get(CPF).setModalidade(modalidadeTreino);
            return;
        }
        if (campo.equalsIgnoreCase("Salario")) {
            BigDecimal salario = new BigDecimal(alteracao);
            repositorio.getInstrutores().get(CPF).setSalario(salario);
            return;
        }
        editarCampoContrato(repositorio.getInstrutores(), CPF, campo, alteracao);
    }
}
