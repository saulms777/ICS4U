package Music;

public class Clarinet extends Woodwind {

    public Clarinet(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "squawk";
    }

}
