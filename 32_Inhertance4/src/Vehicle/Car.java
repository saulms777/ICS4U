package Vehicle;

public class Car extends Vehicle {

    public Car(String name, double weight, double cost) {
        super(name, weight, cost);
    }

    @Override
    public String getSound() {
        return "vroom";
    }

    @Override
    public String getType() {
        return "Car";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Car && o.toString().equals(toString());
    }

}
