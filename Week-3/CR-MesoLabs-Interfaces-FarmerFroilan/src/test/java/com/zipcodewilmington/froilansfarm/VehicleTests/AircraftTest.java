package com.zipcodewilmington.froilansfarm.VehicleTests;

import com.zipcodewilmington.froilansfarm.Vehicles.Aircraft;
import org.junit.Assert;
import org.junit.Test;

public class AircraftTest {

    Aircraft testAircraft;

    public AircraftTest(){
        testAircraft = new Aircraft("woosh");
    }

    @Test
    public void testMakeNoise() {

        Assert.assertEquals("woosh", testAircraft.makeNoise());
    }

    @Test
    public void testFlies() {

        // grounded bird
        testAircraft.setFlies(false);

        Assert.assertFalse(testAircraft.getFlies());
    }
}
