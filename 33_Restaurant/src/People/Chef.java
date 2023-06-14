package People;

/**
 * The Chef class is a subclass of the abstract class Employee,
 * and acts as a chef in a Restaurant.
 *
 * @author Samuel Zhang
 */
public class Chef extends Employee {

    /**
     * The type of dish the chef specializes in
     */
    private final String specialty;

    /**
     * Initializes a Chef. Also see {@link Employee#Employee(String, String, int, int, WorkShift)}
     *
     * @param name The name of the chef
     * @param backgroundInfo Background information on the chef
     * @param age The age of the chef
     * @param salary The monthly salary of the chef
     * @param workShift The chef's work shift
     * @param specialty The chef's specialty dish
     */
    public Chef(String name, String backgroundInfo, int age, int salary, WorkShift workShift, String specialty) {
        super(name, backgroundInfo, age, salary, workShift);
        this.specialty = specialty;
    }

    /**
     * Returns a String representing all the information of the Chef. Also see {@link Employee#toString()}
     *
     * @return String with all Chef information
     */
    @Override
    public String toString() {
        return "Job: Chef\n" + super.toString() + "\nSpecialty: " + specialty;
    }

    /**
     * Gets the specialty dish of the Chef.
     *
     * @return Chef specialty
     */
    public String getSpecialty() {
        return specialty;
    }

}
