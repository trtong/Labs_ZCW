package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import static io.zipcoder.ParenChecker.checkParenthesis;

public class ParenCheckerTest {

    @Test
    public void testParen1() {
        String s = "((()))";

        Assert.assertTrue(checkParenthesis(s));
    }

    @Test
    public void testParen2() {
        String s = "))((";

        Assert.assertFalse(checkParenthesis(s));
    }

    @Test
    public void testParen3() {
        String s ="((()))(";
        Assert.assertFalse(checkParenthesis(s));
    }
}