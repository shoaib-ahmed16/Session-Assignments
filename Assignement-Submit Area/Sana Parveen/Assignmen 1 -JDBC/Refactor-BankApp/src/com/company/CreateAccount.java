package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class CreateAccount {

    private String firstName;
    private String lastName;
    private String mob;
    private String email;
    private int amount;
    private int accountNumber;

    private Connection conn = DBUtils.getConnection();

    public void createAccount() {
        //field  :  who is the provider ?
        Scanner sc = InputTaker.getScanner();
        // firstName  : --> user
        System.out.println("Enter the First Name");
        firstName = sc.nextLine();

        //lastName : --> user
        System.out.println("Enter the Last Name");
        lastName = sc.nextLine();
        //mobile : --> user
        System.out.println("Enter the Mobile Number");
        mob = sc.nextLine();

        //accountNumber :  <-- bank
        //email Id; : --> user
        System.out.println("Enter the Email Id");
        email = sc.nextLine();

        //amount  :--> user
        System.out.println("Enter the Initial Deposit amount");
        amount = sc.nextInt();

        // automatically generating Account number. must be unique for each account
        Random rnd = new Random();
        accountNumber = 100000 + rnd.nextInt(900000);

        // to check the enter fields are valid or not.
        validation();

        try {
            addAccountToDataBase();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }


    }

    public void validation() {
        if (this.firstName.length() == 0) {
            throw new UserExceptionHandling("User First Name cannot Be empty!");
        }
        if (this.lastName.length() == 0) {
            throw new UserExceptionHandling("User Last Name cannot Be empty!");
        }
        if (this.mob.length() == 0) {
            throw new UserExceptionHandling("User Mobile Number cannot Be empty!");
        }
        if (this.email.length() == 0) {
            throw new UserExceptionHandling("User  Email cannot Be empty!");
        } else if (!email.contains("@")) {
            throw new UserExceptionHandling("User provided Email is invalid!");
        }
        if (this.amount < 0) {
            throw new UserExceptionHandling("Invalid amount , amount must be in whole number");
        }
        if (this.accountNumber == 0) {
            throw new UserExceptionHandling("Account Number not Created.");
        }
    }

    public void addAccountToDataBase() throws SQLException {
        Statement st = conn.createStatement();
        String str = "insert into user(First_name,Last_name,Mobile_no,Account_no,Email_id,Balance) values('" + this.firstName + "','" + this.lastName + "','" + this.mob + "'," + this.accountNumber + ",'" + this.email + "'," + this.amount + ")";
        int x = st.executeUpdate(str);
        System.out.println("Account is created : " + "User Name: " + firstName + " " + lastName + " , " + " Account Number : " + accountNumber);
        conn.close();
    }
}