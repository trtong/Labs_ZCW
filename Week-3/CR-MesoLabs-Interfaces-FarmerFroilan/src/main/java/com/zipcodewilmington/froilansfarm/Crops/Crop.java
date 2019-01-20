package com.zipcodewilmington.froilansfarm.Crops;

import com.zipcodewilmington.froilansfarm.Fertilizeable;
import com.zipcodewilmington.froilansfarm.Produce;
import com.zipcodewilmington.froilansfarm.ProduceResult;
import com.zipcodewilmington.froilansfarm.SiloStorable;

public class Crop implements Fertilizeable, SiloStorable, Produce {

    private boolean fertilized;
    private boolean harvested;
    private String cropType;

    public Crop(String cropType) {
        this.fertilized = false;
        this.harvested = false;
        this.cropType = cropType;
    }

    // Do boolean like person with harvestedable/Fertalizable
    // Fertilizers will use set fertlize to true
    // harvestable = true, then add to silo, is if fertlized is true


    public boolean getFertilized() {
        return this.fertilized;
    }

    public void setFertilized(boolean hasBeenFertilized) {

        this.fertilized = hasBeenFertilized;
    }

    public boolean getHarvested() {
        return this.harvested;
    }

    public void setHarvested(boolean hasBeenHarvested) {
        this.harvested = hasBeenHarvested;
    }


    public String getCropType() {
        return cropType;
    }

    public ProduceResult yield() {
        return new EdibleCrop();
    }
}
