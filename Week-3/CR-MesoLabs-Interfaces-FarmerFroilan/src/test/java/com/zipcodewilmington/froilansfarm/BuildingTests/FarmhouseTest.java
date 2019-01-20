package com.zipcodewilmington.froilansfarm.BuildingTests;

import com.zipcodewilmington.froilansfarm.Buildings.Farmhouse;
import com.zipcodewilmington.froilansfarm.Person.Farmer;
import com.zipcodewilmington.froilansfarm.Person.Person;
import org.junit.Assert;
import org.junit.Test;

public class FarmhouseTest {

    Farmhouse testHouse;
    Farmer froilan;

    public FarmhouseTest() {
        testHouse = new Farmhouse();
        froilan = new Farmer("Rahh", false, true);

    }

    @Test
    public void testAddPeople() {

        testHouse.store(froilan);

        Assert.assertEquals(1, testHouse.howManyPeople());
    }
}
