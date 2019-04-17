

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;


/**
 * The test class UnitTest.
 *
 * @author  Alexi Most
 * @version 1
 */
public class UnitTest
{
    /** a Unit to test against */
    Unit testUnit;
    /** a Customer to test with */
    Customer testCustomer;
    /** double allowance */
    double ALLOWANCE;
    
    
    /**
     * Default constructor for test class UnitTest
     */
    public UnitTest()
    {
        ALLOWANCE = 0.00001;
        
        testCustomer = new Customer("Alexi Most", "0001112222");
        testUnit = new StandardUnit(4, 8, 2, new Location("WA01Seattle"));
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
     * tests getters
     */
    @Test
    public void testGetters(){
        assertEquals(StandardUnit.class, testUnit.getClass());
        assertEquals(4, testUnit.getWidth());
        assertEquals(8, testUnit.getLength());
        assertEquals(2, testUnit.getHeight());
        assertEquals(null, testUnit.getCustomer());
    }
    
    /**
     * tests prices
     */
    @Test
    public void testPrices(){
        Location l = new Location("WA01Seattle");
        StandardUnit s = new StandardUnit(4, 4, 2, l);
        HumidityUnit u = new HumidityUnit(4, 4, 2, l, 30);
        HumidityUnit up = new HumidityUnit(4, 4, 2, l, 29); // premium
        TemperatureUnit t = new TemperatureUnit(4, 4, 2, l, 64);
        TemperatureUnit tp = new TemperatureUnit(4, 4, 2, l, 65); // premium
        
        assertEquals(50.0 + 75, s.getPrice(), ALLOWANCE);
        assertEquals(50.0 + 4 * 4 * 5, u.getPrice(), ALLOWANCE);
        assertEquals(50.0 + 4 * 4 * 1 + 20, up.getPrice(), ALLOWANCE);
        assertEquals(50.0 + 4 * 4 * 2 * 5, t.getPrice(), ALLOWANCE);
        assertEquals(50.0 + 4 * 4 * 2 * 5 + 30, tp.getPrice(), ALLOWANCE);
    }
    
    
    /**
     * test renting
     */
    @Test
    public void testRenting(){
        LocalDate currentTime = LocalDate.now();
        
        testUnit.rentUnit(testCustomer, currentTime);
        
        assertEquals(testCustomer, testUnit.getCustomer());
        assertEquals(currentTime, testUnit.getRentalDate());
        assertEquals(5.5, testUnit.getPrice(), ALLOWANCE);
    }
    
    
    /**
     * tests releasing the unit
     */
    @Test
    public void testRelease(){
        testUnit.rentUnit(testCustomer, LocalDate.now()); // just in case it didn't get called
        testUnit.releaseUnit();
        assertEquals(null, testUnit.getCustomer());
    }
    
    /**
     * tests dimension validation
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidation(){
        StandardUnit testUnit2 = new StandardUnit(5, 4, 2, new Location("WA01Seattle"));
    }
}
