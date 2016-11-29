package facade;

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
    
    public FlightFacade addFlight(FlightFacade f)
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
}
