import java.util.Scanner;

class Ex6_BoxPlot {

    public static void main(String[] args) {
        int[] arr;
        try (Scanner sc = new Scanner(System.in)) {
            String[] input = sc.nextLine().split(", ");
            arr = new int[input.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
        }
        boxPlot(arr);
    }

    static void boxPlot(int[] arr) {
        insertionSort(arr);
        printArray(arr);

        System.out.println("            ________ ________            ");
        System.out.println("  |--------|________|________|--------|  ");

        for (double num : new double[]{
                arr[0],
                median(arr, 0, (arr.length - 1) / 2 + 1),
                median(arr, 0, arr.length),
                median(arr, arr.length / 2, arr.length),
                arr[arr.length - 1]
        }) {
            printNum(num);
            System.out.print("    ");
        }
    }

    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int index = i, el = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (el >= arr[j]) break;
                arr[j + 1] = arr[j];
                index = j;
            }
            arr[index] = el;
        }
    }

    static void printArray(int[] numbers) {
        for (int num : numbers) {
            System.out.print(num);
            if (num != numbers[numbers.length - 1]) System.out.print(", ");
        }
        System.out.println();
    }

    static double median(int[] arr, int start, int end) {
        int length = end - start;
        if (length % 2 == 1) {
            return arr[start + length / 2];
        } else {
            return (arr[start + length / 2 - 1] + arr[start + length / 2]) / 2.0;
        }
    }

    static void printNum(double num) {
        String str;
        if (num % 1 == 0) {
            str = Integer.toString((int) num);
        } else {
            str = Double.toString(num);
        }

        str = " ".repeat(2 - str.length() / 2) + str;
        str += " ".repeat(5 - str.length());
        System.out.print(str);
    }

}
