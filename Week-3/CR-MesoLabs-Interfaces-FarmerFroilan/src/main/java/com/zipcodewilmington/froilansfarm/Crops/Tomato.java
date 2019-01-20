package com.zipcodewilmington.froilansfarm.Crops;

import com.zipcodewilmington.froilansfarm.Edible;
import com.zipcodewilmington.froilansfarm.ProduceResult;
import com.zipcodewilmington.froilansfarm.SiloStorable;
import com.zipcodewilmington.froilansfarm.Storable;

public class Tomato implements Edible, ProduceResult, Storable, SiloStorable {

    private boolean isEdible;

    public Tomato() {

        this.isEdible = true;

    }

    public void setEdible(boolean edible) {
        this.isEdible = edible;
    }

    public boolean getEdible() {
        return this.isEdible;
    }

}
