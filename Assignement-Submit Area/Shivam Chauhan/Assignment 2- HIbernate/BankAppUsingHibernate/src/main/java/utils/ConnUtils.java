package utils;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnUtils {

    public static EntityManager getEM() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BankUnit");
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
