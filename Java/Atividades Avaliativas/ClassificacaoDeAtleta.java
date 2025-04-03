/*
 * Arquivo Fluxograma:  ClassificaoDeAtleta.fprg
 * 
 * Desafio do Fluxograma: Classificação de Atleta
 */

import java.util.Scanner;

public class ClassificacaoDeAtleta {
    public static void main(String[] args) {
        
        // declarar as variaveis para armazenar os tempos e o valor da media
        int tempo1, tempo2, tempo3, media;

        // iniciar o scanner para a coleta de dados
        Scanner scanner = new Scanner(System.in);

        // Cabeçalho do programa
        System.out.println("\n --------- Classificação de atleta ---------");

        // informar que se os valores informados for menor que zero o programa vai ser suspenso
        System.out.print("\nO tempo dos atletas deve ser maior que ZERO, caso contrario o programa será suspenso.");

        // obtendo o tempo do atleta
        System.out.print("Informe o 1° tempo do atleta: ");
        tempo1 = scanner.nextInt();
        
        // limpando o scanner
        scanner.nextLine();

        // validando o tempo do atleta
        if (tempo1 < 0){
            System.out.println("Tempo informado menor que zero, encerrando o programa.");
            System.exit(0);
        }

        // obtendo o tempo do atleta
        System.out.print("Informe o 2° tempo do atleta: ");
        tempo2 = scanner.nextInt();
        
        // limpando o scanner
        scanner.nextLine();
        
        // validando o tempo do atleta
        if (tempo2 < 0){
            System.out.println("Tempo informado menor que zero, encerrando o programa.");
            System.exit(0);
        }

        // obtendo o tempo do atleta
        System.out.print("Informe o 3° tempo do atleta: ");
        tempo3 = scanner.nextInt();
        
        // limpando o scanner
        scanner.nextLine();

        // validando o tempo do atleta
        if (tempo3 < 0){
            System.out.println("Tempo informado menor que zero, encerrando o programa.");
            System.exit(0);
        }

        // Calculando a Média do atleta
        media = (tempo1 + tempo2 + tempo3) / 3;

        // Exibindo a média de tempo do atleta
        System.out.println("O atleta obteve um tempo médio de " + media + " segundos.");

        // Verificando a Categoria do atleta
        if (media <= 10){
            System.out.println("Classifição do Atleta: CATEGORIA OURO");
        } else if (media > 10 & media <= 15){
            System.out.println("Classifição do Atleta: CATEGORIA PRATA");
        } else if (media > 15 & media <= 20){
            System.out.println("Classifição do Atleta: CATEGORIA BRONZE");
        } else {
            System.out.println("Atleta DESCLASSIFICADO");
        }
        scanner.close();
        
    }
    
}
