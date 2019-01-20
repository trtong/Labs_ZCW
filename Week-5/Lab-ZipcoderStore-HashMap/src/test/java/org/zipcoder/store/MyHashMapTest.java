package org.zipcoder.store;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MyHashMapTest {
    private MyMap myMap;

    @Before
    public void setup(){
        myMap = new MyHashMap();
    }

    @Test
    public void testPutAndGet_WithOneItem(){
        User user = new User("Tiana");
        Cart cart = new Cart(1);

        // When
        myMap.put(user, cart);

        // Then
        Cart actualCart = myMap.get(user);
        Assert.assertEquals(cart, actualCart);
    }

    @Test
    public void testPutAndGet_WithTwoItems(){
        User tiana = new User("Tiana");
        Cart tianasCart = new Cart(1134);

        User john = new User("John");
        Cart johnsCart = new Cart(42);

        // When
        myMap.put(john, johnsCart);
        myMap.put(tiana, tianasCart);

        // Then
        Cart actualJohnsCart = myMap.get(john);
        Assert.assertEquals(johnsCart, actualJohnsCart);

        Cart actualTianasCart = myMap.get(tiana);
        Assert.assertEquals(tianasCart, actualTianasCart);
    }

    @Test
    public void testPutAndGet_UpdateCart(){
        User tiana = new User("Tiana");
        Cart tianasCart = new Cart(11);
        myMap.put(tiana, tianasCart);

        // When
        Cart updatedCart = new Cart(99);
        myMap.put(tiana, updatedCart);

        // Then
        Cart actualCart = myMap.get(tiana);
        Assert.assertEquals(updatedCart, actualCart);
    }

    @Test
    public void testGetWithoutPut(){
        // Given
        User user = new User("Tiana");

        // When
        Cart actualCart = myMap.get(user);

        // Then
        Assert.assertNull(actualCart);
    }

    @Test
    public void testPutAndGet_WithDifferentKeyInstance(){
        // Given
        String name = "Tiana";
        User tiana = new User(name);
        Cart cart = new Cart(76);

        // When
        myMap.put(tiana, cart);
        User cloneTiana = new User(name);
        Cart actualCart = myMap.get(cloneTiana);

        // Then
        Assert.assertEquals(cart, actualCart);
    }

    @Test
    public void testSize_WithNoEntry(){
        int expectedSize = 0;
        Assert.assertEquals(expectedSize, myMap.size());
    }

    @Test
    public void testSize_WithEntries(){
        // Given
        User user1 = new User("Monica");
        Cart cart1 = new Cart(45);

        User user2 = new User("Quincy");
        Cart cart2 = new Cart(78);

        // When
        myMap.put(user1, cart1);
        myMap.put(user2, cart2);

        // Then
        int expectedSize = 2;
        Assert.assertEquals(expectedSize, myMap.size());
    }

    @Test
    public void testIsEmpty_WithoutEntry(){
        Assert.assertTrue(myMap.isEmptry());
    }

    @Test
    public void testisEmpty_WithEntries(){
        // Given
        User user1 = new User("Monica");
        Cart cart1 = new Cart(45);

        // When
        myMap.put(user1, cart1);

        // Then
        Assert.assertFalse(myMap.isEmptry());
    }

    @Test
    public void testGetKeys(){
        // Given
        User user1 = new User("Zeke");
        Cart cart1 = new Cart(7);

        User user2 = new User("Nona");
        Cart cart2 = new Cart(29);

        // When
        myMap.put(user1, cart1);
        myMap.put(user2, cart2);

        // Then
        List<User> keys = myMap.getKeys();
        int expectedKeySize = 2;
        Assert.assertEquals(expectedKeySize, keys.size());
        Assert.assertTrue(keys.contains(user1));
        Assert.assertTrue(keys.contains(user2));
    }

    @Test
    public void testGetValues(){
        // Given
        User user1 = new User("Camille");
        Cart cart1 = new Cart(433);

        User user2 = new User("Nathan");
        Cart cart2 = new Cart(71);

        // When
        myMap.put(user1, cart1);
        myMap.put(user2, cart2);

        // Then
        List<Cart> values = myMap.getValues();
        int expectedKeySize = 2;
        Assert.assertEquals(expectedKeySize, values.size());
        Assert.assertTrue(values.contains(cart1));
        Assert.assertTrue(values.contains(cart2));
    }

//    I commented this out because it takes a long time to run. Uncomment it when implement your put method, uncomment this test
    @Test
    public void testPutAndGet_WithManyItems(){
        // Given
        int numberOfEntries = 70000;

        for (int i = 0; i < numberOfEntries; i++) {
            myMap.put(new User(i), new Cart(i));
        }


        for (int i = 0; i < numberOfEntries; i++) {
            // When
            Cart actualCart = myMap.get(new User(i));
            Cart expectedCart = new Cart(i);

            // Then
            Assert.assertEquals(actualCart, expectedCart);
        }
    }

    @Test
    public void testRemove(){
        // Given
        User user1 = new User("Lena");
        Cart cart1 = new Cart(11);

        User user2 = new User("Jamal");
        Cart cart2 = new Cart(21);

        User user3 = new User("Kelvin");
        Cart cart3 = new Cart(31);

        // When
        myMap.put(user1, cart1);
        myMap.put(user2, cart2);
        myMap.put(user3, cart3);

        // Then
        Cart actualCart = myMap.remove(user2);

        Assert.assertEquals(cart2, actualCart);
        Assert.assertNull(myMap.get(user2));
    }

    @Test
    public void testRemove_CartNotInTheMap(){
        // Given
        User user1 = new User("Lena");

        // When & Then
        Assert.assertNull(myMap.remove(user1));
    }
}
