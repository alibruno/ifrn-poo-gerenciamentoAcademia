package repositorio;

import dominio.Aluno;
import dominio.Instrutor;
import dominio.enums.FrequenciaPagamento;
import dominio.enums.ModalidadeTreino;
import dominio.enums.Sexo;
import dominio.enums.PlanoTreino;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositorioAcademia {
    private final List<Aluno> alunos = new ArrayList<>(List.of(
            // --- 1. MATRÍCULAS RECENTES (2026) ---
            new Aluno("Lucas Ferreira", "123.456.789-00", Sexo.MASCULINO, "(11) 99999-0001", 24, LocalDate.of(2026, 1, 15), "2026001", PlanoTreino.ELITE, FrequenciaPagamento.MENSAL),
            new Aluno("Mariana Souza", "234.567.890-11", Sexo.FEMININO, "(21) 98888-0002", 29, LocalDate.of(2026, 1, 20), "2026002", PlanoTreino.BASIC, FrequenciaPagamento.ANUAL),
            new Aluno("Pedro Alcântara", "345.678.901-22", Sexo.MASCULINO, "(31) 97777-0003", 19, LocalDate.of(2026, 2, 1), "2026003", PlanoTreino.PREMIUM, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Beatriz Lima", "456.789.012-33", Sexo.FEMININO, "(41) 96666-0004", 35, LocalDate.of(2026, 2, 2), "2026004", PlanoTreino.ELITE, FrequenciaPagamento.MENSAL),
            new Aluno("João Silva", "567.890.123-44", Sexo.MASCULINO, "(51) 95555-0005", 22, LocalDate.of(2026, 1, 5), "2026005", PlanoTreino.BASIC, FrequenciaPagamento.DIARIA),
            new Aluno("Fernanda Costa", "678.901.234-55", Sexo.FEMININO, "(61) 94444-0006", 27, LocalDate.of(2026, 1, 10), "2026006", PlanoTreino.PREMIUM, FrequenciaPagamento.ANUAL),
            new Aluno("Kevin Dias", "555.666.777-50", Sexo.MASCULINO, "(61) 95555-0015", 21, LocalDate.of(2026, 2, 3), "2026007", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL),
            new Aluno("Roberta Alves", "234.234.234-23", Sexo.FEMININO, "(41) 98833-0022", 32, LocalDate.of(2026, 1, 8), "2026008", PlanoTreino.ELITE, FrequenciaPagamento.MENSAL),
            new Aluno("Yara Satis", "555.666.555-66", Sexo.FEMININO, "(71) 95566-6655", 27, LocalDate.of(2026, 1, 25), "2026009", PlanoTreino.BASIC, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Caio Ribeiro", "112.223.334-45", Sexo.MASCULINO, "(11) 99111-2222", 18, LocalDate.of(2026, 1, 30), "2026010", PlanoTreino.PREMIUM, FrequenciaPagamento.MENSAL),
            new Aluno("Alok Petrillo", "111.222.999-00", Sexo.MASCULINO, "(62) 99999-1111", 32, LocalDate.of(2026, 1, 12), "2026014", PlanoTreino.PREMIUM, FrequenciaPagamento.ANUAL),
            new Aluno("Anitta Machado", "222.333.888-11", Sexo.FEMININO, "(21) 98888-2222", 30, LocalDate.of(2026, 1, 28), "2026015", PlanoTreino.ELITE, FrequenciaPagamento.MENSAL),
            new Aluno("Casimiro Miguel", "333.444.777-22", Sexo.MASCULINO, "(21) 97777-3333", 29, LocalDate.of(2026, 2, 1), "2026016", PlanoTreino.BASIC, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Drauzio Varella", "444.555.666-33", Sexo.MASCULINO, "(11) 96666-4444", 80, LocalDate.of(2026, 2, 2), "2026017", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL),
            new Aluno("Evaristo Costa", "555.666.555-44", Sexo.MASCULINO, "(11) 95555-5555", 47, LocalDate.of(2026, 1, 5), "2026018", PlanoTreino.PREMIUM, FrequenciaPagamento.ANUAL),

            // --- 2. ALUNOS REGULARES (2023-2025) ---
            new Aluno("Carlos Oliveira", "789.012.345-66", Sexo.MASCULINO, "(71) 93333-0007", 40, LocalDate.of(2025, 5, 12), "2025040", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL),
            new Aluno("Daniela Rocha", "890.123.456-77", Sexo.FEMININO, "(81) 92222-0008", 31, LocalDate.of(2025, 8, 22), "2025088", PlanoTreino.ELITE, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Eduardo Santos", "901.234.567-88", Sexo.MASCULINO, "(91) 91111-0009", 26, LocalDate.of(2024, 3, 15), "2024015", PlanoTreino.PREMIUM, FrequenciaPagamento.ANUAL),
            new Aluno("Fabiana Martins", "012.345.678-99", Sexo.FEMININO, "(11) 90000-0010", 23, LocalDate.of(2024, 11, 1), "2024101", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL),
            new Aluno("Gustavo Pereira", "111.222.333-10", Sexo.MASCULINO, "(21) 99911-0011", 33, LocalDate.of(2023, 6, 10), "2023060", PlanoTreino.ELITE, FrequenciaPagamento.MENSAL),
            new Aluno("Heloisa Nunes", "222.333.444-20", Sexo.FEMININO, "(31) 98822-0012", 45, LocalDate.of(2023, 2, 5), "2023020", PlanoTreino.BASIC, FrequenciaPagamento.ANUAL),
            new Aluno("Igor Mendes", "333.444.555-30", Sexo.MASCULINO, "(41) 97733-0013", 28, LocalDate.of(2025, 9, 20), "2025095", PlanoTreino.PREMIUM, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Julia Ribeiro", "444.555.666-40", Sexo.FEMININO, "(51) 96644-0014", 25, LocalDate.of(2025, 12, 1), "2025121", PlanoTreino.ELITE, FrequenciaPagamento.MENSAL),
            new Aluno("Larissa Araujo", "666.777.888-60", Sexo.FEMININO, "(71) 94466-0016", 38, LocalDate.of(2024, 7, 14), "2024077", PlanoTreino.PREMIUM, FrequenciaPagamento.ANUAL),
            new Aluno("Matheus Castro", "777.888.999-70", Sexo.MASCULINO, "(81) 93377-0017", 30, LocalDate.of(2023, 10, 30), "2023100", PlanoTreino.ELITE, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Nicole Lopes", "888.999.000-80", Sexo.FEMININO, "(91) 92288-0018", 29, LocalDate.of(2025, 4, 18), "2025048", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL),
            new Aluno("Otavio Barbosa", "999.000.111-90", Sexo.MASCULINO, "(11) 91199-0019", 34, LocalDate.of(2024, 1, 20), "2024012", PlanoTreino.ELITE, FrequenciaPagamento.ANUAL),
            new Aluno("Paula Gomes", "000.111.222-01", Sexo.FEMININO, "(21) 90011-0020", 27, LocalDate.of(2025, 11, 11), "2025111", PlanoTreino.PREMIUM, FrequenciaPagamento.MENSAL),
            new Aluno("Quirino Silva", "123.123.123-12", Sexo.MASCULINO, "(31) 99922-0021", 50, LocalDate.of(2022, 5, 5), "2022055", PlanoTreino.BASIC, FrequenciaPagamento.ANUAL),
            new Aluno("Samuel Cruz", "345.345.345-34", Sexo.MASCULINO, "(51) 97744-0023", 24, LocalDate.of(2025, 2, 28), "2025028", PlanoTreino.PREMIUM, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Tiago Ramos", "987.654.321-00", Sexo.MASCULINO, "(11) 98888-7777", 26, LocalDate.of(2024, 6, 15), "2024065", PlanoTreino.ELITE, FrequenciaPagamento.MENSAL),
            new Aluno("Ursula Andress", "876.543.210-11", Sexo.FEMININO, "(21) 97777-6666", 36, LocalDate.of(2023, 11, 20), "2023112", PlanoTreino.BASIC, FrequenciaPagamento.ANUAL),
            new Aluno("Vinicius Junior", "765.432.109-22", Sexo.MASCULINO, "(31) 96666-5555", 22, LocalDate.of(2025, 1, 10), "2025010", PlanoTreino.PREMIUM, FrequenciaPagamento.SEMESTRAL),
            new Aluno("William Bonner", "654.321.098-33", Sexo.MASCULINO, "(41) 95555-4444", 55, LocalDate.of(2022, 8, 5), "2022085", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL),
            new Aluno("Xuxa Meneghel", "543.210.987-44", Sexo.FEMININO, "(51) 94444-3333", 60, LocalDate.of(2022, 2, 2), "2022022", PlanoTreino.ELITE, FrequenciaPagamento.ANUAL),
            new Aluno("Yuri Alberto", "432.109.876-55", Sexo.MASCULINO, "(61) 93333-2222", 23, LocalDate.of(2024, 9, 12), "2024092", PlanoTreino.PREMIUM, FrequenciaPagamento.MENSAL),
            new Aluno("Zeca Pagodinho", "321.098.765-66", Sexo.MASCULINO, "(71) 92222-1111", 62, LocalDate.of(2023, 4, 1), "2023041", PlanoTreino.BASIC, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Amanda Nunes", "210.987.654-77", Sexo.FEMININO, "(81) 91111-0000", 34, LocalDate.of(2025, 3, 30), "2025030", PlanoTreino.ELITE, FrequenciaPagamento.MENSAL),
            new Aluno("Bruno Mars", "109.876.543-88", Sexo.MASCULINO, "(91) 99999-8888", 38, LocalDate.of(2024, 12, 25), "2024125", PlanoTreino.PREMIUM, FrequenciaPagamento.ANUAL),
            new Aluno("Clara Nunes", "098.765.432-99", Sexo.FEMININO, "(11) 98888-9999", 29, LocalDate.of(2025, 7, 7), "2025077", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL),
            new Aluno("Diego Maradona", "987.654.321-10", Sexo.MASCULINO, "(21) 97777-8888", 60, LocalDate.of(2022, 11, 10), "2022111", PlanoTreino.ELITE, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Elza Soares", "876.543.210-20", Sexo.FEMININO, "(31) 96666-7777", 75, LocalDate.of(2023, 1, 15), "2023015", PlanoTreino.BASIC, FrequenciaPagamento.ANUAL),
            new Aluno("Fabio Porchat", "765.432.109-30", Sexo.MASCULINO, "(41) 95555-6666", 40, LocalDate.of(2025, 10, 5), "2025105", PlanoTreino.PREMIUM, FrequenciaPagamento.MENSAL),
            new Aluno("Gloria Maria", "654.321.098-40", Sexo.FEMININO, "(51) 94444-5555", 58, LocalDate.of(2024, 5, 20), "2024052", PlanoTreino.ELITE, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Humberto Gessinger", "543.210.987-50", Sexo.MASCULINO, "(61) 93333-4444", 55, LocalDate.of(2023, 8, 8), "2023088", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL),
            new Aluno("Ivete Sangalo", "432.109.876-60", Sexo.FEMININO, "(71) 92222-3333", 50, LocalDate.of(2022, 12, 12), "2022122", PlanoTreino.PREMIUM, FrequenciaPagamento.ANUAL),
            new Aluno("Jota Quest", "321.098.765-70", Sexo.MASCULINO, "(81) 91111-2222", 45, LocalDate.of(2024, 2, 14), "2024021", PlanoTreino.ELITE, FrequenciaPagamento.MENSAL),
            new Aluno("Katy Perry", "210.987.654-80", Sexo.FEMININO, "(91) 90000-1111", 39, LocalDate.of(2025, 6, 1), "2025061", PlanoTreino.BASIC, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Luan Santana", "109.876.543-90", Sexo.MASCULINO, "(11) 99911-2233", 32, LocalDate.of(2023, 3, 3), "2023033", PlanoTreino.PREMIUM, FrequenciaPagamento.MENSAL),
            new Aluno("Marisa Monte", "098.765.432-00", Sexo.FEMININO, "(21) 98822-3344", 54, LocalDate.of(2024, 8, 18), "2024081", PlanoTreino.ELITE, FrequenciaPagamento.ANUAL),
            new Aluno("Nando Reis", "987.123.456-11", Sexo.MASCULINO, "(31) 97733-4455", 58, LocalDate.of(2025, 1, 30), "2025013", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL),
            new Aluno("Olivia Palito", "876.234.567-22", Sexo.FEMININO, "(41) 96644-5566", 28, LocalDate.of(2022, 10, 10), "2022101", PlanoTreino.PREMIUM, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Pelé Nascimento", "765.345.678-33", Sexo.MASCULINO, "(51) 95555-6677", 80, LocalDate.of(2020, 1, 1), "2020001", PlanoTreino.ELITE, FrequenciaPagamento.ANUAL),
            new Aluno("Queen Elizabeth", "654.456.789-44", Sexo.FEMININO, "(61) 94466-7788", 90, LocalDate.of(2019, 5, 5), "2019055", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL),
            new Aluno("Roberto Carlos", "543.567.890-55", Sexo.MASCULINO, "(71) 93377-8899", 78, LocalDate.of(2021, 12, 25), "2021125", PlanoTreino.PREMIUM, FrequenciaPagamento.ANUAL),
            new Aluno("Fernanda Montenegro", "666.777.444-55", Sexo.FEMININO, "(21) 94444-6666", 94, LocalDate.of(2023, 3, 10), "2023031", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL),
            new Aluno("Gusttavo Lima", "777.888.333-66", Sexo.MASCULINO, "(62) 93333-7777", 34, LocalDate.of(2024, 6, 15), "2024061", PlanoTreino.ELITE, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Maisa Silva", "888.999.222-77", Sexo.FEMININO, "(11) 92222-8888", 21, LocalDate.of(2025, 1, 20), "2025012", PlanoTreino.BASIC, FrequenciaPagamento.ANUAL),
            new Aluno("Péricles Faria", "999.000.111-88", Sexo.MASCULINO, "(11) 91111-9999", 54, LocalDate.of(2022, 5, 5), "2022051", PlanoTreino.PREMIUM, FrequenciaPagamento.MENSAL),
            new Aluno("Whindersson Nunes", "000.111.000-99", Sexo.MASCULINO, "(86) 90000-1111", 29, LocalDate.of(2023, 9, 9), "2023091", PlanoTreino.ELITE, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Ana Castela", "121.232.343-12", Sexo.FEMININO, "(67) 99888-7777", 20, LocalDate.of(2025, 12, 1), "2025120", PlanoTreino.PREMIUM, FrequenciaPagamento.ANUAL),
            new Aluno("Belo Pires", "232.343.454-23", Sexo.MASCULINO, "(11) 98777-6666", 49, LocalDate.of(2024, 4, 12), "2024042", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL),
            new Aluno("Claudia Leitte", "343.454.565-34", Sexo.FEMININO, "(71) 97666-5555", 43, LocalDate.of(2023, 7, 7), "2023071", PlanoTreino.ELITE, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Daniel Cantor", "454.565.676-45", Sexo.MASCULINO, "(11) 96555-4444", 55, LocalDate.of(2021, 10, 30), "2021103", PlanoTreino.BASIC, FrequenciaPagamento.ANUAL),
            new Aluno("Emanuelle Araújo", "565.676.787-56", Sexo.FEMININO, "(71) 95444-3333", 47, LocalDate.of(2022, 11, 11), "2022112", PlanoTreino.PREMIUM, FrequenciaPagamento.MENSAL),
            new Aluno("Fagner Raimundo", "676.787.898-67", Sexo.MASCULINO, "(85) 94333-2222", 74, LocalDate.of(2020, 2, 20), "2020022", PlanoTreino.BASIC, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Gretchen Miranda", "787.898.909-78", Sexo.FEMININO, "(21) 93222-1111", 64, LocalDate.of(2025, 5, 15), "2025051", PlanoTreino.ELITE, FrequenciaPagamento.ANUAL),
            new Aluno("Leonardo Costa", "898.909.010-89", Sexo.MASCULINO, "(62) 92111-0000", 60, LocalDate.of(2023, 8, 25), "2023082", PlanoTreino.PREMIUM, FrequenciaPagamento.MENSAL),
            new Aluno("Marilia Gabriela", "909.010.121-90", Sexo.FEMININO, "(11) 91000-9999", 75, LocalDate.of(2024, 1, 15), "2024016", PlanoTreino.BASIC, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Ney Matogrosso", "010.121.232-01", Sexo.MASCULINO, "(21) 90999-8888", 82, LocalDate.of(2021, 3, 3), "2021031", PlanoTreino.ELITE, FrequenciaPagamento.ANUAL),
            new Aluno("Preta Gil", "112.223.334-11", Sexo.FEMININO, "(21) 99888-7777", 49, LocalDate.of(2025, 2, 28), "2025029", PlanoTreino.PREMIUM, FrequenciaPagamento.MENSAL),
            new Aluno("Raul Gil", "223.334.445-22", Sexo.MASCULINO, "(11) 98777-6666", 86, LocalDate.of(2022, 12, 1), "2022123", PlanoTreino.BASIC, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Suzana Vieira", "334.445.556-33", Sexo.FEMININO, "(21) 97666-5555", 81, LocalDate.of(2024, 11, 20), "2024112", PlanoTreino.ELITE, FrequenciaPagamento.ANUAL),
            new Aluno("Tiririca Silva", "445.556.667-44", Sexo.MASCULINO, "(11) 96555-4444", 58, LocalDate.of(2023, 6, 10), "2023061", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL),
            new Aluno("Vanessa da Mata", "556.667.778-55", Sexo.FEMININO, "(65) 95444-3333", 48, LocalDate.of(2025, 8, 8), "2025081", PlanoTreino.PREMIUM, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Tatiana Pinto", "456.456.456-45", Sexo.FEMININO, "(61) 96655-0024", 26, LocalDate.of(2023, 3, 10), "2023030", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL),
            new Aluno("Ugo Ramos", "567.567.567-56", Sexo.MASCULINO, "(71) 95566-0025", 29, LocalDate.of(2022, 6, 15), "2022066", PlanoTreino.ELITE, FrequenciaPagamento.ANUAL),
            new Aluno("Viviane Melo", "678.678.678-67", Sexo.FEMININO, "(81) 94477-0026", 33, LocalDate.of(2024, 2, 20), "2024022", PlanoTreino.PREMIUM, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Wagner Luz", "789.789.789-78", Sexo.MASCULINO, "(91) 93388-0027", 41, LocalDate.of(2021, 8, 8), "2021088", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL),
            new Aluno("Xavier Nogueira", "890.890.890-89", Sexo.MASCULINO, "(11) 92299-0028", 36, LocalDate.of(2022, 9, 9), "2022099", PlanoTreino.ELITE, FrequenciaPagamento.ANUAL),
            new Aluno("Valdir Souza", "111.999.222-88", Sexo.MASCULINO, "(11) 91234-1234", 45, LocalDate.of(2023, 5, 20), "2023055", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL),
            new Aluno("Wesley Safadão", "222.888.333-77", Sexo.MASCULINO, "(85) 99999-0000", 35, LocalDate.of(2024, 12, 10), "2024120", PlanoTreino.PREMIUM, FrequenciaPagamento.ANUAL),
            new Aluno("Ximbinha Guitarra", "333.777.444-66", Sexo.MASCULINO, "(91) 98888-7777", 50, LocalDate.of(2022, 1, 15), "2022015", PlanoTreino.ELITE, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Yasmin Brunet", "444.666.555-55", Sexo.FEMININO, "(21) 97777-6666", 34, LocalDate.of(2026, 2, 1), "2026011", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL), // Entrou agora
            new Aluno("Zezé Di Camargo", "555.555.666-44", Sexo.MASCULINO, "(62) 96666-5555", 60, LocalDate.of(2025, 11, 20), "2025112", PlanoTreino.PREMIUM, FrequenciaPagamento.ANUAL),
            new Aluno("Adriana Lima", "666.444.777-33", Sexo.FEMININO, "(71) 95555-4444", 42, LocalDate.of(2023, 8, 30), "2023080", PlanoTreino.ELITE, FrequenciaPagamento.MENSAL),
            new Aluno("Cauã Reymond", "777.333.888-22", Sexo.MASCULINO, "(21) 94444-3333", 43, LocalDate.of(2024, 4, 10), "2024041", PlanoTreino.BASIC, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Débora Falabella", "888.222.999-11", Sexo.FEMININO, "(31) 93333-2222", 44, LocalDate.of(2025, 9, 5), "2025090", PlanoTreino.PREMIUM, FrequenciaPagamento.MENSAL),
            new Aluno("Emilio Surita", "999.111.000-00", Sexo.MASCULINO, "(11) 92222-1111", 61, LocalDate.of(2020, 3, 15), "2020035", PlanoTreino.ELITE, FrequenciaPagamento.ANUAL),
            new Aluno("Fátima Bernardes", "000.999.111-99", Sexo.FEMININO, "(21) 91111-0000", 60, LocalDate.of(2026, 1, 18), "2026012", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL),
            new Aluno("Galvão Bueno", "123.321.123-88", Sexo.MASCULINO, "(11) 99988-7766", 73, LocalDate.of(2021, 6, 20), "2021062", PlanoTreino.PREMIUM, FrequenciaPagamento.ANUAL),
            new Aluno("Hortência Marcari", "234.432.234-77", Sexo.FEMININO, "(11) 98877-6655", 64, LocalDate.of(2022, 10, 10), "2022100", PlanoTreino.ELITE, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Inês Brasil", "345.543.345-66", Sexo.FEMININO, "(21) 97766-5544", 54, LocalDate.of(2026, 2, 4), "2026013", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL), // Entrou ontem
            new Aluno("João Gomes", "456.654.456-55", Sexo.MASCULINO, "(81) 96655-4433", 21, LocalDate.of(2024, 7, 7), "2024070", PlanoTreino.PREMIUM, FrequenciaPagamento.MENSAL),
            new Aluno("Kevinho Funk", "567.765.567-44", Sexo.MASCULINO, "(19) 95544-3322", 25, LocalDate.of(2025, 2, 15), "2025021", PlanoTreino.ELITE, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Ludmilla Oliveira", "678.876.678-33", Sexo.FEMININO, "(21) 94433-2211", 28, LocalDate.of(2023, 11, 11), "2023110", PlanoTreino.BASIC, FrequenciaPagamento.ANUAL),
            new Aluno("Mano Brown", "789.987.789-22", Sexo.MASCULINO, "(11) 93322-1100", 53, LocalDate.of(2019, 1, 1), "2019001", PlanoTreino.PREMIUM, FrequenciaPagamento.MENSAL),
            new Aluno("Naldo Benny", "890.098.890-11", Sexo.MASCULINO, "(21) 92211-0099", 43, LocalDate.of(2022, 4, 1), "2022040", PlanoTreino.BASIC, FrequenciaPagamento.MENSAL),
            new Aluno("Oscar Schmidt", "901.109.901-00", Sexo.MASCULINO, "(11) 91100-9988", 65, LocalDate.of(2020, 5, 20), "2020052", PlanoTreino.ELITE, FrequenciaPagamento.ANUAL),
            // --- 3. ALUNOS INATIVOS / CANCELADOS (Usando 2º Construtor) ---
            new Aluno("Yasmin Farias", "901.901.901-90", Sexo.FEMININO, "(21) 91100-0029", 22, LocalDate.of(2023, 11, 11), true, LocalDate.of(2024, 2, 2), "2023111", PlanoTreino.PREMIUM, FrequenciaPagamento.MENSAL),
            new Aluno("Zeca Camargo", "012.012.012-01", Sexo.MASCULINO, "(31) 90011-0030", 55, LocalDate.of(2020, 1, 1), true, LocalDate.of(2025, 12, 31), "2020001", PlanoTreino.BASIC, FrequenciaPagamento.ANUAL),
            new Aluno("Andreia Horta", "123.000.123-99", Sexo.FEMININO, "(41) 99900-1122", 30, LocalDate.of(2021, 4, 1), true, LocalDate.of(2022, 4, 1), "2021041", PlanoTreino.PREMIUM, FrequenciaPagamento.MENSAL),
            new Aluno("Beto Falcão", "321.111.321-88", Sexo.MASCULINO, "(51) 98811-2233", 42, LocalDate.of(2019, 10, 10), true, LocalDate.of(2023, 1, 1), "2019100", PlanoTreino.ELITE, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Carminha Tufão", "213.222.132-77", Sexo.FEMININO, "(61) 97722-3344", 45, LocalDate.of(2018, 2, 15), true, LocalDate.of(2020, 3, 20), "2018025", PlanoTreino.BASIC, FrequenciaPagamento.ANUAL),
            new Aluno("Zeca Baleiro", "667.778.889-66", Sexo.MASCULINO, "(98) 94333-2222", 57, LocalDate.of(2021, 5, 5), true, LocalDate.of(2022, 12, 10), "2021051", PlanoTreino.BASIC, FrequenciaPagamento.ANUAL),
            new Aluno("Wanessa Camargo", "778.889.990-77", Sexo.FEMININO, "(62) 93222-1111", 41, LocalDate.of(2023, 1, 10), true, LocalDate.of(2024, 1, 10), "2023013", PlanoTreino.ELITE, FrequenciaPagamento.MENSAL),
            new Aluno("Tom Cavalcante", "889.990.001-88", Sexo.MASCULINO, "(85) 92111-0000", 62, LocalDate.of(2020, 9, 20), true, LocalDate.of(2021, 8, 15), "2020092", PlanoTreino.PREMIUM, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Simaria Mendes", "990.001.112-99", Sexo.FEMININO, "(11) 91000-9999", 41, LocalDate.of(2022, 4, 4), true, LocalDate.of(2023, 4, 4), "2022044", PlanoTreino.BASIC, FrequenciaPagamento.ANUAL),
            new Aluno("Pabllo Vittar", "012.210.012-99", Sexo.FEMININO, "(34) 90099-8877", 30, LocalDate.of(2021, 9, 9), true, LocalDate.of(2025, 1, 10), "2021099", PlanoTreino.PREMIUM, FrequenciaPagamento.SEMESTRAL),
            new Aluno("Renato Aragão", "001.112.223-00", Sexo.MASCULINO, "(21) 90999-8888", 89, LocalDate.of(2019, 1, 15), true, LocalDate.of(2020, 12, 20), "2019015", PlanoTreino.ELITE, FrequenciaPagamento.MENSAL)

    ));

    private final List<Instrutor> instrutores = new ArrayList<>(List.of(
            // --- 2026 (Novos Contratados) ---
            new Instrutor("Amanda Vasconcelos", "111.111.111-11", Sexo.FEMININO, "(11) 99900-1111", 26, LocalDate.of(2026, 1, 10), "INST2601", 30, ModalidadeTreino.MUSCULACAO, new BigDecimal("1621.00")),
            new Instrutor("Bernardo Silva", "222.222.222-22", Sexo.MASCULINO, "(21) 98800-2222", 28, LocalDate.of(2026, 1, 15), "INST2602", 40, ModalidadeTreino.CROSSFIT, new BigDecimal("1621.00")),

            // --- Equipe Fixa (Anos anteriores) ---
            new Instrutor("Gisele Bündchen", "777.777.777-77", Sexo.FEMININO, "(71) 93300-7777", 42, LocalDate.of(2019, 8, 15), "INST07", 20, ModalidadeTreino.FUNCIONAL, new BigDecimal("1621.00")),
            new Instrutor("Hugo Gloss", "888.888.888-88", Sexo.MASCULINO, "(81) 92200-8888", 30, LocalDate.of(2024, 1, 10), "INST08", 30, ModalidadeTreino.SPINNING, new BigDecimal("1621.00")),
            new Instrutor("Neymar Santos", "456.456.456-04", Sexo.MASCULINO, "(51) 96644-4455", 29, LocalDate.of(2025, 7, 7), "INST14", 44, ModalidadeTreino.MUSCULACAO, new BigDecimal("1621.00")),

            // --- Demitidos/Inativos (Usando construtor longo) ---
            new Instrutor("Ana Maria Braga", "777.888.777-88", Sexo.FEMININO, "(91) 93388-8877", 70, LocalDate.of(2016, 2, 2), true, LocalDate.of(2025, 1, 10), "INST_OLD_2", 20, ModalidadeTreino.DANCA, new BigDecimal("1621.00")),
            new Instrutor("Fausto Silva", "888.999.888-99", Sexo.MASCULINO, "(11) 92299-9988", 72, LocalDate.of(2014, 5, 5), true, LocalDate.of(2023, 6, 1), "INST_OLD_3", 40, ModalidadeTreino.MUSCULACAO, new BigDecimal("1621.00"))
    ));

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Instrutor> getInstrutores() {
        return instrutores;
    }

}
