package cap.maria.catalogo.ExceptionsTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import cap.maria.catalogo.Exceptions.InvalidDataException;

import java.util.HashMap;
import java.util.Map;

public class InvalidDataExceptionTest {

    @Test
    public void testDefaultConstructor() {
        InvalidDataException exception = new InvalidDataException();
        assertEquals("Invalid data", exception.getMessage());
        assertFalse(exception.hasErrors());
    }

    @Test
    public void testConstructorWithMessage() {
        String message = "Custom message";
        InvalidDataException exception = new InvalidDataException(message);
        assertEquals(message, exception.getMessage());
        assertFalse(exception.hasErrors());
    }

    @Test
    public void testConstructorWithErrors() {
        Map<String, String> errors = new HashMap<>();
        errors.put("field1", "error1");
        InvalidDataException exception = new InvalidDataException(errors);
        assertEquals("Invalid data", exception.getMessage());
        assertTrue(exception.hasErrors());
        assertEquals(errors, exception.getErrors());
    }

    @Test
    public void testConstructorWithMessageAndErrors() {
        String message = "Custom message";
        Map<String, String> errors = new HashMap<>();
        errors.put("field1", "error1");
        InvalidDataException exception = new InvalidDataException(message, errors);
        assertEquals(message, exception.getMessage());
        assertTrue(exception.hasErrors());
        assertEquals(errors, exception.getErrors());
    }

    @Test
    public void testConstructorWithCause() {
        Throwable cause = new Throwable("Cause of the exception");
        InvalidDataException exception = new InvalidDataException(cause);
        assertEquals("Invalid data", exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertFalse(exception.hasErrors());
    }

    @Test
    public void testConstructorWithMessageAndCause() {
        String message = "Custom message";
        Throwable cause = new Throwable("Cause of the exception");
        InvalidDataException exception = new InvalidDataException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertFalse(exception.hasErrors());
    }

    @Test
    public void testConstructorWithMessageCauseAndErrors() {
        String message = "Custom message";
        Throwable cause = new Throwable("Cause of the exception");
        Map<String, String> errors = new HashMap<>();
        errors.put("field1", "error1");
        InvalidDataException exception = new InvalidDataException(message, cause, errors);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertTrue(exception.hasErrors());
        assertEquals(errors, exception.getErrors());
    }

    @Test
    public void testConstructorWithAllParameters() {
        String message = "Custom message";
        Throwable cause = new Throwable("Cause of the exception");
        Map<String, String> errors = new HashMap<>();
        errors.put("field1", "error1");
        InvalidDataException exception = new InvalidDataException(message, cause, errors, true, true);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertTrue(exception.hasErrors());
        assertEquals(errors, exception.getErrors());
        assertTrue(exception.getSuppressed().length == 0);
        assertTrue(exception.getStackTrace().length > 0);
    }
}
