package com.zipcodewilmington.froilansfarm.Vehicles;

import com.zipcodewilmington.froilansfarm.NoiseMaker;

abstract class Vehicle implements NoiseMaker {

    private String noise;

    public Vehicle(String noise) {
        this.noise = noise;
    }

    public String makeNoise() {

        return noise;
    }
}
