package cap.maria.catalogo.ExceptionsTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import cap.maria.catalogo.Exceptions.NotFoundException;

public class NotFoundExceptionTest {

    @Test
    public void testDefaultConstructor() {
        NotFoundException exception = new NotFoundException();
        assertEquals("Not found", exception.getMessage());
    }

    @Test
    public void testConstructorWithMessage() {
        String message = "Custom message";
        NotFoundException exception = new NotFoundException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void testConstructorWithCause() {
        Throwable cause = new Throwable("Cause of the exception");
        NotFoundException exception = new NotFoundException(cause);
        assertEquals("Not found", exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    public void testConstructorWithMessageAndCause() {
        String message = "Custom message";
        Throwable cause = new Throwable("Cause of the exception");
        NotFoundException exception = new NotFoundException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    public void testConstructorWithAllParameters() {
        String message = "Custom message";
        Throwable cause = new Throwable("Cause of the exception");
        NotFoundException exception = new NotFoundException(message, cause, true, true);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertTrue(exception.getSuppressed().length == 0);
        assertTrue(exception.getStackTrace().length > 0);
    }
}