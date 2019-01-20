package com.zipcodewilmington.froilansfarm.AnimalTests;

import com.zipcodewilmington.froilansfarm.Animal.Chicken;
import com.zipcodewilmington.froilansfarm.Buildings.Silo;
import com.zipcodewilmington.froilansfarm.Crops.Egg;
import org.junit.Assert;
import org.junit.Test;

public class ChickenTest {
    Chicken testChicken;
    Egg testEgg;
//    Silo testSilo;


    public ChickenTest() {
        testChicken = new Chicken();
        testEgg = testChicken.yield();
//        testSilo = new Silo();
    }

    @Test
    public void testMakeNoise() {
        String expected = "cluck";

        String actual = testChicken.makeNoise();

        Assert.assertEquals(expected,actual);
    }



}
