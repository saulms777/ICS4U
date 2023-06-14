import java.io.*;
import java.util.*;

public class Rectangles {

    public static Rectangle[] rectangles = new Rectangle[5];

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(new File("src/rectangles.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }

        for (int i = 0; i < 5; i++) {
            String input = sc.nextLine();
            int length = Integer.parseInt(input.substring(0, input.indexOf(',')));
            input = input.substring(input.indexOf(',') + 1);
            double width = Double.parseDouble(input.substring(0, input.indexOf(',')));
            input = input.substring(input.indexOf(',') + 1);
            String colour = input.substring(1, input.length() - 1);
            rectangles[i] = new Rectangle(length, width, colour);
        }

        int choice;
        while ((choice = Input.nextInt("""
                1. Display info
                2. Display areas
                3. Display perimeters
                4. Find rectangle
                5. Modify info
                6. Save info
                0. Exit
                Choice:\s""")) != 0) {
            switch (choice) {
                case 1 -> display();
                case 2 -> areas();
                case 3 -> perimeters();
                case 4 -> find();
                case 5 -> data();
                case 6 -> save();
            }
        }

        sc.close();
    }

    public static void display() {
        for (Rectangle r : rectangles) System.out.println(r);
    }

    public static void areas() {
        for (Rectangle r : rectangles) System.out.println(r.getArea());
    }

    public static void perimeters() {
        for (Rectangle r : rectangles) System.out.println(r.getPerimeter());
    }

    public static void find() {
        Rectangle rectangle = new Rectangle(
                Input.nextInt("Length: "),
                Input.nextDouble("Width: "),
                Input.next("Colour: ")
        );
        for (Rectangle r : rectangles) if (r.equals(rectangle)) System.out.println("Match found");
    }

    public static void data() {
        int index = Input.nextInt("Index: ");
        switch (Input.next("Type: ")) {
            case "length" -> rectangles[index].setLength(Input.nextInt("New length: "));
            case "width" -> rectangles[index].setWidth(Input.nextDouble("New width: "));
            case "colour" -> rectangles[index].setColour(Input.next("New colour: "));
        }
    }

    public static void save() {
        PrintWriter output;
        try {
            output = new PrintWriter("src/rectangles.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Rectangle r : rectangles)
            output.println(r.getLength() + "," + r.getWidth() + ",\"" + r.getColour() + "\"");

        output.close();
    }

    private static class Rectangle {

        private int length;
        private double width;
        private String colour;

        public Rectangle(int length, double width, String colour) {
            this.length = length;
            this.width = width;
            this.colour = colour;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public String getColour() {
            return colour;
        }

        public void setColour(String colour) {
            this.colour = colour;
        }

        @Override
        public String toString() {
            return "Rectangle:[length=" + length + ",width=" + width + ",colour=" + colour + "]";
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Rectangle &&
                    ((Rectangle) o).getLength() == length &&
                    ((Rectangle) o).getWidth() == width &&
                    ((Rectangle) o).getColour().equals(colour);
        }

        public double getArea() {
            return length * width;
        }

        public double getPerimeter() {
            return 2 * (length + width);
        }

    }

}
