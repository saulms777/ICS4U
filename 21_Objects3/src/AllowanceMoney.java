public class AllowanceMoney {

    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();

        boolean loop = true;
        while (loop) {
            switch (utils.inputInt("""
                    ---------------------------------------
                    1) Show parent info
                    2) Show child info
                    3) Give allowance
                    4) Check if child is broke
                    5) Spend money
                    0) Quit
                    Enter your choice:\s""")) {
                case 1 -> System.out.println(parent);
                case 2 -> System.out.println(child);
                case 3 -> parent.giveMoney(child);
                case 4 -> parent.checkChildMoney(child);
                case 5 -> child.spendMoney(utils.inputInt("Money to spend: "));
                case 0 -> loop = false;
            }
        }
    }

}

class Parent {

    private int allowanceTimes = 0;
    private boolean childIsBroke;

    public void giveMoney(Child child) {
        if (allowanceTimes > 10) return;
        child.giveAllowance();
        allowanceTimes++;
    }

    public void checkChildMoney(Child child) {
        childIsBroke = child.isBroke();
    }

    @Override
    public String toString() {
        return "Parent\nAllowances given: " + allowanceTimes + "\nDoes the child have less than $10: " + childIsBroke;
    }

}

class Child {

    private int money;

    public void giveAllowance() {
        money += 10;
    }

    public void spendMoney(int amount) {
        money -= amount;
    }

    public boolean isBroke() {
        return money < 10;
    }

    @Override
    public String toString() {
        return "Child\nMoney: " + money;
    }

}
