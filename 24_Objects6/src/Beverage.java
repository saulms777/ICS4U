import java.util.Random;

public class Beverage {

    private static int quantity = 0;
    private static double totalCost = 0;

    private final String name;
    private final String size;
    private final double cost;

    public Beverage(String name, String size, double cost) {
        this.name = name;
        this.size = size;
        this.cost = cost * (size.equals("small") ? 1 : size.equals("medium") ? 1.5 : 1.9);
    }

    public void increaseQuantity() {
        quantity++;
    }

    public void increaseTotalCost(double cost) {
        totalCost += cost;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getCost() {
        return cost;
    }

}

class Main {

    public static void main(String[] args) {
        Random r = new Random();
        Beverage[] drinks = new Beverage[15];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                drinks[3 * i + j] = new Beverage(
                        new String[]{"Apple", "Orange", "Coke", "Sprite", "Wine"}[r.nextInt(5)],
                        new String[]{"Small", "Medium", "Large"}[j],
                        (300 + r.nextInt(301)) / 100.0
                );
            }
        }

        while (utils.inputInt("Press 0 to exit: ") != 0) {
            String name = utils.inputWord("Type of drink: ");
            String size = utils.inputWord("Drink size: ");

            double cost;
            for (int i = 0; i < 15; i++) {
                if (drinks[i].getName().equals(name) && drinks[i].getSize().equals(size)) {
                    cost = drinks[i].getCost();
                    drinks[i].increaseQuantity();
                    drinks[i].increaseTotalCost(cost);
                }
            }
        }
    }

}
