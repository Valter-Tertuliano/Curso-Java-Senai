import java.util.Scanner;

public class AulaDiaNoveDeAbrilSomarLinhaEspecifica {

    public static void preencherMatriz(int[][] matriz, Scanner scanner){
        System.out.println("----------------------------------------------");
        System.out.println("Adicionando valores a Matriz.");
        System.out.println("----------------------------------------------");
        for (int linha= 0;linha< matriz.length; linha++){
            for (int coluna = 0;coluna < matriz[linha].length; coluna++){
                System.out.print("Digite um valor para Matriz: ");
                matriz[linha][coluna] = scanner.nextInt();
            }
        }
        System.out.println("----------------------------------------------");
    }

    public static int calcularLinha(int[][] matriz, int linha){
        System.out.println("----------------------------------------------");
        System.out.printf("Calculando Linha: %d\n", linha);
        int cont = 0;
        for (int i = 0; i < matriz[linha].length; i++) {
            cont += matriz[linha][i];
        }
        System.out.println("----------------------------------------------");
        return cont;


    }

    public static void exibirMatriz(int[][] matriz){
        System.out.println("----------------------------------------------");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");
    }
    
    public static int obterLinha(Scanner scanner){
        System.out.println("----------------------------------------------");
        System.out.println("Escolher Linha da Matriz");
        System.out.println("----------------------------------------------");
        // obter a linha para ser calculada
        System.out.print("Digite 0 - linha 1");
        System.out.print("\nigite 1 - linha 2");
        System.out.print("\nDigite 2 - linha 3");
        System.out.println("\n----------------------------------------------");
        System.out.print("Informe qual linha da matriz deseja calcular: ");
        int linha = scanner.nextInt();
        System.out.println("----------------------------------------------");
        return linha;
    }

    public static void main(String[] args) {
        // criar matriz
        int[][] matriz = new int[3][3];

        // criar scanner
        Scanner scanner = new Scanner(System.in);

        // pedir para o usuario preencher matriz
        preencherMatriz(matriz, scanner);

        System.out.println("Exibir Matriz Criada");
        exibirMatriz(matriz);

        // obter linha
        int linha = obterLinha(scanner);

        // obter a soma dos elementos da linha especificada
        int resultado = calcularLinha(matriz, linha);

        System.out.printf("Resultado: %d", resultado);
        System.out.println("\n----------------------------------------------");
    }

}