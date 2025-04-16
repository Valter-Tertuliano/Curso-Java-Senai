import java.util.Scanner;

public class AulaDiaNoveDeAbrilVerificarSimetria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de N (tamanho da matriz quadrada): ");
        int n = scanner.nextInt();

        int[][] matriz = new int[n][n];

        System.out.println("Digite os elementos da matriz " + n + "x" + n + ":");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        boolean simetrica = true;

        for (int i = 0; i < n && simetrica; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    simetrica = false;
                    break;
                }
            }
        }

        if (simetrica) {
            System.out.println("A matriz é simétrica.");
        } else {
            System.out.println("A matriz não é simétrica.");
        }

        scanner.close();
    }
}
