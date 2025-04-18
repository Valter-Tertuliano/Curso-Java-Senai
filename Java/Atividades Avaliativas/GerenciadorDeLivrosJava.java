import java.util.Scanner;

public class GerenciadorDeLivrosJava {

    /**
     * Limpa o terminal do sistema operacional.
     * Funciona tanto para Windows quanto para sistemas Unix-like.
     */
    public static void limparTerminal() {
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

    /**
     * Exibe informações sobre o armazenamento disponível na matriz.
     *
     * @param matriz Matriz contendo os registros de livros.
     */
    public static void exibirArmazenamento(String[][] matriz) {
        int[] info = obterDetalhesArmazenamento(matriz);
        int espacoLivre = info[0];

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("|     ---->>>----->|<-----<<<->>>----->| Memória |<-----<<<->>>----->|<-----<<<     |");
        System.out.println();
        System.out.println("  |Limite de Armazenamento: " + (matriz.length - 1));
        System.out.println("  |Espaço Livre: " + espacoLivre);
        System.out.println();
        System.out.println("|     ---->>>----->|<-----<<<->>>----->| Memória |<-----<<<->>>----->|<-----<<<     |");
        System.out.println("-------------------------------------------------------------------------------------");
    }

    /**
     * Retorna detalhes sobre o espaço de armazenamento disponível na matriz.
     *
     * @param matriz Matriz contendo os registros de livros.
     * @return Array com o número de espaços livres e o primeiro índice livre.
     */
    public static int[] obterDetalhesArmazenamento(String[][] matriz) {
        int espacoLivre = 0;
        int marcarIndice = 0;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == null) {
                espacoLivre += 1;
                if (marcarIndice == 0) {
                    marcarIndice = (int) i;
                }
            }
        }

