

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BankTest.
 *
 * @author      Bill Barry
 * @version     2019-03-27
 */
public class BankTest {

    public static final double PCT_ALLOW    = 0.000001;
    public static final double DOLLAR_ALLOW = 0.0001;
    
    /**
     * Default constructor for test class BankTest
     */
    public BankTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

    //---------------------------------------------------
    //          HAPPY PATH TESTS
    //---------------------------------------------------
    
    @Test
    public void testConstructorAndMutators() {
        final double INT_RATE = 0.035;
        Bank testBank = new Bank(INT_RATE);
        assertEquals(INT_RATE, testBank.getInterestRate(), PCT_ALLOW);

        testBank.setInterestRate(0.052);
        assertEquals(0.052, testBank.getInterestRate(), PCT_ALLOW);
    }
    
    @Test
    public void testOpenCloseGetAccount() {
        final double INT_RATE = 0.041;
        Bank testBank = new Bank(INT_RATE);
        BankAccount testAcct = new BankAccount("Joe Schmoe", "12345", 432.18);
        testBank.openAccount(testAcct);
        
        assertEquals(testAcct,  testBank.getAccount("12345"));
        assertEquals(null,      testBank.getAccount("23456"));
        testBank.closeAccount(testAcct);
        assertEquals(null,      testBank.getAccount("12345"));
    }
    
    
    @Test
    public void testGetTotalBalance() {
        final double INT_RATE = 0.198;
        Bank testBank = new Bank(INT_RATE);
        BankAccount testAcct1 = new BankAccount("Joe Schmoe", "12345", 432.18);
        BankAccount testAcct2 = new BankAccount("Dana David", "23456", 748.25);
        testBank.openAccount(testAcct1);
        testBank.openAccount(testAcct2);
        assertEquals(432.18 + 748.25,   testBank.getTotalBalance(), DOLLAR_ALLOW);
    }

    @Test
    public void testGetAcctsBelow() {
        final double INT_RATE = 0.198;
        Bank testBank = new Bank(INT_RATE);
        BankAccount testAcct1 = new BankAccount("Joe Schmoe", "12345", 499.99);
        BankAccount testAcct2 = new BankAccount("Dana David", "23456", 500.00);
        BankAccount testAcct3 = new BankAccount("Dana David", "23456", 123.56);
        testBank.openAccount(testAcct1);
        testBank.openAccount(testAcct2);
        testBank.openAccount(testAcct3);
        
        BankAccount[] acctsBelow500 = testBank.getAcctsBelowAmt(500.00);
        assertEquals(2,             acctsBelow500.length);
        assertEquals(testAcct1,     acctsBelow500[0]);
        assertEquals(testAcct3,     acctsBelow500[1]);
    }

    //---------------------------------------------------
    //          TESTS THAT YIELD EXCEPTIONS
    //          Note:  only ONE precondition test allowed per test case
    //---------------------------------------------------

    @Test (expected = IllegalArgumentException.class) 
    public void testInterestRateTooLow() {
        Bank testBank = new Bank(-0.001);
    }
        
    @Test (expected = IllegalArgumentException.class) 
    public void testInterestRateTooHigh() {
        Bank testBank = new Bank(1.0);
    }
    
}
