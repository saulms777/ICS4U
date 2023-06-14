class Ex4_PascalTriangle {

    static int[][] pascalTriangle(int rows) {
        int[][] pascal = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] row = new int[i + 1];
            row[0] = 1;
            if (row.length > 1) row[row.length - 1] = 1;
            if (i > 1) for (int j = 1; j < row.length - 1; j++) row[j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            pascal[i] = row;
        }
        return pascal;
    }

}
