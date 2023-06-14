class SelectionSorts {
    private static int n;

    static void selectionSort(int[] arr) {
        int n = arr.length - 1;
        for (int i = n; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 1; j < i; j++) {
                if (arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }

    static void selectionSortReverse(int[] arr) {
        int n = arr.length - 1;
        for (int i = n; i > 0; i--) {
            int minIndex = 0;
            for (int j = 1; j < i; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    static void selectionSortReverseAlt(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
