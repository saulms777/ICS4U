import java.util.Scanner;

class Ex3_5Words {
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] words = new String[5];
            for (int i = 0; i < 5; i++) {
                System.out.print("Enter a word: ");
                words[i] = sc.nextLine();
            }
            System.out.println(mostChars(words));
            System.out.println(leastChars(words));
            System.out.println(alphabetic(words));
        }
    }

    private static String mostChars(String[] words) {
        String longest = words[0];
        for (String word : words) {
            if (word.toCharArray().length > longest.toCharArray().length) longest = word;
        }
        return longest;
    }

    private static String leastChars(String[] words) {
        String shortest = words[0];
        for (String word : words) {
            if (word.toCharArray().length < shortest.toCharArray().length) shortest = word;
        }
        return shortest;
    }

    private static String alphabetic(String[] words) {
        String first = words[0];
        for (String word : words) {
            if (word.compareToIgnoreCase(first) < 0) first = word;
        }
        return first;
    }

}
