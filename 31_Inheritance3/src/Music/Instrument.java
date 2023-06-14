package Music;

public abstract class Instrument {

    private final String name;

    public Instrument(String name) {
        this.name = name;
    }

    public String getMusician() {
        return name;
    }

    public abstract String makeSound();

    @Override
    public String toString() {
        return String.format("%s makes a %s sound", getMusician(), makeSound());
    }

}
