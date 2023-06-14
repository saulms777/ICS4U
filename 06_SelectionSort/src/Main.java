/*
 * Comparisons: (arr.length - 2)(arr.length - 1) / 2
 * Swaps: arr.length - 1
 */


import java.util.Random;

class Main {

    public static void main(String[] args) {
        int[] arr = randomArray(10, 1, 30);
        selectionSort(arr);
    }

    static void selectionSort(int[] arr) {
        int comparisons = 0, swaps = 0, n = arr.length - 1;
        printLine(arr, swaps);
        for (int i = n; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }
                comparisons++;
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
            swaps++;
            printLine(arr, swaps);
        }
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
    }

    static int[] randomArray(int length, int min, int max) {
        Random r = new Random();

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = min + r.nextInt(max - min);
        }
        return arr;
    }

    static void printLine(int[] numbers, int step) {
        final int SPACES = 5;

        String n = Integer.toString(step);
        n += " ".repeat(SPACES - n.length());
        System.out.print(n + "|   ");

        for (int num : numbers) {
            String str = Integer.toString(num);
            str += " ".repeat(SPACES - str.length());
            System.out.print(str);
        }
        System.out.println();
    }

}
