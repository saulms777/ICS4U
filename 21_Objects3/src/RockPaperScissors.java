import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        Player p;
        System.out.print("Name: (leave blank for no name) ");
        String input = sc.nextLine();
        if (input.equals("")) p = new Player();
        else p = new Player(input);

        boolean loop = true;
        int player;
        int computer;
        HashMap<Integer, String> results = new HashMap<>() {{
            put(0, "Rock");
            put(1, "Paper");
            put(2, "Scissors");
        }};
        while (loop) {
            switch (((player = r.nextInt(3)) - (computer = r.nextInt(3))) % 3) {
                case 0 -> System.out.println();
                case 1 -> {
                    System.out.println("You won");
                    p.win();
                }
                case 2 -> {
                    System.out.println("You lost");
                    p.lose();
                }
            }
            System.out.println("Player: " + results.get(player) + "\nComputer: " + results.get(computer));

            System.out.println("Play again? (y/n)");
            if (sc.next().equals("n")) loop = false;
        }
        System.out.print(p);
        sc.close();
    }

}

class Player {

    private final String name;
    private int score;

    public Player() {
        name = "Unnamed Player";
        score = 0;
    }

    public Player(String name) {
        this.name = name;
        score = 0;
    }

    public void win() {
        score += 2;
    }

    public void lose() {
        score--;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nScore: " + score;
    }

}
