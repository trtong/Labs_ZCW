

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SwitchDisplayTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SwitchDisplayTest
{
    /**
     * Default constructor for test class SwitchDisplayTest
     */
    public SwitchDisplayTest()
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
    public void toBinary()
    {
        SwitchDisplay switchDi1 = new SwitchDisplay();
        assertEquals("101101", switchDi1.toBinary(45));
    }

    @Test
    public void toOctal()
    {
        SwitchDisplay switchDi1 = new SwitchDisplay();
        assertEquals("55", switchDi1.toOctal(45));
    }

    @Test
    public void toHexa()
    {
        SwitchDisplay switchDi1 = new SwitchDisplay();
        assertEquals("2d", switchDi1.toHexa(45));
    }

    @Test
    public void toDecimal()
    {
        SwitchDisplay switchDi1 = new SwitchDisplay();
        assertEquals("45", switchDi1.toDecimal(45));
    }
}




