import java.util.Scanner;

class Ex4_interest {
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Initial value: ");
            double value = sc.nextDouble();
            System.out.print("Interest rate: ");
            final int rate = sc.nextInt();
            System.out.print("Number of years: ");
            final int years = sc.nextInt();

            System.out.println(" Year | Amount at start of year | Interest earned | Amount at end of year");
            System.out.println("------|-------------------------|-----------------|-----------------------");
            for (int i = 1; i <= years; i++) {
                value = calculateInterest(value, rate, i);
            }
        }
    }

    private static double calculateInterest(double value, int rate, int year) {
        double interest = value * rate / 100.0;

        String yearString = Integer.toString(year);
        yearString += " ".repeat(4 - yearString.length());

        String initString = String.format("%.2f", value);
        initString += " ".repeat(23 - initString.length());

        String interestString = String.format("%.2f", interest);
        interestString += " ".repeat(15 - interestString.length());

        String valueString = String.format("%.2f", value + interest);
        valueString += " ".repeat(21 - valueString.length());

        System.out.println(" " + yearString + " | " + initString + " | " + interestString + " | " + valueString);
        
        return value + interest;
    }

}
