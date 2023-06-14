package Music;

import Utils.Input;

public class Music {

    public static void main(String[] args) {
        Instrument[] band = new Instrument[3];
        for (int i = 0; i < 3; i++) band[i] = assignInstrument();

        while (true) {
            switch (Input.nextWord("Performance: ")) {
                case "solo" -> System.out.println(new Performance(band[0]).begin());
                case "duet" -> System.out.println(new Performance(band[0], band[1]).begin());
                case "trio" -> System.out.println(new Performance(band[0], band[1], band[2]).begin());
                case "leave" -> System.exit(0);
            }
        }
    }

    public static Instrument assignInstrument() {
        String name = Input.nextLine("Musician name: ");
        return switch (Input.nextWord("Instrument type: ")) {
            case "vocal" -> new Vocal(name);
            case "woodwind" -> new Woodwind(name);
            case "piccolo" -> new Piccolo(name);
            case "clarinet" -> new Clarinet(name);
            default -> throw new IllegalArgumentException();
        };
    }

}
