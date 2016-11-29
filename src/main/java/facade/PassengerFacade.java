package facade;

import entity.Passenger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PassengerFacade
{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("momondo");
    private static PassengerFacade instance;

    private PassengerFacade()
    {
    }

    public static PassengerFacade getInstance()
    {
        if(instance == null)
        {
            instance = new PassengerFacade();
        }
        return instance;
    }
    
    public Passenger addPassenger(Passenger p)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }
}
