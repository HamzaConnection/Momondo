package test;

import entity.Airport;
import facade.AirportFacade;
import facade.ReservationFacade;
import facade.RESTFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester
{   
    static AirportFacade apf = AirportFacade.getInstance();
    
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
        Airport a1 = new Airport();
        a1.setIATACode("STN");
        a1.setName("London Stansted Airport");
        a1.setCity("London");
        a1.setCountry("United Kingdom");
        System.out.println("pls");
        apf.addAirport(a1);
        System.out.println(a1.getIATACode() + " added");
        em.close();
    }

    public static int giveMeTen()
    {
        return 10;
    }
}
