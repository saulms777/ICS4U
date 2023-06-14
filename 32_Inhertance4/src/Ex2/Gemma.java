package Ex2;

public class Gemma extends Alpha {

    private int num;
    private String postalCode = "A0A0A0";

    public Gemma(int num) {
        super();
        this.num = num;
    }

    public Gemma(int num, int postalCode) {
        super();
        this.num = num;
        this.postalCode = postalCode;
    }

    public String display() {
        return ("num: " + num + " value: " + getValue());
    }

    @Override
    public int mysteryOperation(int num) {
        return num * getValue();
    }

}
