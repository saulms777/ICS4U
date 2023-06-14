package Ex2;

public abstract class Alpha {

    private int value = 4;
    public Alpha() {}

    public abstract String display();

    public void setValue (int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public abstract int mysteryOperation(int num);

}

