import java.util.Random;

public class Rectangle {

    private final int height;
    private final int width;
    private final String colour;

    public Rectangle() {
        Random r = new Random();
        height = 1 + r.nextInt(10);
        width = 1 + r.nextInt(10);
        colour = new String[]{"Red", "Yellow", "Blue"}[r.nextInt(3)];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return "Colour: " + colour + ("\n" + "*".repeat(width)).repeat(height);
    }

    public boolean equals(Rectangle rectangle) {
        return rectangle.toString().equals(toString());
    }

    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[10];
        for (int i = 0; i < 10; i++) System.out.println(rectangles[i] = new Rectangle());

        int height = utils.inputInt("Height to find: ");
        int width = utils.inputInt("Width to find: ");
        for (int i = 0; i < 10; i++) {
            if (rectangles[i].getHeight() == height && rectangles[i].getWidth() == width)
                System.out.println("Rectangle found");
        }

        String colour = utils.inputWord("Colour to find: ");
        for (int i = 0; i < 10; i++) if (rectangles[i].getColour().equals(colour)) System.out.println("Colour found");
    }

}
