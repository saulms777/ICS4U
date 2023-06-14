import java.util.Scanner;

public class Rectangle {

    private int height;
    private int width;
    private String colour;

    public Rectangle() {
        height = 4;
        width = 6;
        colour = "White";
    }

    public int getArea() {
        return height * width;
    }

    public int getPerimeter() {
        return 2 * (height + width);
    }

    public void updateColour() {
        if (getArea() > 30) colour = "Green";
        else if (getArea() < 20) colour = "Red";
        else colour = "White";
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        updateColour();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        updateColour();
    }

    public String getColour() {
        return colour;
    }

    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("""
                    (1) Get dimensions
                    (2) Get colour
                    (3) Get area and perimeter
                    (4) Change width
                    (5) Change height
                    
                    Option:\s""");
            int input = sc.nextInt();
            switch (input) {
                case 1 -> System.out.println("Width: " + rect.getWidth() + "\nHeight: " + rect.getHeight());
                case 2 -> System.out.println("Colour: " + rect.getColour());
                case 3 -> System.out.println("Area: " + rect.getArea() + "\nPerimeter: " + rect.getPerimeter());
                case 4 -> {
                    System.out.print("New width: ");
                    rect.setWidth(sc.nextInt());
                }
                case 5 -> {
                    System.out.print("New height: ");
                    rect.setHeight(sc.nextInt());
                }
            }
        }
    }

}
