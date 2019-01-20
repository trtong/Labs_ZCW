import org.junit.Assert;
import org.junit.Test;

public class CalcTest {

    @Test
    public void addTest() {
        // Given is the calc class
        Calculator calc = new Calculator();

        int number1 = 5;
        int number2 = 7;

        int expectedNumber = 12;

        // When

        int actualNumber = calc.add(number1, number2);

        // Then

        Assert.assertEquals(expectedNumber, actualNumber);
    }
}
