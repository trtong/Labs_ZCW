package com.zipcodewilmington.froilansfarm.WorkWeekSimulations;

import com.zipcodewilmington.froilansfarm.Animal.Chicken;
import com.zipcodewilmington.froilansfarm.Animal.Horse;
import com.zipcodewilmington.froilansfarm.Buildings.*;
import com.zipcodewilmington.froilansfarm.Crops.*;
import com.zipcodewilmington.froilansfarm.Person.Farmer;
import com.zipcodewilmington.froilansfarm.Person.Person;
import com.zipcodewilmington.froilansfarm.Storer;
import com.zipcodewilmington.froilansfarm.Vehicles.Aircraft;
import com.zipcodewilmington.froilansfarm.Vehicles.Cropduster;
import com.zipcodewilmington.froilansfarm.Vehicles.Tractor;

public class WorkDay {
    Farmer froilan;
    Farmer freelan;
    Person froilanda;

    Farmhouse farmhouse;

    Farm farm;

    Field field;

    CropRow<TomatoPlant> tomatoRow;
    CropRow<Cornstalk> cornRow;
    CropRow<Cornstalk> cornRow2;

    ChickenCoop coop1;
    ChickenCoop coop2;
    ChickenCoop coop3;
    ChickenCoop coop4;

    Stable stable1;
    Stable stable2;
    Stable stable3;

    Silo silo;

    Aircraft aircraft;

    Tractor tractor1;
    Tractor tractor2;

    Cropduster cropduster;

    public WorkDay() {
        froilan = new Farmer("Go away.", false, true);
        freelan = new Farmer("Stay away.", true, true);
        froilanda = new Person("Hello", true, false);

        farmhouse = new Farmhouse();
        farmhouse.store(froilan);
        farmhouse.store(freelan);
        farmhouse.store(froilanda);

        farm = new Farm(farmhouse);

        field = new Field();

        tomatoRow = new CropRow<>();
        cornRow = new CropRow<>();
        cornRow2 = new CropRow<>();

        field.addCropRow(tomatoRow);
        field.addCropRow(cornRow);
        field.addCropRow(cornRow2);

        coop1 = new ChickenCoop();
        coop2 = new ChickenCoop();
        coop3 = new ChickenCoop();
        coop4 = new ChickenCoop();

        addChickens(coop1, 4);
        addChickens(coop2, 4);
        addChickens(coop3, 4);
        addChickens(coop4, 4);

        farm.addBuilding(coop1);
        farm.addBuilding(coop2);
        farm.addBuilding(coop3);
        farm.addBuilding(coop4);

        stable1 = new Stable();
        stable2 = new Stable();
        stable3 = new Stable();

        addHorses(stable1, 3);
        addHorses(stable2, 3);
        addHorses(stable3, 3);

        farm.addBuilding(stable1);
        farm.addBuilding(stable2);
        farm.addBuilding(stable3);

        aircraft = new Aircraft("woosh");

        tractor1 = new Tractor("beep");
        tractor2 = new Tractor("beep beep");

        cropduster = new Cropduster("nyeww");

        silo = new Silo();

    }

    private void addChickens(Storer s, int howMany) {
        for (int i = 0; i < howMany; i++) {
            s.store(new Chicken());
        }
    }

    private void addHorses(Storer s, int howMany) {
        for (int i = 0; i < howMany; i++) {
            s.store(new Horse());
        }
    }


    public void rideHorseTask(Person p, Stable stable) {
        for (Horse h: stable.getStable()) {
            p.mount(h);
            p.dismount(h);
            h.setRidden();
        }
    }

    public void feedHorses() {
        for (Stable s: farm.getStables()) {
            for (Horse h : s.getStable()) {
                for (int i = 0; i < 3; i++) {
                    silo.consumeCorn();
                }
            }
        }
    }

    public void eatBreakfast() {

        for (int i = 0; i < 3; i++) {
            silo.consumeCorn();
        }

        for (int i = 0; i < 6; i ++) {
            silo.consumeTomato();
        }

        for (int i = 0; i < 9; i++) {
            silo.consumeEgg();
        }
    }



}
