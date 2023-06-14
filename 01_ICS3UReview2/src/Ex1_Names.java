import java.util.Scanner;
import java.util.Random;

class Ex1_Names {

    public static void main(String[] args) {
        String[] names = inputNames();
        for (int i = 0; i < names.length; i++) {
            names[i] = capitalize(names[i]);
        }
        printNames(names);
    }

    private static String[] inputNames() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Number of names: ");
            int length = sc.nextInt();
            sc.nextLine();

            String[] names = new String[length];
            for (int i = 0; i < length; i++) {
                System.out.print("Name: ");
                names[i] = sc.nextLine();
            }

            return names;
        }
    }

    private static String capitalize(String name) {
        String[] words = name.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
        }
        return String.join(" ", words);
    }

    private static void printNames(String[] names) {
        Random r = new Random();
        String[] sentences = {"_ is a good student", "_ is a decent student", "_ is a bad student"};
        for (String name : names) {
            System.out.println(sentences[r.nextInt(3)].replace("_", name));
        }
    }

}
