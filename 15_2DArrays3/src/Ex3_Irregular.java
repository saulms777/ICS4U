import java.util.Arrays;

class Ex3_Irregular {

    static int[][] arr = {
            {4, 3, 7},
            {5, 2},
            {7, 8, 1, 4}
    };

    static void display() {
        System.out.println(Arrays.deepToString(arr));
    }

    static int sum(int row) {
        int total = 0;
        for (int n : arr[row]) total += n;
        return total;
    }

    static int sum() {
        int total = 0;
        for (int[] a : arr) {
            for (int n : a) total += n;
        }
        return total;
    }

    static int max() {
        int max = Integer.MIN_VALUE;
        for (int[] a : arr) {
            for (int n : a) {
                if (max < n) max = n;
            }
        }
        return max;
    }

}
