package com.zipcodewilmington.froilansfarm.Buildings;


import com.zipcodewilmington.froilansfarm.Crops.EarOfCorn;
import com.zipcodewilmington.froilansfarm.Crops.EdibleCrop;
import com.zipcodewilmington.froilansfarm.Crops.Egg;
import com.zipcodewilmington.froilansfarm.Crops.Tomato;

import com.zipcodewilmington.froilansfarm.SiloStorable;
import com.zipcodewilmington.froilansfarm.Storer;

import java.util.ArrayList;


public class Silo implements Storer<SiloStorable> {
    private ArrayList<EarOfCorn> corn;
    private ArrayList<Tomato> tomatoes;
    private ArrayList<Egg> eggs;
    //private ArrayList<EdibleCrop> arbitraryCrops;

    public Silo() {
        corn = new ArrayList<>();
        tomatoes = new ArrayList<>();
        eggs = new ArrayList<>();
        //arbitraryCrops = new ArrayList<>();

    }

    // Change from instance of to type
    public void store(SiloStorable s) {
        if (s instanceof EarOfCorn) {
            corn.add((EarOfCorn) s);
        } else if (s instanceof Tomato) {
            tomatoes.add((Tomato) s);
        } else if (s instanceof Egg) {
            eggs.add((Egg) s);
        } else {
            System.out.println("Invalid product.");
        }
    }

    public void consumeCorn() {
        this.corn.remove(corn.size() - 1);
    }

    public void consumeTomato() {
        this.tomatoes.remove(tomatoes.size() - 1);
    }

    public void consumeEgg() {
        this.eggs.remove(eggs.size() - 1);
    }



    public int howManyCorn() {
        return corn.size();
    }

    public int howManyTomato() {
        return tomatoes.size();
    }

    public int howManyEgg() {
        return eggs.size();
    }

    public ArrayList<EarOfCorn> retrieveEdibleCorn() {
        return this.corn;
    }

    public ArrayList<Tomato> retrieveEdibleTomato() {
        return this.tomatoes;
    }

    public ArrayList<Egg> retrieveEdibleEggs() {
        return this.eggs;
    }



}

