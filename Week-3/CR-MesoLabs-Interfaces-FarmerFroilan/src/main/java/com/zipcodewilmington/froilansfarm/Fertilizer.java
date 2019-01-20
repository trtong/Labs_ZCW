package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.Crops.Crop;

public interface Fertilizer {
    default void fertilizes(Crop c) {
        c.setFertilized(true);
    }


}
