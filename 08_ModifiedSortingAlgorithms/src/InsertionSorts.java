class InsertionSorts {

    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int index = i, el = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (el >= arr[j]) break;
                arr[j + 1] = arr[j];
                index = j;
            }
            arr[index] = el;
        }
    }

    static void insertionSortAlt(int[] arr) {
        int n = arr.length - 1;
        for (int i = n - 1; i >= 0; i--) {
            int index = i, el = arr[i];
            for (int j = i + 1; j <= n; j++) {
                if (el <= arr[j]) break;
                arr[j + 1] = arr[j];
                index = j;
            }
            arr[index] = el;
        }
    }

    static void insertionSortReverse(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int index = i, el = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (el <= arr[j]) break;
                arr[j + 1] = arr[j];
                index = j;
            }
            arr[index] = el;
        }
    }

}
