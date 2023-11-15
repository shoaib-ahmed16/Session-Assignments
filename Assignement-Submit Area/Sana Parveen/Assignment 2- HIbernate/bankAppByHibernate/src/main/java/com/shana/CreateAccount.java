package com.shana;


import jakarta.persistence.*;



import java.util.Scanner;

public class CreateAccount {

    private String firstName;
    private String lastName;
    private String mob;
    private String email;
    private int amount;
//    private int accountNumber;

    public void createAccount()
    {
        Scanner sc=InputTaker.getScanner();

        System.out.println("Enter your first name : ");
        firstName=sc.nextLine();

        System.out.println("Enter your last name : ");
        lastName=sc.nextLine();

        System.out.println("Enter your mobile number : ");
        mob=sc.nextLine();

        System.out.println("Enter your email Id ");
        email=sc.nextLine();

        System.out.println("Enter your initial Deposit Amount");
        amount=sc.nextInt();



        validation();

        Bank bn=new Bank(firstName,lastName,mob,email,amount);
        pushingChangesTodatabase(bn);

    }

    public void validation(){

        if(this.firstName.length()==0){
            throw new UserExceptionHandling("User First Name cannot Be empty!");
        }
        if(this.lastName.length()==0){
            throw new UserExceptionHandling("User Last Name cannot Be empty!");
        }
        if(this.mob.length()==0){
            throw new UserExceptionHandling("User Mobile Number cannot Be empty!");
        }
        if(this.email.length()==0){
            throw new UserExceptionHandling("User  Email cannot Be empty!");
        }else if(!email.contains("@")){
            throw new UserExceptionHandling("User provided Email is invalid!");
        }
        if(this.amount<0){
            throw new UserExceptionHandling("Invalid amount , amount must be in whole number");
        }

    }

    public void pushingChangesTodatabase(Bank bn){
        if(bn!=null) {
            EntityManager em = HibernateConn.conn();
            try {
                em.getTransaction().begin();
                em.persist(bn);
                em.getTransaction().commit();
                em.close();
                System.out.println("Account Records is save successfully");
            } catch (Exception exc) {
                throw new UserExceptionHandling(exc.getMessage());
            }
        }
            else
                throw new UserExceptionHandling("bank object cannot be null");
        }
    }

