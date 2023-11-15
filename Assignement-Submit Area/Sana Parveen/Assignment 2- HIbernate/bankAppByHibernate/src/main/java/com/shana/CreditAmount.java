package com.shana;

import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CreditAmount {

    public static void credit(){

        Scanner sc=InputTaker.getScanner();
        EntityManager em=HibernateConn.conn();
        System.out.println("Enter account no");
        int account=sc.nextInt();
        System.out.println("Enter amount u want to credit your account");
        int amount=sc.nextInt();

        if(amount>0){
            Bank bn=em.find(Bank.class,account);
            System.out.println("Current balance :"+ bn.getAmount());
            int newAmount=amount+bn.getAmount();
            bn.setAmount(newAmount);
            em.getTransaction().begin();
            em.persist(bn);
            em.getTransaction().commit();
            em.close();
            System.out.println(newAmount + " credit amount on date" + LocalDateTime.now());
            System.out.println("new credit updated");
            em.close();
        }
        else{
            throw new UserExceptionHandling("credit amount less than zero");
        }
    }
}
