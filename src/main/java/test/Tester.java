package test;

import entity.Airline;
import entity.Airport;
import entity.Flight;
import facade.AirlineFacade;
import facade.AirportFacade;
import facade.FlightFacade;
import facade.ReservationFacade;
import facade.RESTFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester
{   
    static AirportFacade apf = AirportFacade.getInstance();
    static AirlineFacade alf = AirlineFacade.getInstance();
    static FlightFacade ff = FlightFacade.getInstance();
    
    public static void main(String[] args)
    {
        Build();
        Test();
    }

    public static void Build()
    {
        Persistence.generateSchema("momondo", null);
    }

    public static void Test()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("momondo");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Airport ap1 = new Airport();
        ap1.setIATACode("STN");     
        Airport ap2 = new Airport();
        ap2.setIATACode("CPH");
        Airline al1 = new Airline();
        al1.setName("SAS");
        Flight f1 = new Flight();
        f1.setFlightNumber("COL3257");
        
        System.out.println("pls");
        apf.addAirport(ap1);
        apf.addAirport(ap2);
        alf.addAirline(al1);
        ff.addFlight(f1);
        ff.addDestination(f1, ap2);
        ff.addOrigin(f1, ap1);
        ff.addAirline(f1, al1);
        System.out.println("fgt");
        em.close();
    }

    public static int giveMeTen()
    {
        return 10;
    }
}
