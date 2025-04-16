import java.util.Scanner;

public class ProvaPraticaGerenciadorDeAlunos {
    
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

    public static void preencherMatriz(String[] matriz, Scanner scanner){
        String nome;
        for (int i = 0; i < matriz.length; i++){
            System.out.print("Digite um Nome: ");
            nome = scanner.nextLine();
            matriz[i] = nome;
            System.out.printf("Nome: %s --> adicionado com sucesso\n", nome);
        }
    
    }

    public static void exibirMatriz(String[] matriz){
        System.out.println("-----  Nomes da Lista -----\n");

        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Nome: " + matriz[i]);
        }

        System.out.println("\n-----  Fim da lista -----");
    }

    public static void buscarNome(String[] matriz, String nome){
        System.out.printf("--- Procurando por %s -----\n", nome);
        boolean encontrado = false;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i].equalsIgnoreCase(nome)){
                encontrado = true;
                System.out.println("Nome Encontrado: " + matriz[i]);
            }
        }
        if (!encontrado){
            System.out.println("Nome não encontrado !!!");
            System.out.println("\n----- Fim de busca -----");
        }
    }
    
    public static int contarNome(String[] matriz, String nome){
    int contar = 0;
    for (int i = 0; i < matriz.length; i++) {
        if (matriz[i].equalsIgnoreCase(nome)){
            contar++;
        }
    }
    if (contar > 0){
        System.out.println("Total de vezes que o nome apareceu: " + contar);
    } else {
        System.out.println("O nome não foi encontrado.");
    }

    return contar;
    
    }
    
    public static void ordenarAlfabeticamente(String[] matriz){
        // ordena uma matriz de nomes em ordem alfabetica
        
        for (int i = 0; i < matriz.length - 1; i++) {
            for (int j = 1 + i; j < matriz.length; j++){
                String str1 = matriz[i];
                String str2 = matriz[j];

                if (str1.compareToIgnoreCase(str2) > 0){
                    String trocar = matriz[i];
                    matriz[i] = matriz[j];
                    matriz[j] = trocar;

                }
            }    
        }

    }

    public static void exibirPorLetraInicial(String letra, String[] matriz){
        // mostrar todos os nomes que começam a letra dada
        for (int i = 0; i < matriz.length; i++) {
            String nome = matriz[i];
            String primeiraLetra = nome.substring(0,1);
            if (primeiraLetra.equalsIgnoreCase(letra)){
                System.out.println("Nome: " + nome);
            }


        }

    }

    public static int menuPrincipal(Scanner scanner){
        int opcao = 0;
        System.out.println("\n=== MENU ===");
        System.out.println("1. Preencher lista com nomes aleatórios");
        System.out.println("2. Exibir todos os nomes");
        System.out.println("3. Buscar por um nome");
        System.out.println("4. Contar quantas vezes um nome aparece");
        System.out.println("5. Mostrar o maior e menor nome (alfabeticamente)");
        System.out.println("6. Exibir nomes que começam com uma letra específica");
        System.out.println("7. Ordenar a lista em ordem alfabética");
        System.out.println("8. Sair");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha
        return opcao;

    }
    
    
    public static String obterNome(Scanner scanner){
        System.out.println("---- Buscar por nome ----");
        String escolherNome;
        System.out.print("\nDigite o nome: ");
        escolherNome = scanner.nextLine();
        return escolherNome;
    }
    public static void main(String[] args) {
        String[] nomes = new String[5];
        Scanner scanner = new Scanner(System.in);
        boolean controlarLaco = true;

        while (controlarLaco) {
            
            int op = menuPrincipal(scanner);
            switch (op) {
                case 1:
                    limparTerminal();
                    System.out.println("----------------------------------");
                    System.out.println("----- Criando lista de Nomes -----");
                    preencherMatriz(nomes, scanner);
                    System.out.println("----- Lista Criada com sucesso ----\n");
                    System.out.println("-------------------------------");    
                    break;
                
                case 2:
                    limparTerminal();
                    System.out.println("----- Exibindo Lista -----");
                    exibirMatriz(nomes);
                    break;
                
                case 3:
                    limparTerminal();
                    System.out.println("----------------------------");
                    String escreverNome = obterNome(scanner);
                    String nome = escreverNome;
                    buscarNome(nomes, nome);
                    System.out.println("\n-------------------------");
                    break;

                case 4:
                    limparTerminal();
                    System.out.println("-------------------------------");
                    escreverNome = obterNome(scanner);
                    nome = escreverNome;
                    contarNome(nomes, nome);
                    System.out.println("-------------------------------");
                    break;

                case 5:
                    limparTerminal();
                    System.out.println("----------------------------------");
                    // localizando menor e maior nome alfabeticamente
                    ordenarAlfabeticamente(nomes);

                    String menor = nomes[0];
                    int posicaoFinal = nomes.length - 1;
                    String maior = nomes[posicaoFinal];
                    
                    System.out.println("Menor Nome: " + menor);
                    System.out.println("Maior Nome: " + maior);
                    System.out.println("-------------------------------");
                    break;

                case 6:
                    limparTerminal();
                    System.out.println("-------------------------------------------------------");
                    System.out.println("---- Exibir nomes que começam com letra especifica ----\n");

                    System.out.print("Digite uma Letra: ");
                    String letra = scanner.nextLine();
                    System.out.println();
                    exibirPorLetraInicial(letra, nomes);
                    System.out.println("-------------------------------");
                    break;

                case 7:
                    limparTerminal();
                    System.out.println("--------------------------------------------------");
                    System.out.println("----- Ordenando Alfabeticamente -----");
                    ordenarAlfabeticamente(nomes);
                    System.out.println("-------------------------------");
                    break;

                case 8:
                    limparTerminal();
                    System.out.println("-------------------------------------------------");
                    System.out.println("------ Obrigado Volte Sempre ----------");
                    System.out.println("-------------------------------");
                    controlarLaco = false;
                    break;

                default:
                    limparTerminal();
                    System.out.println("Opção Invalida tente novamente");
                    break;
            }
        }
    }
}
