/**
 * Name: Hasnain
 * Date: April 27th, 2023
 * Course: ICS4U
 * Description: Restaurant class that allows for the main to communicate with the Employee inheritance tree and
 * take advantage of all the methods
 */
import People.Employee;
import People.WorkShift;
import People.Chef;
import People.Janitor;
import People.Waiter;

import java.text.NumberFormat;

/**
 * The Restaurant class is responsible for taking all the employees and taking advantage of all the methods provided to create more complex
 * functionalities that are more useful for the main than the basic accessor methods.
 *
 * @Author Hasnain
 */
public class Restaurant {
    /**
     * The last selected employee for any function
     */
    private int currentlySelected;
    /**
     * The max number of employees for a restaurant using this program
     */
    private final int maxEmployees = 500;
    /**
     * The name of the restaurant
     */
    private final String restaurantName;
    /**
     * The amount of stars the restaurant has
     */
    private final int restaurantStars;
    /**
     * The total amount of employees currently hired
     */
    private int totalEmployeeCount;
    /**
     * The full array of all the employees that the restaurant can hire and also keeps history of previous employees that have been fired
     */
    private final Employee[] employees = new Employee[maxEmployees];

    /**
     * Initializes a restaurant
     *
     * @param restaurantNameN
     * The restaurant name provided by the main
     * @param restaurantStarsN
     * the restaurant stars provided by the main
     */
    public Restaurant(String restaurantNameN, int restaurantStarsN) {
        currentlySelected = 0;
        totalEmployeeCount = 0;
        restaurantName = restaurantNameN;
        restaurantStars = restaurantStarsN;
    }

    /**
     * Checks if the employees array has enough space to hire a new employee
     * @return
     * An integer that represents whether the array has enough space. if its -1 then the array is full.
     * If the number is greater than -1 then that is the index at which there is space for an employee
     */
    private int checkForSpace() {
        return Search.searchForNull(employees);
    }

    /**
     * Initializes an employee to type Janitor
     *
     * @param janitorName
     * Name of the janitor
     * @param backgroundInfo
     * Background info of the janitor
     * @param age
     * Age of the janitor
     * @param salary
     * Salary of the janitor
     * @param workShift
     * WorkShift of the janitor
     * @param job
     * The specific job that the janitor is responsible for
     * @return
     * A String for whether the employee was hired or not
     */
    public String initializeJanitor(String janitorName, String backgroundInfo, int age, int salary, WorkShift workShift, String job) {
        int index = checkForSpace();
        if (index != -1) {
            employees[index] = new Janitor(janitorName, backgroundInfo, age, salary, workShift, job);
            currentlySelected = index;
            totalEmployeeCount++;
            return "Employee hired";
        }
        return "Max number of employees reached. Cannot hire more.";
    }

    /**
     * Initializes an employee to type Waiter
     *
     * @param waiterName
     * Name of the waiter
     * @param backgroundInfo
     * Background info of the waiter
     * @param age
     * Age of the waiter
     * @param salary
     * Salary of the waiter
     * @param workShift
     * WorkShift of the waiter
     * @return
     * A String for whether the employee was hired or not
     */
    public String initializeWaiter(String waiterName,String backgroundInfo, int age, int salary, WorkShift workShift) {
        int index = checkForSpace();
        if (index != -1) {
            employees[index] =new Waiter(waiterName, backgroundInfo, age, salary, workShift);
            currentlySelected = index;
            totalEmployeeCount++;
            return "Employee hired";
        }
        return "Max number of employees reached. Cannot hire more.";
    }

