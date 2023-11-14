package operations;

import domain.Customer;
import exception.CustomerException;
import utils.ConnUtils;
import utils.InputTaker;
import javax.persistence.EntityManager;
import java.util.Scanner;

public class CreateCustomer {

    private Customer cust=new Customer();
    private Scanner input= InputTaker.takeInput;

    public void create(){
        //user First_name
        System.out.println("Enter Your First Name : ");
        cust.setFirstname(input.nextLine());

        //User Last_name
        System.out.println("Enter Your Last Name : ");
        cust.setLastname(input.nextLine());

        //User Mobile_no
        System.out.println("Enter Your Mobile_no : ");
        cust.setMob(input.nextLine());

        // User email id
        System.out.println("Enter Your email_id : ");
        cust.setEmail(input.nextLine());

        //User initial Amount
        System.out.println("Enter Your Initial Amount : ");
        cust.setAmount(input.nextInt());

        //User account_no provided by the bank that why cant take input from you
        Validation(cust);
        pushingChangesTodatabase(cust);
    }
    public void Validation(Customer cust){

        if (cust.getFirstname().length()==0){
            throw new CustomerException("User First Name Can not Be Empty");
        }
        if (cust.getLastname().length() == 0) {
            throw new CustomerException("User Last Name Can not Be Empty");
        }
        if (cust.getMob().length() == 0) {
            throw new CustomerException("User Mobile No Can not Be Empty");
        }
        if (cust.getEmail().length() == 0) {
            throw new CustomerException("User email Can not Be Empty");
        } else if (!cust.getEmail().contains("@")) {
            throw new CustomerException("User provided Invalid email ");
        }
        if (cust.getAmount() < 0) {
            throw new CustomerException("Invalid amount ,it Must be in Positive Number");
        }
    }

    public void pushingChangesTodatabase(Customer cust){
        if(cust!=null){
            EntityManager em= ConnUtils.getEM();
            try {
                em.getTransaction().begin();
                em.persist(cust);
                em.getTransaction().commit();
                em.close();
                System.out.println("Customer Record is Saved Succesfully");
            }catch (Exception exc){
                throw new CustomerException(exc.getMessage());
            }
        }else
            throw new CustomerException("Customer object cannot be null");

    }
}
