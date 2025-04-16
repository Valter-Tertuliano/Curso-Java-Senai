public class AulaDiaNoveDeAbrilSubstituirValoresNegativos {
	
	public static void exibirMatriz(int[][] matriz){
	    for (int i =0; i<matriz.length ;i++){
		    for (int j =0; j < matriz[i].length; j++){
		        System.out.print(matriz[i][j] + " ");
		    }
		    System.out.println();
	    }
	}
	    
	
	public static void main(String[] args) {
		// iniciar vetor
		int[][] matriz = new int[5][5];
		
		System.out.println("Matriz com numeros negativos");
		// preencher matriz
		int cont = 1;
		for (int i =0; i<matriz.length ;i++){
		    for (int j =0; j < matriz[i].length; j++){
		        if (cont % 3 == 0){
		            matriz[i][j] = cont - (cont + cont); // valor negativo
		        } else {
		            matriz[i][j] = cont;
		        }
		        cont++;
		    }
		}
		
		// exibir matriz
		exibirMatriz(matriz);

        for (int j = 0; j < matriz.length; j++){
			for (int i = 0; i < matriz[j].length; i++){
				int valor = matriz[j][i];
				if (valor < 0){
					matriz[j][i] = 0;
				}
			}
		}
		
		System.out.println("\nMatriz com valores trocados");
		exibirMatriz(matriz);
		
		
	}
}