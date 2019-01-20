package com.zipcodewilmington.froilansfarm.Crops;

import com.zipcodewilmington.froilansfarm.*;

public class Egg implements Edible, Fertilizeable, ProduceResult, SiloStorable, Storable {

    private boolean fertilized,
                    isEdible;

    public Egg() {
        this.fertilized = false;
        this.isEdible = true;
    }

    public void setEdible(boolean edible) {

         this.isEdible = edible;
    }

    public boolean getEdible() {
        return this.isEdible;
    }

    public boolean getFertilized() {
        return this.fertilized;
    }

    public void setFertilized(boolean hasBeenFertilized) {

        this.fertilized = hasBeenFertilized;
    }
}
