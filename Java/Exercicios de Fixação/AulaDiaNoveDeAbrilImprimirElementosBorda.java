public class AulaDiaNoveDeAbrilImprimirElementosBorda {
    
    public static void main(String[] args) {
        int[][] matriz = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };

        int linhas = matriz.length;
        int colunas = matriz[0].length;

        System.out.println("Elementos da borda da matriz:");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (i == 0 || i == linhas - 1 || j == 0 || j == colunas - 1) {
                    System.out.print(matriz[i][j] + " ");
                } 
            }
            System.out.println();
        }
    }
    
}
