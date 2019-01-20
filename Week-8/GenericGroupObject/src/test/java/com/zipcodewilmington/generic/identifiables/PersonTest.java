package com.zipcodewilmington.generic.identifiables;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author leon on 06/12/2018.
 */
public class PersonTest {
    Person<String> foo;

    @Before
    public void setUp() throws Exception {
        foo = new Person<>();
        foo.setId("BAR");
    }

    @Test
    public void testImplementation() {
        Assert.assertTrue(foo instanceof IdentifiableInterface);
    }

    @Test
    public void testGetIdentityType() {
        Assert.assertEquals(foo.getIdentityType(), String.class);
    }
}
