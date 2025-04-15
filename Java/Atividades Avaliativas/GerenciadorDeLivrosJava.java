import java.util.Scanner;


public class GerenciadorDeLivrosJava {
    // desenvolver um programa que gerencie informações de livros, 
    // realizando cadastro, listagem, busca e exclusão de livros cadastrados

    public static void limparTerminal(){
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

    // metodo para visualizar a coleção de livros
    public static void exibirLivros(String[][] matriz){
        for (int i = 0; i < matriz.length; i++){
            if (matriz[i][0] == null){
                System.out.println("----- FIM -----");
                break;
            } else {
                for (int j = 0; j < matriz[i].length; j++){
                    System.out.print(" " + matriz[i][j] + " ");
                    }
                }
            System.out.println();
    }
    }

    // metodo para obter uma String do usuario ( titulo e autor )
    public static String entradaUsuario(Scanner scanner, String informacao){
        /*
         * metodo para coletar titulo ou autor do livro
         * 
         * Parametros:
         *  scanner: leitor de entrada
         *  informacao: uma string dizendo titulo ou autor 
         * 
         * Retorna: A string com a entrada do usuario
         */

        System.out.printf("Informe %s: ", informacao);
        String resposta = scanner.nextLine();
        return "| " + resposta + " ";

    }

    // método para obter e validar a data
    public static String obterData(Scanner scanner){

            /*
            * Método para validar a data de publicação de um livro
            * 
            * 1 - Solicita do usuário o dia, mês e ano da publicação utilizando o Scanner
            * 2 - Verifica se o dia está entre 1 e 31
            * 3 - Verifica se o mês está entre 1 e 12
            * 4 - Verifica se o ano não ultrapassa o ano atual (2025)
            * 5 - Caso todas as partes da data estejam válidas, retorna a data formatada como string
            * 6 - Caso contrário, retorna "Data Inválida"
            * 
            * Parâmetros:
            *  scanner: Objeto utilizado para capturar os dados digitados pelo usuário
            * 
            * Retorno:
            *  String representando a data no formato "dd/mm/aaaa" ou a mensagem "Data Inválida"
            */


        // concatenação final das datas
        String dataCompleta;

        System.out.println("\n ---------- Obtendo Data de Publicação ----------\n");
        
        
        // obter dia para validar 
        System.out.print("Digite o dia da publicação do livro (apenas dois numeros): ");
        int dia = scanner.nextInt();

        if (dia >= 1 && dia <= 31){
            System.out.println("Dia dentro dos parametros: " + dia);
        } else {
            System.out.print("Dia deve estar entre 1 e 31 !!!\n");
            System.out.println("Valor fora do intervalo adequado para dia: " + dia);
            dia = 0;
        }
        
        // obter mes para validar
        System.out.print("Digite o mês da publicação do livro (apenas dois numeros): ");
        int mes = scanner.nextInt();
        
        if (mes >= 1 && mes <= 12){
            System.out.println("Mes informado dentro dos parametros: " + mes);
        } else {
            mes = 0;
            System.out.print("Mês deve ser Numeros entre 1 e 12");
            System.out.println("Valor fora do intervalo adequado para mes: " + dia);
        }

        // obter ano para validar
        System.out.print("Digite o ano da Publicação do livro (apenas 4 digitos): " );
        int ano = scanner.nextInt();

        // verificar se o ano não passou do ano atual
        if (ano > 2025){
            System.out.println("Ano informado está muito avançado, estamos em 2025 !!!");
            System.out.println("Esse livro não pode ter vindo do futuro.");
            ano = 0;
        } else {
            System.out.println("Ano dentro dos parametros esperado: " + ano);
        }

        // se qualquer das variaveis deu 0, houve erro e validação não pode ser concluida
        if (mes != 0 && ano != 0 && dia != 0){
            dataCompleta = "| " + String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano);
            return dataCompleta;
        } else {
            return "Data Inválida";
        }

        
    }
    
    // Método para o cadastro de livros
    public static void cadastrarLivro(String[][] matriz, Scanner scanner){
        /*
         * Metodo para o cadastro de livros
         * 
         * 1 - garantir que tenha espaço suficiente na matriz para o cadastro
         * 2 - deve cadastrar titulo, autor e data de publicação da obra as informações 
         * do livro deve ser guardada dentro do vetor em espaços null
         * 
         * Parametros:
         *  matriz: vetor onde o cadastro de livros está sendo realizado
         *  scanner: Obter os dados do livros
         * 
         */

        System.out.println("\nLimite de Livros cadastrados: " + matriz.length);
        
        // variavel para guardar espaços diponiveis para armazenar livros
        byte espacoLivre = 0; // não vai passar de 100, podemos usar byte ( suporta ate 120)

        // variavel para guardar a posição da primeira linha disponivel
        byte marcarIndice = 0; // sabemos que zero nunca vai estar disponivel

        // itera pela lista para verificar os espaços diponiveis
        for (int i = 0; i < matriz.length; i++){

            // toda linha que inciar com null consideramos vazia
            if (matriz[i][0] == null){
                espacoLivre += 1;

                // se marcarIndice ainda for zero salvamos o indice
                if (marcarIndice == 0){
                    marcarIndice = (byte) i;
                }

            }
        }
    
        // sabemos que se o espaço livre for diferente de 0 é porque ainda tem espaço
        System.out.println("Total de espaços disponiveis: " + espacoLivre);

        if (espacoLivre > 0){
            
            System.out.print("\n ----- Iniciando Cadastro de Livro -----\n");
            matriz[marcarIndice][0] = entradaUsuario(scanner, "o Título do Livro");
            matriz[marcarIndice][1] = entradaUsuario(scanner, "o Autor do Livro");
            matriz[marcarIndice][2] = obterData(scanner);
            System.out.print(" ----- Cadastro de Livro Concluido -----\n");

        } else {
            System.out.println("Infelizmente, não temos espaço disponivel para adicionar mais livros");
        }
    }

    public static void main(String[] args) {
        
        // Vamos criar um vetor com N linhas e 3 coluna
        // vamos supor que teremos até 100 livros cadastrados
        String[][] livros = new String[100][3];

        // primeira linha deve exibir o tipo de informação ( cabeçalho do vetor )
        livros[0][0] = "| Título do Livro ";
        livros[0][1] = "| Autor do Livro ";
        livros[0][2] = "| Data de Publicação do Livro ";

        // Iniciar Scanner
        Scanner scanner = new Scanner(System.in);

        
        // TESTE 1 - CABEÇALHO
        // TESTE 2 - Cadastro
        cadastrarLivro(livros, scanner);
        exibirLivros(livros);

        // TESTE 3 - VALIDAR DATA
        // obterData(scanner);
        // limparTerminal();




    }
}
