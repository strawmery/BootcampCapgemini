package cap.maria.catalogo.ExceptionsTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import cap.maria.catalogo.Exceptions.DuplicateKeyException;

public class DuplicateKeyExceptionTest {

    @Test
    public void testDefaultConstructor() {
        DuplicateKeyException exception = new DuplicateKeyException();
        assertEquals("Duplicate key", exception.getMessage());
    }

    @Test
    public void testConstructorWithMessage() {
        String message = "Custom message";
        DuplicateKeyException exception = new DuplicateKeyException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void testConstructorWithCause() {
        Throwable cause = new Throwable("Cause of the exception");
        DuplicateKeyException exception = new DuplicateKeyException(cause);
        assertEquals("Duplicate key", exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    public void testConstructorWithMessageAndCause() {
        String message = "Custom message";
        Throwable cause = new Throwable("Cause of the exception");
        DuplicateKeyException exception = new DuplicateKeyException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    public void testConstructorWithAllParameters() {
        String message = "Custom message";
        Throwable cause = new Throwable("Cause of the exception");
        DuplicateKeyException exception = new DuplicateKeyException(message, cause, true, true);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertTrue(exception.getSuppressed().length == 0);
        assertTrue(exception.getStackTrace().length > 0);
    }
}