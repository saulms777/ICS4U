package People;

/**
 * The Janitor class is a subclass of the abstract class Employee,
 * and acts as a janitor in a Restaurant.
 *
 * @author Samuel Zhang
 */
public class Janitor extends Employee {

    /**
     * The type of job the janitor does
     */
    private final String job;

    /**
     * Initializes a Janitor. Also see {@link Employee#Employee(String, String, int, int, WorkShift)}
     *
     * @param name The name of the janitor
     * @param backgroundInfo Background information on the janitor
     * @param age The age of the janitor
     * @param salary The monthly salary of the janitor
     * @param workShift The janitor's work shift
     * @param job The type of job the janitor does
     */
    public Janitor(String name, String backgroundInfo, int age, int salary, WorkShift workShift, String job) {
        super(name, backgroundInfo, age, salary, workShift);
        this.job = job;
    }

    /**
     * Returns a String representing all the information of the Janitor. Also see {@link Employee#toString()}
     *
     * @return String with all Janitor information
     */
    @Override
    public String toString() {
        return "Job: Janitor\n" + super.toString() + "\nJob Type: " + job;
    }

    /**
     * Gets the job type of the Janitor.
     *
     * @return Job type
     */
    public String getJob() {
        return job;
    }

}
