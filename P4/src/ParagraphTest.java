

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ParagraphTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ParagraphTest
{
    /**
     * Default constructor for test class ParagraphTest
     */
    public ParagraphTest()
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
     * tests constructor and preconditions
     */
    @Test
    public void ctorAndPre(){
        Paragraph p = new Paragraph();
        assertTrue(p.getContent().equals("New Paragraph"));
        p = new Paragraph("Test", Paragraph.ParaStyle.Heading_1);
        assertTrue(p.getContent().equals("Test"));
        assertEquals(Paragraph.ParaStyle.Heading_1, p.getStyle());
        assertEquals(false, p.setContent(null));
        p.addContent("2");
        assertTrue(p.getContent().equals("Test2"));
    }
}
