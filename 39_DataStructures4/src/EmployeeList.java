import java.util.NoSuchElementException;

public class EmployeeList {

    private Employee youngest;
    private int size = 0;

    public void hireEmployee(String name, String birthdate, String title) {
        if (size == 5) throw new ArrayIndexOutOfBoundsException();

        size++;
        Employee newEmployee = new Employee(name, birthdate, title);
        newEmployee.supervisor = youngest;
        youngest = newEmployee;
    }

    public int supervisorsBetween(String name) {
        int i = 1;
        Employee last = youngest;
        while (last != null && !last.name.equals(name)) {
            last = last.supervisor;
            i++;
        }
        if (last == null) throw new NoSuchElementException();
        return size - i;
    }

    public Employee getYoungest() {
        return youngest;
    }

    private static final class Employee {

        String name;
        String birthdate;
        String title;
        Employee supervisor;

        Employee(String name, String birthdate, String title) {
            this.name = name;
            this.birthdate = birthdate;
            this.title = title;
        }

    }

}
