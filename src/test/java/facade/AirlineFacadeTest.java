package facade;

import entity.Airline;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AirlineFacadeTest
{
    
    public AirlineFacadeTest()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    @Test
    public void testAddAirline()
    {
        System.out.println("addAirline");
        Airline al = new Airline();
        AirlineFacade instance = AirlineFacade.getInstance();
        al = instance.addAirline(al);
        int result = al.getAirlineID();
        assertEquals(1, result);
    }   
}
