package Circles;

import Utils.Input;

public class Hockey {

    public static void main(String[] args) {
        Puck p = new Puck(Input.nextDouble("Weight of puck in ounces: "));
        p.setRadius(Input.nextDouble("New radius in inches: "));
        p.setThickness(Input.nextDouble("New thickness in inches: "));
        System.out.println(p);
    }

}
