

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HumidityUnitTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HumidityUnitTest
{
    /**
     * Default constructor for test class HumidityUnitTest
     */
    public HumidityUnitTest()
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
     * tests constructor and getter
     */
    @Test
    public void constrAndGetter(){
        HumidityUnit h = new HumidityUnit(4, 4, 2, new Location("WA01Seattle"), 20);
        assertEquals(20, h.getHumidity());
    }
    
    /**
     * tests setter
     */
    @Test
    public void setter(){
        HumidityUnit h = new HumidityUnit(4, 4, 2, new Location("WA01Seattle"), 20);
        h.setHumidity(60);
        assertEquals(60, h.getHumidity());
    }
    
    /**
     * tests humidity validation
     */
    @Test(expected = IllegalArgumentException.class)
    public void validation(){
        HumidityUnit h = new HumidityUnit(4, 4, 2, new Location("WA01Seattle"), 19);
    }
}

