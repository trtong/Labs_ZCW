package io.zipcoder.interfaces;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    Person person1;

    public PersonTest() {
        person1 = new Person(123, "dodo");

    }

    @Test
    public void testConstructor() {

        long expectedId = 123;

        Assert.assertEquals(expectedId, person1.getId());
    }

    @Test
    public void testSetAndGetName() {
        person1.setName("Bob");

        Assert.assertEquals("Bob", person1.getName());
    }

}