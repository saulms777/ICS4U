package Rectangles;

public class PencilCase extends Box {

    private int age;

    public PencilCase(int age, double length, double width, double depth) {
        super(length, width, depth);
        this.age = age;
        setColour(new String[]{"white", "black", "blue", "green", "red"}[(int) (Math.random() * 5)]);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAudience() {
        if (age < 15) return "elementary";
        else if (getColour().equals("black") || getColour().equals("blue")) return "high school";
        else return "secondary";
    }

    @Override
    public String toString() {
        return String.format("""
                Age: %d
                Audience: %s
                """,
                getAge(), getAudience())
                + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof PencilCase && o.toString().equals(toString());
    }

}
