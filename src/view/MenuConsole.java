package view;

import service.*;
import service.dto.RelatorioAlunoDTO;
import service.dto.RelatorioInstrutorDTO;
import view.util.ClasseUtilitariaEntrada;

import java.math.BigDecimal;
import java.util.List;

public class MenuConsole {

    // Dependências (Services)
    private final CadastroContratoService cadastroService;
    private final ConsultaContratoService consultaService;
    private final EditarContratoService editarService;
    private final EncerrarContratoService encerrarService;
    private final ExcluirVinculoService excluirService;

    public MenuConsole(CadastroContratoService cadastroService,
                       ConsultaContratoService consultaService,
                       EditarContratoService editarService,
                       EncerrarContratoService encerrarService,
                       ExcluirVinculoService excluirService) {
        this.cadastroService = cadastroService;
        this.consultaService = consultaService;
        this.editarService = editarService;
        this.encerrarService = encerrarService;
        this.excluirService = excluirService;
    }

    public void iniciar() {
        boolean rodando = true;
        while (rodando) {
            System.out.println("\n======================================");
            System.out.println("      SISTEMA DE GESTÃO - ACADEMIA    ");
            System.out.println("======================================");
            System.out.println("1. Cadastros");
            System.out.println("2. Relatórios e Consultas");
            System.out.println("3. Editar Dados");
            System.out.println("4. Encerrar Contratos (Cancelar)");
            System.out.println("5. Excluir Registros (Admin)");
            System.out.println("0. Sair");
            System.out.println("======================================");

            int opcao = ClasseUtilitariaEntrada.lerInteiro("Escolha uma opção");

            try {
                switch (opcao) {
                    case 1 -> menuCadastro();
                    case 2 -> menuRelatorios();
                    case 3 -> menuEdicao();
                    case 4 -> menuEncerramento();
                    case 5 -> menuExclusao();
                    case 0 -> {
                        rodando = false;
                        System.out.println("Encerrando sistema... Até logo!");
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("ERRO NO SISTEMA: " + e.getMessage());
            }
        }
    }

    // --- SUB-MENUS ---

    private void menuCadastro() {
        System.out.println("\n--- CADASTRO ---");
        System.out.println("1. Novo Aluno");
        System.out.println("2. Novo Instrutor");
        int op = ClasseUtilitariaEntrada.lerInteiro("Opção");

        try {
            if (op == 1) {
                String nome = ClasseUtilitariaEntrada.lerTexto("Nome Completo");
                String cpf = ClasseUtilitariaEntrada.lerTexto("CPF (apenas números ou com ponto)");
                String sexo = ClasseUtilitariaEntrada.lerTexto("Sexo (MASCULINO/FEMININO)");
                String tel = ClasseUtilitariaEntrada.lerTexto("Telefone (com DDD)");
                int idade = ClasseUtilitariaEntrada.lerInteiro("Idade");
                String matricula = ClasseUtilitariaEntrada.lerTexto("Matrícula Gerada"); // Em sistema real seria automático
                String plano = ClasseUtilitariaEntrada.lerTexto("Plano (BASIC/ELITE/PREMIUM)");
                String freq = ClasseUtilitariaEntrada.lerTexto("Frequência (MENSAL/ANUAL...)");

                cadastroService.cadastrarAluno(nome, cpf, sexo, tel, idade, matricula, plano, freq);
                System.out.println("Aluno cadastrado com sucesso!");

            } else if (op == 2) {
                String nome = ClasseUtilitariaEntrada.lerTexto("Nome Completo");
                String cpf = ClasseUtilitariaEntrada.lerTexto("CPF");
                String sexo = ClasseUtilitariaEntrada.lerTexto("Sexo (MASCULINO/FEMININO)");
                String tel = ClasseUtilitariaEntrada.lerTexto("Telefone");
                int idade = ClasseUtilitariaEntrada.lerInteiro("Idade");
                String id = ClasseUtilitariaEntrada.lerTexto("ID Funcional");
                int ch = ClasseUtilitariaEntrada.lerInteiro("Carga Horária");
                String mod = ClasseUtilitariaEntrada.lerTexto("Modalidade (MUSCULACAO/CROSSFIT...)");
                String sal = ClasseUtilitariaEntrada.lerDecimalString("Salário");

                cadastroService.cadastrarInstrutor(nome, cpf, sexo, tel, idade, id, ch, mod, sal);
                System.out.println("Instrutor cadastrado com sucesso!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de Validação: " + e.getMessage());
        }
        ClasseUtilitariaEntrada.aguardarEnter();
    }

    private void menuRelatorios() {
        System.out.println("\n--- RELATÓRIOS ---");
        System.out.println("1. Listar Alunos (Resumo)");
        System.out.println("2. Listar Instrutores (Resumo)");
        System.out.println("3. Ver Financeiro (Lucro Total)");
        System.out.println("4. Ver Financeiro (Lucro por Ano)");
        int op = ClasseUtilitariaEntrada.lerInteiro("Opção");

        if (op == 1) {
            List<RelatorioAlunoDTO> lista = consultaService.listarRelatorioAlunos();
            System.out.printf("%-25s | %-12s | %-10s | %-10s | %s%n", "NOME", "MATRICULA", "PLANO", "STATUS", "DATA");
            System.out.println("-".repeat(80));
            lista.forEach(dto -> System.out.printf("%-25s | %-12s | %-10s | %-10s | %s%n",
                    dto.nome(), dto.matricula(), dto.plano(), dto.status(), dto.dataEntrada()));

        } else if (op == 2) {
            List<RelatorioInstrutorDTO> lista = consultaService.listarRelatorioInstrutores();
            System.out.printf("%-25s | %-10s | %-15s | %-5s | %s%n", "NOME", "ID", "MODALIDADE", "CH", "STATUS");
            System.out.println("-".repeat(80));
            lista.forEach(dto -> System.out.printf("%-25s | %-10s | %-15s | %-5d | %s%n",
                    dto.nome(), dto.ID(), dto.modalidade(), dto.cargaHoraria(), dto.status()));

        } else if (op == 3) {
            System.out.println("Lucro Total Acumulado: R$ " + consultaService.getLucro());

        } else if (op == 4) {
            int ano = ClasseUtilitariaEntrada.lerInteiro("Informe o Ano");
            try {
                BigDecimal lucroAno = consultaService.lucroPorAno(ano);
                System.out.println("Lucro até " + ano + ": R$ " + lucroAno);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        ClasseUtilitariaEntrada.aguardarEnter();
    }

    private void menuEdicao() {
        System.out.println("\n--- EDITAR DADOS ---");
        System.out.println("1. Editar Aluno");
        System.out.println("2. Editar Instrutor");
        int op = ClasseUtilitariaEntrada.lerInteiro("Opção");

        String cpf = ClasseUtilitariaEntrada.lerTexto("Informe o CPF do registro");

        System.out.println("Campos disponíveis: Nome, Telefone, Idade");
        if(op == 1) System.out.println("Específicos Aluno: 'Plano Treino', 'Frequencia Pagamento'");
        if(op == 2) System.out.println("Específicos Instrutor: 'Salario', 'Carga Horaria', 'Modalidade Treino'");

        String campo = ClasseUtilitariaEntrada.lerTexto("Qual campo deseja alterar?");
        String novoValor = ClasseUtilitariaEntrada.lerTexto("Novo Valor");

        try {
            if (op == 1) {
                editarService.editarCampoAluno(cpf, campo, novoValor);
            } else {
                editarService.editarCampoInstrutor(cpf, campo, novoValor);
            }
            System.out.println("Registro atualizado!");
        } catch (Exception e) {
            System.out.println("Falha na edição: " + e.getMessage());
        }
        ClasseUtilitariaEntrada.aguardarEnter();
    }

    private void menuEncerramento() {
        System.out.println("\n--- ENCERRAR CONTRATO ---");
        String cpf = ClasseUtilitariaEntrada.lerTexto("CPF para cancelamento");
        System.out.println("1. Aluno | 2. Instrutor");
        int op = ClasseUtilitariaEntrada.lerInteiro("Tipo");

        try {
            if (op == 1) encerrarService.encerrarContratoAluno(cpf);
            else encerrarService.encerrarContratoInstrutor(cpf);
            System.out.println("Contrato encerrado com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ClasseUtilitariaEntrada.aguardarEnter();
    }

    private void menuExclusao() {
        System.out.println("\n--- EXCLUIR VINCULO (CUIDADO) ---");
        String cpf = ClasseUtilitariaEntrada.lerTexto("CPF para excluir");
        System.out.println("1. Aluno | 2. Instrutor");
        int op = ClasseUtilitariaEntrada.lerInteiro("Tipo");

        try {
            if (op == 1) excluirService.excluirVinculoAluno(cpf);
            else excluirService.excluirVinculoInstrutor(cpf);
            System.out.println("Registro apagado do sistema.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ClasseUtilitariaEntrada.aguardarEnter();
    }
}