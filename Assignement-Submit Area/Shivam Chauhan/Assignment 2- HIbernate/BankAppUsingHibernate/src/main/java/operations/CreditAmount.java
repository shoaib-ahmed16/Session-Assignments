package operations;

import domain.Customer;
import exception.CustomerException;
import utils.ConnUtils;
import utils.InputTaker;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CreditAmount {

    private static Scanner input= InputTaker.takeInput;
    public static void Creditamount() {
        EntityManager em= ConnUtils.getEM();
        System.out.println("Please enter Account Number");
        int account=input.nextInt();
        input.nextLine();
        System.out.println("Enter amount you want to credit into your account");
        int creditAmount=input.nextInt();
        if(creditAmount>0) {
            input.nextLine();
            Customer cust = (Customer) em.find(Customer.class, account);
            System.out.println("Current balance :" + cust.getAmount());
            int UpdatedAmount = creditAmount + cust.getAmount();
            cust.setAmount(UpdatedAmount);
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            em.close();
            System.out.println(UpdatedAmount+"Credited into your account on date :"+ LocalDateTime.now());
            System.out.println("done");
            em.close();
        }else{
            throw new CustomerException("credit Amount Must be Greater Than Zero");
        }
    }
}
