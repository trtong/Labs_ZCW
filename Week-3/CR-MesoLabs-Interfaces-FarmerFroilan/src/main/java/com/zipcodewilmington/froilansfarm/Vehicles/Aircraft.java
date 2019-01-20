package com.zipcodewilmington.froilansfarm.Vehicles;

import com.zipcodewilmington.froilansfarm.Flyable;

public class Aircraft extends Vehicle implements Flyable {
    private boolean flies;

    public Aircraft(String noise) {
        super(noise);

    }

    public boolean getFlies(){
        return this.flies;
    }

    public void setFlies(boolean flies) {
        this.flies = flies;
    }

}
