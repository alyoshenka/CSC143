

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the class BankAccount
 *
 * @author        Bill Barry
 * @version       2018-03-31
 */
public class BankAccountTest {

    public static final double DOLLAR_VARIANCE = 0.0001;
    
    /**
     * Default constructor for test class BankAccountTest
     */
    public BankAccountTest() {
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
    
    @Test
    public void testConstrAndGets() {
        BankAccount testAcct = new BankAccount("Joe Schmoe", "483723", 103.99);
        assertEquals("Joe Schmoe",  testAcct.getOwner());
        assertEquals("483723",      testAcct.getId());
        assertEquals(103.99,        testAcct.getBalance(),      DOLLAR_VARIANCE);
    }
    
    @Test
    public void testDepositAndWithdraw() {
        BankAccount testAcct = new BankAccount("Chris Campos", "947658", 300.0);
        assertEquals(285.03, testAcct.withdraw(14.97),      DOLLAR_VARIANCE);
        assertEquals(285.03, testAcct.getBalance(),         DOLLAR_VARIANCE);
        assertEquals(408.88, testAcct.deposit(123.85),      DOLLAR_VARIANCE);
        assertEquals(408.88, testAcct.getBalance(),         DOLLAR_VARIANCE);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testConstrBalanceNeg() {
        BankAccount testAcct = new BankAccount("Zed Zanders", "999999", -0.01);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testDepositNeg() {
        BankAccount testAcct = new BankAccount("Pat Portillo", "490378", 501.23);
        testAcct.deposit(-0.01);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testWithdrawNeg() {
        BankAccount testAcct = new BankAccount("Pat Portillo", "490378", 501.23);
        testAcct.withdraw(-0.01);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testOverdrawn() {
        BankAccount testAcct = new BankAccount("Dana Davenport", "294832", 250.00);
        testAcct.withdraw(250.01);
    }
    
}
