package com.zipcodewilmington.froilansfarm.Crops;

import com.zipcodewilmington.froilansfarm.Fertilizeable;
import com.zipcodewilmington.froilansfarm.Produce;
import com.zipcodewilmington.froilansfarm.ProduceResult;

public class Cornstalk extends Crop implements Produce, Fertilizeable {


    public Cornstalk() {
        super("Cornstalk");
    }

    public ProduceResult yield() {

        return new EarOfCorn();
    }
}
