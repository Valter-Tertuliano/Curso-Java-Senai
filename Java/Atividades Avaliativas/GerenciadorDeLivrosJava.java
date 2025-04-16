import java.util.Scanner;

public class GerenciadorDeLivrosJava {

    // Método para limpar o terminal
    public static void limparTerminal() {
        /*
         * Método que tenta limpar o terminal de acordo com o sistema operacional
         * 
         * Parâmetros:
         *  Nenhum
         * 
         * Retorno:
         *  Nenhum (apenas executa comando no terminal)
         */
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar limpar a tela.");
        }
    }

    // Método para exibir os livros cadastrados
    public static void exibirLivros(String[][] matriz) {
        /*
         * Método que exibe todos os livros cadastrados
         * 
         * Parâmetros:
         *  matriz: vetor bidimensional contendo os dados dos livros
         * 
         * Retorno:
         *  Nenhum (apenas imprime no terminal)
         */
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == null) {
                System.out.println("----- FIM -----");
                break;
            } else {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(" " + matriz[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    // Método para obter uma String do usuário (título ou autor)
    public static String entradaUsuario(Scanner scanner, String informacao) {
        /*
         * Método para coletar título ou autor do livro com formatação visual
         * 
         * Parâmetros:
         *  scanner: leitor de entrada
         *  informacao: uma string dizendo "título" ou "autor" 
         * 
         * Retorna:
         *  A string formatada com a entrada do usuário ("| entrada ")
         */
        System.out.printf("Informe %s: ", informacao);
        String resposta = scanner.nextLine();
        return "| " + resposta.trim() + " ";
    }

    // Método para obter e validar a data
    public static String obterData(Scanner scanner) {
        /*
         * Método para validar e formatar a data de publicação de um livro
         * 
         * Parâmetros:
         *  scanner: objeto utilizado para capturar os dados digitados pelo usuário
         * 
         * Retorno:
         *  String representando a data no formato "| dd/mm/aaaa" ou "Data Inválida"
         */

        String dataCompleta;

        System.out.println("\n ---------- Obtendo Data de Publicação ----------\n");

        System.out.print("Digite o dia da publicação do livro (apenas dois números): ");
        int dia = scanner.nextInt();

        if (dia < 1 || dia > 31) {
            System.out.println("Dia deve estar entre 1 e 31 !!!");
            dia = 0;
        }

        System.out.print("Digite o mês da publicação do livro (apenas dois números): ");
        int mes = scanner.nextInt();

        if (mes < 1 || mes > 12) {
            System.out.println("Mês deve estar entre 1 e 12 !!!");
            mes = 0;
        }

        System.out.print("Digite o ano da Publicação do livro (apenas 4 dígitos): ");
        int ano = scanner.nextInt();
        scanner.nextLine(); // limpar o buffer

        if (ano > 2025) {
            System.out.println("Ano informado está muito avançado, estamos em 2025 !!!");
            ano = 0;
        }

        if (dia != 0 && mes != 0 && ano != 0) {
            dataCompleta = "| " + dia + "/" + mes + "/" + ano;
            return dataCompleta;
        } else {
            return "Data Inválida";
        }
    }

    // Método para o cadastro de livros
    public static void cadastrarLivro(String[][] matriz, Scanner scanner) {
        /*
         * Método para cadastrar livros, preenchendo os campos título, autor e data
         * 
         * Parâmetros:
         *  matriz: vetor bidimensional para armazenar os livros
         *  scanner: leitor de entrada
         * 
         * Retorno:
         *  Nenhum (atualiza a matriz com os dados)
         */
        System.out.println("\nLimite de Livros cadastrados: " + matriz.length);

        byte espacoLivre = 0;
        byte marcarIndice = 0;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == null) {
                espacoLivre += 1;
                if (marcarIndice == 0) {
                    marcarIndice = (byte) i;
                }
            }
        }

        System.out.println("Total de espaços disponíveis: " + espacoLivre);

        if (espacoLivre > 0) {
            System.out.print("\n ----- Iniciando Cadastro de Livro -----\n");
            matriz[marcarIndice][0] = entradaUsuario(scanner, "o Título do Livro");
            matriz[marcarIndice][1] = entradaUsuario(scanner, "o Autor do Livro");
            matriz[marcarIndice][2] = obterData(scanner);
            System.out.print(" ----- Cadastro de Livro Concluído -----\n");
        } else {
            System.out.println("Infelizmente, não temos espaço disponível para adicionar mais livros.");
        }
    }

    // Método para buscar livros por autor
    public static void buscarAutor(String[][] matriz, Scanner scanner) {
        /*
         * Método para buscar livros cadastrados por nome do autor
         * 
         * Parâmetros:
         *  matriz: vetor bidimensional contendo os livros
         *  scanner: leitor de entrada para receber o autor
         * 
         * Retorno:
         *  Nenhum (exibe livros encontrados ou mensagem de erro)
         */
        String entrada = entradaUsuario(scanner, "autor");
        String autorBuscado = entrada.toLowerCase().trim();

        boolean encontrado = false;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] != null) {
                String autorNaMatriz = matriz[i][1].toLowerCase().trim();
                if (autorNaMatriz.equals(autorBuscado)) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        System.out.print(matriz[i][j] + " ");
                    }
                    System.out.println();
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("Autor não encontrado");
        }
    }

    // Método para excluir um livro pelo titulo
    public static String[][] excluirLivro(String[][] matriz, Scanner scanner){
        String entrada = entradaUsuario(scanner, "titulo");
        String tituloBuscado = entrada.toLowerCase().trim();

        // obter linhas
        int linhas = matriz.length;
        int colunas = matriz[0].length;

        String[][] novaMatriz = new String[linhas][colunas];

        boolean encontrado = false;

        for (int i = 0; i < matriz.length; i++){
            if (matriz[i][0] != null && matriz[i][0].equa)
        }


        

        if (!encontrado) {
            System.out.println("Autor não encontrado");
        }

    }

    // Método principal
    public static void main(String[] args) {
        /*
         * Método principal que inicializa o sistema de gerenciamento
         * 
         * Parâmetros:
         *  Nenhum
         * 
         * Retorno:
         *  Nenhum (executa o sistema)
         */
        String[][] livros = new String[100][3];

        livros[0][0] = "| Título do Livro ";
        livros[0][1] = "| Autor do Livro ";
        livros[0][2] = "| Data de Publicação do Livro ";

        Scanner scanner = new Scanner(System.in);

        // Testes do sistema
        cadastrarLivro(livros, scanner);
        exibirLivros(livros);
        buscarAutor(livros, scanner);

        scanner.close();
    }
}
