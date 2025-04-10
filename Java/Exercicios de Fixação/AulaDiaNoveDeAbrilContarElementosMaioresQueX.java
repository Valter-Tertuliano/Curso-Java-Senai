import java.util.Scanner;

public class AulaDiaNoveDeAbrilContarElementosMaioresQueX {
    
    public static void lerMatriz(int[][] matriz, Scanner scanner){
       
        // loop para adicionar numero na matriz
        for (int linha = 0; linha < matriz.length; linha++){
            for (int coluna = 0; coluna < matriz[linha].length; coluna++){
                System.out.print("Digite um número: ");
                int adicionar = scanner.nextInt();
                matriz[linha][coluna] = adicionar;
                
            }
        }
    }

    public static int maiorQueX(int[][] matriz, Scanner scanner, int X){
        
        // contador para os elementos maiores que x
        int cont = 0;
        
        // percorrer elementos da matriz
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                if (matriz[i][j] > X){
                    cont++;
                }
            }
        }
        return cont;

    }

    public static void main(String[] args) {

        // iniciar matriz
        int[][] matriz = new int[2][2];

         // iniciar scanner
        Scanner scanner = new Scanner(System.in);

        // metodo para leitura de matriz
        lerMatriz(matriz, scanner);

        
        // obter valor de x
        System.out.print("\nDigite um valor X: ");
        int X = scanner.nextInt();


        // exibir resultado
        System.out.printf("Existem %d elementos maiores que %d", maiorQueX(matriz, scanner, X), X);


        
    }    
}
