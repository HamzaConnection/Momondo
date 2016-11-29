package facade;

import entity.Airline;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AirlineFacade
{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("momondo");
    private static AirlineFacade instance;

    private AirlineFacade()
    {
    }

    public static AirlineFacade getInstance()
    {
        if (instance == null)
        {
            instance = new AirlineFacade();
        }
        return instance;
    }

    public Airline addAirline(Airline al)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(al);
            em.getTransaction().commit();
            return al;
        } finally
        {
            em.close();
        }
    }
}
