package com.zipcodewilmington.froilansfarm.EdibleTest;

import com.zipcodewilmington.froilansfarm.Crops.Tomato;
import org.junit.Assert;
import org.junit.Test;

public class TomatoTest {
    // set get edible
    Tomato testTomato;

    public TomatoTest() {
         testTomato = new Tomato();
    }


    @Test
    public void testEdible() {

        testTomato.setEdible(false);

        Assert.assertFalse(testTomato.getEdible());

    }
}
