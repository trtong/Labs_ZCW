package com.zipcodewilmington.froilansfarm.Crops;

import com.zipcodewilmington.froilansfarm.Fertilizeable;
import com.zipcodewilmington.froilansfarm.Produce;
import com.zipcodewilmington.froilansfarm.ProduceResult;

public class TomatoPlant extends Crop implements Produce, Fertilizeable {

    public TomatoPlant() {
        super("Tomato Plant");
    }

    public ProduceResult yield() {
        return new Tomato();
    }

}
