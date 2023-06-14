import java.util.*;

public class MatchingBrackets {

    public static void main(String[] args) {
        String input;
        while (!(input = Input.nextLine("Enter a string: ")).equalsIgnoreCase("exit")) {
            Deque<Integer> stack = new ArrayDeque<>();
            ArrayList<Integer[]> pairs = new ArrayList<>();
            char[] arr = input.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '(')
                    stack.push(i + 1);
                else if (arr[i] == ')')
                    pairs.add(new Integer[]{stack.pop(), i + 1});
            }
            pairs.forEach(pair -> System.out.println("Pairs: " + pair[0] + " " + pair[1]));
        }
    }

}
