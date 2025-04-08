import java.util.Scanner;

public class AulaDiaPrimeiroDeAbril {
    public static void main(String[] args) {
        // inicar vetor para obter numeros do usúario
        int[] numeros = new int[5];
        
        // iniciar Scanner para coletar a entrada 
        Scanner entrada = new Scanner(System.in);

        System.out.print("\n------------------------\n");
        System.out.println("Preenchendo Vetor");
        // iniciar loop para preencher o vetor
        for (int i = 0; i < 5; i++){
            System.out.print("Digite um número: ");
            numeros[i] = entrada.nextInt();
        }
        System.out.print("\n------------------------");
    
        //Pedir ao usúario um novo valor
        System.out.print("\nDigite um valor para trocar pelo valor da posição 3: ");
        int novoNumero = entrada.nextInt();
        
        // substituir o elemento na posição 3 
        numeros[2] = novoNumero;
        System.out.println("---------------------------------");

        System.out.print("Verificando substituição: \n");
        System.out.print("Vetor: { ");
        for (int i = 0; i < numeros.length; i++) {
            if (i == numeros.length - 1){
                System.out.printf("%d, ...}\n", numeros[i]);
            } else {
                System.out.printf("%d, ", numeros[i]);

            }
        }
        System.out.println("---------------------------------");

        //----------------------------------------------
        // remover o elemento da posição 5
        //----------------------------------------------
        // 1 - obter o valor guardado na posição
        int guardarElemento = numeros[4];

        // 2 - Obter o tamanho total do vetor que vai ter o elemento removido
        // remover o espaço do elemento que vai ser removido 
        int tamanho = numeros.length - 1; 

        // 3 - iniciar um novo vetor com o novo tamanho definido
        int[] novoVetor = new int[tamanho];

        // 4 - criar um indice para controlar os elementos do novo vetor
        int indice = 0;

        // iniciar loop
        System.out.printf("Removendo elemento");
        for (int i = 0; i < numeros.length; i++){
            // verifica se o elemento atual da lista original
            // é diferente do valor que deve ser removido
            if (numeros[i] != guardarElemento){
                // o novo vetor recebe o elemento na posição do indice
                novoVetor[indice] = numeros[i];
                // passamos para o proximo indice
                indice++;
            }
        }
        
        // exibir o novo vetor
        System.out.print("\n{");
        for (int i = 0; i < novoVetor.length; i++) {
            if (i == novoVetor.length - 1){
                
                System.out.printf("%d, ...", novoVetor[i]);
            } else {
                System.out.printf("%d, ", novoVetor[i]);
            }
        }
        System.out.print("}\n");
        System.out.println("----------------------------");
        entrada.close();
    }
}
