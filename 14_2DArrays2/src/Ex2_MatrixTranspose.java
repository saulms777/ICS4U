class Ex2_MatrixTranspose {

    static int[][] transpose(int[][] arr) {
        int[][] transposed = new int[arr[0].length][arr.length];
        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 0; i < arr.length; i++) transposed[j][i] = arr[i][j];
        }
        return transposed;
    }

}
