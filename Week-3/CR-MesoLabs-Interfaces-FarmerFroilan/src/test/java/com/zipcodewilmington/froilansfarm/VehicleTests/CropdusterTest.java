package com.zipcodewilmington.froilansfarm.VehicleTests;

import com.zipcodewilmington.froilansfarm.Crops.Cornstalk;
import com.zipcodewilmington.froilansfarm.Crops.CropRow;
import com.zipcodewilmington.froilansfarm.Crops.Field;
import com.zipcodewilmington.froilansfarm.Vehicles.Cropduster;
import org.junit.Assert;
import org.junit.Test;

public class CropdusterTest {
    Cropduster testCropDuster;
    private Field testField;
    private CropRow<Cornstalk> testRow;

    public CropdusterTest() {
        testCropDuster = new Cropduster("nyew");
        testField = new Field();
        testRow = new CropRow<>();

        // Adds 2 crops to the row
        testRow.addCrop(new Cornstalk(), 2);

    }

    @Test
    public void testMakeNoise() {

        Assert.assertEquals("nyew", testCropDuster.makeNoise());
    }


    @Test
    public void testFertilizing() {
        for (Cornstalk cs: testRow.getRow()) {
            testCropDuster.fertilizes(cs);
            Assert.assertTrue(cs.getFertilized());
        }
    }

}
