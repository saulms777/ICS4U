public class MySavings {

    public static void main(String[] args) {
        PiggyBank bank;
        if (utils.inputString("Standard piggy bank? (y/n) ").equals("y")) bank = new PiggyBank();
        else bank = new PiggyBank(utils.inputInt("Amount in bank: "));

        boolean loop = true;
        while (loop) {
            switch (utils.inputInt("""
                    ---------------------------------------
                    1) Show total in piggy bank
                    2) Add a cent
                    3) Add a nickel
                    4) Add a dime
                    5) Add a quarter
                    6) Take money out of the piggy bank
                    0) Quit
                    Enter your choice:\s""")) {
                case 1 -> System.out.println(bank);
                case 2 -> bank.addCent();
                case 3 -> bank.addNickel();
                case 4 -> bank.addDime();
                case 5 -> bank.addQuarter();
                case 6 -> bank.takeAmount(utils.inputInt("Amount to take: "));
                case 0 -> loop = false;
            }
        }
    }

}

class PiggyBank {

    private double total;

    public PiggyBank() {
        total = 1;
    }

    public PiggyBank(double amount) {
        total = amount;
    }

    @Override
    public String toString() {
        return "Total amount: " + total;
    }

    public void addCent() {
        total += 0.01;
    }

    public void addNickel() {
        total += 0.05;
    }

    public void addDime() {
        total += 0.1;
    }

    public void addQuarter() {
        total += 0.25;
    }

    public void takeAmount(double amount) {
        total -= amount;
    }

}
