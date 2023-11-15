package com.shana;

import jakarta.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class WithDraw {

    public static void withDrawAmount() {

        Scanner sc = InputTaker.getScanner();
        EntityManager em = HibernateConn.conn();
        System.out.println("Enter account no");
        int account = sc.nextInt();
        System.out.println("Enter amount u want to withdraw your account");
        int amount = sc.nextInt();

        Bank bn = em.find(Bank.class, account);
        int currentamount = bn.getAmount();


        if (amount > 0 && currentamount >= amount) {
            int newAmount = currentamount - amount;
            bn.setAmount(newAmount);
            em.getTransaction().begin();
            em.persist(bn);
            em.getTransaction().commit();
            em.close();
            System.out.println(newAmount + " withdraw amount on date" + LocalDateTime.now());
            System.out.println("new updated amount" + newAmount);
            System.out.println("amount update");
            em.close();
        }
    }
}
