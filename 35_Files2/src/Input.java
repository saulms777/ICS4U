import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * A utility class for easier user input from the console. Uses the <code>java.util.Scanner</code> class
 * to take the input. Instead of throwing an error when an <code>InputMismatchException</code> is
 * found, each method will output to the console an error message, following with the original
 * prompt. Until a valid input is entered, this will continue.
 *
 * @see Scanner
 * @author Samuel Zhang
 */
public final class Input {

    /**
     * Scanner object for reading user input from the console.
     */
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Prints a given prompt and returns a single word.
     *
     * @param prompt Prompt to print
     * @return User input
     * @see Scanner#next()
     */
    public static String next(String prompt) {
        try {
            System.out.print(prompt);
            return sc.next();
        } finally {
            sc.nextLine();
        }
    }

    /**
     * Prints a given prompt and returns the full line.
     *
     * @param prompt Prompt to print
     * @return User input
     * @see Scanner#nextLine()
     */
    public static String nextLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    /**
     * Prints a given prompt and returns a <code>boolean</code> value.
     * If the input is not a <code>boolean</code>, print an error message and prompt again.
     *
     * @param prompt Prompt to print
     * @return User input
     * @see Scanner#nextBoolean()
     */
    public static boolean nextBoolean(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextBoolean();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
            } finally {
                sc.nextLine();
            }
        }
    }

    /**
     * Prints a given prompt and returns a <code>char</code> value.
     * If the input is not a <code>char</code>, print an error message and prompt again.
     *
     * @param prompt Prompt to print
     * @return User input
     * @see String#charAt(int)
     */
    public static char nextChar(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String s = sc.next();
                if (s.length() == 1)
                    return s.charAt(0);
                System.out.println("Invalid input.");
            } finally {
                sc.nextLine();
            }
        }
    }

    /**
     * Prints a given prompt and returns a <code>byte</code> value.
     * If the input is not a <code>byte</code>, print an error message and prompt again.
     *
     * @param prompt Prompt to print
     * @return User input
     * @see Scanner#nextByte()
     */
    public static byte nextByte(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
            } finally {
                sc.nextLine();
            }
        }
    }

    /**
     * Prints a given prompt and returns a <code>short</code> value.
     * If the input is not a <code>short</code>, print an error message and prompt again.
     *
     * @param prompt Prompt to print
     * @return User input
     * @see Scanner#nextShort()
     */
    public static short nextShort(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextShort();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
            } finally {
                sc.nextLine();
            }
        }
    }

    /**
     * Prints a given prompt and returns a <code>int</code> value.
     * If the input is not a <code>int</code>, print an error message and prompt again.
     *
     * @param prompt Prompt to print
     * @return User input
     * @see Scanner#nextInt()
     */
    public static int nextInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
            } finally {
                sc.nextLine();
            }
        }
    }

    /**
     * Prints a given prompt and returns a <code>long</code> value.
     * If the input is not a <code>long</code>, print an error message and prompt again.
     *
     * @param prompt Prompt to print
     * @return User input
     * @see Scanner#nextLong()
     */
    public static long nextLong(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextLong();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
            } finally {
                sc.nextLine();
            }
        }
    }

    /**
     * Prints a given prompt and returns a <code>float</code> value.
     * If the input is not a <code>float</code>, print an error message and prompt again.
     *
     * @param prompt Prompt to print
     * @return User input
     * @see Scanner#nextFloat()
     */
    public static float nextFloat(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
            } finally {
                sc.nextLine();
            }
        }
    }

    /**
     * Prints a given prompt and returns a <code>double</code> value.
     * If the input is not a <code>double</code>, print an error message and prompt again.
     *
     * @param prompt Prompt to print
     * @return User input
     * @see Scanner#nextDouble()
     */
    public static double nextDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
            } finally {
                sc.nextLine();
            }
        }
    }

}
