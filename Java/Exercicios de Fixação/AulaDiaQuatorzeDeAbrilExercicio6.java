public class AulaDiaQuatorzeDeAbrilExercicio6 {
    // crie um metodo que receba dois numeros inteiros e retorne o resultado da multiplicação entre eles

    public static int multiplicar(int n1, int n2){
        return n1 * n2;
    }

    public static void main(String[] args) {
        int n1 = 5, n2 = 5;

        System.out.printf("%d * %d = %d", n1, n2, multiplicar(n1, n2));
    }
}
