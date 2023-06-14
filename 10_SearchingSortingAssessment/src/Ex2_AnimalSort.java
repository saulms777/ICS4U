class Ex2_AnimalSort {

    /**
     * Insertion sort that sorts an <code>String</code> array.
     * The sorted array is on the right and will in descending order.
     *
     * @param arr Array to sort
     */
    static void modifiedInsertionSort(String[] arr) {
        // print initial array
        printArray(arr);

        // insertion sort algorithm
        int n = arr.length - 1;
        for (int i = n - 1; i >= 0; i--) {
            String current = arr[i];
            int j = i + 1;

            // move element to proper position
            while (j <= n && current.compareTo(arr[j]) < 0) {
                arr[j - 1] = arr[j];
                j++;
            }
            arr[j - 1] = current;

            // print array
            printArray(arr);
        }
    }

    /**
     * Prints a <code>String</code> array
     *
     * @param arr Array to print
     */
    static void printArray(String[] arr) {
        // initialize variables
        final int SPACES = 10;
        int length = arr.length;

        // print each element of array
        for (int i = 0; i < length; i++) {
            String current = arr[i];
            System.out.print(current);

            // print extra spaces for consistency
            for (int j = current.length(); j < SPACES; j++) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

}
