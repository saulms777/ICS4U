import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // create stack
        IntegerStack stack = new IntegerStack();
        switch (Input.nextInt("""
                Create new stack:
                1. Default stack
                2. Initial values
                3. Set size
                Choice:\s""")) {
            case 1 -> {}
            case 2 -> stack = new IntegerStack(
                    Arrays.stream(
                            Input.nextLine("Enter stack separated by space: ")
                                    .split(" ")).mapToInt(Integer::parseInt).toArray()
            );
            case 3 -> stack = new IntegerStack(
                    Input.nextInt("Size of stack: ")
            );
        }

        int choice;
        while ((choice = Input.nextInt("""
                Options:
                1. Push to stack
                2. Pop off stack
                3. View top value
                4. View stack size
                5. Clear stack
                6. Is stack empty
                7. Is stack full
                0. Exit
                Choice:\s""")) != 0) {
            switch (choice) {
                case 1 -> stack.push(Input.nextInt("Number to push: "));
                case 2 -> System.out.println("Popped number: " + stack.pop());
                case 3 -> System.out.println("Top value: " + stack.top());
                case 4 -> System.out.println("Stack size: " + stack.size());
                case 5 -> stack.clear();
                case 6 -> System.out.println("Stack is " + (stack.isEmpty() ? "empty" : "not empty"));
                case 7 -> System.out.println("Stack is " + (stack.isFull() ? "full" : "not full"));
            }
        }
    }

}
