package org.zipcoder.store;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private User user;

    @Before
    public void setup(){
        user = new User();
    }

    @Test
    public void testGetSetName(){
        // Given
        String expectedName = "Tiana";
        user.setName(expectedName);

        // When
        String actualName = user.getName();

        // Then
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetSetId(){
        // Given
        long expectedId = 1133;
        user.setId(expectedId);

        // When
        long actualId = user.getId();

        // Then
        Assert.assertEquals(expectedId, actualId);
    }

    @Test
    public void testEqual_withDefaultFields(){
        User user1 = new User();
        User user2 = new User();

        Assert.assertTrue(user1.equals(user2));
    }

    @Test
    public void testEqual_withSameIdAndNoName(){
        long id = 73;
        User user1 = new User(id);
        User user2 = new User(id);

        Assert.assertTrue(user1.equals(user2));
    }

    @Test
    public void testEqual_withSameIdAndDifferentName(){
        long id = 613;
        User user1 = new User(id, "Jonas");
        User user2 = new User(id, "Fiona");

        Assert.assertFalse(user1.equals(user2));
    }

    @Test
    public void testEqual_withSameNameDifferentId(){
        String name = "Asher";
        User user1 = new User(92, name);
        User user2 = new User(87, name);

        Assert.assertFalse(user1.equals(user2));
    }

    @Test
    public void testEqual_withSameIdAndSameName(){
        long id = 613;
        String name = "Asher";
        User user1 = new User(id, name);
        User user2 = new User(id, name);

        Assert.assertTrue(user1.equals(user2));
    }

    @Test
    public void testHashCode_withDefaultFields(){
        User user1 = new User();
        User user2 = new User();

        Assert.assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testHashCode_withSameIdAndNoName(){
        long id = 124;
        User user1 = new User(id);
        User user2 = new User(id);

        Assert.assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testHashCode_withSameIdAndDifferentName(){
        long id = 57;
        User user1 = new User(id, "Jonas");
        User user2 = new User(id, "Fiona");

        Assert.assertNotEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testHashCode_withSameNameDifferentId(){
        String name = "Asher";
        User user1 = new User(11, name);
        User user2 = new User(22, name);

        Assert.assertNotEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testHashCode_withSameIdAndSameName(){
        long id = 33;
        String name = "Asher";
        User user1 = new User(id, name);
        User user2 = new User(id, name);

        Assert.assertEquals(user1.hashCode(), user2.hashCode());
    }
}
