import java.util.*;

public class ReverseList {

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();

        int input;
        while ((input = Input.nextInt("Enter a number (0 to quit): ")) != 0)
            stack.push(input);

        System.out.println("The list in reverse is: " + stack.stream().toList());
    }

}
