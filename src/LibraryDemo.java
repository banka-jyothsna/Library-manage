
import java.util.*;

public class LibraryDemo {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        System.out.print("How many books do you want to add? ");

        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details for Book " + i + ":");
            System.out.print("Enter Book ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Book Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            LibraryClass book = new LibraryClass(id, title, author);
            library.addItem(book);
        }
        library.displayAllItems();
        System.out.println("\n--- Borrowing a Book ---");
        System.out.print("Enter Book ID to borrow: ");
        String borrowId = sc.nextLine();
        System.out.print("Enter your name: ");
        String user = sc.nextLine();

        LibraryItem borrowItem = library.findItemById(borrowId);
        if (borrowItem != null && borrowItem instanceof Borrowable) {
            try {
                ((Borrowable) borrowItem).borrowItem(user);
            } catch (BookNotAvailable e) {
                System.out.println("Exception: " + e.getMessage());
            }
        } else {
            System.out.println("Book not found!");
        }

        // Step 4: Try borrowing the same book again (exception)
        System.out.println("\n--- Trying to Borrow Already Borrowed Book ---");
        try {
            ((Borrowable) borrowItem).borrowItem(user);
        } catch (BookNotAvailable e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Step 5: Returning the book
        System.out.println("\n--- Returning a Book ---");
        System.out.print("Enter Book ID to return: ");
        String returnId = sc.nextLine();
        System.out.print("Enter your name: ");
        String returnUser = sc.nextLine();

        LibraryItem returnItem = library.findItemById(returnId);
        if (returnItem != null && returnItem instanceof Borrowable) {
            try {
                ((Borrowable) returnItem).returnItem(returnUser);
            } catch (InvalidReturnException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        } else {
            System.out.println("Book not found!");
        }


        System.out.println("\nBooks After Operations...");
        library.displayAllItems();


        library.displayAllAvailableItems();

        sc.close();
    }


}
