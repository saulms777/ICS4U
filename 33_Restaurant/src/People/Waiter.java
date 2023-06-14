package People;

/**
 * The Waiter class is a subclass of the abstract class Employee,
 * and acts as a waiter in a Restaurant.
 *
 * @author Samuel Zhang
 */
public class Waiter extends Employee {

    /**
     * Tips collected by the waiter in a month
     */
    private double tipsCollected = 0.0;

    /**
     * Initializes a Waiter. Also see {@link Employee#Employee(String, String, int, int, WorkShift)}
     *
     * @param name The name of the waiter
     * @param backgroundInfo Background information on the waiter
     * @param age The age of the waiter
     * @param salary The monthly salary of the waiter
     * @param workShift The waiter's work shift
     */
    public Waiter(String name, String backgroundInfo, int age, int salary, WorkShift workShift) {
        super(name, backgroundInfo, age, salary, workShift);
    }

    /**
     * Returns a String representing all the information of the Waiter. Also see {@link Employee#toString()}
     *
     * @return String with all Waiter information
     */
    @Override
    public String toString() {
        return "Job: Waiter\n" + super.toString() + "\nTips this month: " + tipsCollected;
    }

    /**
     * Overrides setSalary() method in superclass. Updates tipsCollected to 5% of salary.
     * Also see {@link Employee#setSalary(int)}
     *
     * @param salary Salary to update to
     */
    @Override
    public void setSalary(int salary) {
        this.salary = salary;
        tipsCollected = salary * 0.05;
    }

    /**
     * Overrides payWorker() method in superclass. Updates amount paid to include tipsCollected.
     * Also see {@link Employee#payWorker()}
     *
     * @return Feedback message for paying the worker
     */
    @Override
    public String payWorker() {
        return "Paid $" + (salary + tipsCollected) + " to " + name;
    }

    /**
     * Gets the amount of tips collected
     *
     * @return Tips collected
     */
    public double getTipsCollected() {
        return tipsCollected;
    }

}
