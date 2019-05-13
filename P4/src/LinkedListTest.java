

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LinkedListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LinkedListTest
{
    /**
     * Default constructor for test class LinkedListTest
     */
    public LinkedListTest()
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
     * tests constructor and size
     */
    @Test
    public void constructorTest(){
        LinkedList<Integer> list = new LinkedList<>();
        assertEquals(0, list.size());
        list.add(1);
        list.add(0);
        assertEquals(2, list.size());
        assertTrue(list.start() != null);
        assertTrue(list.end() != null);
    }
    
    /**
     * tests adding and indexing
     */
    @Test
    public void addAndIndex(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        assertEquals(0, (int)list.dataAt(0));
        assertEquals(5, (int)list.dataAt(5));
        list.addAt(0, -1);
        list.addAt(-2, list.size());
        assertEquals(-1, (int)list.dataAt(0));
        assertEquals(-2, (int)list.dataAt(7));

        assertEquals(false, list.addAt(0, -1));
        assertEquals(false, list.addAt(0, list.size() + 1));
    }
}
