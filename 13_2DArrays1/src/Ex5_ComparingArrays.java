import java.util.Random;

class Ex5_ComparingArrays {

    static void createArrays() {
        Random r = new Random();
        int[][] arr1 = new int[2][2];
        int[][] arr2 = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                arr1[i][j] = 1 + r.nextInt(5);
                arr2[i][j] = 1 + r.nextInt(5);
            }
        }

        print2DArray(arr1);
        System.out.println();
        print2DArray(arr2);
    }

    static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean compareArrays(int[][] arr1, int[][] arr2) {
        if (arr1.length != arr2.length) throw new RuntimeException("2D arrays are not the same dimensions");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j] != arr2[i][j]) return false;
            }
            System.out.println();
        }
        return true;
    }

}
