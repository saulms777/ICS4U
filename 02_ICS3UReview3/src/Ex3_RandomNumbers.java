import java.util.Scanner;
import java.util.Random;

class Ex3_RandomNumbers {
    
    public static void main(String[] args) {
        Random r = new Random();

        int[] ten = new int[10];
        for (int i = 0; i < 10; i++) ten[i] = 10 + r.nextInt(11);

        int[] user = new int[15];
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < 15; i++) user[i] = sc.nextInt();
        }

        char[] letters = new char[3];
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < 3; i++) letters[i] = sc.next().charAt(0);
        }
    }

}
