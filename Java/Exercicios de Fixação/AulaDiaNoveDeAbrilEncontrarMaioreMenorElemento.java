import java.util.Random;

public class AulaDiaNoveDeAbrilEncontrarMaioreMenorElemento {
    
    public static void preencherMatriz(int[][] matriz){
        Random random = new Random();

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                matriz[i][j] = random.nextInt(100) + 1;
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static int menorElemento(int[][] matriz){
        int menor = 101; // a matriz terá no maximo o numero 100

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                if (matriz[i][j] < menor){
                    menor = matriz[i][j];
                }
            }
        }

        return menor;
    }
    
    public static int maiorElemento(int[][] matriz){
        int maior = 0;

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                if (matriz[i][j] > maior){
                    maior = matriz[i][j];
                }
            }
        }

        return maior;
    }
    
    public static void main(String[] args) {
        int[][] matriz = new int[3][3];

        // preencher e exibir matriz para validação
        preencherMatriz(matriz);

        System.out.printf("\nO Maior elemento da Matriz: %d.\n", maiorElemento(matriz));
        System.out.printf("O Menor elemento da Matriz: %d.\n", menorElemento(matriz));
    
    }   
}
