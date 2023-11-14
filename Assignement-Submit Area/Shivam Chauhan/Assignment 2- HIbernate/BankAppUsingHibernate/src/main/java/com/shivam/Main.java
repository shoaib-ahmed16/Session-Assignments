package com.shivam;

import operations.*;
import utils.InputTaker;

import java.util.Scanner;

public class Main {
    private static Scanner input= InputTaker.takeInput;
    public static void main(String[] args) {
       System.out.println("Do want to add new New customer to bank");
       System.out.println("Enter Yes/No");
       String opt1=input.nextLine();
       if(opt1.equalsIgnoreCase("yes")){
           new CreateCustomer().create();
       }
       else{
           System.out.println("Choose options : ");
           System.out.println("Please enter 1 to Check the User Account Balance");
           System.out.println("Please enter 2 to Check the User Details");
           System.out.println("Please enter 3 to Update user Details");
           System.out.println("Please enter 4 to credit amount into account");
           System.out.println("Please enter 5 to debit amount from account");
           int answer=input.nextInt();
           input.nextLine();

           switch (answer){
               case 1:{
                   CheckAccountBalance.CheckAccountBalance();
                   break;
               }
               case 2:{
                   CheckUserDeatils.checkUserDetails();
                   break;
               }
               case 3:{
                   UpdateUserDetails.UpdateuserDetails();
               }
               case 4:{
                   CreditAmount.Creditamount();
               }
               case 5:{
                   DebitAmount.DebitAmount();
               }
               }
       }
    }
}