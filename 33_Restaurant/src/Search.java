/**
 * Name: Hasnain
 * Date: April 27th, 2023
 * Course: ICS4U
 * Description: Search class that allows for the restaurant class to search for all the employees with a specific parameter
 */
import People.Chef;
import People.Employee;
import People.Janitor;
import People.Waiter;
import People.WorkShift;

/**
 * The search class only contains static methods and allows for searching through an employees array and finds all the employees with certain parameters
 */
public final class Search {
    /**
     * The array that tells you whether the employee is valid based on the search parameter
     */
    private static boolean[] validEmployees = new boolean[500];

    /**
     * Searches for where the first null is within the employee array
     * @param employees
     * the array of employees
     * @return
     * The index of the null
     */
    public static int searchForNull(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Searches for all the employees with the provided name
     * @param employees
     * The array of employees
     * @param name
     * The name being searched for
     * @return
     * A boolean array that tells you if the employee is valid or not based on the search parameter
     */
    public static boolean[] searchOnName(Employee[] employees, String name) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getName().equals(name)) {
                validEmployees[i] = true;
            }
        }
        return validEmployees;
    }

    /**
     * Searches for all the employees with the provided age
     * @param employees
     * the array of employees
     * @param age
     * The age being searched for
     * @return
     * A boolean array that tells you if the employee is valid or not based on the search parameter
     */
    public static boolean[] searchOnAge(Employee[] employees, int age) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getAge() == age) {
                validEmployees[i] = true;
            }
        }
        return validEmployees;
    }

    /**
     * Searches for all the employees with the provided salary
     * @param employees
     * The array of employees
     * @param salary
     * The salary provided
     * @return
     * A boolean array that tells you if the employee is valid or not based on the search parameter
     */
    public static boolean[] searchOnSalary(Employee[] employees, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() == salary) {
                validEmployees[i] = true;
            }
        }
        return validEmployees;
    }

    /**
     * Searches for all the employees with the provided salary inside the range
     * @param employees
     * the array of employees
     * @param salary
     * the salary provided
     * @param salaryComparison
     * The range for the salary
     * @return
     * A boolean array that tells you if the employee is valid or not based on the search parameter
     */
    public static boolean[] searchOnSalary(Employee[] employees, int salary, char salaryComparison) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (salaryComparison == '>' && employees[i].getSalary() > salary) {
                    validEmployees[i] = true;
                } else if (salaryComparison == '<' && employees[i].getSalary() < salary) {
                    validEmployees[i] = true;
                } else if (salaryComparison == '=' && employees[i].getSalary() == salary) {
                    validEmployees[i] = true;
                }
            }
        }
        return validEmployees;
    }

    /**
     * Searches for all the employees with the provided background info
     * @param employees
     * the array of employees
     * @param backgroundInfo
     * the provided background info
     * @return
     * A boolean array that tells you if the employee is valid or not based on the search parameter
     */
    public static boolean[] searchOnBackgroundInfo(Employee[] employees, String backgroundInfo) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getBackgroundInfo().equalsIgnoreCase(backgroundInfo)) {
                validEmployees[i] = true;
            }
        }
        return validEmployees;
    }

    /**
     * Searches for all the employees with the provided workshift
     * @param employees
     * the array of employees
     * @param workShift
     * the provided workshift
     * @return
     * A boolean array that tells you if the employee is valid or not based on the search parameter
     */
    public static boolean[] searchOnWorkShift(Employee[] employees, WorkShift workShift) {
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null && employees[i].getWorkShift().equals(workShift)) {
                validEmployees[i] = true;
            }
        }
        return validEmployees;
    }

    /**
     * Searches for all the employees with the provided job type
     * @param employees
     * the array of employees
     * @param jobType
     * the provided job type
     * @return
     * A boolean array that tells you if the employee is valid or not based on the search parameter
     */
    public static boolean[] searchOnJobType(Employee[] employees, String jobType) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (jobType.equalsIgnoreCase("chef") && employees[i] instanceof Chef) {
                    validEmployees[i] = true;
                } else if (jobType.equalsIgnoreCase("janitor") && employees[i] instanceof Janitor) {
                    validEmployees[i] = true;
                } else if (jobType.equalsIgnoreCase("waiter") && employees[i] instanceof Janitor) {
                    validEmployees[i] = true;
                }
            }
        }
        return validEmployees;
    }

    /**
     * searches for all the employees with the provided status
     * @param employees
     * the array of employees
     * @param isActive
     * the provided status
     * @return
     * A boolean array that tells you if the employee is valid or not based on the search parameter
     */
    public static boolean[] searchOnEmployeeStatus(Employee[] employees, boolean isActive) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getStatus() == isActive) {
                validEmployees[i] = true;
            }
        }
        return validEmployees;
    }

    /**
     * Searches for all the employees with the provided janitor job
     * @param employees
     * The array of employees
     * @param job
     * the provided janitor job
     * @return
     * A boolean array that tells you if the employee is valid or not based on the search parameter
     */
    public static boolean[] searchOnJanitorJobType(Employee[] employees, String job) {
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null && employees[i] instanceof Janitor && ((Janitor)employees[i]).getJob().equalsIgnoreCase(job)) {
                validEmployees[i] = true;
            }

        }
        return validEmployees;
    }
    /**
     * Searches for all the employees with the provided food specialty
     * @param employees
     * the array of employees
     * @param specialty
     * The provided food specialty
     * @return
     * A boolean array that tells you if the employee is valid or not based on the search parameter
     */
    public static boolean[] searchOnChefFoodSpecialty(Employee[] employees, String specialty) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i] instanceof Chef && ((Chef)employees[i]).getSpecialty().equalsIgnoreCase(specialty)) {
                validEmployees[i] = true;
            }
        }
        return validEmployees;
    }

    /**
     * Resets the validEmployees array to default
     */
    public static void resetArray() {
        validEmployees = new boolean[validEmployees.length];
    }

}