    /**
     * initializes an employee to type Chef
     *
     * @param chefName
     * Name of the Chef
     * @param backgroundInfo
     * Background Info of the Chef
     * @param age
     * Age of the Chef
     * @param salary
     * Salary of the Chef
     * @param workShift
     * WorkShift of the Chef
     * @param specialty
     * The food specialty of the Chef
     * @return
     * A String for whether the employee was hired or not
     */
    public String initializeChef(String chefName, String backgroundInfo, int age, int salary, WorkShift workShift, String specialty) {
        int index = checkForSpace();
        if (index != -1) {
            employees[index] = new Chef(chefName, backgroundInfo, age, salary, workShift, specialty);
            currentlySelected = index;
            totalEmployeeCount++;
            return "Employee hired";
        }
        return "Max number of employees reached. Cannot hire more.";
    }

    /**
     * Hires a chef
     *
     * @param name
     * Name of the Chef
     * @param backgroundInfo
     * Background Info of the Chef
     * @param age
     * Age of the Chef
     * @param salary
     * Salary of the Chef
     * @param workShift
     * WorkShift of the Chef
     * @param specialty
     * The food specialty of the Chef
     */
    public String hireChef(String name, String backgroundInfo, int age, int salary, WorkShift workShift, String specialty) {
        return initializeChef(name, backgroundInfo, age, salary, workShift, specialty);
    }

    /**
     * Hires a waiter
     *
     * @param name
     * Name of the waiter
     * @param backgroundInfo
     * Background info of the waiter
     * @param age
     * Age of the waiter
     * @param salary
     * Salary of the waiter
     * @param workShift
     * WorkShift of the waiter
     */
    public String hireWaiter(String name, String backgroundInfo, int age, int salary, WorkShift workShift) {
        return initializeWaiter(name, backgroundInfo, age, salary, workShift);
    }

    /**
     * Hires a janitor
     *
     * @param name
     * Name of the janitor
     * @param backgroundInfo
     * Background info of the janitor
     * @param age
     * Age of the janitor
     * @param salary
     * Salary of the janitor
     * @param workShift
     * WorkShift of the janitor
     * @param job
     * The specific job that the janitor is responsible for
     */
    public String hireJanitor(String name, String backgroundInfo, int age, int salary, WorkShift workShift, String job) {
        return initializeJanitor(name, backgroundInfo, age, salary, workShift, job);
    }

