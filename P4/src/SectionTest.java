

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SectionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SectionTest
{
    /**
     * Default constructor for test class SectionTest
     */
    public SectionTest()
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
     * tests preconditions
     */
    @Test
    public void preconds(){
        Section s = new Section("H", new ListManager<Paragraph>());
        assertTrue(s.getHeading().equals("H"));
        s = new Section(null, null);
        assertTrue(null != s.getHeading());
        assertEquals(false, s.addParagraph(null));
        s.addParagraph(new Paragraph(""));
        assertEquals(1, s.size());
    }
}
