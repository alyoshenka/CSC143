import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

/**
 * The test class LocationTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LocationTest
{
    /** Location to test with */
    private Location testLocation;
    
    /**
     * Default constructor for test class LocationTest
     */
    public LocationTest()
    {
        testLocation = new Location("WA01Seattle");
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
     * Tests constructor
     */
    @Test
    public void testConstructor(){
        assertEquals("WA01Seattle", testLocation.getName());
        assertEquals(0, testLocation.getCustomerCount());
    }
    
    /**
     * tests name validation
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetters(){
        Location badNameLocation = new Location("badName");
    }
    
    /**
     * tests methods relating to Units
     */
    public void testUnits(){
        assertEquals(Unit.Type.standard, testLocation.getUnit(8, 0));
    }
    
    /**
     * tests methods relating to customers
     */
    @Test
    public void testCustomers(){
        // adding a new customer
        testLocation.addCustomer(new Customer("John Doe", 0001112222));
        // checking customer count
        assertEquals(1, testLocation.getCustomerCount());
        // checking getting units of type
            // no units have been specifically rented, so nothing should come up
        assertEquals(0, testLocation.getUnits(new Customer("John Doe", 0001112222), Unit.Type.standard));
            // there should be (4 * 20 = ) 80 locations of each type
        assertEquals(80, testLocation.getUnits(null, Unit.Type.standard));
            // rent units 
        Customer jimDandy = new Customer("Jim Dandy", 0000000000);
        testLocation.getUnit(0, 0).rentUnit(jimDandy, LocalDate.now(), 10.1);
        testLocation.getUnit(0, 1).rentUnit(jimDandy, LocalDate.now(), 10.1);
        assertEquals(2, testLocation.getUnits(jimDandy, null));
    }
    
    
    /**
     * tests resizing customer array
     */
    @Test
    public void testResizingCustomers(){
        
        // fill array
        for(int i = testLocation.getCustomerCount() - 1; i < 100; i++){
            testLocation.addCustomer(new Customer("Alexi Most", 0001112222));
        }
        
        // push over limt of resizing
        testLocation.addCustomer(new Customer("Jane Doe", 0001112222));
        assertEquals("Jane Doe", testLocation.getCustomer(100).getName());
    } 
    
    /**
     * tests charging monthly rent
     */
    @Test
    public void testChargingRent(){
        
    }
}
