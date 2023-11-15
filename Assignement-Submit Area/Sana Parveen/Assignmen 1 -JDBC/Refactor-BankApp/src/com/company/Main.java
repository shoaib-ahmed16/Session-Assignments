package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws Exception {
        System.out.println("Do you want to create Account ?");
        Scanner sc =InputTaker.getScanner();
        String ans = sc.nextLine();
        if(ans.equalsIgnoreCase("yes")){
            new CreateAccount().createAccount();
        }
        else{
            System.out.println("Enter Your account Number");
            int account =sc.nextInt();
            System.out.println("Enter 1 to Check Balance");
            System.out.println("Enter 2 to Check account details");
            System.out.println("Enter 3 to Update user details");
            System.out.println("Enter 4 to Credit amount");
            System.out.println("Enter 5 to Debit amount");
            int num = sc.nextInt();
            switch (num){
                case 1: {
                    CheckBalance.checkBalance(account);
                } break;
                case 2:{
                    UserDetails.showDetails(account);
                } break;
                case 3:{
                    UpdateUserDetails.updateDetails(account);
                } break;
                case 4:{
                    CreditAmount.credit(account);
                } break;
                case 5:{
                    WithDraw.withDrawAmmount(account);
                } break;
                default:{
                    throw new UserExceptionHandling("Unknown action: About which System is not aware!");
                }
            }


        }
    }
}