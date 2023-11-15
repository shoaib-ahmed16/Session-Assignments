package com.shana;

import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class UserDetails {

    public static void showDetails(){

        Scanner sc=InputTaker.getScanner();
        EntityManager em= HibernateConn.conn();
        System.out.println("Enter account no");
        int account=sc.nextInt();


        Bank bn=em.find(Bank.class,account);
        if(bn!=null){
            System.out.println(bn);
        }
        else{
            System.out.println("Account not exist" );
        }
        em.close();

    }
}
