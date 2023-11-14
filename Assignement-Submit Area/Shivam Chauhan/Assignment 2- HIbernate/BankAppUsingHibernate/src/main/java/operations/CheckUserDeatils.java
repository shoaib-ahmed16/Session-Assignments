package operations;

import domain.Customer;
import utils.ConnUtils;
import utils.InputTaker;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class CheckUserDeatils {

    private Scanner input= InputTaker.takeInput;
    public static void checkUserDetails() {
        Scanner input= InputTaker.takeInput;
        EntityManager em = ConnUtils.getEM();
        System.out.println("Plese Enter Account Number");
        int account = input.nextInt();
        input.nextLine();
        Customer s = (Customer) em.find(Customer.class,account );
        if (s != null) {
            System.out.println(s);
        } else {
            System.out.println("Student does not exit..");
        }
        em.close();
    }

}
