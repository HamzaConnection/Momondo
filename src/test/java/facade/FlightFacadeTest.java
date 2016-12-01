package facade;

import entity.Airline;
import entity.Airport;
import entity.Flight;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FlightFacadeTest
{
    
    public FlightFacadeTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
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
    public void testAddDestination()
    {
        System.out.println("addDestination");
        Flight f = new Flight();
        Airport ap = new Airport();
        FlightFacade ff = FlightFacade.getInstance();
        AirportFacade apf = AirportFacade.getInstance();
        ap = apf.addAirport(ap);
        f = ff.addFlight(f);
        f = ff.addDestination(f, ap);
        int expResult = ap.getAirportID();
        int result = f.getDestination().getAirportID();
        assertEquals(result, expResult);
        System.out.println(result+" = "+expResult);
    }

    @Test
    public void testAddOrigin()
    {
        System.out.println("addOrigin");
        Flight f = new Flight();
        Airport ap = new Airport();
        FlightFacade ff = FlightFacade.getInstance();
        AirportFacade apf = AirportFacade.getInstance();
        ap = apf.addAirport(ap);
        f = ff.addFlight(f);
        f = ff.addOrigin(f, ap);
        int expResult = ap.getAirportID();
        int result = f.getOrigin().getAirportID();
        assertEquals(result, expResult);
        System.out.println(result+" = "+expResult);
    }
    
    @Test
    public void testAddAirline()
    {
        System.out.println("addAirline");
        Flight f = new Flight();
        Airline al = new Airline();
        FlightFacade ff = FlightFacade.getInstance();
        AirlineFacade alf = AirlineFacade.getInstance();
        al = alf.addAirline(al);
        f = ff.addAirline(f, al);
        int expResult = al.getAirlineID();
        int result = f.getAirline().getAirlineID();
        assertEquals(result, expResult);
        System.out.println(result+" = "+expResult);
    }
}