        return new int[] {espacoLivre, marcarIndice};
    }

    /**
     * Exibe todos os livros cadastrados na matriz.
     *
     * @param matriz Matriz contendo os dados dos livros.
     */
    public static void exibirLivros(String[][] matriz) {
        int encontrados = 0;

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("    ------------------------ Registro de Livros Cadastrados ---------------------");
        System.out.println("-------------------------------------------------------------------------------------\n");

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == null) {
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("\tLivros Encontrados: " + (encontrados - 1));
                System.out.println("------------------------------------------------------------------------------------- ");
                break;
            } else {
                System.out.println("-------------------------------------------------------------------------------------");
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(" " + matriz[i][j] + " ");
                }
                encontrados++;
                System.out.println();
            }
        }
    }

    /**
     * Captura a entrada do usuário para título ou autor do livro.
     *
     * @param scanner Objeto Scanner para leitura.
     * @param informacao Tipo de dado a ser solicitado (título ou autor).
     * @return Entrada do usuário formatada.
     */
    public static String entradaUsuario(Scanner scanner, String informacao) {
        System.out.printf("Informe %s: ", informacao);
        return "| " + scanner.nextLine() + " ";
    }

    /**
     * Solicita e valida a data de publicação do livro.
     *
     * @param scanner Objeto Scanner para leitura.
     * @return Data formatada no padrão dd/mm/aaaa, ou "Data Inválida".
     */
    public static String obterData(Scanner scanner) {
        System.out.println("------------------------------------------------------------------------------------- ");
        System.out.println("\n\t\t----- Obtendo Data de Publicação -----\n");

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
        scanner.nextLine();

        if (ano > 2025) {
            System.out.println("Ano informado está muito avançado, estamos em 2025 !!!");
            ano = 0;
        }

        System.out.println("-------------------------------------------------------------------------------------");

        if (dia != 0 && mes != 0 && ano != 0) {
            return "| " + dia + "/" + mes + "/" + ano;
        } else {
            return "Data Inválida";
        }
    }

    /**
     * Cadastra um novo livro na matriz.
     *
     * @param matriz Matriz contendo os registros dos livros.
     * @param scanner Objeto Scanner para entrada de dados.
     */
    public static void cadastrarLivro(String[][] matriz, Scanner scanner) {
        int[] info = obterDetalhesArmazenamento(matriz);
        int espacoLivre = info[0];
        int marcarIndice = info[1];

        if (espacoLivre > 0) {
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.print("\n\t\t ----- Iniciando Cadastro de Livro -----\n\n");
            matriz[marcarIndice][0] = entradaUsuario(scanner, "o Título do Livro");
            matriz[marcarIndice][1] = entradaUsuario(scanner, "o Autor do Livro");
            matriz[marcarIndice][2] = obterData(scanner);
            System.out.print("----- Cadastro de Livro Concluído -----\n");
            System.out.println("-------------------------------------------------------------------------------------");
        } else {
            System.out.println("Infelizmente, não temos espaço disponível para adicionar mais livros. ");
            System.out.println("------------------------------------------------------------------------------------- ");
        }
    }

    /**
     * Busca livros cadastrados com base no nome do autor.
     *
     * @param matriz Matriz contendo os registros dos livros.
     * @param scanner Objeto Scanner para entrada de dados.
     */
    public static void buscarAutor(String[][] matriz, Scanner scanner) {
        String entrada = entradaUsuario(scanner, "autor").toLowerCase().trim();
        boolean encontrado = false;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] != null) {
                String autor = matriz[i][1].toLowerCase().trim();
                if (autor.equals(entrada)) {
                    for (String campo : matriz[i]) {
                        System.out.print(campo + " ");
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

    /**
     * Exclui um livro da matriz com base no título informado.
     *
     * @param matriz Matriz contendo os registros dos livros.
     * @param scanner Objeto Scanner para entrada de dados.
     * @return Nova matriz atualizada com o livro removido, se encontrado.
     */
    public static String[][] excluirLivro(String[][] matriz, Scanner scanner) {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("\t\t\t------ Excluir Livro -----");
        String tituloBuscado = entradaUsuario(scanner, "titulo");
        int linhas = matriz.length;
        int colunas = matriz[0].length;
        String[][] novaMatriz = new String[linhas][colunas];
        boolean encontrado = false;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] != null && matriz[i][0].equalsIgnoreCase(tituloBuscado)) {
                encontrado = true;
                continue;
            }
            for (int j = 0; j < matriz[i].length; j++) {
                novaMatriz[i][j] = matriz[i][j];
            }
        }

        if (!encontrado) {
            System.out.println("Titulo não encontrado");
            System.out.println("------------------------------------------------------------------------------------- ");
        } else {
            System.out.println("Livro: " + tituloBuscado + " apagado com sucesso");
            System.out.println("------------------------------------------------------------------------------------- ");
        }

        return novaMatriz;
    }

    /**
     * Exibe o menu principal com as opções disponíveis.
     */
    public static void exibirMenu() {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("       ----     ---   ---   ----- Menu Principal -----   ---   ---     -----         ");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println(" [ 1 ] CADASTRAR LIVRO");
        System.out.println(" [ 2 ] EXCLUIR LIVRO");
        System.out.println(" [ 3 ] BUSCAR AUTOR");
        System.out.println(" [ 4 ] EXIBIR TODOS OS LIVROS");
        System.out.println(" [ 0 ] SAIR");
        System.out.println("-------------------------------------------------------------------------------------");
    }

    /**
     * Controla a execução das operações do menu principal.
     *
     * @param matriz Matriz com os registros dos livros.
     * @param scanner Objeto Scanner para leitura do usuário.
     */
    public static void executarMenu(String[][] matriz, Scanner scanner) {
        int operacao = 100;

        while (operacao > 0) {
            exibirArmazenamento(matriz);
            exibirMenu();
            System.out.print("Digite um número: ");
            operacao = scanner.nextInt();
            scanner.nextLine();

            switch (operacao) {
                case 1 -> {
                    cadastrarLivro(matriz, scanner);
                    limparTerminal();
                }
                case 2 -> {
                    limparTerminal();
                    matriz = excluirLivro(matriz, scanner);
                }
                case 3 -> {
                    limparTerminal();
                    buscarAutor(matriz, scanner);
                }
                case 4 -> {
                    limparTerminal();
                    exibirLivros(matriz);
                }
                case 0 -> {
                    limparTerminal();
                    System.out.println("Obrigado por usar nosso sistema.");
                    System.exit(0);
                }
            }
        }
    }

    /**
     * Método principal: inicializa o sistema de gerenciamento de livros.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        String[][] livros = new String[100001][3];
        livros[0][0] = "| Título do Livro ";
        livros[0][1] = "| Autor do Livro ";
        livros[0][2] = "| Data de Publicação do Livro ";

        Scanner scanner = new Scanner(System.in);
        executarMenu(livros, scanner);
        scanner.close();
    }
}
