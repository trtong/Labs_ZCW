package org.zipcoder.store;

import org.junit.Assert;
import org.junit.Test;

public class EntryTest {

    @Test
    public void testGetKey(){
        User key = new User();
        Cart value = new Cart(13);
        Entry entry = new Entry(key, value);

        User actualKey = entry.getKey();

        Assert.assertEquals(key, actualKey);
    }

    @Test
    public void testGetValue(){
        User key = new User();
        Cart value = new Cart(54);
        Entry entry = new Entry(key, value);

        Cart actualValue = entry.getValue();

        Assert.assertEquals(value, actualValue);
    }


    @Test
    public void testGetSetValue(){
        User key = new User();
        Cart value = new Cart(54);
        Entry entry = new Entry(key, null);

        entry.setValue(value);
        Cart actualValue = entry.getValue();

        Assert.assertEquals(value, actualValue);
    }
}
