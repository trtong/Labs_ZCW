package com.zipcodewilmington.froilansfarm.WorkWeekSimulations;

import com.zipcodewilmington.froilansfarm.Animal.Chicken;
import com.zipcodewilmington.froilansfarm.Buildings.ChickenCoop;
import com.zipcodewilmington.froilansfarm.Crops.*;
import com.zipcodewilmington.froilansfarm.SiloStorable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WorkWeekTest extends WorkDay {

    public WorkWeekTest() {
        for (int i = 0; i < 100; i++) {
            silo.store(new EarOfCorn());
        }

        for (int i = 0; i < 25; i++) {
            silo.store(new Egg());
        }

        for (int i = 0; i < 30; i++) {
            silo.store(new Tomato());
        }
    }

    @Before
    public void weekSetup() {

        tomatoRow.addCrop(new TomatoPlant(), 50);

        cornRow.addCrop(new Cornstalk(), 50);

        cornRow2.addCrop(new Cornstalk(), 50);


        field.addCropRow(tomatoRow);
        field.addCropRow(cornRow);
        field.addCropRow(cornRow2);

        // Ride All Horses & feed
        rideHorseTask(froilan, stable1);
        rideHorseTask(freelan, stable2);
        rideHorseTask(froilanda, stable3);

        Assert.assertTrue(stable1.getStable().get(0).isRidden());

        // Feed Horses
        feedHorses();

        // Eat Breakfast
        eatBreakfast();
    }

    @Test
    public void testSunday() {

        Assert.assertEquals(70, silo.howManyCorn());

        Assert.assertTrue(field.getCropRows().get(0).getRow().get(0) instanceof TomatoPlant);

    }

    @Test
    public void testMonday() {

        // Ride All Horses & feed
        rideHorseTask(froilan, stable1);
        rideHorseTask(freelan, stable2);
        rideHorseTask(froilanda, stable3);

        Assert.assertTrue(stable1.getStable().get(0).isRidden());

        // Feed Horses
        feedHorses();

        // Eat Breakfast
        eatBreakfast();

        cropduster.setFlown(froilanda, true);
        Assert.assertTrue(cropduster.isFlown());

        for (Crop t: field.getCropRows().get(0).getRow()) {
            cropduster.fertilizing((TomatoPlant) t);
        }

        Assert.assertTrue(field.getCropRows().get(0).getRow().get(0).getFertilized());

        for (Crop c: field.getCropRows().get(1).getRow()) {
            cropduster.fertilizing((Cornstalk) c);
        }

        Assert.assertTrue(field.getCropRows().get(1).getRow().get(0).getFertilized());

    }

    @Test
    public void testTuesday() {
        testMonday();


        tractor1.setUsed(froilan, true);

        Assert.assertTrue(tractor1.isUsed());

        for (Crop c: field.getCropRows().get(0).getRow()) {
            tractor1.harvests(c);
        }

        for (Crop c: field.getCropRows().get(1).getRow()) {
            tractor1.harvests(c);
        }


        Assert.assertTrue(field.getCropRows().get(0).getRow().get(0).getHarvested());

        for (TomatoPlant t: tomatoRow.getRow()) {
            silo.store((SiloStorable) t.yield());
        }

        tomatoRow.clearRow();

        for (Cornstalk c: cornRow.getRow()) {
            silo.store((SiloStorable) c.yield());
        }

        cornRow.clearRow();

        Assert.assertEquals(90,silo.howManyCorn());

    }

    @Test
    public void testWednesday() {
        testTuesday();

        // Froilan harvests the eggs from all the chickens
        for (ChickenCoop cc : farm.getCoops()) {
            for (Chicken c : cc.getChickenCoop()) {
                silo.store(c.yield());
            }
        }

        // Ride All Horses & feed
        rideHorseTask(froilan, stable1);
        rideHorseTask(freelan, stable2);
        rideHorseTask(froilanda, stable3);

        Assert.assertTrue(stable1.getStable().get(0).isRidden());

        // Feed Horses
        feedHorses();

        // Eat Breakfast
        eatBreakfast();

        // Freelan uses Cropduster to fly over field and fertlize last crop row.
        for (Crop c: field.getCropRows().get(2).getRow()) {
            cropduster.fertilizing((Cornstalk) c);
        }

        Assert.assertTrue(field.getCropRows().get(2).getRow().get(0).getFertilized());


        Assert.assertEquals(14, silo.howManyEgg());

        // Third row of corn, split row 2 evenly
        // harvest third, plant third here

        for (Cornstalk c: cornRow2.getRow()) {
            silo.store((SiloStorable) c.yield());
        }

        cornRow2.clearRow();

        Assert.assertEquals(0, cornRow2.size());

        cornRow2.addCrop(new Cornstalk(), 50);

        Assert.assertNotNull(cornRow2.getRow().get(0));

    }

    @Test
    public void testThursday() {
        testWednesday();

        // Freelan harvests the eggs from all the chickens
        for (ChickenCoop cc : farm.getCoops()) {
            for (Chicken c : cc.getChickenCoop()) {
                silo.store(c.yield());
            }
        }

        // Ride All Horses & feed
        rideHorseTask(froilan, stable1);
        rideHorseTask(freelan, stable2);
        rideHorseTask(froilanda, stable3);

        Assert.assertTrue(stable1.getStable().get(0).isRidden());

        // Feed Horses
        feedHorses();

        // Eat Breakfast
        eatBreakfast();

        // Froilan plants row 1
        tomatoRow.addCrop(new TomatoPlant(), 50);

        Assert.assertEquals(50, tomatoRow.size());
        //Freelan plants row 2

        cornRow.addCrop(new Cornstalk(), 50);

    }

    @Test
    public void testFriday() {

        // Friday

        // Freelan harvests the eggs from all the chickens
        for (ChickenCoop cc : farm.getCoops()) {
            for (Chicken c : cc.getChickenCoop()) {
                silo.store(c.yield());
            }
        }

        // Ride All Horses & feed
        rideHorseTask(froilan, stable1);
        rideHorseTask(freelan, stable2);
        rideHorseTask(froilanda, stable3);

        Assert.assertTrue(stable1.getStable().get(0).isRidden());

        // Feed Horses
        feedHorses();

        // Eat Breakfast
        eatBreakfast();

        // Froilanda fertilizes all rows
        cropduster.setFlown(froilanda, true);
        Assert.assertTrue(cropduster.isFlown());

        for (Crop t: field.getCropRows().get(0).getRow()) {
            cropduster.fertilizing((TomatoPlant) t);
        }

        Assert.assertTrue(field.getCropRows().get(0).getRow().get(0).getFertilized());

        for (Crop c: field.getCropRows().get(1).getRow()) {
            cropduster.fertilizing((Cornstalk) c);
        }

        Assert.assertTrue(field.getCropRows().get(1).getRow().get(0).getFertilized());

        for (Crop c: field.getCropRows().get(2).getRow()) {
            cropduster.fertilizing((Cornstalk) c);
        }

        Assert.assertTrue(field.getCropRows().get(2).getRow().get(0).getFertilized());

    }

    @Test
    public void testSaturday() {
        testFriday();
        // Freelan harvests the eggs from all the chickens
        for (ChickenCoop cc : farm.getCoops()) {
            for (Chicken c : cc.getChickenCoop()) {
                silo.store(c.yield());
            }
        }

        // Ride All Horses & feed
        rideHorseTask(froilan, stable1);
        rideHorseTask(freelan, stable2);
        rideHorseTask(froilanda, stable3);

        Assert.assertTrue(stable1.getStable().get(0).isRidden());

        // Feed Horses
        feedHorses();

        // Eat Breakfast
        eatBreakfast();

        // Rest for tomorrow :)

    }
}

