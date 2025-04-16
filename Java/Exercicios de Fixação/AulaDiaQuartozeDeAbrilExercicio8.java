
public class AulaDiaQuartozeDeAbrilExercicio8 {
 
    public static double quadradoExponencial(int num){
        return Math.pow(num, 2);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.printf("%d² -> %d", n, (int) quadradoExponencial(n));
    }
}
