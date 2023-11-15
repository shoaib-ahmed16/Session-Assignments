package com.shana;


import jakarta.persistence.*;

public class HibernateConn {

    public static EntityManager conn(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("bankUnit");
        EntityManager em=emf.createEntityManager();
        return em;
    }
}
