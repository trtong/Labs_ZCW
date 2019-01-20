package com.zipcodewilmington.froilansfarm.Person;

import com.zipcodewilmington.froilansfarm.*;
import com.zipcodewilmington.froilansfarm.Animal.Horse;

import java.util.ArrayList;

public class Farmer extends Person implements Rider, Storable {

    public Farmer(String noise, boolean pilots, boolean drivesTractor) {
        super(noise, pilots, drivesTractor);
        // Farmer can always plant
        // Froilan cannot pilot = New Farmer("Stop", false)
        // Freelan can pilot = new Farmer ("Go", true);
    }

//    public void rides(Horse h) {
//        h.setRidden();
//    }
//


}
