import java.util.Scanner;

public class AulaDiaNoveDeAbrilMultiplicarMatrizPorK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[3][3];

        System.out.println("Digite os 9 elementos da matriz 3x3:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Digite o valor de K: ");
        int k = scanner.nextInt();

        System.out.println("Matriz após multiplicação por K:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] *= k;
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}
