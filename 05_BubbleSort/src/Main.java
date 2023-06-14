import java.util.Random;

class Main {

    public static void main(String[] args) {
        int[] arr = randomArray(10, 1, 30);
        bubbleSort(arr);
    }

    static void bubbleSort(int[] arr) {
        int comparisons = 0, accesses = 0, n = arr.length - 1;
        for (int i = 0; i < n; i++) {
            boolean sorted = true;
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    sorted = false;
                    accesses += 2;
                }
                printLine(arr);
                comparisons++;
                accesses++;
            }
            if (sorted) {
                System.out.println("Comparisons: " + (comparisons - 1));
                System.out.println("Swaps: " + accesses);
                return;
            }
        }
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
