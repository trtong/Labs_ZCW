

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RealAdvancedTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RealAdvancedTest
{
    /**
     * Default constructor for test class RealAdvancedTest
     */
    public RealAdvancedTest()
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
    public void squaredTest()
    {
        RealAdvanced realAdva1 = new RealAdvanced();
        assertEquals(9.0, realAdva1.squared(3), 0.1);
    }

    @Test
    public void exponentTest()
    {
        RealAdvanced realAdva1 = new RealAdvanced();
        assertEquals(8.0, realAdva1.exponent(2, 3), 0.1);
    }

    @Test
    public void oppositeTest()
    {
        RealAdvanced realAdva1 = new RealAdvanced();
        assertEquals(2.0, realAdva1.opposite(-2), 0.1);
    }

    @Test
    public void inverseTest()
    {
        RealAdvanced realAdva1 = new RealAdvanced();
        assertEquals(0.5, realAdva1.inverse(2), 0.1);
    }

    @Test
    public void absoluteTest()
    {
        RealAdvanced realAdva1 = new RealAdvanced();
        assertEquals(4.0, realAdva1.absoluteValue(-4), 0.1);
    }

    @Test
    public void squareRootTest()
    {
        RealAdvanced realAdva1 = new RealAdvanced();
        assertEquals(5.0, realAdva1.sqrt(25), 0.1);
    }

    @Test
    public void factorialTest()
    {
        RealAdvanced realAdva1 = new RealAdvanced();
        assertEquals(120.0, realAdva1.factorial(5), 0.1);
    }
}







