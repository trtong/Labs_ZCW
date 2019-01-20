package com.zipcodewilmington.froilansfarm.Vehicles;

import com.zipcodewilmington.froilansfarm.FarmVehicle;
import com.zipcodewilmington.froilansfarm.Harvester;
import com.zipcodewilmington.froilansfarm.Person.Farmer;

public class  Tractor extends Vehicle implements FarmVehicle, Harvester {
    boolean used;

    public Tractor(String noise) {
        super(noise);
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(Farmer p, boolean used) {
        this.used = used;
    }
}
