package com.zipcodewilmington.froilansfarm.CropTest;

import com.zipcodewilmington.froilansfarm.Crops.Cornstalk;
import org.junit.Assert;
import org.junit.Test;

public class CornstalkTest {

    Cornstalk testCornStalk;

    public CornstalkTest() {
        testCornStalk =  new Cornstalk();
    }

    @Test
    public void testCheckFertilized() {

        testCornStalk.setFertilized(true);

        Assert.assertTrue(testCornStalk.getFertilized());
    }

    @Test
    public void testCheckHarvestable() {

        testCornStalk.setHarvested(true);
        Assert.assertTrue(testCornStalk.getHarvested());

    }

    @Test
    public void testCropType() {
        Assert.assertEquals("Cornstalk", testCornStalk.getCropType());
    }
}
