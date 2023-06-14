package Rectangles;

import Utils.Input;

public class Main {

    public static void main(String[] args) {
        PencilCase p = new PencilCase(
                Input.nextInt("Age: "),
                Input.nextDouble("Length: "),
                Input.nextDouble("Width: "),
                Input.nextDouble("Depth: ")
        );
        p.setAge(Input.nextInt("New age: "));
        System.out.println(p);
    }

}
