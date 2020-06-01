package implementation;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


/**
 * The test class TestGeneric.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestGeneric
{
    /**
     * Default constructor for test class TestGeneric
     */
    public TestGeneric()
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
     * JUnit Tests should be for automated testing only, not for manual testing (ex) Printing to the terminal).
     * 
     * Despite this, this test method was created to test and visually confirm that the list was polymorphic
     * and could hold instances of WindFarm, PowerPlant, and SolarPark.
     */
    @Test
    public void TestPrintPolymorphicList()
    {
        ArrayList<GenericFacility> array = new ArrayList<>();
        array.add(new WindFarm("Thortonbank", "Belgium", 325, 54, 2013));
        array.add(new PowerPlant("Shimane", "Japan", 137.3, 2007, -1));
        array.add(new PowerPlant("Hinkley Point C", "U.K.", 3300, 2018, 2026));
        array.add(new SolarPark("Rewa Ultra Mega Solar", "India", 750, -1, 2018));
        array.add(new WindFarm("Rampion Wind Farm", "United Kingdom", 400.0, 116, 2018));
        array.add(new SolarPark("Solar Star", "United States", 579, 13, 2015));
        array.add(new WindFarm("BARD Offshore 1", "Germany", 400.0, 80, 2013));
        array.add(new PowerPlant("Akkuyu", "Turkey", 101.4, 2015, 2023));
        array.add(new SolarPark("Mount Signal Solar", "U.S.A.", 460, 16, 2018));
        
        common.Facility.printHeader("Polymorphic List Print Test");
        for(GenericFacility facility : array) {
            facility.print();
        }
    }
}

