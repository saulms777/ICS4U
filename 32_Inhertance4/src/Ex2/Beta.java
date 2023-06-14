package Ex2;

public class Beta extends Alpha {

    private static boolean funny = true;

    private int num;

    public Beta(int num) {
        super();
        this.num = num;
        super.setValue(num - 3);
    }

    public String display() {
        return ("value: " + getValue() + " num: " + num);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Beta && ((Beta) o).display().equals(display());
    }

    @Override
    public int mysteryOperation(int num) {
        return this.num + num;
    }

}
