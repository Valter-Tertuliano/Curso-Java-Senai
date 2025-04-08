import java.util.Scanner;

public class AulaPrimeiroDeAbrilEstacionamento {

    // constante para representar o total de vagas
    public static final int TOTAL_VAGAS = 10;
    
    // Exibe todas as vagas com seu status (Ocupada ou Liberada)
    public static void exibirVagas(int[] vagas) {
        System.out.print("--------------------------");
        System.out.print("\nVAGAS DISPONÍVEIS\n");
        System.out.print("--------------------------");
        for (int i = 0; i < vagas.length; i++) {
            String status = (vagas[i] == 1) ? "Ocupada" : "Liberada";
            System.out.printf("\n| Vaga: %d | %s", i + 1, status);
        }
        System.out.println();
        System.out.print("--------------------------");
    }

    // Ocupa uma vaga específica, se estiver disponível
    public static void ocuparVagas(int[] vagas, int numeroVaga) {
        System.out.print("--------------------------");
        for (int i = 0; i < vagas.length; i++) {
            if ((numeroVaga - 1) == i) {
                if (vagas[i] == 0) {
                    System.out.println("\nOcupando Vaga");
                    vagas[i] = 1;
                } else {
                    System.out.println("\nVaga já está ocupada, tente outra.");
                }
            }
        }
    }

    // Libera uma vaga específica, se estiver ocupada
    public static void liberarVagas(int[] vagas, int numeroVaga) {
        System.out.print("--------------------------\n");
        for (int i = 0; i < vagas.length; i++) {
            if ((numeroVaga - 1) == i) {
                if (vagas[i] == 1) {
                    System.out.println("Liberando Vaga");
                    vagas[i] = 0;
                } else {
                    System.out.println("Vaga já está liberada. Você informou sua vaga corretamente?");
                }
            }
        }
    }

    // Verifica se o número da vaga é válido (entre 1 e 10)
    public static boolean entradaValida(int numeroVaga) {
        return numeroVaga > 0 && numeroVaga <= TOTAL_VAGAS;
    }

    // Exibe todas as vagas que estão livres
    public static void vagasDisponiveis(int[] vagas) {
        System.out.print("Vagas disponíveis -> { ");
        for (int i = 0; i < vagas.length; i++) {
            if (vagas[i] == 0) {
                System.out.printf("%d ", i + 1);
            }
        }
        System.out.print("}\n");
    }

    // Exibe todas as vagas que estão ocupadas
    public static void vagasOcupadas(int[] vagas) {
        System.out.print("Vagas ocupadas -> { ");
        for (int i = 0; i < vagas.length; i++) {
            if (vagas[i] == 1) {
                System.out.printf("%d ", i + 1);
            }
        }
        System.out.print("}\n");
    }

    // Verifica se ainda há vagas disponíveis
    public static boolean existemVagasDisponiveis(int[] vagas) {
        int contador = 0;
        for (int i = 0; i < vagas.length; i++) {
            if (vagas[i] == 1) {
                contador++;
            }
        }
        if (contador == 10) {
            System.out.println("Não há vagas disponíveis.");
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {

        // Inicializa o Scanner para obter entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Cria um array de 10 vagas numeradas
        int[] vagasNumeradas = new int[TOTAL_VAGAS];

        // Inicializa todas as vagas como livres (0)
        for (int i = 0; i < 10; i++) {
            vagasNumeradas[i] = 0;
        }

        // Menu principal do programa
        while (true) {
            System.out.print("\nBem-vindo ao estacionamento SEU ESTACIONAMENTO.\n");
            System.out.print("Digite 1: Ocupar Vaga\n");
            System.out.print("Digite 2: Liberar Vaga\n");
            System.out.print("Digite 3: Exibir Vagas\n");
            System.out.print("Digite 0: Encerrar\n");

            // Obtém a escolha do usuário
            System.out.print("\nEscolha: ");
            int escolha = scanner.nextInt();

            if (escolha == 0) {
                System.out.println("Obrigado por utilizar nossos serviços. Volte sempre.");
                scanner.close();
                System.exit(0);
            } else if (escolha == 1) {
                // Verifica se há vagas disponíveis
                if (existemVagasDisponiveis(vagasNumeradas)) {
                    vagasDisponiveis(vagasNumeradas);
                    System.out.print("\nInforme o número da vaga que deseja ocupar: ");
                    int numeroVaga = scanner.nextInt();

                    // Valida a entrada do número da vaga
                    if (entradaValida(numeroVaga)) {
                        ocuparVagas(vagasNumeradas, numeroVaga);
                    } else {
                        System.out.println("Vaga informada não existe. Temos apenas 10 vagas.");
                    }
                }
            } else if (escolha == 2) {
                vagasOcupadas(vagasNumeradas);
                System.out.print("\nInforme o número da vaga que deseja liberar: ");
                int numeroVaga = scanner.nextInt();

                // Valida a entrada do número da vaga
                if (entradaValida(numeroVaga)) {
                    liberarVagas(vagasNumeradas, numeroVaga);
                } else {
                    System.out.println("Vaga informada não existe. Temos apenas 10 vagas.");
                }
            } else if (escolha == 3) {
                exibirVagas(vagasNumeradas);
            } else {
                System.out.println("Opção inválida. Informe os números 0, 1, 2 ou 3.");
            }
        }

    }

}
