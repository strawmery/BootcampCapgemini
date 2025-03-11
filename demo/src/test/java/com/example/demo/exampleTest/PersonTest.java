package com.example.demo.exampleTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.example.demo.example.Person;

public class PersonTest {

    @Test
    void createPerson(){
        var person = new Person(1, "Juan");

        assertNotNull(person);
        assertAll("Constructor",
            () -> assertEquals(1, person.id, "id"),
            () -> assertEquals("Juan", person.name, "name"));
        assertEquals(1, person.id);
        assertEquals("Juan", person.name);
    }

    @Test
    void wrongPerson(){
        var person = new Person(1, "juan");

        assertNotNull(person);
        assertNotEquals(2, person.id);
        assertNotEquals("pedro",person.name);
    }

}
