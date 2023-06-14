public class Student {

    private String name;
    private int age;
    private final String[] courses;
    private final int[] grades;

    public Student() {
        courses = new String[4];
        grades = new int[4];
    }

    public Student(String name) {
        this();
        this.name = name;
    }

    public Student(String name, int age) {
        this(name);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course, int index) {
        courses[index] = course;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrade(int grade, int index) {
        grades[index] = grade;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Student: " + name + "\nAge" + age + "\nCourse and marks:");
        for (int i = 0; i < 4; i++) str.append("\n").append(courses[i]).append(": ").append(grades[i]);
        return str.toString();
    }

}
