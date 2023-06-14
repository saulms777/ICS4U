import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        int choice;
        while ((choice = Input.nextInt("""
                Options:
                1. Create empty list
                2. Create list with initial items
                3. Add item to front
                4. Add item to end
                5. Remove specific item
                6. Clear list
                7. Check if list empty
                8. List size
                9. Display list
                0. Exit
                
                Choice:\s""")) != 0) {
            switch (choice) {
                case 1 -> {}
                case 2 -> list = new LinkedList<>(
                        Input.nextLine("Enter initial items separated by (, ): ")
                                .split(", ")
                );
                case 3 -> list.addFirst(
                        Input.nextLine("Item to add: ")
                );
                case 4 -> list.add(
                        Input.nextLine("Item to add: ")
                );
                case 5 -> list.remove(
                        Input.nextLine("Item to remove: ")
                );
                case 6 -> list.clear();
                case 7 -> System.out.println(list.isEmpty() ? "Empty" : "Not empty");
                case 8 -> System.out.println("Size: " + list.size());
                case 9 -> System.out.println("List: " + list);
            }
        }
    }

}
