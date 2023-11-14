package operations;

import domain.Customer;
import utils.ConnUtils;
import utils.InputTaker;
import javax.persistence.EntityManager;
import java.util.Scanner;
public class UpdateUserDetails {
    static Scanner input= InputTaker.takeInput;

public static void UpdateuserDetails(){

    EntityManager em= ConnUtils.getEM();

    System.out.println("Enter a to update Mobile Number");
    System.out.println("Enter b to update Email Id");
    String answer=input.nextLine();
    System.out.println("Enter Account Number");
    int account=input.nextInt();
    input.nextLine();


    if (answer.equalsIgnoreCase("a")) {
        Customer cust=(Customer) em.find(Customer.class,account );
        System.out.println("Enter Mobile Number you Want to Update");
        cust.setMob(input.nextLine());
        em.getTransaction().begin();
        em.persist(cust);
        em.getTransaction().commit();
        em.close();
        System.out.println("done");
        em.close();
    } else {
        Customer cust=(Customer) em.find(Customer.class,account );
        System.out.println("Enter Email Id you Want to Update");
        cust.setEmail(input.nextLine());
        em.getTransaction().begin();
        em.persist(cust);
        em.getTransaction().commit();
        em.close();
        System.out.println("done");
        em.close();
    }
}
}

