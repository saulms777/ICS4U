import java.util.Scanner;

class Ex4_CenterValue {
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String name = sc.nextLine();
            System.out.println(capitalize(name));
            System.out.println(middle(name));
            System.out.println(switchChars(name));
        }
    }

    private static String capitalize(String name) {
        String capitalized = "";
        for (String word : name.split(" ")) {
            capitalized += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
        }
        return capitalized;
    }

    private static String middle(String name) {
        int len = name.length();
        if (len % 2 == 1) return name.substring(len / 2, len / 2 + 1);
        else return name.substring(len / 2 - 1, len / 2 + 1);
    }

    private static String switchChars(String name) {
        int secondIndex = name.indexOf(" ") + 1;
        return name.substring(secondIndex, secondIndex + 1) + name.substring(1, secondIndex) + name.substring(0, 1) + name.substring(secondIndex + 1);
    }

}