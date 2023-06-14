package Vehicle;

public class Truck extends Vehicle {

    public Truck(String name, double weight, double cost) {
        super(name, weight, cost);
    }

    @Override
    public String getSound() {
        return "chug";
    }

    @Override
    public String getType() {
        return "Truck";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Truck && o.toString().equals(toString());
    }

}
