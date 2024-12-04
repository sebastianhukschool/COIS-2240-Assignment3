import java.util.Scanner;

public class LibraryManagement {

    private Library library = new Library();
    private Transaction transaction = Transaction.getTransaction();  // Singleton instance of Transaction

    public static void main(String[] args) {
        new LibraryManagement().run();  // Start the program
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);  // Create Scanner object
        boolean running = true;

        while (running) {
            System.out.println("===========================");
            System.out.println("Library Management System");
            System.out.println("1. Add Member");
            System.out.println("2. Add Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Borrowed Books");
            System.out.println("6. View Transaction History");
            System.out.println("7. Exit");
            System.out.println("===========================");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // Add member logic
                    System.out.print("Enter member ID: ");
                    int memberId = scanner.nextInt();
                    System.out.print("Enter member name: ");
                    String memberName = scanner.next();
                    scanner.nextLine();
                    addMember(memberId, memberName);
                    break;
                case 2:
                    System.out.print("Enter book ID: ");
                    int bookId = scanner.nextInt();
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.next();
                    scanner.nextLine();

                    try {
                        Book newBook = new Book(bookId, bookTitle);
                        library.addBook(newBook);  // Add book to the library
                        System.out.println("Book added to library successfully.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    // Borrow book logic...
                    break;
                case 4:
                    // Return book logic...
                    break;
                case 5:
                    // View borrowed books logic...
                    break;
                case 6:
                    // View transaction history logic...
                    break;
                case 7:
                    System.out.println("Exiting. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        // Close scanner to release resource
        scanner.close();
    }

    // Add Member method (existing logic)
    private boolean addMember(int id, String name) {
        if (library.findMemberById(id) != null) {
            System.out.println("Member with ID " + id + " already exists.");
            return false;
        }
        Member newMember = new Member(id, name);
        library.addMember(newMember);
        return true;
    }
}