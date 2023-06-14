/*
 * i) No, acres is private
 * ii) No, central is not defined
 * iii) Yes
 * iv) No, acres is not defined and getAcres method has too many parameters
 * v) No, park.getPlayground() is not a variable
 * vi) Yes
 */

import java.util.Random;
import java.util.Scanner;

public class Park {

    private String name;
    private boolean playground;
    private int acres;

    public Park (String myName, boolean myPlayground, int myAcres){
        name = myName;
        playground = myPlayground;
        acres = myAcres;
    }

    public String getName() {
        return name;
    }

    public boolean hasPlayground() {
        return playground;
    }

    public int getAcres() {
        return acres;
    }

    // Additional implementation not shown

    @Override
    public boolean equals(Object o) {
        return o instanceof Park && ((Park) o).getName().equals(name)
                && (((Park) o).hasPlayground() && playground) && ((Park) o).getAcres() == acres;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        Park userPark = new Park(
                sc.next(),
                sc.nextBoolean(),
                sc.nextInt()
        );
        Park[] parks = new Park[5];
        for (int i = 0; i < 5; i++) {
            parks[i] = new Park(
                    String.valueOf("abcdefghijklmnopqrstuvwxyz".toCharArray()[r.nextInt(26)]),
                    r.nextBoolean(),
                    r.nextInt()
            );
            if (parks[i].equals(userPark)) System.out.println("Found");
        }
    }

}
