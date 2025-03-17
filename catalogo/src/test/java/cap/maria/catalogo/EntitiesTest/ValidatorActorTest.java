package cap.maria.catalogo.EntitiesTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cap.maria.catalogo.Entities.Actor;

public class ValidatorActorTest {

    private Validator validator;

    @BeforeEach
    public void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidActor(){
        Actor actor = new Actor(1,"John","Doe");
        Set<ConstraintViolation<Actor>> violations = validator.validate(actor);
        assertTrue(violations.isEmpty(),"Actor is valid");
    }

    @Test
    public void testInvalidFirstName() {
        Actor actor = new Actor(1,null,"Doe");
        Set<ConstraintViolation<Actor>> violations = validator.validate(actor);
        assertFalse(violations.isEmpty(),"Actor is invalid");
    }

    @Test
    public void testInvalidLastName() {
        Actor actor = new Actor(1,"jon",null);
        Set<ConstraintViolation<Actor>> violations = validator.validate(actor);
        assertFalse(violations.isEmpty(),"Actor is invalid");
    }

    @Test
    public void testInvalidFirstNameTooLong() {
        Actor actor = new Actor(1,"A".repeat(46),"Doe");
        Set<ConstraintViolation<Actor>> violations = validator.validate(actor);
        assertFalse(violations.isEmpty(),"Actor is invalid");
    }

    @Test
    public void testInvalidLastNameTooLong() {
        Actor actor = new Actor(1,"jon","A".repeat(46));
        Set<ConstraintViolation<Actor>> violations = validator.validate(actor);
        assertFalse(violations.isEmpty(),"Actor is invalid");
    }




}
