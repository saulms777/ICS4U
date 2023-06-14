package Circles;

public class Circle {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return String.format("""
                        Radius: %.2f
                        Circumference: %.2f
                        Area: %.2f""",
                getRadius(), circumference(), area());
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Circle && o.toString().equals(toString());
    }

}
