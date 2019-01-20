package com.zipcodewilmington.froilansfarm.PersonTests;

import com.zipcodewilmington.froilansfarm.Animal.Horse;
import com.zipcodewilmington.froilansfarm.Person.Farmer;
import org.junit.Assert;
import org.junit.Test;

public class FarmerTest {
    private Farmer testFarmer;
    private Horse testHorse;

    public FarmerTest() {
        testFarmer = new Farmer("Get off my lawn", false, true);
        testHorse = new Horse();
    }

    @Test
    public void testMakeNoise() {
        Assert.assertEquals("Get off my lawn", testFarmer.makeNoise());
    }

    @Test
    public void testPilots() {
        testFarmer.setPilots(true);
        Assert.assertTrue(testFarmer.getPilots());
    }

    @Test
    public void testPlants() {
        testFarmer.setPlants(true);
        Assert.assertTrue(testFarmer.getPlants());
    }

    @Test
    public void testDrivesTractor() {
        testFarmer.setDrivesTractor(false);

        Assert.assertFalse(testFarmer.getDrivesTractor());
    }

    @Test
    public void testHorseRidingSuccess() {
        // Want to mount the horse & dismount
        testFarmer.mount(testHorse);
        testFarmer.dismount(testHorse);
        testHorse.setRidden();

        Assert.assertTrue(testHorse.isRidden());
    }

    @Test
    public void testHorseRidingFail() {
        testFarmer.mount(testHorse);

        testHorse.setRidden();

        Assert.assertFalse(testHorse.isRidden());


    }
}
