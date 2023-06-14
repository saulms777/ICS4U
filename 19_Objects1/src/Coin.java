import java.util.Random;

public class Coin {

    private int num;

    public Coin() {
        flipCoin();
    }

    public void flipCoin() {
        num = (new Random()).nextInt(2);
    }

    public String showFace() {
        if (num == 0) return "Tails";
        return "Heads";
    }

    public boolean equals(Coin coin) {
        return showFace().equals(coin.showFace());
    }

}

class Main {

    public static void main(String[] args) {
        Coin[] coins = new Coin[3];
        boolean won = true;
        while (won) {
            won = allHeads(coins);
            if (won) System.out.println("Rerolling dice...");
        }
    }

    static boolean allHeads(Coin[] coins) {
        for (Coin c : coins) {
            if (!c.showFace().equals("Heads")) return false;
        }
        return true;
    }

}
