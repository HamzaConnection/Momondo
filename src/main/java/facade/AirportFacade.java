package facade;

import entity.Airport;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AirportFacade
{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("momondo");
    private static AirportFacade instance;

    private AirportFacade()
    {
    }

    public static AirportFacade getInstance()
    {
        if(instance == null)
        {
            instance = new AirportFacade();
        }
        return instance;
    }
   
    public Airport addAirport(Airport ap)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(ap);
            em.getTransaction().commit();
            return ap;
        } finally
        {
            em.close();
        }
    }
}
