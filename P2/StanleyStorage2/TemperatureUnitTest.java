

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TemperatureUnitTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TemperatureUnitTest
{
    /**
     * Default constructor for test class TemperatureUnitTest
     */
    public TemperatureUnitTest()
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
    
    /**
     * tests validation
     * 
     * other tests have been run in humidityunit
     */
    @Test(expected = IllegalArgumentException.class)
    public void validation(){
        TemperatureUnit t = new TemperatureUnit(4, 4, 2, new Location("WA01Seattle"), 71);
    }
}
