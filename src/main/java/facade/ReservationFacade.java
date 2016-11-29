package facade;

import entity.Reservation;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReservationFacade
{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("momondo");
    private static ReservationFacade instance;

    private ReservationFacade()
    {
    }

    public static ReservationFacade getInstance()
    {
        if (instance == null)
        {
            instance = new ReservationFacade();
        }
        return instance;
    }

    public Reservation addReservation(Reservation r)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
            return r;
        } finally
        {
            em.close();
        }
    }
}
