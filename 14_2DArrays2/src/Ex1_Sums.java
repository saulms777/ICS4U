class Ex1_Sums {

    static int[] columnSum(int[][] arr) {
        int[] sums = new int[arr[0].length];
        for (int i = 0; i < sums.length; i++) {
            for (int[] row : arr) sums[i] += row[i];
        }
        return sums;
    }

    static int[] diagonalSum(int[][] arr) {
        int squareLength = Math.min(arr.length, arr[0].length);
        int[] sums = new int[2];
        for (int i = 0; i < squareLength; i++) {
            sums[0] += arr[i][i];
            sums[1] += arr[squareLength - i - 1][i];
        }
        return sums;
    }

}
