package Circles;

public class Puck extends Disk {

    private final double weight;
    private final String division;

    public Puck(double weight) {
        super(1.5, 1);
        if (weight > 5.5 || weight < 4) throw new IllegalArgumentException("Weight has to be between 4 and 5.5 ounces");
        this.weight = weight;
        division = weight <= 5.5 && weight >= 5 ? "Standard" : "Youth";
    }

    public double getWeight() {
        return weight;
    }

    public String getDivision() {
        return division;
    }

    @Override
    public String toString() {
        return String.format("""
                        Division: %s
                        Weight: %.2f
                        """,
                getDivision(), getWeight())
                + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Puck && o.toString().equals(toString());
    }

}
