public class AulaDiaQuatorzeDeAbrilExercicio3 {

    // crie um metodo que receba dois numeros inteiros como parametros e retorne a soma deles
    public static int soma(int num1, int num2){
        return num1 + num2;
    }

    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 5;

        System.out.printf("A soma de %d + %d ---> %d", n1, n2, soma(n1, n2));
    }
}