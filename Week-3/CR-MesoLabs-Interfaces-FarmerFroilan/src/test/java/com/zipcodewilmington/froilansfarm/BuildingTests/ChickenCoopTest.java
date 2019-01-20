package com.zipcodewilmington.froilansfarm.BuildingTests;

import com.zipcodewilmington.froilansfarm.Animal.Chicken;
import com.zipcodewilmington.froilansfarm.Buildings.ChickenCoop;
import org.junit.Assert;
import org.junit.Test;

public class ChickenCoopTest {
    ChickenCoop testCoop;

    public ChickenCoopTest() {
        testCoop =  new ChickenCoop();
    }


    @Test
    public void testStore() {
        for (int i = 0; i < 4; i++) {
            testCoop.store(new Chicken());
        }

        Assert.assertEquals(4, testCoop.howManyChickens());

    }
}
