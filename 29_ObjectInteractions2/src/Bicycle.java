public class Bicycle {

    private double cost;
    private double mileage;

    public Bicycle() {
        cost = 50;
    }

    public Bicycle(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getMileage() {
        return mileage;
    }

    public void addDistance(double distance) {
        mileage += distance;
    }

}
