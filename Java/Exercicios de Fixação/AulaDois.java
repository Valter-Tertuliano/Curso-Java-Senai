/*
 * Arquivo Fluxograma: AulaDoisMediaSituacaoAlunoFluxograma.fprg
 * 
 * Desafio do Fluxograma: Média e situação do Aluno
 */

import java.util.Scanner;

 public class AulaDois {
    public static void exibirMedia(float media){
        System.out.println("Nota Final: " + media);
    }

    public static boolean checarIntervalo(int nota){
        if (nota < 0 || nota > 10){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n1, n2, n3, recuperacao;
        float media;

        Scanner scanner = new Scanner(System.in);

        // obter e validar notas 
        System.out.print("Informe a 1° Nota: ");
        n1 = scanner.nextInt();
        scanner.nextLine(); // limpar scanner
        
        
        if (!checarIntervalo(n1)){
            System.out.println("1° Nota fora do intervalo !!!");
            System.exit(0);
        } 
        
        System.out.print("Informe a 2° Nota: ");
        n2 = scanner.nextInt();
        scanner.nextLine(); // limpar scanner
        
        if (!checarIntervalo(n2)){
            System.out.println("2° Nota fora do intervalo !!!");
            System.exit(0);
                } 
        
        System.out.print("Informe a 3° Nota: ");
        n3 = scanner.nextInt();
        scanner.nextLine(); // limpar scanner
        
        if (!checarIntervalo(n3)){
            System.out.println("3° Nota fora do intervalo !!!");
            System.exit(0);
                } 

        media = (n1 + n2 + n3) / 3;
        exibirMedia(media);

        // verificar se o aluno foi reprovado
        if (media <= 3){
            System.out.println("Aluno reprovado:");
            exibirMedia(media);
        } else if (media > 3 && media < 6){
            System.out.print("Aluno em Recuperação: ");
            System.out.print("Informe a nota de recuperação: ");
            recuperacao = scanner.nextInt();
            scanner.nextLine();
            if (recuperacao > 5){
                System.out.println("Aluno Aprovado");
                exibirMedia(recuperacao);
            } else {
                System.out.println("Aluno Reprovado: ");
                exibirMedia(media);
            }
        } else {
            System.out.println("Aluno Aprovado");
            exibirMedia(media);
        }

        scanner.close();

    }
 }