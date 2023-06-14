import java.util.Scanner;
import java.util.Random;

import java.util.Arrays;

class Ex1_SortedLinearSearch {

    public static void main(String[] args) {
        int[] arr = {3, 8, 9, 10, 10, 15, 32, 35, 36, 48};
        System.out.println(Arrays.toString(arr));

        int num;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Number to search/insert: ");
            num = sc.nextInt();
        }

        System.out.println(linearSearch(arr, num));
        System.out.println(Arrays.toString(linearSearchAll(arr, num)));
        System.out.println(Arrays.toString(insert(arr, num)));
        System.out.println(min(arr));
        System.out.println(max(arr));
        System.out.println(median(arr));
        System.out.println(Arrays.toString(randomSortedArray(10, 1, 51)));
    }

    static int linearSearch(int[] arr, int num) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == num) {
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }
        System.out.println("Comparisons: " + comparisons);
        return -1;
    }

    static int[] linearSearchAll(int[] arr, int num) {
        int comparisons = 0;
        int[] rawIndexes = new int[arr.length];
        int index = 0;
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (found) i = arr.length; // break
            comparisons++;
            if (arr[i] == num) {
                rawIndexes[index] = i;
                index++;
                found = true;
            }
        }
        int[] indexes = new int[index];
        for (int i = 0; i < index; i++) {
            indexes[i] = rawIndexes[i];
        }
        System.out.println("Comparisons: " + comparisons);
        return indexes;
    }

    static int[] insert(int[] arr, int num) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (num > arr[i]) {
                index++;
            }
        }
        int n = 0;
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            if (i == index) {
                newArr[i] = num;
                n = 1;
            } else {
                newArr[i] = arr[i - n];
            }
        }
        return newArr;
    }

    static int min(int[] arr) {
        return arr[0];
    }

    static int max(int[] arr) {
        return arr[arr.length - 1];
    }

    static double median(int[] arr) {
        if (arr.length % 2 == 1) return (double) arr[arr.length / 2];
        else return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0;
    }

    static int[] randomSortedArray(int length, int min, int max) {
        Random r = new Random();

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            int range = max - min;
            if (range == 0) {
                arr[i] = min;
            } else {
                min = min + r.nextInt(range);
                arr[i] = min;
            }
        }
        return arr;
    }

}