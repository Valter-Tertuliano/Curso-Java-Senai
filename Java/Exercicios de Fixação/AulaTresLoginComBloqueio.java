import java.util.Scanner;

public class AulaTresLoginComBloqueio {
    // Scanner para entrada de dados do usuário
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Variáveis de cadastro
        String usuarioCadastrado = "valter";
        String senhaCadastrada = "1234";
        String perguntaCadastrada = "2x - 5 = 5";
        String respostaCadastrada = "5";

        // Variáveis para obter dados do usuário
        String obterUsuario, obterSenha, obterResposta;

        // Controle de tentativas e estado do sistema
        int tentativasRestantes = 3;
        boolean usuarioIdentificado = false;
        boolean acessoLiberado = false;

        // Laço para identificar o usuário
        while (!usuarioIdentificado) {
            System.out.print("Informe o nome de usuário: ");
            obterUsuario = input.nextLine();

            if (obterUsuario.equals(usuarioCadastrado)) {
                System.out.println("Usuário identificado.");
                usuarioIdentificado = true;
            } else {
                System.out.println("Usuário não identificado.");
                tentativasRestantes--;

                if (tentativasRestantes > 0) {
                    System.out.println("Tentativas restantes: " + tentativasRestantes);
                } else {
                    System.out.println("Tentativas insuficientes.");
                    return; // Encerra o programa caso o usuário não seja identificado
                }
            }
        }

        // Reset da variável para armazenar o nome de usuário corretamente
        obterUsuario = usuarioCadastrado;

        // Laço para verificar a senha e liberar o acesso
        while (!acessoLiberado) {
            System.out.print("Informe a senha " + obterUsuario + ": ");
            obterSenha = input.nextLine();

            if (obterSenha.equals(senhaCadastrada)) {
                System.out.println("Acesso liberado.");
                acessoLiberado = true;
            } else {
                System.out.println("Senha inválida.");
                tentativasRestantes--;

                if (tentativasRestantes > 0) {
                    System.out.println("Tentativas restantes: " + tentativasRestantes);
                } else {
                    // Pergunta de segurança como último recurso
                    System.out.println("Tentativas insuficientes.");
                    System.out.println("Pergunta de segurança: " + perguntaCadastrada);
                    obterResposta = input.nextLine();

                    if (obterResposta.equals(respostaCadastrada)) {
                        System.out.println("Acesso liberado.");
                        acessoLiberado = true;
                    } else {
                        System.out.println("Resposta inválida. Acesso negado.");
                        return; // Encerra o programa após falha na resposta de segurança
                    }
                }
            }
        }

        // Mensagem final de boas-vindas
        System.out.println("Bem-vindo, " + obterUsuario + "!");
    }
}
