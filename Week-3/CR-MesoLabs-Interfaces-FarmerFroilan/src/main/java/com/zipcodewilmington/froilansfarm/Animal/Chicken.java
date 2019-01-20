package com.zipcodewilmington.froilansfarm.Animal;

import com.zipcodewilmington.froilansfarm.Crops.Egg;
import com.zipcodewilmington.froilansfarm.Eater;
import com.zipcodewilmington.froilansfarm.Edible;
import com.zipcodewilmington.froilansfarm.Produce;

import java.util.ArrayList;

public class Chicken implements Produce, Animal, Eater {

    public Egg yield(){
        return new Egg();
    }

    public String makeNoise() {
        return "cluck";
    }
}
