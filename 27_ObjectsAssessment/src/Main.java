import java.text.NumberFormat;
import java.util.Scanner;

/*
 * Name: Samuel Zhang
 * Course: ICS4U
 * Description: Objects assessment
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sample book:");
        Book sample = new Book(); // ADD CODE: Create a default book

        sample.setName("Harry Potter"); // ADD CODE: Set the book name to Harry Potter

        // Display the information for the book
        System.out.println(sample);

        // Determines a random number of readers.
        // Up to 1 million people will read the book.
        System.out.print("Number of people read the book: ");
        System.out.println(sample.getReaders());

        // If the number of readers is over 500,000, then return it is popular.
        // Otherwise it is not popular.
        sample.isPopular();
        // If the book is popular, add another 25% on top of the cost
        System.out.println("Cost of the book is " + sample.bookCost());

        System.out.println("\nList of 3 Books:");

        // ADD CODE: Create array of 3 books where the user needs to fill
        // the name and the year published
        Book[] bookList = new Book[3];
        for (int i = 0; i < bookList.length; i++) {
            System.out.println("Book " + (i + 1) + ":");
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter year: ");
            int year = sc.nextInt();
            sc.nextLine();
            bookList[i] = new Book(name, year);
        }

        // ADD CODE: Display the information on each book
        System.out.print("\nYour Book List:");
        for (int i = 0; i < bookList.length; i++) {
            System.out.println("\nBook " + (i + 1) + ":");
            System.out.println(bookList[i]);
            System.out.println("Cost of the book is " + bookList[i].bookCost());
        }

        // ADD CODE: where appropriate write the code to make
        // the totalCost(work)
        System.out.println("-------------------------------");
        System.out.println("Total cost of all books: " + totalOrderCost(bookList));

    }

    /**
     * Finds the total cost of an array of books and returns it in money format
     *
     * @param bookList Array of Books
     * @return Money formatted String of the total cost
     */
    public static String totalOrderCost(Book[] bookList) {
        double total = 0;
        for (int i = 0; i < bookList.length; i++) total += bookList[i].getCost();
        return NumberFormat.getCurrencyInstance().format(total);
    }

}
