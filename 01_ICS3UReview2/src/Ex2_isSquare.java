import java.util.Scanner;
import static java.lang.Math.sqrt;

class Ex2_isSquare {
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Number: ");
            if (isSquare(sc.nextInt())) System.out.print("The number is a square");
            else System.out.print("The number is not a square");
        }
    }

    private static boolean isSquare(int n) {
        return sqrt(n) % 1 == 0;
    }

}
