import java.util.Random;

// O tipo byte ocupa 8 bits de memória e vai de -128 até 127
// como vamos somar 3 valores que não irá passar de 120 ( garatindo isso)
// nunca vamos trabalhar com numeros maiores que 120
public class AulaDiaNoveDeAbrilSomarElementosDaDiagonalPrincipal {

    // Preenche a matriz com números aleatórios de 1 a 40
    public static void preencherMatriz(byte[][] matriz) {
        Random random = new Random();

        for (byte i = 0; i < matriz.length; i++) {
            for (byte j = 0; j < matriz[i].length; j++) {
                // Usamos valores até 40 porque é uma matriz pequena (3x3)
                // e valores baixos são ideais para evitar desperdício de memória com tipos maiores
                matriz[i][j] = (byte)(random.nextInt(40) + 1);
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Soma os elementos da diagonal principal da matriz
    public static byte somarDiagonalPrincipal(byte[][] matriz) {
        byte soma = 0;

        for (byte i = 0; i < matriz.length; i++) {
            soma += matriz[i][i];
        }
        return soma;
    }

    public static void main(String[] args) {
        byte[][] matriz = new byte[3][3];

        preencherMatriz(matriz);
        System.out.println("A soma dos elementos da diagonal principal é " + somarDiagonalPrincipal(matriz));
    }
}
