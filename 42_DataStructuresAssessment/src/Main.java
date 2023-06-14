public class Main {

    public static void main(String[] args) {
        BookLinkedList list1 = new BookLinkedList();
        BookLinkedList list2 = new BookLinkedList();
        int choice = -1;

        while (choice != 0) {
            choice = Input.nextInt("""
                    Options:
                    1. Change list
                    2. Insert book
                    3. Find average years
                    4. Compare two lists
                    5. Remove last book
                    6. See list
                    0. Exit
                    Choice:\s""");

            if (choice == 1) {
                BookLinkedList temp = list1;
                list1 = list2;
                list2 = temp;
            } else if (choice == 2) {
                list1.insertInOrder(new Book(
                        Input.nextLine("Name: "),
                        Input.nextInt("Year published: "),
                        Input.nextInt("Cost: ")
                ));
            } else if (choice == 3) {
                System.out.println("Average year of books: " + list1.averageYear());
            } else if (choice == 4) {
                System.out.println("Compared lists: " + list1.compare(list2));
            } else if (choice == 5) {
                list1.removeLast();
            } else if (choice == 6) {
                System.out.println(list1);
            }
        }
    }

}
