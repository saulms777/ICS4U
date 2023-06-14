package Music;

public class Woodwind extends Instrument {

    public Woodwind(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "toot";
    }

}
