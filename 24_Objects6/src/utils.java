import java.util.Scanner;

public final class utils {

    private static final Scanner sc = new Scanner(System.in);

    public static String inputWord(String prompt) {
        System.out.print(prompt);
        String s = sc.next();
        sc.nextLine();
        return s;
    }

    public static String inputLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static boolean inputBoolean(String prompt) {
        System.out.print(prompt);
        boolean b = sc.nextBoolean();
        sc.nextLine();
        return b;
    }

    public static byte inputByte(String prompt) {
        System.out.print(prompt);
        byte b = sc.nextByte();
        sc.nextLine();
        return b;
    }

    public static short inputShort(String prompt) {
        System.out.print(prompt);
        short s = sc.nextShort();
        sc.nextLine();
        return s;
    }

    public static int inputInt(String prompt) {
        System.out.print(prompt);
        int i = sc.nextInt();
        sc.nextLine();
        return i;
    }

    public static long inputLong(String prompt) {
        System.out.print(prompt);
        long l = sc.nextLong();
        sc.nextLine();
        return l;
    }

    public static float inputFloat(String prompt) {
        System.out.print(prompt);
        float f = sc.nextFloat();
        sc.nextLine();
        return f;
    }

    public static double inputDouble(String prompt) {
        System.out.print(prompt);
        double d = sc.nextDouble();
        sc.nextLine();
        return d;
    }

}
