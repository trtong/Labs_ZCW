package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import static io.zipcoder.FormsChecker.formChecker;

public class FormsCheckerTest {
    @Test
    public void testFormValidPairs() {
        String test = "<<<(((())))>>>";

        Assert.assertTrue(formChecker(test));
    }

    @Test
    public void testFormInvalidSingleQuote() {

        String test = "\'\'\'(\')";
        Assert.assertFalse(formChecker(test));
    }

    @Test
    public void testFormValidNestedForms() {

        String test = "{[{[()]}]}";

        Assert.assertTrue(formChecker(test));
    }

    @Test
    public void testFormCheckValidSingleWithForms() {

        String test = "\'[\'\']\'";
        Assert.assertTrue(formChecker(test));
    }

    @Test
    public void testFormCheckValidDoubleQuote() {
        String test = "\"\"";

        Assert.assertTrue(formChecker(test));
    }

    @Test
    public void testFormCheckValidSingleQuote() {
        String test = "\'\'";

        Assert.assertTrue(formChecker(test));
    }
}