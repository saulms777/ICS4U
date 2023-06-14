public class Account {

    private double balance;
    private final Customer c;

    public Account(double balance, String firstName, String lastName, String street, String city, String province) {
        this.balance = balance;
        c = new Customer(firstName, lastName, street, city, province);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdrawal(double amount) {
        if (amount <= balance) balance -= amount;
        else System.out.println("Not enough money in account");
    }

    public void setAddress(String street, String city, String province) {
        c.setStreet(street);
        c.setCity(city);
        c.setProvince(province);
    }

    @Override
    public String toString() {
        return String.format("Balance: %s\n%s", balance, c);
    }

}
