/*
 * Arquivo Fluxograma: AulaTresBonusSalarial.fprg
 * 
 * Desafio do Fluxograma: Bonus salarial
 */

import java.util.Scanner;

public class AulaTresBonusSalarial {
    public static void main(String[] args) {

        // declarando as variaveis
        int tempoServico, notaDesempenho, bonus;
        double salarioBase, salarioBonificado;

        // iniciando scanner
        Scanner input = new Scanner(System.in);

        // cabeçalho do Programa
        System.out.println("\n----- Calculadora de Bônus Salarial -----\n");

        // Recebendo os dados do usúario

        // Obtendo Sálario Base
        System.out.print("Informe o Sálario Base do Funcionário: ");
        salarioBase = input.nextDouble();

        // Limpando scanner
        input.nextLine();

        // Validando Sálario Base
        if (salarioBase <= 0){
            System.out.println("Sálario informado inválido.");
            System.exit(0);
        }

        // Obtendo Tempo de Serviço
        System.out.print("Informe o tempo de serviço do Funcionário em ANOS: ");
        tempoServico = input.nextInt();

        // limpando scanner
        input.nextLine();

        // Validando Tempo de Serviço
        if (tempoServico < 0){
            System.out.println("Tempo de Serviço Inválido.");
            System.exit(0);
        }

        // Obtendo Nota de Desempenho
        System.out.print("Informe a Nota de Desempenho do Funcionário (0-10): ");
        notaDesempenho = input.nextInt();

        // Limpando Scanner
        input.nextLine();

        // validando Nota de desempenho
        if (notaDesempenho < 0 || notaDesempenho > 10){
            System.out.println("Informe uma nota de desempenho válida.");
            System.exit(0);
        }

        // Processando Resultado
        System.out.print("\n---------- Calculando Bônus Salarial ----------\n");
        
        // definindo bônus por tempo de serviço
        if (tempoServico < 3){
            System.out.println("Tempo de Serviço muito baixo, sem direito a bônus");
            bonus = 0;
        } else if (tempoServico >=3 & tempoServico <= 5){
            bonus = 5;
        } else {
            bonus = 10;
        }

        // definindo sálario bonificado por nota de desempenho
        if (notaDesempenho < 4){
            System.out.println("Desempenho muito baixo, sem direito a bonus: ");
            salarioBonificado = salarioBase;
        } else if (notaDesempenho >= 4 & notaDesempenho <= 7){
            salarioBonificado = salarioBase + (salarioBase * (double) bonus / 100);
        } else {
            bonus = bonus + bonus;
            salarioBonificado = salarioBase + (salarioBase * (double) bonus / 100);

        }

        // Exibindo os resultados
        System.out.println("Bônus Recebido: " + bonus + "%");
        System.out.println("Sálario Base: " + salarioBase + " R$");
        System.out.println("Sálario Bonificado: " + salarioBonificado + " R$");

        input.close();

    }
}
