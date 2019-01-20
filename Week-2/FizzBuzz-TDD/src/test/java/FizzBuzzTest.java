import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzTest {

    @Test
    public void fizzTest() {
        // We are testing for Fizz, expect FizzBuzz.of(3) to return "Fizz"
        // Given

        int number = 3;

        String expectedFizz = "Fizz";

        // When

        String actualFizz = FizzBuzz.of(number);

        // Then

        Assert.assertEquals(expectedFizz, actualFizz);
    }

    @Test
    public void buzzTest() {

        // Given
        int number = 5;
        String expectedBuzz = "Buzz";

        // When

        String actualBuzz = FizzBuzz.of(number);

        // Then

        Assert.assertEquals(expectedBuzz, actualBuzz);

    }

    @Test
    public void fizzBuzzTest() {

        // Given
        int number = 15;
        String expectedFizzBuzz = "FizzBuzz";

        // When

        String actualFizzBuzz = FizzBuzz.of(number);


        // Then

        Assert.assertEquals(expectedFizzBuzz, actualFizzBuzz);

    }

    @Test
    public void notFizzBuzzTest() {

        // Given

        int number = 2;
        String expectedString = Integer.toString(number);

        // When

        String actualString = FizzBuzz.of(number);

        // Then

        Assert.assertEquals(expectedString, actualString);


    }
}
