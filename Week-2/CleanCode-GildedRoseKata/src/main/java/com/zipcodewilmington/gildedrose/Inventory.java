package com.zipcodewilmington.gildedrose;


public class Inventory {
    private Item[] items;
    static final String BRIE = "Aged Brie";
    static final String BACK_PASS = "Backstage passes to a TAFKAL80ETC concert";
    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    static final String CONJURED = "Conjured items by the magnificent wizard";


    public Inventory(Item[] items) {
        super();
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {

            switch (item.getName()) {

                case BRIE:
                    if (!checkSellInNegative(item)) {
                        adjustItemQuality(item, 1);
                    } else {
                        adjustItemQuality(item, 2);
                    }
                    decreaseSellIn(item);
                    break;

                case BACK_PASS:

                    if (checkPassSellIn5(item)) {
                        adjustItemQuality(item, 3);

                    } else if (checkPassSellIn10(item)) {
                        adjustItemQuality(item, 2);

                    } else if (checkSellInNegative(item)) {
                        setQualityZero(item);

                    } else {
                        adjustItemQuality(item, 1);
                    }

                    decreaseSellIn(item);

                    break;

                case SULFURAS:
                    item.setQuality(80);
                    item.setSellIn(item.getSellIn());

                    break;

                case CONJURED:
                    if (!checkSellInNegative(item)) {
                        adjustItemQuality(item, -2);
                    } else {
                        adjustItemQuality(item, -4);
                    }

                    decreaseSellIn(item);
                    break;

                default:
                    break;
            }
        }
    }

    public void decreaseSellIn(Item name) {
        name.setSellIn(name.getSellIn() - 1);

    }

    public boolean checkPassSellIn5(Item item) {

        if (item.getSellIn() <= 5 && item.getSellIn() >= 0) {
            return true;
        }

        return false;
    }

    public boolean checkPassSellIn10(Item item) {

        if (item.getSellIn() <= 10 && item.getSellIn() > 5) {
            return true;
        }

        return false;
    }

    public boolean checkSellInNegative(Item item) {

        if (item.getSellIn() < 0) {
            return true;
        }

        return false;
    }

    public void setQualityMax(Item item) {
        item.setQuality(50);
    }

    public void setQualityZero(Item item) {
        item.setQuality(0);
    }

    public void adjustItemQuality(Item name, int qualityIncrement) {

        if (name.getQuality() + qualityIncrement < 0) {
            setQualityZero(name);

        } else if ((name.getQuality() + qualityIncrement < 50) && (name.getQuality() + qualityIncrement >= 0)) {
            name.setQuality(name.getQuality() + qualityIncrement);

        } else {
            setQualityMax(name);
        }

    }
}
