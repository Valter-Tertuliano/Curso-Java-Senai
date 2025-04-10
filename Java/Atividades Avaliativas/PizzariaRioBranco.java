import java.util.Scanner;

public class PizzariaRioBranco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Dados dos clientes
        String[] nomesClientes = new String[10];
        String[] enderecosClientes = new String[10];
        String[] telefonesClientes = new String[10];
        int idClientes = 0;

        // Dados dos pedidos
        String[] pizzasPedidos = new String[10];
        double[] precosPedidos = new double[10];
        int[] clientesPedidos = new int[10];
        int numPedidos = 0;

        while (true) {
            System.out.println("\nPizzaria Bom Sabor");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Realizar pedido");
            System.out.println("3. Emitir cupom fiscal");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (idClientes < nomesClientes.length) {
                        System.out.print("Nome do cliente: ");
                        nomesClientes[idClientes] = scanner.nextLine();
                        System.out.print("Endereço do cliente: ");
                        enderecosClientes[idClientes] = scanner.nextLine();
                        System.out.print("Telefone do cliente: ");
                        telefonesClientes[idClientes] = scanner.nextLine();
                        
                        // contador ( indice para limitar lista de clientes e definir um indentificador)
                        idClientes++;
                        System.out.println("Cliente cadastrado com sucesso!");
                    } else {
                        System.out.println("Limite de clientes atingido.");
                    }
                    break;

                case 2:
                    if (numPedidos < pizzasPedidos.length) {
                        System.out.println("Clientes cadastrados:");
                        for (int i = 0; i < idClientes; i++) {
                            System.out.println(i + ". " + nomesClientes[i]);
                        }
                        System.out.print("Digite o número do cliente: ");
                        int clientePedido = scanner.nextInt();
                        scanner.nextLine();

                        if (clientePedido >= 0 && clientePedido < idClientes) {
                            System.out.print("Nome da pizza: ");
                            pizzasPedidos[numPedidos] = scanner.nextLine();
                            System.out.print("Preço da pizza: ");
                            precosPedidos[numPedidos] = scanner.nextDouble();
                            scanner.nextLine();
                            clientesPedidos[numPedidos] = clientePedido;

                            // controlar limite de pedidos ( indice )
                            numPedidos++;
                            System.out.println("Pedido realizado com sucesso!");
                        } else {
                            System.out.println("Cliente inválido.");
                        }
                    } else {
                        System.out.println("Limite de pedidos atingido.");
                    }
                    break;

                case 3:
                    System.out.println("Pedidos realizados:");
                    for (int i = 0; i < numPedidos; i++) {
                        System.out.println("\nCupom Fiscal #" + (i*i + 1+i));
                        int clienteIndex = clientesPedidos[i];
                        System.out.println("Cliente: " + nomesClientes[clienteIndex]);
                        System.out.println("Endereço: " + enderecosClientes[clienteIndex]);
                        System.out.println("Telefone: " + telefonesClientes[clienteIndex]);
                        System.out.println("Pizza: " + pizzasPedidos[i]);
                        System.out.println("Preço: R$ " + precosPedidos[i]);
                    }
                    break;

                case 4:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
