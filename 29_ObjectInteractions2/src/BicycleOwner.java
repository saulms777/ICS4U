public class BicycleOwner {

    private String name;
    private final Bicycle bicycle;
    private double speed;

    public BicycleOwner() {
        name = "John Doe";
        bicycle = new Bicycle();
        speed = 10;
    }

    public BicycleOwner(String name, double bikeCost, double speed) {
        this.name = name;
        bicycle = new Bicycle(bikeCost);
        this.speed = speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBicycleCost(double cost) {
        bicycle.setCost(cost);
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void travel(double hours) {
        bicycle.addDistance(speed * hours);
    }

    @Override
    public String toString() {
        return String.format("""
                Profile: %s
                Speed: %.2f
                Bike cost: %.2f
                Bike mileage: %.2f""",
                name, speed, bicycle.getCost(), bicycle.getMileage());
    }

}
