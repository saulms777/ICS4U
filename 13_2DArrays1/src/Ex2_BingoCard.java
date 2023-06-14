import java.util.Random;

class Ex2_BingoCard {

    public static void main(String[] args) {
        Random r = new Random();
        int[][] bingoCard = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int num = 1 + r.nextInt(100);
                bingoCard[i][j] = num;
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
