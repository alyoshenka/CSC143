

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

// TEST UNIT FILTERING

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
        johnDoe = new Customer("John Doe",      "0001112222");
        alexiMost = new Customer("Alexi Most",  "0001112222");
        jimDandy = new Customer("Jim Dandy",    "0001112222");
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
     * tests name validation
     */
    @Test(expected = IllegalArgumentException.class)
    public void testVaidation2(){
        Location bn2 = new Location("WA936Seattle");
    }
    
    /**
     * tests name validation
     */
    @Test(expected = IllegalArgumentException.class)
    public void testVaidation3(){
        Location bn2 = new Location("WA01seattle");
    }
    
    /**
     * tests name validation
     */
    @Test(expected = IllegalArgumentException.class)
    public void testVaidation4(){
        Location bn2 = new Location("Wa01seattle");
    }
    
    /**
     * tests name validation
     */
    @Test(expected = IllegalArgumentException.class)
    public void testVaidation5(){
        Location bn2 = new Location("Wa01Seattle7");
    }
    
    /**
     * tests methods relating to Units
     */
    public void testUnits(){
        assertEquals(StandardUnit.class, testLocation.getUnit(0, 0).getClass());
        assertEquals(HumidityUnit.class, testLocation.getUnit(10, 0).getClass());
        assertEquals(TemperatureUnit.class, testLocation.getUnit(18, 0).getClass());
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
        assertEquals(7 * 10 + 3 * 8 + 2 * 6, (testLocation.getUnits(null, null)).length);
            // there should be (7 * 10 = ) 70 locations of each type
        assertEquals(70, (testLocation.getUnits(null, StandardUnit.class)).length);
            // rent units 
        testLocation.getUnit(0, 0).rentUnit(johnDoe, LocalDate.now());
        testLocation.getUnit(0, 1).rentUnit(johnDoe, LocalDate.now());
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
     * 
     * also tests Unit -> StandardUnit cast
     */
    @Test
    public void testChargingRent(){
        StandardUnit rentingUnit = (StandardUnit)testLocation.getUnit(0, 2);
        StandardUnit rentingUnit2 = (StandardUnit)testLocation.getUnit(0, 4);

        // rent unit with standard price
        rentingUnit.rentUnit(jimDandy, LocalDate.now());
        // rent unit with given price
        rentingUnit2.rentUnit(jimDandy, LocalDate.now());
        
        testLocation.chargeMonthlyRent();
        
        // customer's balance should now be equal to unit price
        assertEquals(rentingUnit.getPrice(), jimDandy.getDebt(), ALLOWANCE);
        
    }
}