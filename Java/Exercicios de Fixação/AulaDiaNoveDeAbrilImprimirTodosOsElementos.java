public class AulaDiaNoveDeAbrilImprimirTodosOsElementos {
    
    public static void preencherMatriz(int[][] matriz, int termo){
        int cont = termo;
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){

                matriz[i][j] = cont;
                cont += termo;
            }   
        }
    }

    public static void exibirMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){

            System.out.print(" " + matriz[i][j] + " ");
            }   
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        // criar matriz
        int[][] matriz = new int[3][3];
        
        // termo de multiplicação para preenchimento
        int termo = 2;

        // metodo para preencher matriz
        preencherMatriz(matriz, termo);

        // metodo para exibir matriz
        exibirMatriz(matriz);


    }
}
