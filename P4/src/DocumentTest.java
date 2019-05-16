

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DocumentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DocumentTest
{
    /**
     * Default constructor for test class DocumentTest
     */
    public DocumentTest()
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
        Document d = Document.getInstance();
        if(null != d){
            d.close();
        }
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
     * tests managing the instance
     */
    @Test
    public void testInstance(){
        Document d = Document.getInstance();
        assertEquals(null, d);
        d = Document.newDocument("d");
        assertTrue(null != d);
        d.close();
        assertEquals(null, Document.getInstance());
    }
    
    /**
     * save with no open doc
     */
    @Test (expected = IllegalStateException.class)
    public void badSave(){
        Document d = Document.getInstance();
        d = Document.newDocument("d");
        d.close();
        d.save();
    }
    
    /**
     * html save with no open doc 
     */
    @Test (expected = IllegalStateException.class)
    public void badSaveHTML(){
        Document d = Document.newDocument("d");
        d.close();
        d.saveToHTML();
    }
    
    /**
     * tries to make new with already open file
     */
    @Test (expected = IllegalStateException.class)
    public void badNew(){
        Document d = Document.newDocument("d");
        d = Document.newDocument("d");
    }
    
    /**
     * tries to open with already open file
     */
    @Test
    public void badOpen(){
        Document d = Document.getInstance();
        d = Document.newDocument("d");
        assertEquals(false, d.open(new java.io.File("f")));
    }
    
    /**
     * tests catches
     */
    @Test
    public void catches(){
        Document d = Document.getInstance();
        d = Document.newDocument("d");
        d.close();
        assertEquals(false, d.open(new java.io.File("notAPath")));
    }
}
