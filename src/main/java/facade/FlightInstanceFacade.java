package facade;

import entity.Flight;
import entity.FlightInstance;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FlightInstanceFacade
{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("momondo");
    private static FlightInstanceFacade instance;

    private FlightInstanceFacade()
    {
    }

    public static FlightInstanceFacade getInstance()
    {
        if (instance == null)
        {
            instance = new FlightInstanceFacade();
        }
        return instance;
    }

    public FlightInstance addFlightInstance(FlightInstance fi)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(fi);
            em.getTransaction().commit();
            return fi;
        } finally
        {
            em.close();
        }
    }
    
    public FlightInstance addFlightInstance(FlightInstance fi, Flight f)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            fi.addFlight(f);
            f.addFlightInstance(fi);
            em.merge(fi);
            em.merge(f);
            em.getTransaction().commit();
            return fi;
        } finally
        {
            em.close();
        }
    }
}
