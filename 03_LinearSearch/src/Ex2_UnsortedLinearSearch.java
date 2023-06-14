import java.util.Scanner;

import java.util.Arrays;

class Ex2_UnsortedLinearSearch {
    
    public static void main(String[] args) {
        int[] arr = Ex1_SortedLinearSearch.randomSortedArray(10, 1, 51);

        int num;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Number to find: ");
            num = sc.nextInt();
        }

        System.out.println(linearSearch(arr, num));
        System.out.println(Arrays.toString(linearSearchAll(arr, num)));
        System.out.println(min(arr));
        System.out.println(max(arr));
    }

    static int linearSearch(int[] arr, int num) {
        return Ex1_SortedLinearSearch.linearSearch(arr, num);
    }

    static int[] linearSearchAll(int[] arr, int num) {
        int comparisons = 0;
        int[] rawIndexes = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == num) {
                rawIndexes[index] = i;
                index++;
            }
        }
        int[] indexes = new int[index];
        for (int i = 0; i < index; i++) {
            indexes[i] = rawIndexes[i];
        }
        System.out.println("Comparisons: " + comparisons);
        return indexes;
    }

    static int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

}