package com.zipcodewilmington.froilansfarm.Buildings;

import com.zipcodewilmington.froilansfarm.Animal.Horse;
import com.zipcodewilmington.froilansfarm.FarmStorable;
import com.zipcodewilmington.froilansfarm.Storer;

import java.util.ArrayList;

public class Stable implements Storer<Horse>, FarmStorable {
    private ArrayList<Horse> horses;

    public Stable() {
        horses = new ArrayList<>();
    }

    public void store(Horse h) {
        horses.add(h);
    }

    public ArrayList<Horse> getStable() {
        return this.horses;
    }

    public int howManyHorses() {
        return this.horses.size();
    }
}
