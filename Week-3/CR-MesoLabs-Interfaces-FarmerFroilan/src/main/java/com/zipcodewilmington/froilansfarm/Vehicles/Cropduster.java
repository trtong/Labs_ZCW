package com.zipcodewilmington.froilansfarm.Vehicles;

import com.zipcodewilmington.froilansfarm.*;

public class Cropduster extends Aircraft implements FarmVehicle, Flyable, Fertilizer {

    private boolean flown;
    public Cropduster(String noise) {
        super(noise);
        flown = false;
    }

    public boolean isFlown() {
        return flown;
    }

    public void setFlown(Pilot p, boolean flown) {

        this.flown = flown;
    }

    public void fertilizing(Fertilizeable c) {
        c.setFertilized(true);
    }
}
