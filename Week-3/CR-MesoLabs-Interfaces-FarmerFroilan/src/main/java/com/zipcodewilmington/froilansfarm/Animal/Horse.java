package com.zipcodewilmington.froilansfarm.Animal;

import com.zipcodewilmington.froilansfarm.Eater;
import com.zipcodewilmington.froilansfarm.Edible;
import com.zipcodewilmington.froilansfarm.Rideable;
import com.zipcodewilmington.froilansfarm.Storable;

import java.util.ArrayList;

public class Horse implements Rideable, Storable, Animal, Eater {
    private boolean rideable,
                    ridden,
                    mounted,
                    dismounted;

    public Horse() {
        this.ridden = false;
        this.rideable = isRideable();
        this.mounted = isMounted();
        this.dismounted = isDismounted();


    }

    public String makeNoise() {
        return "neigh";
    }

    public void setRidden() {

        if (mounted && dismounted) {
            this.ridden = true;
        } else {
            this.ridden = false;
        }

    }

    public boolean isRidden() {

        return ridden;
    }

    public boolean isMounted() {
        return mounted;
    }

    public void setMounted(boolean mounted) {
        this.mounted = mounted;
    }

    public boolean isDismounted() {
        return dismounted;
    }

    public void setDismounted(boolean dismounted) {
        this.dismounted = dismounted;
    }

    //if ridden is false, horse has not been ridden
}
