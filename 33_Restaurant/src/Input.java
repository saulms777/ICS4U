import java.util.Scanner;

/**
 * This class is to help with easier user input, using the java.util.Scanner class
 *
 * @author Samuel Zhang
 */
public final class Input {

    /**
     * java.util.Scanner object to take user input
     */
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Prints a prompt and takes a single word as input.
     *
     * @param prompt Prompt for input
     * @return User input
     */
    public static String nextWord(String prompt) {
        System.out.print(prompt);
        String s = sc.next();
        sc.nextLine();
        return s;
    }

    /**
     * Prints a prompt and takes the full line as input.
     *
     * @param prompt Prompt for input
     * @return User input
     */
    public static String nextLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    /**
     * Prints a prompt and takes a boolean value as input.
     *
     * @param prompt Prompt for input
     * @return User input
     */
    public static boolean nextBoolean(String prompt) {
        System.out.print(prompt);
        boolean b = sc.nextBoolean();
        sc.nextLine();
        return b;
    }

    /**
     * Prints a prompt and takes a char value as input.
     *
     * @param prompt Prompt for input
     * @return User input
     */
    public static char nextChar(String prompt) {
        System.out.print(prompt);
        char c = sc.next().charAt(0);
        sc.nextLine();
        return c;
    }

    /**
     * Prints a prompt and takes a byte value as input.
     *
     * @param prompt Prompt for input
     * @return User input
     */
    public static byte nextByte(String prompt) {
        System.out.print(prompt);
        byte b = sc.nextByte();
        sc.nextLine();
        return b;
    }

    /**
     * Prints a prompt and takes a short value as input.
     *
     * @param prompt Prompt for input
     * @return User input
     */
    public static short nextShort(String prompt) {
        System.out.print(prompt);
        short s = sc.nextShort();
        sc.nextLine();
        return s;
    }

    /**
     * Prints a prompt and takes a int value as input.
     *
     * @param prompt Prompt for input
     * @return User input
     */
    public static int nextInt(String prompt) {
        System.out.print(prompt);
        int i = sc.nextInt();
        sc.nextLine();
        return i;
    }

    /**
     * Prints a prompt and takes a long value as input.
     *
     * @param prompt Prompt for input
     * @return User input
     */
    public static long nextLong(String prompt) {
        System.out.print(prompt);
        long l = sc.nextLong();
        sc.nextLine();
        return l;
    }

    /**
     * Prints a prompt and takes a float value as input.
     *
     * @param prompt Prompt for input
     * @return User input
     */
    public static float nextFloat(String prompt) {
        System.out.print(prompt);
        float f = sc.nextFloat();
        sc.nextLine();
        return f;
    }

    /**
     * Prints a prompt and takes a double value as input.
     *
     * @param prompt Prompt for input
     * @return User input
     */
    public static double nextDouble(String prompt) {
        System.out.print(prompt);
        double d = sc.nextDouble();
        sc.nextLine();
        return d;
    }

}
