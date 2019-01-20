package com.zipcodewilmington.froilansfarm.Person;

import com.zipcodewilmington.froilansfarm.*;
import com.zipcodewilmington.froilansfarm.Animal.Horse;


public class Person implements NoiseMaker, Eater, FarmStorable, Pilot, DrivesTractor, Botanist {

    private String noise;

    private boolean pilots,
                    drivesTractor,
                    plants;

    public Person(String noise, boolean pilots, boolean drivesTractor) {
        this.noise = noise;
        this.pilots = pilots;
        this.drivesTractor = drivesTractor;
        this.plants = false;
    }

    public boolean getPilots() {
        return this.pilots;
    }

    public void setPilots(boolean pilots) {
        this.pilots = pilots;
    }

    public boolean getDrivesTractor() {
        return this.drivesTractor;
    }

    public void setDrivesTractor(boolean drivesTractor){
        this.drivesTractor = drivesTractor;
    }

    public void setPlants(boolean canPlant){
        this.plants = canPlant;
    }

    public boolean getPlants() {
        return this.plants;
    }

    public String makeNoise() {
        return noise;
    }

    public void mount(Horse h) {
        h.setMounted(true);
    }

    public void dismount(Horse h) {
        h.setDismounted(true);

    }

}
