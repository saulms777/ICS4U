import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Array: ");
            String[] raw_nums = sc.nextLine().split(",");
            int[] input = new int[raw_nums.length];
            for (int i = 0; i < input.length; i++) {
                input[i] = Integer.parseInt(raw_nums[i]);
            }

            System.out.print("Number to search: ");
            int num = sc.nextInt();

            System.out.print(binarySearch(input, num));
        }
    }

    static int binarySearch(int[] arr, int value) {
        int lower = 0;
        int higher = arr.length - 1;
        int middle = higher / 2;

        if (arr[0] == value) return 0;
        else if (arr[higher] == value) return higher;
        else if (value < arr[0] || value > arr[higher]) return -1;

        while (lower != middle) {
            if (arr[middle] < value) {
                lower = middle;
                middle = (lower + higher) / 2;
            } else if (arr[middle] > value) {
                higher = middle;
                middle = (lower + higher) / 2;
            } else return middle;
        }

        return -1; // redundant
    }

}