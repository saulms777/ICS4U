/*
 * Average comparisons: 27.3 (20 iterations)
 * Average array accesses: 20.7 (20 iterations)
 * Time complexity: O(n^2)
 */

import java.util.Random;

class Main {

    public static void main(String[] args) {
        int[] arr = randomArray(10, 1, 30);
        insertionSort(arr);
    }

    static void insertionSort(int[] arr) {
        int comparisons = 0, accesses = 0, n = arr.length;
        printLine(arr);
        for (int i = 1; i < n; i++) {
            int index = i, el = arr[i];          accesses++;
            for (int j = i - 1; j >= 0; j--) {
                comparisons++;
                if (el >= arr[j]) {              accesses++;
                    break;
                }
                arr[j + 1] = arr[j];             accesses++;
                index = j;
            }
            arr[index] = el;                     accesses++;
            printLine(arr);
        }
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Array accesses: " + accesses);
    }

    static int[] randomArray(int length, int min, int max) {
        Random r = new Random();

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = min + r.nextInt(max - min);
        }
        return arr;
    }

    static void printLine(int[] numbers) {
        final int SPACES = 5;
        for (int num : numbers) {
            String str = Integer.toString(num);
            str += " ".repeat(SPACES - str.length());
            System.out.print(str);
        }
        System.out.println();
    }

}