    /**
     * Fires an employee by setting their status isActive to false
     *
     * @return
     * A String saying which Employee has been fired
     */
    public String fireEmployee() {
        employees[currentlySelected].switchStatus();
        boolean[] validEmployees = Search.searchOnEmployeeStatus(employees, true);
        String message = "Employee " + employees[currentlySelected].getName() + " has been fired";
        for (int i = 0; i < validEmployees.length; i++) {
            if (validEmployees[i]) {
                currentlySelected = i;
                i = validEmployees.length;
            }
        }
        Search.resetArray();
        return message;
    }
    /**
     * Sets the current employee based on the name provided
     *
     * @param name
     * The name of the employee being set as the current employee
     */
    public void setSelectedEmployee(String name) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getName().equals(name)) {
                currentlySelected = i;
            }
        }
    }
    /**
     * Gets the type of the employee
     * @param employee
     * the employee whose type is needed
     * @return
     * A String specifying the type of the employee
     */
    public String getEmployeeType(Employee employee) {
        if (employee instanceof Chef) {
            return "Chef";
        }
        else if(employee instanceof Janitor) {
            return "Janitor";
        }
        else {
            return "Waiter";
        }
    }

    /**
     * Gets the name of the current employee selected
     * @return
     * A string with the name
     */
    public String getCurrentEmployeeName() {
        if (employees[currentlySelected] != null) {
            return employees[currentlySelected].getName();
        }
        return "No current employee";
    }
    /**
     * Returns both the employee type and name
     *
     * @return
     * A string with the employee type and name separated by a colon.
     */
    public String getCurrentEmployeeNameAndType() {
        if (employees[currentlySelected] != null) {
            if (employees[currentlySelected] instanceof Chef) {
                return "Chef: " + employees[currentlySelected].getName();
            } else if (employees[currentlySelected] instanceof Janitor) {
                return "Janitor: " + employees[currentlySelected].getName();
            } else {
                return "Waiter: " + employees[currentlySelected].getName();
            }
        }
        return "No Employee Found";
    }

    /**
     * Gets the list of the employees
     * @return
     * A string with the list of the employees
     */
    public String getEmployeeList() {
        String employeeList = "";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employeeList =  getEmployeeType(employees[i]) + ": " + employees[i].getName() + "; is Employee Active: " + employees[i].getStatus() + "\n" + employeeList;
            }
        }
        return employeeList;
    }

    /**
     * Pays an employee their salary
     * @return
     * a string saying which employee was paid and how much
     */
    public String payEmployee() {
        NumberFormat money = NumberFormat.getCurrencyInstance();
        if (employees[currentlySelected].getStatus()) {
            return employees[currentlySelected].getName() + " has been paid their monthly salary of " + money.format(employees[currentlySelected].getSalary());
        }
        else {
            return employees[currentlySelected].getName() + " is terminated. They cannot be paid";
        }
    }

    /**
     * Gets the total payroll
     * @return
     * an int for the total payroll
     */
    public int getPayroll() {
        int totalPayroll = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getStatus()) {
                totalPayroll += employees[i].getSalary();
            }
        }
        return totalPayroll;
    }

    /**
     * Checks if a certain employee exists
     * @param name
     * The name of the employee being searched for
     * @return
     * True if the employee exists
     * false if it does not
     */
    public boolean hasEmployee(String name) {
        boolean[] validEmployees = Search.searchOnName(employees, name);
        for (int i = 0; i < validEmployees.length; i++) {
            if (validEmployees[i]) {
                currentlySelected = i;
                return validEmployees[i];
            }
        }
        Search.resetArray();
        return false;
    }

    /**
     * Sets the data of an employees
     * @param name
     * The name of the employee
     * @param backgroundInfo
     * the background info of the employee
     * @param age
     * the age of the employee
     * @param salary
     * the salary of the employee
     * @param workShift
     * the WorkShift of the employee
     */
    public void setData(String name, String backgroundInfo, int age, int salary, WorkShift workShift) {
        employees[currentlySelected].setName(name);
        employees[currentlySelected].setBackgroundInfo(backgroundInfo);
        employees[currentlySelected].setAge(age);
        employees[currentlySelected].setSalary(salary);
        employees[currentlySelected].setWorkShift(workShift);
    }

    /**
     * Finds which employees are valid after they have been searched for
     * @param validEmployees
     * The array with true or false specifying which employees are valid based on the search criteria
     * @return
     * A string with the list of employees that are valid
     */
    public String findValidEmployees(boolean[] validEmployees) {
        String strValidEmployees = "";
        for (int i = 0; i < validEmployees.length; i++) {
            if (validEmployees[i]) {
                strValidEmployees = getEmployeeType(employees[i]) + ": " + employees[i].getName() + "\n" + strValidEmployees;
            }
        }
        return strValidEmployees;
    }

    /**
     * Gets the employee toString
     * @return
     * A string with all the employee info
     */
    public String getCurrentEmployeeInfo() {
        return employees[currentlySelected].toString();
    }
    /**
     * Searches for all the employees that have the provided name
     * @param name
     * The name being searched for
     * @return
     * A string with all the valid employees
     */
    public String searchName(String name) {
        boolean[] validEmployees = Search.searchOnName(employees, name);
        String strValidEmployees = findValidEmployees(validEmployees);
        Search.resetArray();
        return strValidEmployees;
    }

    /**
     * Searches for all the employees that have the provided background info
     * @param bgInfo
     * The background info being searched for
     * @return
     * A string with all the valid employees
     */
    public String searchBgInfo(String bgInfo) {
        boolean[] validEmployees = Search.searchOnBackgroundInfo(employees, bgInfo);
        String strValidEmployees = findValidEmployees(validEmployees);
        Search.resetArray();
        return strValidEmployees;
    }

    /**
     * Searches for all the employees that have the provided age
     * @param age
     * Thea ge being searched for
     * @return
     * A string with all the valid employees
     */
    public String searchAge(int age) {
        boolean[] validEmployees = Search.searchOnAge(employees, age);
        String strValidEmployees = findValidEmployees(validEmployees);
        Search.resetArray();
        return strValidEmployees;
    }
    /**
     * Searches for all the employees that come in the range of the provided salary
     * @param salary
     * The salary provided
     * @param salaryComparison
     * The range of the salary
     * @return
     * A string with all the valid employees
     */
    public String searchSalary(int salary, char salaryComparison) {
        boolean[] validEmployees = Search.searchOnSalary(employees, salary, salaryComparison);
        String strValidEmployees = findValidEmployees(validEmployees);
        Search.resetArray();
        return strValidEmployees;
    }

    /**
     * Searches for all the employees with the provided workshift
     * @param workShift
     * The workshift provided
     * @return
     * A string with all the valid employees
     */
    public String searchWorkShift(WorkShift workShift) {
        boolean[] validEmployees = Search.searchOnWorkShift(employees, workShift);
        String strValidEmployees = findValidEmployees(validEmployees);
        Search.resetArray();
        return strValidEmployees;
    }

    /**
     * Searches for all the employees with the job type provided
     * @param job
     * The job type provided
     * @return
     * A string with all the valid employees
     */
    public String searchJob(String job) {
        boolean[] validEmployees = Search.searchOnJobType(employees, job);
        String strValidEmployees = findValidEmployees(validEmployees);
        Search.resetArray();
        return strValidEmployees;
    }

    /**
     * Searches for all the employees with the status provided
     * @param status
     * The status provided
     * @return
     * A string with all the valid employees
     */
    public String searchStatus(boolean status) {
        boolean[] validEmployees = Search.searchOnEmployeeStatus(employees, status);
        String strValidEmployees = findValidEmployees(validEmployees);
        Search.resetArray();
        return strValidEmployees;
    }

    /**
     * searches for all the Chefs that have the specialty provided
     * @param specialty
     * the specialty provided
     * @return
     * A string with all the valid chefs
     */
    public String searchChefSpecialty(String specialty) {
        boolean[] validEmployees = Search.searchOnChefFoodSpecialty(employees, specialty);
        String strValidEmployees = findValidEmployees(validEmployees);
        Search.resetArray();
        return strValidEmployees;
    }

    /**
     * Searches for all the Janitors with the specific job provided
     * @param job
     * the job provided
     * @return
     * A string with all the valid janitors
     */
    public String searchJanitorJob(String job) {
        boolean[] validEmployees = Search.searchOnJanitorJobType(employees, job);
        String strValidEmployees = findValidEmployees(validEmployees);
        Search.resetArray();
        return strValidEmployees;
    }
    /**
     * Gets the employee count for a specific job type
     * @param jobType
     * The job type
     * @return
     * An int with the count of that employee
     */
    public int getEmployeeCount(String jobType) {
        boolean[] validEmployees = Search.searchOnJobType(employees, jobType);
        int employeeCount = 0;
        for (int i = 0; i < validEmployees.length; i++) {
            if (validEmployees[i]) {
                employeeCount++;
            }
        }
        Search.resetArray();
        return employeeCount;
    }

    /**
     * returns a string with all the information about the Restaurant
     * @return
     * A string
     */
    public String toString() {
        return "Restaurant Name: " + restaurantName + "\nRestaurant Stars: " + restaurantStars + " stars" + "\nEmployee Count: " +
                totalEmployeeCount + "\n\t1. Waiter Count: " + getEmployeeCount("Waiter") + "\n\t2. Janitor Count: " + getEmployeeCount("Janitor")
                + "\n\t3. Chef Count: " + getEmployeeCount("Chef");
    }
}
