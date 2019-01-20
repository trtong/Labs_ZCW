package com.zipcodewilmington.froilansfarm.Animal;

import com.zipcodewilmington.froilansfarm.*;

import java.util.ArrayList;

public interface Animal extends NoiseMaker, Eater, Storable {
    default void eats(Edible e, ArrayList<Edible> storedSilo) {
        // If edible e instance of Arraylist[0]
        storedSilo.remove(storedSilo.size()-1);
    }

    String makeNoise();
}
