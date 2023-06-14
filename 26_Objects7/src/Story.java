/*
 * b) var1, var2, str1
 */

public class Story {

    private int var1;
    private double var2;
    private String str1;
    public static String str2 = "";

    public Story(String x, int y, double z) {
        var1 = y;
        var2 = z;
        str1 = x;
    }

    public void setVar2(double var2) {
        this.var2 = var2;
    }

    public static void main(String[] args) {
        Story Cinderella = new Story("Disney", 19, 24.18);
        Cinderella.setVar2(106.9);
        Story[] stories = new Story[10];
    }

}
