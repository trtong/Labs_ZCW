package com.zipcodewilmington.froilansfarm;

public interface Storer<S extends Storable> {

    void store(S storable);

}
