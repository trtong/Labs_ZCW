package com.zipcodewilmington.froilansfarm.Crops;

import com.zipcodewilmington.froilansfarm.Edible;
import com.zipcodewilmington.froilansfarm.ProduceResult;
import com.zipcodewilmington.froilansfarm.SiloStorable;
import com.zipcodewilmington.froilansfarm.Storable;

public class EarOfCorn implements Edible, ProduceResult, SiloStorable, Storable {

    private boolean isEdible;

    public EarOfCorn() {
        this.isEdible = true;
    }

    public EarOfCorn(boolean notEdible) {
        this.isEdible = notEdible;
    }

    public void setEdible(boolean edible) {
        this.isEdible = edible;
    }

    public boolean getEdible() {
        return this.isEdible;
    }
}
