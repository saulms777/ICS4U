package Music;

public class Vocal extends Instrument {

    public Vocal(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "lalala";
    }

}
