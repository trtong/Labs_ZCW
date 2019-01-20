package io.zipcoder.polymorphism;

import org.junit.Assert;
import org.junit.Test;

public class MainApplicationTest {

    @Test
    public void speakDogTest() {
        //Given
        Dog rover = new Dog();
        String expected = "What's up dawg?";

        //When
        String actual = rover.speak();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void speakCatTest() {
        //Given
        Cat stripes = new Cat();
        String expected = "How do you like meow?";

        //When
        String actual = stripes.speak();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void speakFrogTest() {
        //Given
        Frog kermit = new Frog();
        String expected = "This code is ribbeting!";

        //When
        String actual = kermit.speak();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void speakDuckTest() {
        //Given
        Duck donald = new Duck();
        String expected = "You quack me up!";

        //When
        String actual = donald.speak();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void dogNameTest() {
        //Given
        Dog rover = new Dog();
        String newName = "Fido";
        String expected = "Fido";

        //When
        rover.setName(newName);
        String actual = rover.getName();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void catNameTest() {
        //Given
        Cat stripes = new Cat();
        String newName = "Jingles";
        String expected = "Jingles";

        //When
        stripes.setName(newName);
        String actual = stripes.getName();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void frogNameTest() {
        //Given
        Frog kermit = new Frog();
        String newName = "Mr. Frog";
        String expected = "Mr. Frog";

        //When
        kermit.setName(newName);
        String actual = kermit.getName();

        //Then
        Assert.assertEquals(expected, actual);

    }


    @Test
    public void duckNameTest() {
        //Given
        Duck donald = new Duck();
        String newName = "Daffy";
        String expected = "Daffy";

        //When
        donald.setName(newName);
        String actual = donald.getName();

        //Then
        Assert.assertEquals(expected, actual);

    }


}
