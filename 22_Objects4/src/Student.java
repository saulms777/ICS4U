public class Student {

    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student: " + name + "\nAge: " + age;
    }

}

class StudentMain {

    public static void main(String[] args) {
        Student[] students = new Student[10];
        for (int i = 0; i < 10; i++) {
            String name = utils.inputLine("Name of student: ");
            int age = utils.inputInt("Age of student: ");
            students[i] = new Student(name, age);
        }
        for (Student s : students) System.out.println(s);
    }

}
