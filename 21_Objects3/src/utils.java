import java.util.Scanner;

public final class utils {

    private static final Scanner sc = new Scanner(System.in);

    public static String inputString(String prompt) {
        System.out.print(prompt);
        return sc.next();
    }

    public static int inputInt(String prompt) {
        System.out.print(prompt);
        return sc.nextInt();
    }

}
