import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

/**
 * The test class LocationTest.
 *
 * @author  Alexi Most
 * @version 1
 */
public class LocationTest
{
    /** Location to test with */
    private Location testLocation;
    /** Customers to test with */
    Customer johnDoe;
    Customer alexiMost;
    Customer jimDandy;
    /** double allowance */
    private static double ALLOWANCE;
    
    /**
     * Default constructor for test class LocationTest
     */
    public LocationTest()
    {
        testLocation = new Location("WA01Seattle");
        ALLOWANCE = 0.00001;
        johnDoe = new Customer("John Doe", 0001112222);
        alexiMost = new Customer("Alexi Most", 0001112222);
        jimDandy = new Customer("Jim Dandy", 0000000000);
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
    public void testVaidation(){
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
        testLocation.addCustomer(johnDoe);
        // checking customer count
        assertEquals(1, testLocation.getCustomerCount());
        
        // checking getting units of type
            // no units have been specifically rented, so nothing should come up
        assertEquals(240, (testLocation.getUnits(null, null)).length);
            // there should be (4 * 20 = ) 80 locations of each type
        assertEquals(80, (testLocation.getUnits(null, Unit.Type.standard)).length);
            // rent units 
        testLocation.getUnit(0, 0).rentUnit(johnDoe, LocalDate.now(), 10.1);
        testLocation.getUnit(0, 1).rentUnit(johnDoe, LocalDate.now(), 10.1);
        assertEquals(2, (testLocation.getUnits(johnDoe, null)).length);
    }
    
    
    /**
     * tests resizing customer array
     */
    @Test
    public void testResizingCustomers(){
        
        // fill array
        for(int i = testLocation.getCustomerCount() - 1; i < 99; i++){
            testLocation.addCustomer(alexiMost);
        }
        
        // push over limit of resizing
        testLocation.addCustomer(johnDoe);
        assertEquals(johnDoe, testLocation.getCustomer(100));
    } 
    
    /**
     * tests charging monthly rent
     */
    @Test
    public void testChargingRent(){
        Unit rentingUnit = testLocation.getUnit(0, 2);
        Unit rentingUnit2 = testLocation.getUnit(0, 3);
        double testPrice = 3.4;

        // rent unit with standard price
        rentingUnit.rentUnit(jimDandy, LocalDate.now(), rentingUnit.getPrice());
        // rent unit with given price
        rentingUnit2.rentUnit(jimDandy, LocalDate.now(), testPrice);
        
        testLocation.chargeMonthlyRent();
        
        // customer's balance should now be equal to unit price
        assertEquals(rentingUnit.getPrice() + testPrice, jimDandy.getDebt(), ALLOWANCE);
        
    }
}
