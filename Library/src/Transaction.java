import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Transaction {

    // Singleton instance
    private static Transaction instance;

    // Private constructor to prevent instantiation
    private Transaction() {
    }

    // Get the Singleton instance
    public static Transaction getTransaction() {
        if (instance == null) {
            instance = new Transaction();
        }
        return instance;
    }

    // Borrow book method (now an instance method, not static)
    public boolean borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.borrowBook();
            member.borrowBook(book);
            String transactionDetails = getCurrentDateTime() + " - Borrowing: " + member.getName() + " borrowed " + book.getTitle();
            System.out.println(transactionDetails);
            saveTransaction(transactionDetails); // Save transaction to file
            return true;
        } else {
            System.out.println("The book is not available.");
            return false;
        }
    }

    // Return book method (now an instance method, not static)
    public void returnBook(Book book, Member member) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.returnBook();
            String transactionDetails = getCurrentDateTime() + " - Returning: " + member.getName() + " returned " + book.getTitle();
            System.out.println(transactionDetails);
            saveTransaction(transactionDetails); // Save transaction to file
        } else {
            System.out.println("This book was not borrowed by the member.");
        }
    }

    // Utility method to get current date and time
    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    // Method to save transaction details to a file
    private void saveTransaction(String transactionDetails) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt", true))) {
            writer.write(transactionDetails);
            writer.newLine();  // Write a new line after each transaction
        } catch (IOException e) {
            System.out.println("Failed to save transaction: " + e.getMessage());
        }
    }

    // Method to display transaction history (we will implement file reading in Step 2.3)
    public void displayTransactionHistory() {
        System.out.println("Displaying transaction history...");
        // For now, this will just show a placeholder message
    }
}