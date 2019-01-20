package com.zipcodewilmington.froilansfarm.VehicleTests;

import com.zipcodewilmington.froilansfarm.Crops.Cornstalk;
import com.zipcodewilmington.froilansfarm.Crops.CropRow;
import com.zipcodewilmington.froilansfarm.Crops.Field;
import com.zipcodewilmington.froilansfarm.Vehicles.Tractor;
import org.junit.Assert;
import org.junit.Test;

public class TractorTest {

    private Tractor testTractor;
    private Field testField;
    private CropRow<Cornstalk> testRow;


    public TractorTest() {
        testTractor = new Tractor("Beep");
        testField = new Field();
        testRow = new CropRow<>();

        // Adds 2 crops to the row

        testRow.addCrop(new Cornstalk(), 2);

        for (Cornstalk cs: testRow.getRow()) {
            cs.setFertilized(true);
        }

    }

    @Test
    public void testMakeNoise() {
        Assert.assertEquals("Beep", testTractor.makeNoise());
    }

    // Test harvesting
    @Test
    public void testHarvesting() {
        for (Cornstalk cs: testRow.getRow()) {
            testTractor.harvests(cs);
            Assert.assertTrue(cs.getHarvested());
        }
    }

    // Once fertlized & harvested == true, add to silo
}
