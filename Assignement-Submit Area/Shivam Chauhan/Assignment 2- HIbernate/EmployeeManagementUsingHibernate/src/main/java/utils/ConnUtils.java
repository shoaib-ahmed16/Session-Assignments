package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnUtils {
    public static EntityManager getEm(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("EmployeeUnit");
        EntityManager em=emf.createEntityManager();
        return em;
    }
}
