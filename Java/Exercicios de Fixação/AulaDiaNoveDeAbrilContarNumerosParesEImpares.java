public class AulaDiaNoveDeAbrilContarNumerosParesEImpares {
    
    public static void preencherMatriz(int[][] matriz){
        int cont = 1;
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){

                matriz[i][j] = cont;
                cont ++;
            }   
        }
    }

    public static int contarElementos(int[][] matriz, int resto){
        int cont = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int valor = matriz[i][j];
                if (valor % 2 == resto){
                    cont++;
                }
            }
        }
        return cont;
    }

    public static void exibirMatriz(int[][] matriz){
        System.out.print("\nExibindo matriz Criada");
        System.out.println();
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
        
        // preencher matriz
        preencherMatriz(matriz);

        // metodo para exibir matriz
        exibirMatriz(matriz);

        // Verificar Valores Pares
        int numPares = contarElementos(matriz, 0);

        // verificar Valores Impares
        int numImpares = contarElementos(matriz, 1);
        
        System.out.printf("\nTotal de Pares: %d\nTotal de Impares: %d", numPares, numImpares);


    }
}
