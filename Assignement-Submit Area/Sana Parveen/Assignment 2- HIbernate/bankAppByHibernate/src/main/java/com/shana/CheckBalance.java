package com.shana;

import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class CheckBalance {

    public static void checkBalance(){

        Scanner sc=InputTaker.getScanner();
        EntityManager em=HibernateConn.conn();
        System.out.println("Enter your account no");
        int account=sc.nextInt();

        Bank bn=em.find(Bank.class,account);
        if(bn!=null){
            System.out.println("FirstName :"+ bn.getFirstName());
            System.out.println("LastName :"+ bn.getLastName());
            System.out.println("Balance : "+ bn.getAmount());

        }
        else{
            System.out.println("account does not exist");
        }
        em.close();

    }
}
