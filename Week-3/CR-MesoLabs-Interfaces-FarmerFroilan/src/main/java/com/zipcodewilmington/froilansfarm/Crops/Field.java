package com.zipcodewilmington.froilansfarm.Crops;

import java.util.ArrayList;

public class Field {

    // ? extends Crop allows for covariance; could technically just use CropRow<Crop>
    private ArrayList<CropRow<? extends Crop>> cropRows;

    public Field() {
        cropRows = new ArrayList<>();
    }

    public void addCropRow(CropRow<? extends Crop> cropRow) {
        cropRows.add(cropRow);
    }

    // return how many crops in a crop row?
    public ArrayList<CropRow<? extends Crop>> getCropRows() {
        return cropRows;
    }

}
