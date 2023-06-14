import java.util.Random;
import java.lang.Math;

class Ex3_ShuffleArray {

    /**
     * Shuffles an array using the following algorithm:
     * 1. Randomize two indexes
     * 2. Swap the two numbers in the array
     * These two steps are repeated arr.length times.
     *
     * @param arr Array to randomize
     */
    static void shuffle(int[] arr) {
        // initialize variables
        Random r = new Random();
        int length = arr.length;
        int first;
        int second;

        // print initial array
        printArray(arr);

        // randomizer loop
        for (int i = 0; i < length; i++) {

            // randomize two indexes
            first = r.nextInt(length);
            second = r.nextInt(length);

            // swap two values
            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;

            // print array
            printArray(arr);
        }
    }

    /**
     * Prints an <code>int</code> array
     *
     * @param arr Array to print
     */
    static void printArray(int[] arr) {
        // initialize variables
        final int SPACES = 5;
        int length = arr.length;

        // print each element of array
        for (int i = 0; i < length; i++) {
            int current = arr[i];
            System.out.print(current);

            // print extra spaces for consistency
            for (int j = (int) Math.log10(current) + 1; j < SPACES; j++) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

}
