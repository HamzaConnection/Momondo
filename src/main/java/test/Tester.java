package test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester
{

    public static void main(String[] args)
    {
        Test();
    }

    public static void Test()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("momondo");
        EntityManager em = emf.createEntityManager();
        //em.getTransaction().begin();
        //Object b = new Object("params");
        //em.persist(b);
        
        
    }
}
