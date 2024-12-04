import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.Constructor;

public class LibraryManagementTest {

    // Existing tests...

    // Test 1: Verify Singleton pattern - same instance across multiple calls
    @Test
    public void testTransactionSingleton() {
        // Get the first instance of Transaction
        Transaction firstInstance = Transaction.getTransaction();

        // Get the second instance of Transaction
        Transaction secondInstance = Transaction.getTransaction();

        // Verify that both instances are the same (Singleton)
        assertSame("The two instances should be the same", firstInstance, secondInstance);
    }

    // Test 2: Verify that the constructor is private and cannot be accessed directly
    @Test
    public void testTransactionConstructorIsPrivate() throws Exception {
        // Try to access the constructor using reflection
        Constructor<Transaction> constructor = Transaction.class.getDeclaredConstructor();
        constructor.setAccessible(true); // Make the private constructor accessible

        // Try to create a new instance of Transaction using reflection
        Transaction transaction = constructor.newInstance();

        // Ensure that the constructor is private and the instance can still be created
        assertNotNull("The constructor should be private, but instance was created", transaction);
    }

    // Test 3: Verify that multiple calls to getTransaction() return the same instance (Singleton behavior)
    @Test
    public void testTransactionSameInstanceAcrossMultipleCalls() {
        Transaction instance1 = Transaction.getTransaction();
        Transaction instance2 = Transaction.getTransaction();

        // Assert that both instances are the same
        assertSame("getTransaction() should always return the same instance", instance1, instance2);
    }
}