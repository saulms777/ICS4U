import java.util.Scanner;

class Ex4_Letters {

    public static void main(String[] args) {
        char[][][] arr = userInput();
        fillAlphabet(arr);
        printArray(arr);
        countElements(arr);
    }

    static char[][][] userInput() {
        int d, r, c;
        boolean invalid = false;
        try (Scanner sc = new Scanner(System.in)) {
            do {
                if (invalid) System.out.println("Dimensions are invalid\n");
                System.out.print("Depth: ");
                d = sc.nextInt();
                System.out.print("Rows: ");
                r = sc.nextInt();
                System.out.print("Columns: ");
                c = sc.nextInt();
                invalid = d < 1 || d > 3 || r < 1 || r > 3 || c < 1 || c > 3;
            } while (invalid);
        }
        return new char[d][r][c];
    }

    static void fillAlphabet(char[][][] arr) {
        char current = 'a';
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                for (int k = 0; k < arr[0][0].length; k++) {
                    arr[i][j][k] = current;
                    current++;
                }
            }
        }
    }

    static void printArray(char[][][] a) {
        for (char[][] arr : a) {
            for (char[] row : arr) {
                for (char el : row) System.out.print(el + " ");
                System.out.println();
            }
            System.out.println();
        }
    }

    static void countElements(char[][][] arr) {
        System.out.println("Elements in array: " + arr.length * arr[0].length * arr[0][0].length);
    }

}
