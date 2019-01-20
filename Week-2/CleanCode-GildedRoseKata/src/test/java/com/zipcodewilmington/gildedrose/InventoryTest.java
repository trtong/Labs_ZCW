package com.zipcodewilmington.gildedrose;

import org.junit.Assert;
import org.junit.Test;

/**
 * Creating tests for the Inventory Class
 * The Inventory class will keep track of SellIn & Quality
 *
 */

public class InventoryTest {
    Inventory inventory;

    Item wine = new Item("wine", 2, 25);
    Item agedBrie = new Item("Aged Brie", 1, 45);
    Item passes = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 25);
    Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 10, 80 );
    Item conjured = new Item("Conjured items by the magnificent wizard", 5, 4);

    Item[] items = {wine, agedBrie, passes, sulfuras, conjured};

    public InventoryTest() {
        inventory = new Inventory(items);
    }

    @Test
    public void testBrieQuality() {

        int expectedBrieQuality = 46;
        String itemName = "agedBrie";

        inventory.adjustItemQuality(agedBrie, 1);
        int actualBrieQuality = agedBrie.getQuality();

        Assert.assertEquals(expectedBrieQuality,actualBrieQuality);
    }


    @Test
    public void testPassQuality() {

        int expectedQuality = 26;

        inventory.updateQuality();
        int actualQuality = passes.getQuality();

        Assert.assertEquals(expectedQuality, actualQuality);

    }

    @Test
    public void testSulfurasQuality() {

        int expectedQuality = 80;

        inventory.updateQuality();
        int actualQuality = sulfuras.getQuality();

        Assert.assertEquals(expectedQuality, actualQuality);

    }

    @Test
    public void testConjuredQuality() {

    }

    @Test
    public void testReachMaxQuality(){

        int expectedQuality = 50;

        inventory.adjustItemQuality(wine, 45);

        int actualQuality = wine.getQuality();

        Assert.assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void testDecreaseSellIn() {

        int expectedSellin= 0;

        inventory.decreaseSellIn(agedBrie);
        int actualSellIn = agedBrie.getSellIn();

        Assert.assertEquals(expectedSellin, actualSellIn);

    }

    @Test
    public void testSellIn5() {

        boolean actualSell = inventory.checkPassSellIn5(passes);

        Assert.assertFalse(actualSell);

    }

    @Test
    public void adjustPassQuality5() {

        int expectedQuality = 39;

        for (int i = 0; i < 7; i++) {
            inventory.updateQuality();
        }
        int actualQuality = passes.getQuality();

        Assert.assertEquals(expectedQuality,actualQuality);

    }

    @Test
    public void adjustPassQualityNegative() {

        int expectedQuality = 0;

        for (int i = 0; i < 15; i++) {
            inventory.updateQuality();
        }

        int actualQuality = passes.getQuality();

        Assert.assertEquals(expectedQuality,actualQuality);
    }

    @Test
    public void testSellIn10() {

        inventory.decreaseSellIn(passes);
        inventory.decreaseSellIn(passes);
        boolean actualSell = inventory.checkPassSellIn10(passes);

        Assert.assertTrue(actualSell);

    }

    @Test
    public void testSellIn0() {

        boolean actualSell = inventory.checkSellInNegative(passes);
        Assert.assertFalse(actualSell);

    }

    @Test
    public void testSetMaxQuality() {

        int expectedMaxQuality = 50;

        inventory.setQualityMax(wine);
        int actualQuality = wine.getQuality();

        Assert.assertEquals(expectedMaxQuality, actualQuality);

    }

    @Test
    public void testSetQualityZero() {

        int expectedQuality = 0;

        inventory.setQualityZero(wine);
        int actualQuality = wine.getQuality();

        Assert.assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void testNegativeQualityisZero() {

        int expectedQuality = 0;

        for (int i = 0; i < 5; i++) {
            inventory.updateQuality();
        }

        int actualQuality = conjured.getQuality();

        Assert.assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void testGetName() {

        String expectedName = "Conjured items by wizard";

        conjured.setName(expectedName);
        String actualName = conjured.getName();

        Assert.assertEquals(expectedName, actualName);

    }

}

// Test for previous code

//
//    public InventoryTest() {
//
//        Item wine = new Item("wine", 2, 25);
//        Item agedBrie = new Item("Aged Brie", 1, 45);
//        Item passes = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 25);
//        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 10, 80 );
//
//        Item[] items = {wine, agedBrie, passes, sulfuras};
//
//        inventory = new Inventory(items);
//    }
//
//    public void assertTestValues(Inventory inventory, int days, int wineSellIn, int wineQuality, int brieSellIn, int brieQuality,
//                                 int passSellIn, int passQuality, int sulfurasSellIn, int sulfurasQuality) {
//        for (int i = 0; i < days; i++) {
//            inventory.updateQuality();
//        }
//        Item[] items = inventory.getItems();
//        Item currentItem = items[0];
//        Assert.assertSame("wine", currentItem.getName());
//        Assert.assertEquals(wineSellIn, currentItem.getSellIn());
//        Assert.assertEquals(wineQuality, currentItem.getQuality());
//
//        currentItem = items[1];
//        Assert.assertSame("Aged Brie", currentItem.getName());
//        Assert.assertEquals(brieSellIn, currentItem.getSellIn());
//        Assert.assertEquals(brieQuality, currentItem.getQuality());
//
//        currentItem = items[2];
//        Assert.assertSame("Backstage passes to a TAFKAL80ETC concert", currentItem.getName());
//        Assert.assertEquals(passSellIn, currentItem.getSellIn());
//        Assert.assertEquals(passQuality, currentItem.getQuality());
//
//        currentItem = items[3];
//        Assert.assertSame("Sulfuras, Hand of Ragnaros", currentItem.getName());
//        Assert.assertEquals(sulfurasSellIn, currentItem.getSellIn());
//        Assert.assertEquals(sulfurasQuality, currentItem.getQuality());
//    }
//
//    @Test
//    public void updateQualityTest(){
//        // Given
//
//        // One day
//        assertTestValues(inventory, 1, 1, 24, 0, 46, 10, 26, 10, 80);
//
//        // One more day
//        assertTestValues(inventory, 1, 0, 23, -1, 48, 9, 28, 10, 80);
//
//        // Four more days
//        assertTestValues(inventory, 4, -4, 15, -5, 50, 5, 36, 10, 80);
//
//        // Three more days
//        assertTestValues(inventory, 3, -7, 9, -8, 50, 2, 45, 10, 80);
//
//        // Five more days
//        assertTestValues(inventory, 5, -12, 0, -13, 50, -3, 0, 10, 80);
//    }