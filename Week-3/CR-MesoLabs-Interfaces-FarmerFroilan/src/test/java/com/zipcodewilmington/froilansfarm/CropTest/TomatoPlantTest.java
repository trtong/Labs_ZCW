package com.zipcodewilmington.froilansfarm.CropTest;

import com.zipcodewilmington.froilansfarm.Crops.TomatoPlant;
import org.junit.Assert;
import org.junit.Test;

public class TomatoPlantTest {

    TomatoPlant testTomatoPlant;

    public TomatoPlantTest() {
        testTomatoPlant = new TomatoPlant();
    }

    @Test
    public void testCheckFertilized() {

        testTomatoPlant.setFertilized(true);

        Assert.assertTrue(testTomatoPlant.getFertilized());
    }

    @Test
    public void testCheckHarvestable() {

        testTomatoPlant.setHarvested(true);
        Assert.assertTrue(testTomatoPlant.getHarvested());

    }

    @Test
    public void testCropType() {
        Assert.assertEquals("Tomato Plant", testTomatoPlant.getCropType());
    }
}
