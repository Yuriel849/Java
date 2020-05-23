package implementation;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PowerPlantTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PowerPlantTest
{
    /**
     * Default constructor for test class PowerPlantTest
     */
    public PowerPlantTest()
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
    public void testConstructor()
    {
        implementation.PowerPlant powerPla1 = new implementation.PowerPlant("Future03", "Germany", 3000, 2020, 2045);
        assertEquals(powerPla1.getName(), "Future03");
        assertEquals(powerPla1.getCountry(), "Germany");
        assertEquals(powerPla1.getCapacity(), 3000, 0.1);
        assertEquals(powerPla1.getConstructionStart(), 2020);
        assertEquals(powerPla1.getConnectionYear(), 2045);
    }
}

