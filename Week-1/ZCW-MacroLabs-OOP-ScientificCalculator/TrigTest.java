

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TrigTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TrigTest
{
    /**
     * Default constructor for test class TrigTest
     */
    public TrigTest()
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
    public void testSIN()
    {
        Trig trig1 = new Trig();
        assertEquals(-0.54402111088, trig1.calcSin(10), 0.1);
    }

    @Test
    public void testCOS()
    {
        Trig trig1 = new Trig();
        assertEquals(-0.83907152907, trig1.calcCos(10), 0.1);
    }

    @Test
    public void testTAN()
    {
        Trig trig1 = new Trig();
        assertEquals(0.64836082745, trig1.calcTan(10), 0.1);
    }

    @Test
    public void testRadtoDeg()
    {
        Trig trig1 = new Trig();
        assertEquals(37.14833901458697, trig1.toDegrees(0.64836082745), 0.1);
    }

    @Test
    public void testArcSin()
    {
        Trig trig2 = new Trig();
        assertEquals(0.523598776, trig2.calcArcsin(0.5), 0.1);
    }

    @Test
    public void testArcTan()
    {
        Trig trig1 = new Trig();
        assertEquals(0.463647609, trig1.calcArctan(0.5), 0.1);
    }

    @Test
    public void testArcCos()
    {
        Trig trig1 = new Trig();
        assertEquals(1.04719755, trig1.calcArccos(0.5), 0.1);
    }

    @Test
    public void testLog()
    {
        Trig trig1 = new Trig();
        assertEquals(1, trig1.calcLog(10), 0.1);
    }
}








