import java.text.NumberFormat;
import java.util.Random;

/*
 * Name: Samuel Zhang
 * Course: ICS4U
 * Description: Objects assessment
 */

public class Book {

    private final static int CURRENT_YEAR = 2023;

    private String name;
    private final int year;
    private double cost;
    private int readers;

    /**
     * Default constructor; name is "Harry Potter" and year of publication is 2010
     */
    public Book() {
        name = "Harry Potter";
        year = 2010;
        cost = (CURRENT_YEAR - 2010) * 60 / 100.0;
    }

    /**
     * Constructor with parameters: if the age of the book is more than 20 the cost is 85% of the age, otherwise the
     * cost is 60% of the age
     *
     * @param newName name of the book
     * @param newYear year of publication
     */
    public Book(String newName, int newYear) {
        name = newName;
        year = newYear;
        if (CURRENT_YEAR - year > 20) cost = (CURRENT_YEAR - year) * 85 / 100.0;
        else cost = (CURRENT_YEAR - year) * 60 / 100.0;
    }

    /**
     * Returns the name and year of the book in String format
     *
     * @return Book information in String
     */
    @Override
    public String toString() {
        return "Name: " + name + "\nYear: " + year;
    }

    /**
     * Sets the name of the book
     *
     * @param newName New name of book
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Gets the cost of the book
     *
     * @return Cost of the book
     */
    public double getCost() {
        return cost;
    }

    /**
     * Generates a random number between 1 and 1,000,000 and returns it separated by commas each thousands
     *
     * @return Formatted String
     */
    public String getReaders() {
        return NumberFormat.getIntegerInstance().format(
                readers = 1 + (new Random()).nextInt(1_000_000)
        );
    }

    /**
     * Checks if the book is popular, if it is add 25% to the cost
     *
     * @return If the book is popular
     */
    public boolean isPopular() {
        if (readers > 500_000) {
            cost *= 1.25;
            return true;
        }
        else return false;
    }

    /**
     * Returns the cost of the book in money format
     *
     * @return Formatted String
     */
    public String bookCost() {
        return NumberFormat.getCurrencyInstance().format(cost);
    }

}
