import org.junit.Test;

import static org.junit.Assert.*;

public class StringParserTest {
    @Test
    public void upperCaseString() {
        //Given
        String string1 = "test string";
        String expected = "TEST STRING";

        //When
        String actual = StringParser.upperCaseString(string1);

        //Expect
        assertEquals(expected, actual);
    }

    @Test
    public void lowerCaseString() {
        //Given
        String string1 = "TEST STRING";
        String expected = "test string";

        //When
        String actual = StringParser.lowerCaseString(string1);

        //Expect
        assertEquals(expected, actual);
    }

    @Test
    public void getFirstCharacter() {
        //Given
        String string1 = "test string";
        Character expected = 't';

        //When
        Character actual = StringParser.getFirstCharacter(string1);

        //Expect
        assertEquals(expected, actual);
    }

    @Test
    public void getNthCharacter() {
        //Given
        String string1 = "test string";
        Integer index = 2;
        Character expected = 's';

        //When
        Character actual = StringParser.getNthCharacter(string1, index);

        //Expect
        assertEquals(expected, actual);
    }

    @Test
    public void upperCaseFirstCharacter() {
        //Given
        String string1 = "test string";
        String expected = "Test string";

        //When
        String actual = StringParser.upperCaseFirstCharacter(string1);

        //Expect
        assertEquals(expected, actual);
    }

    @Test
    public void camelCaseString() {
        //Given
        String string1 = "tEsT sTrInG";
        String expected = "TestString";

        //When
        String actual = StringParser.camelCaseString(string1);

        //Expect
        assertEquals(expected, actual);
    }

    @Test
    public void snakeCaseString() {
        //Given
        String string1 = "tEST STring";
        String expected = "test_string";

        //When
        String actual = StringParser.snakeCaseString(string1);

        //Expect
        assertEquals(expected, actual);
    }

    @Test
    public void getLength() {
        //Given
        String string1 = "A different string";
        Integer expected1 = 18;

        String string2 = "test string";
        Integer expected2 = 11;

        //When
        Integer actual1 = StringParser.getLength(string1);
        Integer actual2 = StringParser.getLength(string2);

        //Expect
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void isEqual() {
        //Given
        String string1 = "A different string";
        String compareString1 = "a Different string";
        Boolean expected1 = false;

        String string2 = "test string";
        String compareString2 = "test string";
        Boolean expected2 = true;

        //When
        Boolean actual1 = StringParser.isEqual(string1, compareString1);
        Boolean actual2 = StringParser.isEqual(string2, compareString2);

        //Expect
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void isEqualIgnoreCase() {
        //Given
        String string1 = "A different string";
        String compareString1 = "a Different string";
        Boolean expected1 = true;

        String string2 = "test string";
        String compareString2 = "test string";
        Boolean expected2 = true;

        String string3 = "A different string";
        String compareString3 = "A different string!";
        Boolean expected3 = false;


        //When
        Boolean actual1 = StringParser.isEqualIgnoreCase(string1, compareString1);
        Boolean actual2 = StringParser.isEqualIgnoreCase(string2, compareString2);
        Boolean actual3 = StringParser.isEqualIgnoreCase(string3, compareString3);

        //Expect
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }
}