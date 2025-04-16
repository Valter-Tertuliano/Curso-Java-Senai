public class AulaDiaQuartozeDeAbrilExercicio10 {

    public static double calcularMedia(double n1, double n2, double n3){
        return (n1 + n2 + n3) / 3;
    }

    public static void main(String[] args) {
        double n1 = 6, n2 = 6, n3 = 6;

        System.out.printf("A média do Aluno: %.2f", calcularMedia(n1, n2, n3));
    }
}
