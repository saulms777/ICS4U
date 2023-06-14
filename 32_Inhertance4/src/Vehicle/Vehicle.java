package Vehicle;

public abstract class Vehicle {

    private String name;
    private double weight;
    private double cost;

    protected Vehicle(String name, double weight, double cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("""
                Name: %s
                Weight: %.2f
                Cost: $%.2f
                Type: %s""",
                name, weight, cost, getType());
    }

    public abstract String getSound();

    public abstract String getType();

    @Override
    public abstract boolean equals(Object o);

}
