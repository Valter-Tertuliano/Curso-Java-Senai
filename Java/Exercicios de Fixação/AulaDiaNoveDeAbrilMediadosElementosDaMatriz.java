import java.util.Random;

public class AulaDiaNoveDeAbrilMediadosElementosDaMatriz {

    public static void preencherMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                Random num = new Random();
                matriz[i][j] = num.nextInt(100) + 1;
            }
        }

    }

    public static float calcularMedia(int[][] matriz){
        int media = 0;
        int totalElementos = 0;
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                
                media += matriz[i][j];
                totalElementos++;
            }
        }

        return (float) media / totalElementos;
    }

    public static void exibirMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                System.out.print(matriz[i][j] + " ");    
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int[][] matriz = new int[3][4];

        preencherMatriz(matriz);
        exibirMatriz(matriz);
        System.out.println("A média dos elementos: " + calcularMedia(matriz));

    }
}
