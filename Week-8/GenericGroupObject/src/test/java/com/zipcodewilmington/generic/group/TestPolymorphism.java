package com.zipcodewilmington.generic.group;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author leon on 05/12/2018.
 */
public class TestPolymorphism {
    @Test
    public void testImplementation() {
        Assert.assertTrue(new Group<>() instanceof GroupInterface);
    }
}
