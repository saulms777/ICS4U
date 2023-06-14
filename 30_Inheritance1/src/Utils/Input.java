package Utils;

import java.util.*;

public final class Input {

    private static final Scanner sc = new Scanner(System.in);

    public static String nextWord(String prompt) {
        try {
            System.out.print(prompt);
            return sc.next();
        } finally {
            sc.nextLine();
        }
    }

    public static String nextLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

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

    public static char nextChar(String prompt) {
        try {
            System.out.print(prompt);
            return sc.next().charAt(0);
        } finally {
            sc.nextLine();
        }
    }

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
