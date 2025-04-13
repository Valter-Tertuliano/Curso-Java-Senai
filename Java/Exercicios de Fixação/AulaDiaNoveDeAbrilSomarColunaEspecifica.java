import java.util.Scanner;

public class AulaDiaNoveDeAbrilSomarColunaEspecifica {

    public static void preencherMatriz(int[][] matriz, Scanner scanner){
        System.out.println("----------------------------------------------");
        System.out.println("Adicionando valores à Matriz.");
        System.out.println("----------------------------------------------");
        for (int linha = 0; linha < matriz.length; linha++){
            for (int coluna = 0; coluna < matriz[linha].length; coluna++){
                System.out.print("Digite um valor para Matriz: ");
                matriz[linha][coluna] = scanner.nextInt();
            }
        }
        System.out.println("----------------------------------------------");
    }

    public static int calcularColuna(int[][] matriz, int coluna){
        System.out.println("----------------------------------------------");
        System.out.printf("Calculando Coluna: %d\n", coluna);
        int cont = 0;
        for (int i = 0; i < matriz.length; i++) {
            cont += matriz[i][coluna];
        }
        System.out.println("----------------------------------------------");
        return cont;
    }

    public static void exibirMatriz(int[][] matriz){
        System.out.println("----------------------------------------------");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");
    }

    public static int obterColuna(Scanner scanner){
        System.out.println("----------------------------------------------");
        System.out.println("Escolher Coluna da Matriz");
        System.out.println("----------------------------------------------");
        System.out.print("Digite 0 - coluna 1");
        System.out.print("\nDigite 1 - coluna 2");
        System.out.print("\nDigite 2 - coluna 3");
        System.out.println("\n----------------------------------------------");
        System.out.print("Informe qual coluna da matriz deseja calcular: ");
        int coluna = scanner.nextInt();
        System.out.println("----------------------------------------------");
        return coluna;
    }

    public static void main(String[] args) {
        int[][] matriz = new int[3][3];
        Scanner scanner = new Scanner(System.in);

        preencherMatriz(matriz, scanner);

        System.out.println("Exibir Matriz Criada");
        exibirMatriz(matriz);

        int coluna = obterColuna(scanner);
        int resultado = calcularColuna(matriz, coluna);

        System.out.printf("Resultado: %d", resultado);
        System.out.println("\n----------------------------------------------");
    }

}

