package operations;

import domain.Customer;
import utils.ConnUtils;
import utils.InputTaker;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class CheckAccountBalance {

    private Scanner input= InputTaker.takeInput;
    public static void CheckAccountBalance() {
        Scanner input= InputTaker.takeInput;
        EntityManager em = ConnUtils.getEM();
        System.out.println("Plese Enter Account Number");
         int account = input.nextInt();
        input.nextLine();
        Customer s = (Customer) em.find(Customer.class,account );
        if (s != null) {
            System.out.println("First_Name :"+ s.getFirstname());
            System.out.println("Last_name :"+ s.getLastname());
            System.out.println("Current Account Balance :"+ s.getAmount());

        } else {
            System.out.println("Student does not exit..");
        }
        em.close();
    }
}

