package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.Crops.Crop;

public interface Harvester {

    default void harvests(Crop c) {
        if (c.getFertilized()) {
            c.setHarvested(true);
        }
    }
}
