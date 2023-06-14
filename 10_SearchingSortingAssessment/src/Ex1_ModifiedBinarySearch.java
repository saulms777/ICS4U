class Ex1_ModifiedBinarySearch {

    /**
     * Binary search that searches for the index of a given value.
     * If the value is not found in the array, the index of the
     * element closest to the value will be returned.
     *
     * @param arr Array to search
     * @param val Value to find
     * @return Closest index of array to value
     */
    static int modifiedBinarySearch(int[] arr, int val) {
        // initialize binary search variables
        int bottom = 0;
        int top = arr.length - 1;
        int middle;

        // edge cases for efficiency
        if (arr[bottom] == val) return bottom;
        else if (arr[top] == val) return top;

        // binary search loop
        while (bottom <= top) {

            // calculate middle index
            middle = (bottom + top) / 2;

            // update binary search variables
            if (val < arr[middle]) top = middle - 1;
            else if (val > arr[middle]) bottom = middle + 1;
            else return middle;
        }

        // return index of element closest to value
        if (val - arr[top] <= arr[top + 1] - val) return top;
        else return top + 1;
    }

}
