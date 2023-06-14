import java.util.Random;

public class Soup {

    private String flavour;
    private int amount;

    public Soup() {
        Random r = new Random();
        flavour = new String[]{"Chicken", "Chili", "Cream of Broccoli", "Seafood"}[r.nextInt(4)];
        amount = 300 + r.nextInt(51);
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Soup: %s\nFlavour: %d mL", flavour, amount);
    }

    public boolean equals(Soup soup) {
        return soup.getFlavour().equals(flavour) && Math.abs(soup.getAmount() - amount) <= 10;
    }

    public static void main(String[] args) {
        Soup[] soups = new Soup[5];
        for (int i = 0; i < 5; i++) soups[i] = new Soup();

        boolean loop = true;
        while (loop) {
            switch (utils.inputInt("""
                    (1) Update soup flavour
                    (2) Update soup amount
                    (3) Display soup
                    (4) Search soup
                    (0) Exit""")) {
                case 0 -> loop = false;
                case 1 -> soups[utils.inputInt("Soup to update: ")]
                        .setFlavour(utils.inputWord("Flavour to update to: "));
                case 2 -> soups[utils.inputInt("Soup to update: ")]
                        .setAmount(utils.inputInt("Amount to update to: "));
                case 3 -> System.out.println(soups[utils.inputInt("Soup to print: ")]);
                case 4 -> {
                    int index = utils.inputInt("Soup to check: ");
                    boolean found = false;
                    for (int i = 0; i < 5; i++) {
                        if (i == index) continue;
                        found = soups[i].equals(soups[index]);
                    }
                    System.out.println(found ? "Soup found" : "Soup not found");
                }
            }
        }
    }

}
