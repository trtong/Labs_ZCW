package com.zipcodewilmington.froilansfarm.Crops;

import java.util.ArrayList;

public class CropRow<T extends Crop> {
    private ArrayList<T> row;

    public CropRow() {
        this.row = new ArrayList<>();
    }

    public void addCrop(T crop, int howMany) {
        for (int i = 0; i < howMany; i++) {
            this.row.add(crop);
        }
    }

    public ArrayList<T> getRow() {
        return this.row;
    }

    public void clearRow() {
        this.getRow().clear();
    }

    public int size() {
        return this.getRow().size();
    }
}
