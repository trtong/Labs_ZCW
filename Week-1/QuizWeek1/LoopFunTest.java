

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoopFunTest
{
    private LoopFun loop;

    @Before
    public void setUp(){
        loop = new LoopFun();
    }

    @Test
    public void testFactorialBase(){
        //Given
        int number = 1;
        int expected = 1;

        //When
        int actual = loop.factorial(number);

        //Then
        assertEquals(expected, actual);

    }

    @Test
    public void testFactorialOfSmallNumber(){
        //Given
        int number = 3;
        int expected = 6;

        //When
        int actual = loop.factorial(number);

        //Then
        assertEquals(expected, actual);

    }

    @Test
    public void testFactorialOfBigNumber(){
        //Given
        int number = 6;
        int expected = 720;

        //When
        int actual = loop.factorial(number);

        //Then
        assertEquals(expected, actual);

    }

    @Test
    public void testAcronymBasic() {
        //Given
        String phrase = "Portable Network Graphics";
        String expected = "PNG";

        //When
        String actual = loop.acronym(phrase);

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void testAcronymBasicLowercaseWords() {
        //Given
        String phrase = "Ruby on Rails";
        String expected = "ROR";

        //When
        String actual = loop.acronym(phrase);

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void testAcronymBasicPunctuation() {
        //Given
        String phrase = "First In, First Out";
        String expected = "FIFO";

        //When
        String actual = loop.acronym(phrase);

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void testAcronymBasicNonAcronymAllCapsWord() {
        //Given
        String phrase = "GNU Image Manipulation Program";
        String expected = "GIMP";

        //When
        String actual = loop.acronym(phrase);

        //Then
        assertEquals(expected, actual);
    }




    @Test
    public void testEncryptWithTheFirstAlphabet(){
        //Given
        String word = "apple";
        String expected = "dssoh";

        //When
        String actual = loop.encrypt(word);

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void testEncryptWithTheLastLetters(){
        //Given
        String word = "wxyz";
        String expected = "zabc";

        //When
        String actual = loop.encrypt(word);

        //Then
        assertEquals(expected, actual);
    }



}
