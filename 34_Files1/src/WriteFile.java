import java.io.*;

public class WriteFile {

    public static void main(String[] args) {
        Student[] students = {
                new Student("A", 1, 1, "a"),
                new Student("B", 2, 2, "b"),
                new Student("C", 3, 3, "c"),
                new Student("D", 4, 4, "d")
        };

        File f = new File("src/write.txt");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        PrintWriter output;
        try {
            output = new PrintWriter(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 4; i++)
            output.println(
                    students[i].name + ", " + students[i].age + ", " + students[i].studentNum + ", " + students[i].teacher
            );

        output.close();
    }

    private static class Student {

        private final String name;
        private final int age;
        private final int studentNum;
        private final String teacher;

        public Student(String name, int age, int studentNum, String teacher) {
            this.name = name;
            this.age = age;
            this.studentNum = studentNum;
            this.teacher = teacher;
        }

    }

}
