package com.zipcodewilmington.froilansfarm.Buildings;

import com.zipcodewilmington.froilansfarm.Animal.Chicken;
import com.zipcodewilmington.froilansfarm.FarmStorable;
import com.zipcodewilmington.froilansfarm.Storer;

import java.util.ArrayList;

public class ChickenCoop implements Storer<Chicken>, FarmStorable {

    private ArrayList<Chicken> coop;

    public ChickenCoop() {
        coop =  new ArrayList<>();
    }

    public void store(Chicken c) {
        this.coop.add(c);
    }

    public ArrayList<Chicken> getChickenCoop() {
        return this.coop;
    }

    public int howManyChickens() {
        return this.coop.size();
    }


}
