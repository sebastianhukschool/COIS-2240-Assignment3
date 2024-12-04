import static org.junit.Assert.*;
import org.junit.Test;

public class LibraryManagementTest {

    @Test
    public void testBorrowBook() throws Exception {
        Book book = new Book(101, "Programming");
        Member member = new Member(1, "George");

        // Before borrowing, the book should be available
        assertTrue(book.isAvailable());

        // Borrow the book
        Transaction transaction = Transaction.getTransaction();
        assertTrue(transaction.borrowBook(book, member));

        // After borrowing, the book should be unavailable
        assertFalse(book.isAvailable());
    }

    @Test
    public void testBorrowAlreadyBorrowedBook() throws Exception {
        Book book = new Book(102, "AI");
        Member member1 = new Member(2, "Anne");
        Member member2 = new Member(3, "John");

        // Borrow the book with the first member
        Transaction transaction = Transaction.getTransaction();
        assertTrue(transaction.borrowBook(book, member1));

        // Attempt to borrow the same book with a second member
        assertFalse(transaction.borrowBook(book, member2));  // Should return false
    }

    @Test
    public void testReturnBook() throws Exception {
        Book book = new Book(103, "Math");
        Member member = new Member(4, "Alice");

        // Borrow the book
        Transaction transaction = Transaction.getTransaction();
        transaction.borrowBook(book, member);

        // Return the book
        transaction.returnBook(book, member);

        // After returning, the book should be available
        assertTrue(book.isAvailable());
    }

    @Test
    public void testReturnBookNotBorrowed() throws Exception {
        Book book = new Book(104, "Science");
        Member member = new Member(5, "Bob");

        Transaction transaction = Transaction.getTransaction();

        // Attempt to return a book that was never borrowed
        try {
            transaction.returnBook(book, member);
            fail("Should have thrown an IllegalStateException for returning a book not borrowed.");
        } catch (IllegalStateException e) {
            assertEquals("The book was not borrowed.", e.getMessage());
        }
    }
}