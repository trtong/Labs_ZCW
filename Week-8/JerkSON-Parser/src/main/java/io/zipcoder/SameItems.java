package io.zipcoder;

public class SameItems {
    private String name;
    private int count;
    private Prices prices;

    public SameItems(String name) {
        this.name = name;
        count = 1;
        prices = new Prices();
    }


    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }
}
