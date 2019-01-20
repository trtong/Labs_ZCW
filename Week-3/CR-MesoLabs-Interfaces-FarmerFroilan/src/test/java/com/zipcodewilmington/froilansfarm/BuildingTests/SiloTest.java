package com.zipcodewilmington.froilansfarm.BuildingTests;

import com.zipcodewilmington.froilansfarm.Buildings.Silo;
import com.zipcodewilmington.froilansfarm.Crops.EarOfCorn;
import com.zipcodewilmington.froilansfarm.Crops.Egg;
import com.zipcodewilmington.froilansfarm.Crops.Tomato;
import org.junit.Assert;
import org.junit.Test;

public class SiloTest {
    private Silo testSilo;
    int howMany;
    int howManyLeft;

    public SiloTest() {
        testSilo = new Silo();
        howMany = 5;
        howManyLeft = 4;

        for (int i = 0; i < howMany; i++) {
            testSilo.store(new EarOfCorn());
            testSilo.store(new Tomato());
            testSilo.store(new Egg());
        }

    }

    @Test
    public void testAddCorn() {
        Assert.assertEquals(howMany, testSilo.howManyCorn());
    }

    @Test
    public void testAddEgg() {
        Assert.assertEquals(howMany, testSilo.howManyEgg());
    }

    @Test
    public void testAddTomato() {
        Assert.assertEquals(howMany, testSilo.howManyTomato());
    }

    @Test
    public void testConsumeCorn() {
        testSilo.consumeCorn();
        Assert.assertEquals(howManyLeft, testSilo.howManyCorn());
    }

    @Test
    public void testConsumeTomato() {
        testSilo.consumeTomato();
        Assert.assertEquals(howManyLeft, testSilo.howManyTomato());
    }

    @Test
    public void testConsumeEgg() {
        testSilo.consumeEgg();
        Assert.assertEquals(howManyLeft, testSilo.howManyEgg());
    }

    @Test
    public void testGetList() {

        Assert.assertEquals(howMany, testSilo.retrieveEdibleCorn().size());
    }
}
