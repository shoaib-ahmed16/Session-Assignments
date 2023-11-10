package com.shoaib.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBEMUtils {

    public static EntityManager getEM(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentUnit");
        EntityManager em= emf.createEntityManager();
        return em;
    }
}
