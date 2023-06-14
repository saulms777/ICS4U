package Music;

public class Performance {

    private final String arrangement;
    private final Instrument solo;
    private Instrument duet;
    private Instrument trio;

    public Performance(Instrument solo) {
        this.solo = solo;
        arrangement = solo.makeSound();
    }

    public Performance(Instrument solo, Instrument duet) {
        this.solo = solo;
        this.duet = duet;
        arrangement = solo.makeSound() + " " + duet.makeSound();
    }

    public Performance(Instrument solo, Instrument duet, Instrument trio) {
        this.solo = solo;
        this.duet = duet;
        this.trio = trio;
        arrangement = solo.makeSound() + " " + duet.makeSound() + " " + trio.makeSound();
    }

    public String begin() {
        return arrangement;
    }

    @Override
    public String toString() {
        String sounds = solo.toString();
        if (duet != null) sounds += " " + duet;
        if (trio != null) sounds += " " + trio;
        return sounds;
    }

}
