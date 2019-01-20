package io.zipcoder;

import java.util.HashMap;

public class Prices {
    private HashMap<Double, Integer > prices = new HashMap<>();

    public void IncrementPriceCounter(Double price) {
        prices.put(price, prices.get(price) + 1);
    }

    public void addNewPrice(Double price) {
        prices.put(price, 1);
    }

    public Integer getCount(Double price) {
        return prices.get(price);
    }


    public HashMap<Double, Integer> getPrices() {
        return prices;
    }


}
