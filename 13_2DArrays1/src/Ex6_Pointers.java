class Ex6_Pointers {

    public static void main(String[] args) {
        int[][] x = {{1, 2}, {3, 4}};
        int[][] y = {{5, 6}, {7, 8}};
        Ex5_ComparingArrays.print2DArray(x);
        Ex5_ComparingArrays.print2DArray(y);

        x = y; // x now points to the array y
        y[0][0] = 100; // changes y and also x
        Ex5_ComparingArrays.print2DArray(x);
        Ex5_ComparingArrays.print2DArray(y);
    }

}
