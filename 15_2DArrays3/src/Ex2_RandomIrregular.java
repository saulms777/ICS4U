import java.util.Random;

class Ex2_RandomIrregular {

    static int[][] randomArr() {
        Random r = new Random();
        int rows = 2 + r.nextInt(5);
        int[][] arr = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int columns = 2 + r.nextInt(5);
            arr[i] = new int[columns];
            for (int j = 0; j < columns; j++) arr[i][j] = i + 1;
        }
        return arr;
    }

}
