package com.zipcodewilmington.froilansfarm;

import java.util.ArrayList;

public interface Eater {
    default void eats(Edible food, int howMuch, ArrayList<Edible> storedSilo) {
        for (int i = 0; i < howMuch; i++) {
            storedSilo.remove(food);
        }
    };
}
