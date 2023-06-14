class Ex5_DuplicatingArrays {

    static int[][] duplicateArr(int[][] arr) {
        return duplicateArr(arr, 2);
    }

    static int[][] duplicateArr(int[][] arr, int scale) {
        int length = arr.length;
        if (scale < 1) throw new IllegalArgumentException("Scale cannot be less than 1");
        for (int[] row : arr) if (row.length != length) throw new IllegalArgumentException("Square array needed");

        int[][] duplicated = new int[length * scale][length * scale];
        for (int row = 0; row < scale * length; row += length) {
            for (int column = 0; column < scale * length; column += length) {
                for (int i = 0; i < length; i++) {
                    for (int j = 0; j < length; j++) {
                        duplicated[row + i][column + j] = arr[i][j];
                    }
                }
            }
        }
        return duplicated;
    }

}
