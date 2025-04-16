public class AulaDiaQuartozeDeAbrilExercicio9 {
    public static int maiorDeDoisNumeros(int n1, int n2){
        if (n1 > n2) {
            return n1;
        } else if (n2 > n1){
            return n2;
        } else {
            System.out.println("Ambos os valores são iguais");
            return n1;
        }
    }

    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 5;

        System.out.printf("O maior numero entre %d e %d é %d", n1, n2, maiorDeDoisNumeros(n1, n2));
    }
}
