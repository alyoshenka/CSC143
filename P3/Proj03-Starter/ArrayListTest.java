

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * The test class ArrayListTest.
 *
 * @author  Alexi Most
 * @version 1
 */
public class ArrayListTest {
    /**
     * Default constructor for test class ArrayListTest
     */
    public ArrayListTest() {
    }

    /**
     * Sets up the test fixture.
     * <p>
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     * <p>
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

    /**
     * tests constructor and preconditions within
     */
    @Test
    public void testConstructor() {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>(-1);
        ArrayList<Integer> c = new ArrayList<Integer>(0);

        assertEquals(a.size(), 0);
        assertEquals(b.size(), 0);
        assertEquals(c.size(), 0);
    }

    /**
     * tests adding and getting
     */
    @Test
    public void testAdding() {
        ArrayList<Point> list = new ArrayList<>();
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,0);
        Point p3 = new Point(0,0);
        Point p4 = new Point(0,0);
        assertTrue(list.isEmpty());
        list.add(p1);
        list.add(p2);
        list.add(p3);
        assertEquals(p1, list.get(2));
        list.add(p4, 2);
        assertEquals(p4, list.get(2));
        assertTrue(list.contains(p4));
        assertEquals(0, list.indexOf(p1));
    }

    /**
     * tests removing and clearing
     */
    @Test
    public void testRemoving() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.remove(1);
        assertEquals(3, list.size());
        assertEquals(null, list.get(1));
        list.clear();
        assertTrue(list.isEmpty());
    }

    /**
     * tests ensure capacity
     */
    @Test
    public void testResize() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        assertEquals(3, list.size());
        list.ensureCapacity(100);
    }

    /**
     * tests iterator
     */
    @Test
    public void testIterator(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        for(Iterator it = list.iterator(); it.hasNext();){
            System.out.println(it.next());
            it.remove();
        }
        list.compressNulls();
        assertTrue(list.isEmpty());
    }

    /**
     * tests compressNulls
     */
    @Test
    public void testCompressNulls(){
        ArrayList<Point> list = new ArrayList<>();
        list.add(null);
        list.add(new Point(0,0));
        list.add(new Point(0,0));
        list.add(null);
        list.add(new Point(0,0));
        list.add(new Point(0,0));
        list.add(null);
        assertEquals(7, list.size());
        list.compressNulls();
        assertEquals(4, list.size());
        assertEquals(null, list.get(4));
    }

}
