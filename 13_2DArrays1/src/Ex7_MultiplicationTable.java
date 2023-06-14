import java.util.Scanner;

class Ex7_MultiplicationTable {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] input1 = userInput();
        int[] input2 = userInput();

        int[][] arr1 = generateArr(input1[0], input1[1], input2[0], input2[1]);
        print2DArray(arr1, input1[0], input2[0]);

        System.out.println();

        int[][] arr2 = generateArr(input2[0], input2[1], input1[0], input1[1]);
        print2DArray(arr2, input2[0], input1[0]);
    }

    private static int[] userInput() {
        int[] input;
        input = new int[2];
        System.out.print("Enter min: ");
        input[0] = sc.nextInt();
        System.out.print("Enter max: ");
        input[1] = sc.nextInt();
        return input;
    }

    private static int[][] generateArr(int rowMin, int rowMax, int columnMin, int columnMax) {
        int[][] arr = new int[rowMax - rowMin + 1][columnMax - columnMin + 1];
        for (int i = rowMin; i <= rowMax; i++) {
            for (int j = columnMin; j <= columnMax; j++) {
                arr[i - rowMin][j - columnMin] = i * j;
            }
        }
        return arr;
    }

    private static void print2DArray(int[][] arr, int rowMin, int columnMin) {
        final int SPACES = 5;
        String str;

        System.out.print(" ".repeat(SPACES));
        for (int i = columnMin; i < columnMin + arr[0].length; i++) {
            str = Integer.toString(i);
            str += " ".repeat(SPACES - str.length());
            System.out.print(str);
        }
        System.out.println();

        for (int[] row : arr) {
            str = Integer.toString(rowMin);
            str += " ".repeat(SPACES - str.length());
            System.out.print(str);
            rowMin++;

            for (int el : row) {
                str = Integer.toString(el);
                str += " ".repeat(SPACES - str.length());
                System.out.print(str);
            }

            System.out.println();
        }
    }

}
