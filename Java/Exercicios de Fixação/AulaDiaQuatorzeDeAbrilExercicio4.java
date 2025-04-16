public class AulaDiaQuatorzeDeAbrilExercicio4 {

    // crie um metodo que receba dois numeros inteiros e retorne o resultado da subtração
    public static int subtrair(int n1, int n2){
        return n1 - n2;
    }

    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 4;

        System.out.printf("\n%d - %d = %d\n", n1, n2, subtrair(n1, n2));
    }
}