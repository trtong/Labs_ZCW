package com.zipcodewilmington.froilansfarm.EdibleTest;

import com.zipcodewilmington.froilansfarm.Crops.EarOfCorn;
import org.junit.Assert;
import org.junit.Test;

public class EarOfCornTest {
    EarOfCorn testEar;

    public EarOfCornTest() {
        testEar = new EarOfCorn();
    }

    @Test
    public void testEdible() {

        testEar.setEdible(false);

        Assert.assertFalse(testEar.getEdible());
    }
}
