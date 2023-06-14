package Rectangles;

public class Box extends Rectangle {

    private double depth;
    private String colour;

    public Box(double length, double width, double depth) {
        super(length, width);
        this.depth = depth;
        colour = "white";
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getVolume() {
        return getLength() * getWidth() * depth;
    }

    public double getSurfaceArea() {
        return 2 * (getLength() * getWidth() + getLength() * depth + getWidth() * depth);
    }

    @Override
    public String toString() {
        return String.format("""
                Length: %.2f
                Width: %.2f
                Depth: %.2f
                Colour: %s
                Volume: %.2f
                Surface area: %.2f""",
                getLength(), getWidth(), getDepth(), getColour(), getVolume(), getSurfaceArea());
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Box && o.toString().equals(toString());
    }

}
