

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
        
        testCustomer = new Customer("Alexi Most", 0001112222);
        testUnit = new Unit(Unit.Type.standard, 4, 8, 2, 1.6);
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
        assertEquals(Unit.Type.standard, testUnit.getType());
        assertEquals(4, testUnit.getWidth());
        assertEquals(8, testUnit.getLength());
        assertEquals(2, testUnit.getHeight());
        assertEquals(null, testUnit.getCustomer());
        assertEquals(1.6, testUnit.getPrice(), ALLOWANCE);
    }
    
    
    /**
     * test renting
     */
    @Test
    public void testRenting(){
        LocalDate currentTime = LocalDate.now();
        
        testUnit.rentUnit(testCustomer, currentTime, 5.5);
        
        assertEquals(testCustomer, testUnit.getCustomer());
        assertEquals(currentTime, testUnit.getRentalDate());
        assertEquals(5.5, testUnit.getPrice(), ALLOWANCE);
    }
    
    
    /**
     * tests releasing the unit
     */
    @Test
    public void testRelease(){
        testUnit.rentUnit(testCustomer, LocalDate.now(), 5.5); // just in case it didn't get called
        testUnit.releaseUnit();
        assertEquals(null, testUnit.getCustomer());
    }
    
}
