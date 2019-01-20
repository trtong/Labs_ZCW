package com.zipcodewilmington.froilansfarm.BuildingTests;

import com.zipcodewilmington.froilansfarm.Animal.Horse;
import com.zipcodewilmington.froilansfarm.Buildings.Stable;
import org.junit.Assert;
import org.junit.Test;

public class StableTest {
    Stable testStable;

    public StableTest() {
        testStable = new Stable();

    }

    @Test
    public void testAddHorses() {

        for (int i = 0; i < 2; i++) {
            testStable.store(new Horse());
        }

        Assert.assertEquals(2, testStable.howManyHorses());
    }
}
