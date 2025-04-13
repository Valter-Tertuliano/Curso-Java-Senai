public class AulaDiaNoveDeAbrilMatrizTransposta {
    public static void main(String[] args) {
        int[][] matriz = new int[3][3];

        int cont = 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = cont;
                cont++;
            }
        }        

        // Imprimindo a matriz original
        System.out.println("\nMatriz Original:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        // Criando a matriz transposta
        int[][] transposta = new int[3][3];
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                transposta[j][i] = matriz[i][j];
            }
        }        

        // Imprimindo a matriz transposta
        System.out.println("\nMatriz Transposta:");
        for (int i = 0; i < transposta.length; i++) {
            for (int j = 0; j < transposta[i].length; j++) {
                System.out.print(transposta[i][j] + " ");
            }
            System.out.println();
        }
    }
}