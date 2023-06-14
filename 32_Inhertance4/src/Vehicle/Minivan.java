package Vehicle;

public class Minivan extends Vehicle {

    public Minivan(String name, double weight, double cost) {
        super(name, weight, cost);
    }

    @Override
    public String getSound() {
        return "crank";
    }

    @Override
    public String getType() {
        return "Minivan";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Minivan && o.toString().equals(toString());
    }

}
