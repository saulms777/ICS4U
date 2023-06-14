import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Student student = new Student();

    public static void main(String[] args) {
        boolean loop = true;
        while (loop) {
            System.out.println("-----------------------------------------");
            int input = choices();
            switch (input) {
                case 1 -> setFirstName();
                case 2 -> setLastName();
                case 3 -> setAge();
                case 4 -> setCourses();
                case 5 -> setGrades();
                case 6 -> calcAverage();
                case 7 -> displayInfo();
                case 9 -> loop = false;
            }
        }
        System.out.println("-----------------------------------------");
        System.out.print("Goodbye");
    }

    private static int choices() {
        System.out.print("""
                Enter a number for one of the choices
                1. Enter student's first name
                2. Enter student's last name
                3. Enter student's age
                4. Enter student's course
                5. Enter student's marks
                6. Calculate student's average
                7. Display student's info
                9. Exit
                Enter your choice:\s""");
        return sc.nextInt();
    }

    private static void setFirstName() {
        System.out.print("First name: ");
        student.setName(sc.next() + student.getName().split(" ")[1]);
    }

    private static void setLastName() {
        System.out.print("Last name: ");
        student.setName(student.getName().split(" ")[0] + sc.next());
    }

    private static void setAge() {
        System.out.print("Age: ");
        student.setAge(sc.nextInt());
    }

    private static void setCourses() {
        for (int i = 1; i <= 4; i++) {
            System.out.print("Enter course #" + i + " ");
            student.setCourse(sc.next(), i);
        }
    }

    private static void setGrades() {
        for (int i = 1; i <= 4; i++) {
            System.out.print("Enter grade for course #" + i + " ");
            student.setGrade(sc.nextInt(), i);
        }
    }

    private static void calcAverage() {
        int total = 0;
        for (int n : student.getGrades()) total += n;
        System.out.println("Average: " + total / 4.0);
    }

    private static void displayInfo() {
        System.out.println(student);
    }

}
