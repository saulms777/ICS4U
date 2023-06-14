public class Lunch {

    private boolean onDiet;
    private int calories;

    public Lunch(boolean diet, int cal) {
        onDiet = diet;
        calories = cal;
    }

    public boolean isOnDiet() {
        return onDiet;
    }

    public void setOnDiet(boolean onDiet) {
        this.onDiet = onDiet;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return String.format("Diet: %b\nCalories: %d", onDiet, calories);
    }

    public static void main(String[] args) {
        Lunch yummy = new Lunch(true, 900);
    }

}
