package cap.maria.catalogo.ExceptionsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cap.maria.catalogo.Exceptions.BadRequestException;

public class BadRequestExceptionTest {

    @Test
    public void testConstructorWithMessage(){
        String message = "This is a message";

        BadRequestException exception = new BadRequestException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void testConstrutorWithMessageAndCause(){
        String message = "This is a message";
        Throwable cause = new Throwable("Cause of Exception");
        BadRequestException exception = new BadRequestException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test 
    public void testConstructorWithAllParameters(){
        String message ="This is a message";
        Throwable cause = new Throwable("Cause of Exception");
        BadRequestException exception = new BadRequestException(message, cause, true, true);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertTrue(exception.getSuppressed().length == 0);
        assertTrue(exception.getStackTrace().length > 0);
    }

}
