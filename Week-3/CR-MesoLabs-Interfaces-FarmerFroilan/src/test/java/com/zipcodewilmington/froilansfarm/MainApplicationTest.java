package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.Crops.*;
import com.zipcodewilmington.froilansfarm.Vehicles.Aircraft;

/**
 * Created by leon on 2/26/18.
 */
public class MainApplicationTest {
    public static void main(String[] args) {
        Aircraft airplane = new Aircraft("whoosh");

        Field field = new Field();

        // Create crop rows for 5 tomatoes and 10 cornstalks
        CropRow<TomatoPlant> tomatoRow = new CropRow<>();
        tomatoRow.addCrop(new TomatoPlant(), 10);

        CropRow<Cornstalk> cornRow = new CropRow<>();
        cornRow.addCrop(new Cornstalk(), 10);

        field.addCropRow(tomatoRow);
        field.addCropRow(cornRow);

        for (CropRow cr: field.getCropRows()) {
            for (Object o: cr.getRow()) {
                Crop crop = (Crop) o;
                System.out.println("Found a: " + crop.getCropType());
            }
        }
    }
}
