import static org.junit.Assert.*;
import org.junit.Test;

public class LibraryManagementTest {

    // Test for valid book IDs
    @Test
    public void testValidBookIds() {
        try {
            Book validBook1 = new Book(100, "Programming");
            Book validBook2 = new Book(999, "AI");
            assertNotNull(validBook1);
            assertNotNull(validBook2);
        } catch (Exception e) {
            fail("Valid book IDs should not throw an exception");
        }
    }

    // Test for invalid book IDs
    @Test
    public void testInvalidBookIds() {
        try {
            new Book(99, "Math");
            fail("Exception should have been thrown for invalid book ID");
        } catch (Exception e) {
            assertEquals("Invalid book ID. ID must be between 100 and 999.", e.getMessage());
        }

        try {
            new Book(1000, "Science");
            fail("Exception should have been thrown for invalid book ID");
        } catch (Exception e) {
            assertEquals("Invalid book ID. ID must be between 100 and 999.", e.getMessage());
        }
    }
}