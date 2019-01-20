package com.zipcodewilmington.froilansfarm.AnimalTests;

import com.zipcodewilmington.froilansfarm.Animal.Horse;
import org.junit.Assert;
import org.junit.Test;

public class HorseTest {
    Horse testHorse;
    public HorseTest() {
        testHorse = new Horse();
    }

    // Horse has to be tested for make noise
    // eats?
    // Sets ridden


    @Test
    public void testMakeNoise() {
        Assert.assertEquals("neigh", testHorse.makeNoise());
    }


    @Test
    public void testSetRidden() {
        testHorse.setMounted(true);
        testHorse.setDismounted(true);

        testHorse.setRidden();

        Assert.assertTrue(testHorse.isRidden());
    }


}
