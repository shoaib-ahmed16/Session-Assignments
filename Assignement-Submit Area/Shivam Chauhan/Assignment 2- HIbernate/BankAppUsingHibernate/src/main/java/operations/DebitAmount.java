package operations;

import domain.Customer;
import utils.ConnUtils;
import utils.InputTaker;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

import java.util.Scanner;

public class DebitAmount {
    private static Scanner input= InputTaker.takeInput;

    public static void DebitAmount(){
        EntityManager em= ConnUtils.getEM();
        System.out.println("Please enter Account Number");
        int account=input.nextInt();
        input.nextLine();
        System.out.println("Enter amount you want to debit from your account");
        int debitAmount=input.nextInt();
        Customer cust = (Customer) em.find(Customer.class, account);
        int CurrentBalance=cust.getAmount();
        System.out.println("Currrent Balance :"+CurrentBalance);
        if(CurrentBalance>=debitAmount && debitAmount>0){
            int UpDatedBalnace=CurrentBalance-debitAmount;
            cust.setAmount(UpDatedBalnace);
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            System.out.println(debitAmount+"debited From your account on date"+ LocalDateTime.now());
            System.out.println("New Updated Amount:"+UpDatedBalnace);
            System.out.println("done");
            em.close();
        }
    }
}
