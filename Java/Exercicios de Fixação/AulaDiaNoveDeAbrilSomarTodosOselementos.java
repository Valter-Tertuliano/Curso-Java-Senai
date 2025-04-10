public class AulaDiaNoveDeAbrilSomarTodosOselementos {
    
    public static int somarMatriz(int[][] matriz){
    int cont = 0;
    for (int i = 0; i < matriz.length; i++){
        for (int j = 0; j < matriz[i].length; j++){

           cont += matriz[i][j];
        }   
    }
    return cont;
}

    public static void main(String[] args) {
        int[][] matriz = new int[4][4];

        // preencher matriz
        int cont = 1;
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                matriz[i][j] = cont;
                cont++;

                // exibir matriz
                System.out.print(matriz[i][j] + " ");
            }
            // pular linha
            System.out.println();
        }
        
        // exibir soma da matriz
        System.out.println("\nA soma de todos os elementos da Matriz: " + somarMatriz(matriz));

        // prova real - usando formula de Glauss 

        int calculoDeGlauus = 16 * (16 + 1) / 2;
        System.out.printf("Prova real com Formula Matematica: %d", calculoDeGlauus );
    }
}