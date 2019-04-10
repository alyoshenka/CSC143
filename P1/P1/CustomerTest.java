

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerTest.
 *
 * @author  Alexi Most
 * @version 1
 */
public class CustomerTest
{
    Customer testCustomer;
    double VARIANCE;
    
    /**
     * Default constructor for test class CustomerTest
     */
    public CustomerTest()
    {
        testCustomer = new Customer("Alexi Most", 0001112222);
        VARIANCE = 0.00001;
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
     * Test Constructor and Gets 
     */
    @Test
    public void constructorsAndGets(){
        assertEquals("Alexi Most", testCustomer.getName());
        assertEquals(0001112222, testCustomer.getPhone());                
    }
    
    
    /**
     * Tests phone validation
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPhoneValidation(){
        Customer customer = new Customer("Alexi Most", 987);
    }
    
    
    /**
     * Tests charge validation
     */
    @Test(expected = IllegalArgumentException.class)
    public void chargeValid(){
        testCustomer.charge(-0.1);
    }
    
    
    /**
     * Tests credit validation
     */
    @Test(expected = IllegalArgumentException.class)
    public void creditValid(){
        testCustomer.credit(-0.1);
    }
    
    
    /**
     * tests charging and crediting
     */
    @Test
    public void testMoney(){
        testCustomer.charge(5.0);
        testCustomer.credit(3.5);
        assertEquals(1.5, testCustomer.getDebt(), VARIANCE);
    }
    
    
    /**
     * Displays string representation for visual appraisal
     */
    public void testString(){
        System.out.println(testCustomer.toString());
    }
}
