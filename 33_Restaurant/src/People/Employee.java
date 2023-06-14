package People;

/**
 * The Employee class is the superclass of all employees in the Restaurant.
 * All employees will have the attributes of this class.
 *
 * @author Samuel Zhang
 */
public abstract class Employee {

    /**
     * Minimum monthly wage in Ontario
     */
    private static final int MINIMUM_SALARY = 2400;

    /**
     * Whether the employee is active or terminated
     */
    protected boolean isActive = true;

    /**
     * Name of the employee
     */
    protected String name;

    /**
     * Employee background information
     */
    protected String backgroundInfo;

    /**
     * Age of the employee
     */
    protected int age;

    /**
     * Monthly salary of the employee
     */
    protected int salary;

    /**
     * Employee work shift
     */
    protected WorkShift workShift;

    /**
     * Initializes an Employee
     *
     * @param name The name of the employee
     * @param backgroundInfo Background information on the employee
     * @param age The age of the employee
     * @param salary The monthly salary of the employee
     * @param workShift The employee's work shift
     */
    protected Employee(String name, String backgroundInfo, int age, int salary, WorkShift workShift) {
        this.name = name;
        this.backgroundInfo = backgroundInfo;
        this.age = age;
        this.salary = Math.max(salary, MINIMUM_SALARY); // to make sure the salary isn't lower than the minimum
        this.workShift = workShift;
    }

    /**
     * Returns a String representing all the information of the Employee.
     *
     * @return String with all Employee information
     */
    @Override
    public String toString() {
        String status;
        if (isActive) status = "Active";
        else status = "Terminated";
        return "Status: " + status +
                "\nName: " + name +
                "\nAge: " + age +
                "\nBackground info: " + backgroundInfo +
                "\nMonthly salary: " + salary +
                "\nWork shift time: " + workShift.seeStartTime() + " to " + workShift.seeStopTime();
    }

    /**
     * Gets the status of the employee
     *
     * @return Employee status
     */
    public boolean getStatus() {
        return isActive;
    }

    /**
     * Switches the status of the employee, either from active to terminated or from terminated to active
     */
    public void switchStatus() {
        isActive = !isActive;
    }

    /**
     * Gets the name of the employee
     *
     * @return Employee name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the employee
     *
     * @param name Name to change to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the employee background information
     *
     * @return Employee background information
     */
    public String getBackgroundInfo() {
        return backgroundInfo;
    }

    /**
     * Sets the employee background information
     *
     * @param backgroundInfo New employee background information
     */
    public void setBackgroundInfo(String backgroundInfo) {
        this.backgroundInfo = backgroundInfo;
    }

    /**
     * Gets the age of the employee
     *
     * @return Employee age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the employee
     *
     * @param age New employee age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the salary of the employee
     *
     * @return Employee salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the employee
     *
     * @param salary New employee salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Gets the work shift of the employee
     *
     * @return Employee work shift
     */
    public WorkShift getWorkShift() {
        return workShift;
    }

    /**
     * Sets the work shift of the employee
     *
     * @param workShift New employee work shift
     */
    public void setWorkShift(WorkShift workShift) {
        this.workShift = workShift;
    }

    /**
     * Returns a String on the employee's work time
     *
     * @return Feedback message
     */
    public String seeWorkShift() {
        return name + " works from " + workShift.seeStartTime() + " to " + workShift.seeStopTime();
    }

    /**
     * Returns a String on paying the worker
     *
     * @return Feedback message
     */
    public String payWorker() {
        return "Paid $" + salary + " to " + name;
    }

}
