package com.shana;

//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
import jakarta.persistence.*;

public class HibernateConn {

    public static EntityManager conn(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("employeeUnit");
        EntityManager em=emf.createEntityManager();
        return em;
    }
}
