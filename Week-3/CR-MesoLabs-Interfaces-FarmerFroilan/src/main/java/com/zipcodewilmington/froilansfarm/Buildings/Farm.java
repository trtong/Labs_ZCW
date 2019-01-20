package com.zipcodewilmington.froilansfarm.Buildings;

import com.zipcodewilmington.froilansfarm.FarmStorable;
import com.zipcodewilmington.froilansfarm.Storer;

import java.util.ArrayList;

public class Farm implements Storer<FarmStorable> {

    ArrayList<ChickenCoop> chickenCoops;
    ArrayList<Stable> stables;
    Farmhouse farmHouse;

    public Farm(Farmhouse farmHouse){

        this.farmHouse = farmHouse;
        chickenCoops = new ArrayList<>();
        stables =  new ArrayList<>();

    }

    public void addBuilding(ChickenCoop coop) {
        this.chickenCoops.add(coop);
    }

    public void addBuilding(Stable stable) {
        this.stables.add(stable);
    }

    public ArrayList<Stable> getStables() {
        return this.stables;
    }

    public ArrayList<ChickenCoop> getCoops() {
        return this.chickenCoops;
    }

    public void store(FarmStorable storable) {
        if (storable instanceof ChickenCoop) {
            addBuilding((ChickenCoop) storable);
        } else if (storable instanceof Stable) {
            addBuilding((Stable) storable);
        }
    }
}
