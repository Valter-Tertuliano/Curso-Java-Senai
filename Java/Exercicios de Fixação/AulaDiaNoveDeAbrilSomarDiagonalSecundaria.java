import java.util.Random;

public class AulaDiaNoveDeAbrilSomarDiagonalSecundaria {
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

        // Soma os elementos da diagonal secundaria da matriz
        public static byte somarDiagonalSecundaria(byte[][] matriz) {
            byte soma = 0;
    
            for (byte i = 0; i < matriz.length; i++) {
                soma += matriz[i][matriz.length - 1 - i];
            }
            return soma;
        }
    
        public static void main(String[] args) {
            byte[][] matriz = new byte[3][3];
    
            preencherMatriz(matriz);
            System.out.println("A soma dos elementos da diagonal secundaria é " + somarDiagonalSecundaria(matriz));
        }
}
