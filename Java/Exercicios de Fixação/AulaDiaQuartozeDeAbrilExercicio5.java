public class AulaDiaQuartozeDeAbrilExercicio5 {

    public static boolean checarPositivo(int num){
        if (num >= 0){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int positivo = 5;
        int negativo = -5;

        System.out.printf("N: %d ---> %b", positivo, checarPositivo(positivo));
        System.out.printf("\nN: %d ---> %b", negativo, checarPositivo(negativo));
    }
}