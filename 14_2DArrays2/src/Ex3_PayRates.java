import java.util.Scanner;

class Ex3_PayRates {

    public static void main(String[] args) {
        double[][] pay = {
                {15.00, 17.25, 20.70, 25.88, 33.64},
                {18.75, 21.56, 25.88, 32.34, 42.05},
                {24.38, 28.03, 33.64, 42.05, 54.66},
                {32.91, 37.84, 45.41, 56.76, 73.79}
        };

        printArray(pay);
        System.out.println();
        yearAverages(pay);
        System.out.println();
        payRaise(pay);
    }

    private static void printArray(double[][] pay) {
        final int SPACES = 8;
        String str;

        System.out.print(" ".repeat(SPACES));
        for (int i = 0; i < pay[0].length; i++) {
            str = Integer.toString(i);
            str += " ".repeat(SPACES - str.length());
            System.out.print(" | " + str);
        }
        System.out.print("\n" + "-".repeat(SPACES));
        for (int i = 0; i < pay[0].length; i++) System.out.print("-|-" + "-".repeat(SPACES));
        System.out.println();

        for (int i = 0; i < pay.length; i++) {
            str = "Year #" + (i + 1);
            str += " ".repeat(SPACES - str.length());
            System.out.print(str);
            for (int j = 0; j < pay[i].length; j++) {
                str = Double.toString(pay[i][j]);
                str += " ".repeat(SPACES - str.length());
                System.out.print(" | " + str);
            }
            System.out.println();
        }
    }

    private static void yearAverages(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            double total = 0.0;
            for (double el : arr[i]) total += el;
            System.out.println("Year #" + (i + 1) + ": " + (total / arr[i].length));
        }
    }

    private static void payRaise(double[][] arr) {
        int years;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Years of experience: ");
            years = sc.nextInt();
        }
        System.out.println("Pay raise: " + (arr[2][years] - arr[0][years]));
    }

}
