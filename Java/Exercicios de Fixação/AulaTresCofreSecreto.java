import java.util.Scanner;

public class AulaTresCofreSecreto {
    public static void main(String[] args) {
        int tentativasRestantes = 3;
        String senhaCorreta = "1234";
        String obterSenha;
        boolean acessoLiberado = false;

        Scanner entrada = new Scanner(System.in);

        while (tentativasRestantes > 0) {
            
            // informar o número de tentativas
            System.out.println("Tentativas Restantes: " + tentativasRestantes);

            // obter senha do usúario
            System.out.print("Digite a senha: ");
            obterSenha = entrada.nextLine();

            // validar senha 
            if (obterSenha.equals(senhaCorreta)){
                acessoLiberado = true; 
                tentativasRestantes = 0;
        } else {
            System.out.println("Senha inválida");
            tentativasRestantes -= 1;

        }
    }

    if (acessoLiberado == true){
        System.out.println("Acesso Liberado");
    }
    entrada.close();
}
}