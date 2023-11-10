import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
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
            Connection conn= DBUtils.getConnection();
            if(num==1){
                String str ="select balance from user where Account_no="+account;
                try {
                    Statement st = conn.createStatement();
                    // Similar to 2D array
                    ResultSet rs=st.executeQuery(str); //  [2000]
                    while(rs.next())
                    System.out.println("User Account Total Balance: "+rs.getInt(1));
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                }
            }
            if(num ==2){
                String str ="select * from user where Account_no="+account;
                try {
                    Statement st = conn.createStatement();
                    ResultSet rs=st.executeQuery(str);
                    while(rs.next()) {
                        System.out.println("User Name: " + rs.getString(1)+" "+rs.getString(2));
                        System.out.println("User Mobile Number: " + rs.getString(3));
                        System.out.println("User Email: " + rs.getString(5));
                    }
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                }
            }
            if(num==4){
                System.out.println("Enter amount :");
                int addAmount =sc.nextInt();
                try {
                    String get = "select balance from user where Account_no ="+account;
                    Statement st = conn.createStatement();
                    ResultSet rs=st.executeQuery(get);
                    int bal=0;
                    while(rs.next()){
                        bal=rs.getInt(1);
                    }
                    bal +=addAmount;
                    String set ="UPDATE user set balance="+bal +" where Account_no ="+account;
                            st.execute(set);
                    System.out.println("User account balance : "+bal);
                    System.out.println("Your account has be credited "+addAmount+" On date "+ LocalDateTime.now());
                    System.out.println("Your updated balance is "+bal);
                }catch(SQLException sql){
                    System.out.println(sql.getMessage());
                }
            }
            if(num==5){
                System.out.println("Enter amount :");
                int debitAmount =sc.nextInt();
                try {
                    String get = "select balance from user where Account_no ="+account;
                    Statement st = conn.createStatement();
                    ResultSet rs=st.executeQuery(get);
                    int bal=0;
                    while(rs.next()){
                        bal=rs.getInt(1);
                    }
                    if(bal<debitAmount){
                        System.out.println("We cannot fullfill this request as the debiting amount is more then the account balance.");
                        return;
                    }
                    bal-=debitAmount;
                    String set ="UPDATE user set balance="+bal +" where Account_no ="+account;
                        st.execute(set);
                    System.out.println("User account balance : "+bal);
                    System.out.println("Your account has be Debited "+debitAmount+" On date "+ LocalDateTime.now());
                    System.out.println("Your updated balance is "+bal);

                }catch(SQLException sql){
                    System.out.println(sql.getMessage());
                }
            }
            if(num==3){
                sc.nextLine();
                System.out.println("Enter a if you want to update the Account Email ID");
                System.out.println("Enter b if you want to update the Account Mobile Number");
                String updateField = sc.nextLine();
                if(updateField.equalsIgnoreCase("a")){
                    System.out.println("Enter Updated Email:");
                    String email =sc.nextLine();
                    String set ="UPDATE user set Email_id='"+email +"' where Account_no ="+account;
                    try {
                        Statement st = conn.createStatement();
                        int x = st.executeUpdate(set);
                        if(x>0){
                            System.out.println("User Email is updated!!!");
                        }else{
                            System.out.println("Unknown Server error!!!");
                            return;
                        }
                        System.out.println("Your account Email is update To "+email+" On date "+ LocalDateTime.now());
                    }catch(SQLException sql){
                        System.out.println(sql.getMessage());
                    }

                }
                if(updateField.equalsIgnoreCase("b")){
                    System.out.println("Enter Updated Mobile:");
                    String mobile =sc.nextLine();
                    String set ="UPDATE user set Mobile_no='"+mobile +"' where Account_no ="+account;
                    try {
                        Statement st = conn.createStatement();
                        int x = st.executeUpdate(set);
                        if(x>0){
                            System.out.println("User Mobile Number is updated!!!");
                        }else{
                            System.out.println("Unknown Server error!!!");
                            return;
                        }
                        System.out.println("Your account Email is update To "+mobile+" On date "+ LocalDateTime.now());
                    }catch(SQLException sql){
                        System.out.println(sql.getMessage());
                    }
                }
            }

        }
    }
}
