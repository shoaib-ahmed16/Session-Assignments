package com.shana;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        System.out.println("Do you want to create Account ?");
        Scanner sc=InputTaker.getScanner();
        String ans=sc.nextLine();

        if(ans.equalsIgnoreCase("yes")){
            new CreateAccount().createAccount();
        }
        else
        {
            System.out.println("Enter your account Number");
            int accountNumber=sc.nextInt();
            System.out.println("Enter 1 to Check Balance");
            System.out.println("Enter 2 to Check account details");
            System.out.println("Enter 3 to Update user details");
            System.out.println("Enter 4 to Credit amount ");
            System.out.println("Enter 5 to Debit amount");
            int num=sc.nextInt();
            switch (num){
                case 1:{
                    CheckBalance.checkBalance();
                }
                break;
                case 2:{
                    UserDetails.showDetails();
                }
                break;
                case 3:{
                    UpdateUserDetails.updateDetails();
                }
                break;
                case 4:{
                    CreditAmount.credit();
                }
                break;
                case 5:{
                    WithDraw.withDrawAmount();
                }
                break;
                default:{
                    throw new UserExceptionHandling("unkown action:about which system is not aware");
                }
            }
        }

    }

}




