package facade;

import entity.Airline;
import entity.Airport;
import entity.Flight;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FlightFacade
{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("momondo");
    private static FlightFacade instance;

    private FlightFacade()
    {
    }

    public static FlightFacade getInstance()
    {
        if (instance == null)
        {
            instance = new FlightFacade();
        }
        return instance;
    }
    
    public Flight addFlight(Flight f)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
            return f;
        } finally
        {
            em.close();
        }
    }
    
    public Flight addDestination(Flight f, Airport ap)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            ap.addArrivingFlight(f);
            f.setDestination(ap);
            em.merge(f);
            em.merge(ap);
            em.getTransaction().commit();
            return f;
        } finally
        {
            em.close();
        }
    }
    
    public Flight addOrigin(Flight f, Airport ap)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            ap.addDepartingFlight(f);
            f.setOrigin(ap);
            em.merge(f);
            em.merge(ap);
            em.getTransaction().commit();
            return f;
        } finally
        {
            em.close();
        }
    }
  
    public Flight addAirline(Flight f, Airline al)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            al.addFlight(f);
            f.setAirline(al);
            em.merge(f);
            em.merge(al);
            em.getTransaction().commit();
            return f;
        } finally
        {
            em.close();
        }
    }
}

