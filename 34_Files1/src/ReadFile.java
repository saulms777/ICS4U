import java.io.*;
import java.util.*;

public class ReadFile {

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/read.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert sc != null;

        System.out.println(sc.nextLine());

        int[][] arr = new int[5][6];
        int i = 0;
        while (sc.hasNextLine()) {
            int[] a = new int[6];
            String line = sc.nextLine();
            int j = 0;
            for (char c : line.toCharArray()) {
                if (c != ' ') {
                    a[j] = c - '0';
                    j++;
                }
            }
            arr[i] = a;
            i++;
        }
        System.out.println(Arrays.deepToString(arr));

        sc.close();
    }

}
