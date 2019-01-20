package com.zipcodewilmington.froilansfarm.EdibleTest;

import com.zipcodewilmington.froilansfarm.Crops.Egg;
import org.junit.Assert;
import org.junit.Test;

public class EggTest {
    Egg testEgg;
    // check fertilized
    // check edible


    public EggTest() {
        testEgg = new Egg();
    }

    @Test
    public void testFertilized() {
        testEgg.setFertilized(true);

        Assert.assertTrue(testEgg.getFertilized());
    }

    @Test
    public void testEdible() {

        Assert.assertTrue(testEgg.getEdible());
    }
}
