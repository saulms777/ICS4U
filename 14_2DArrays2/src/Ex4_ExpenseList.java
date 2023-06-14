import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class Ex4_ExpenseList {

    public static void main(String[] args) {
        double[][] arr = generateCosts();

        System.out.println("Total expenses: $" + totalCost(arr));
        update(arr);
    }

    private static double[][] generateCosts() {
        Random r = new Random();
        double[][] costs = new double[12][3];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                costs[i][j] = 100 * r.nextInt();
            }
        }
        return costs;
    }

    private static double totalCost(double[][] arr) {
        double total = 0.0;
        for (double[] row : arr) {
            for (double el : row) total += el;
        }
        return total;
    }

    private static void update(double[][] arr) {
        try (Scanner sc = new Scanner(System.in)) {
            String input;
            do {
                System.out.print("Update any entry? ");
                input = sc.nextLine();
                if (input.equalsIgnoreCase("no")) return;
            } while (!input.equalsIgnoreCase("yes"));

            HashMap<String, Integer> months = new HashMap<>() {{
                put("Jan", 0);
                put("Feb", 1);
                put("Mar", 2);
                put("Apr", 3);
                put("May", 4);
                put("Jun", 5);
                put("Jul", 6);
                put("Aug", 7);
                put("Sep", 8);
                put("Oct", 9);
                put("Nov", 10);
                put("Dec", 11);
            }};
            do {
                System.out.print("Enter which month: ");
                input = sc.nextLine();
            } while (!months.containsKey(input));
            int month = months.get(input);

            HashMap<String, Integer> types = new HashMap<>() {{
                put("phone", 0);
                put("car", 1);
                put("food", 2);
            }};
            do {
                System.out.print("Enter which bill value: ");
                input = sc.nextLine();
            } while (!types.containsKey(input));
            int type = types.get(input);

            boolean passed;
            do {
                passed = true;
                try {
                    System.out.print("Enter new value: ");
                    arr[month][type] = sc.nextDouble();
                } catch (InputMismatchException e) {
                    passed = false;
                }
            } while (!passed);
        }
    }

}
