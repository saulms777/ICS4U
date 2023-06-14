import java.util.Random;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        String[] studentNames;
        int[][] songs;
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of students: ");
        int length = sc.nextInt();
        sc.nextLine();

        studentNames = new String[length];
        songs = new int[length][];
        for (int i = 0; i < length; i++) {
            System.out.print("Student name: ");
            studentNames[i] = sc.nextLine();
            System.out.print("Number of songs: ");
            songs[i] = new int[sc.nextInt()];
            sc.nextLine();
        }

        generateSongs(studentNames, songs);

        printArray(studentNames, songs);
        System.out.println("Student with most points: " + studentNames[mostPoints(songs)]);
    }

    static void printArray(String[] studentNames, int[][] songs) {
        System.out.println("\nSong listen times:");

        final int WIDTH = 10;
        for (int i = 0; i < studentNames.length; i++) {
            printWithSpaces(studentNames[i], WIDTH - 3);
            System.out.print(" | ");
            for (int j = 0; j < songs[i].length; j++) printWithSpaces(parseString(songs[i][j]), WIDTH);
            System.out.println();
        }
    }

    static void printWithSpaces(String str, int width) {
        System.out.print(str);
        for (int i = 0; i < width - str.length(); i++) {
            System.out.print(" ");
        }
    }

    static void generateSongs(String[] studentNames, int[][] songs) {
        Random r = new Random();
        for (int i = 0; i < songs.length; i++) {
            for (int j = 0; j < songs[i].length; j++) {
                int count = countI(studentNames[i]);
                if (count <= 4 && count >= 2) songs[i][j] = 10 + r.nextInt(10);
                else if (count == 1) songs[i][j] = 20 + r.nextInt(26);
                else if (count == 0 || count >= 5) songs[i][j] = 46 + r.nextInt(5);
            }
        }
    }

    static int mostPoints(int[][] songs) {
        int[] total = new int[songs.length];
        for (int i = 0; i < songs.length; i++) {
            for (int j = 0; j < songs[i].length; j++) total[i] += songs[i][j];
            if (divisible11(total[i])) total[i] += 10;
        }

        int max = 0;
        for (int i = 0; i < total.length; i++) if (total[i] > total[max]) max = i;
        return max;
    }

    static int countI(String str) {
        if (str.length() == 1) return checkI(str.charAt(0));
        return checkI(str.charAt(0)) + countI(str.substring(1));
    }

    static int checkI(char c) {
        if (c == 'i') return 1;
        else return 0;
    }

    static boolean divisible11(int num) {
        if (num < 10 && num > -10) return num == 0;
        return divisible11(alternateSum(parseString(num), true));
    }

    static int alternateSum(String digits, boolean sign) {
        if (digits.length() == 1) return boolToSign(sign) * parseInt(digits.charAt(0));
        return boolToSign(sign) * parseInt(digits.charAt(0)) + alternateSum(digits.substring(1), !sign);
    }

    static String parseString(int num) {
        return num + "";
    }

    static int parseInt(char str) {
        return (int) str - 48;
    }

    static int boolToSign(boolean b) {
        if (b) return 1;
        else return -1;
    }

}
