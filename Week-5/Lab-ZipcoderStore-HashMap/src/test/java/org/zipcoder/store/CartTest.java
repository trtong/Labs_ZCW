package org.zipcoder.store;

import org.junit.Assert;
import org.junit.Test;

public class CartTest {

    @Test
    public void testGetSetId(){
        // Given
        long expectedId = 931;
        Cart cart1 = new Cart(expectedId);

        // When
        long actualId = cart1.getId();

        // Then
        Assert.assertEquals(expectedId, actualId);
    }

    @Test
    public void testEquals_CartWithTheSameIdAreEquals(){
        // Given
        long id = 111;
        Cart cart1 = new Cart(id);
        Cart copyCart1 = new Cart(id);

        // When
        boolean equality = cart1.equals(copyCart1);

        // Then
        Assert.assertTrue(equality);
    }

    @Test
    public void testHashCode_CartWithTheSameIdAreHaveTheSameHash(){
        // Given
        long id = 111;
        Cart cart1 = new Cart(id);
        Cart copyCart1 = new Cart(id);

        // When
        int cart1Hash = cart1.hashCode();
        int copyCart1Hash = copyCart1.hashCode();

        // Then
        Assert.assertEquals(cart1Hash, copyCart1Hash);
    }
}
