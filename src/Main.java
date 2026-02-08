import repositorio.RepositorioAcademia;
import service.*;
import service.impl.*;
import view.MenuConsole;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciar o Repositório (Banco de Dados em Memória)
        RepositorioAcademia repositorio = new RepositorioAcademia();

        // 2. Instanciar os Serviços (Injetando o Repositório)
        CadastroContratoService cadastroService = new CadastroContratoImpl(repositorio);
        ConsultaContratoService consultaService = new ConsultaContratoImpl(repositorio);
        EditarContratoService editarService = new EditarContratoImpl(repositorio);
        EncerrarContratoService encerrarService = new EncerrarContratoImpl(repositorio);
        ExcluirVinculoService excluirService = new ExcluirVinculoImpl(repositorio);

        // 3. Instanciar a View (Injetando os Serviços)
        MenuConsole menu = new MenuConsole(
                cadastroService,
                consultaService,
                editarService,
                encerrarService,
                excluirService
        );

        // Iniciar aplicação
        menu.iniciar();
    }
}