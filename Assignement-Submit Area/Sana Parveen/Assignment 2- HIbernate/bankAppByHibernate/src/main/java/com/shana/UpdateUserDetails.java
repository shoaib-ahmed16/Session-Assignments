package com.shana;

import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class UpdateUserDetails {

    public static void updateDetails(){

        Scanner sc=InputTaker.getScanner();
        EntityManager em=HibernateConn.conn();

        System.out.println("Enter a to update Email id");
        System.out.println("Enter b to update mobile no");
        String ans=sc.nextLine();
        System.out.println("Enter account no");
        int account=sc.nextInt();
        sc.nextLine();

        if(ans.equalsIgnoreCase("a")){

            Bank bn=em.find(Bank.class,account);
            System.out.println("Enter your new Email id ");
            String a=sc.nextLine();
            bn.setEmail(a);
            em.getTransaction().begin();
            em.persist(bn);
            em.getTransaction().commit();
            em.close();
            System.out.println("new email updated");
        }
        else{
                Bank bn=em.find(Bank.class,account);
                System.out.println("Enter your new mob no ");
                String b=sc.nextLine();
                bn.setMob(b);
                em.getTransaction().begin();
                em.persist(bn);
                em.getTransaction().commit();
                em.close();
                System.out.println("new mob no updated");
        }

    }
}
