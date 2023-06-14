package Music;

public class Piccolo extends Woodwind {

    public Piccolo(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "peep";
    }

}
