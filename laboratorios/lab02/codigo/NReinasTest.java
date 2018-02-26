

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NReinasTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NReinasTest
{
    /**
     * Default constructor for test class NReinasTest
     */
    public NReinasTest()
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
    
    @Test
    public void nReinasTest(){
        assertEquals((int) GraphAlgorithms.nReinas(1),1);
        assertEquals((int) GraphAlgorithms.nReinas(2),0);
        assertEquals((int) GraphAlgorithms.nReinas(3),0);
        assertEquals((int) GraphAlgorithms.nReinas(4),2);
        assertEquals((int) GraphAlgorithms.nReinas(5),10);
        assertEquals((int) GraphAlgorithms.nReinas(6),4);
        assertEquals((int) GraphAlgorithms.nReinas(7),40);
        assertEquals((int) GraphAlgorithms.nReinas(8),92);
        assertEquals((int) GraphAlgorithms.nReinas(9),352);
        assertEquals((int) GraphAlgorithms.nReinas(10),724);
        assertEquals((int) GraphAlgorithms.nReinas(11),2680);
    }
}
