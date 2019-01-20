

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BasicTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BasicTest
{
    /**
     * Default constructor for test class BasicTest
     */
    public BasicTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testAdd()
    {
        Basic basic1 = new Basic();
        assertEquals(14, basic1.getSum(4, 10), 0.1);
    }

    @Test
    public void testAddDec()
    {
        Basic basic1 = new Basic();
        assertEquals(13.27, basic1.getSum(13.2, 0.07), 0.1);
    }

    @Test
    public void testAddNeg()
    {
        Basic basic1 = new Basic();
        basic1.Basic();
        assertEquals(6, basic1.getSum(-3, 9), 0.1);
    }

    @Test
    public void testSub()
    {
        Basic basic1 = new Basic();
        assertEquals(5, basic1.getDiff(10, 5), 0.1);
    }

    @Test
    public void testSubDec()
    {
        Basic basic1 = new Basic();
        assertEquals(4.65, basic1.getDiff(13.2, 8.55), 0.1);
    }

    @Test
    public void testSubNeg()
    {
        Basic basic1 = new Basic();
        assertEquals(18, basic1.getDiff(6, -12), 0.1);
    }

    @Test
    public void testMul()
    {
        Basic basic1 = new Basic();
        assertEquals(15, basic1.getProduct(3, 5), 0.1);
    }

    @Test
    public void testMulDec()
    {
        Basic basic1 = new Basic();
        assertEquals(6.8, basic1.getProduct(3.4, 2), 0.1);
    }

    @Test
    public void testMulNeg()
    {
        Basic basic1 = new Basic();
        assertEquals(10, basic1.getProduct(-2, -5), 0.1);
    }

    @Test
    public void testDiv()
    {
        Basic basic1 = new Basic();
        assertEquals(4, basic1.getQuotient(12, 3), 0.1);
    }

    @Test
    public void testDivDec()
    {
        Basic basic1 = new Basic();
        assertEquals(7.4, basic1.getQuotient(14.8, 2), 0.1);
    }

    @Test
    public void testDivNeg()
    {
        Basic basic1 = new Basic();
        assertEquals(-3, basic1.getQuotient(-12, 4), 0.1);
    }
}












