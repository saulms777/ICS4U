package Circles;

public class Disk extends Circle {

    private double thickness;

    public Disk(double radius, double thickness) {
        super(radius);
        this.thickness = thickness;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public double surfaceArea() {
        return circumference() * thickness + 2 * area();
    }

    public double volume() {
        return area() * thickness;
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("""
                        
                        Thickness: %.2f
                        Surface area: %.2f
                        Volume: %.2f""",
                getThickness(), surfaceArea(), volume());
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Disk && o.toString().equals(toString());
    }

}
