import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        System.out.println("Do you want to create Account ?");
        Scanner sc = new Scanner(System.in);
        String ans = sc.nextLine();
        if(ans.equalsIgnoreCase("yes")){
            //field  :  who is the provider ?

            // firstName  : --> user
            System.out.println("Enter the First Name");
            String firstName = sc.nextLine();

            //lastName : --> user
            System.out.println("Enter the Last Name");
            String lastName = sc.nextLine();
            //mobile : --> user
            System.out.println("Enter the Mobile Number");
            String mob = sc.nextLine();

            //accountNumber :  <-- bank

            //email Id; : --> user
            System.out.println("Enter the Email Id");
            String email = sc.nextLine();

            //amount  :--> user
            System.out.println("Enter the Initial Deposit amount");
            int amount = sc.nextInt();

            if(firstName.length()==0){
                throw new UserExceptionHandling("User First Name cannot Be empty!");
            }
            if(lastName.length()==0){
                throw new UserExceptionHandling("User Last Name cannot Be empty!");
            }
            if(mob.length()==0){
                throw new UserExceptionHandling("User Mobile Number cannot Be empty!");
            }
            if(email.length()==0){
                throw new UserExceptionHandling("User  Email cannot Be empty!");
            }else if(!email.contains("@")){
                throw new UserExceptionHandling("User provided Email is invalid!");
            }
            if(amount<0){
                throw new UserExceptionHandling("Invalid amount , amount must be in whole number");
            }

            // automatically generating Account number. must be unique for each account
            Random rnd = new Random();
            int accountNumber = 100000 + rnd.nextInt(900000);
//            String str="CREATE TABLE USER(First_name VARCHAR(53) NOT NULL,Last_name VARCHAR(52) NOT NULL,Mobile_no VARCHAR(52) NOT NULL,Account_no int NOT NULL,Email_id VARCHAR(52),Balance int)";
            try {
                Connection conn= DBUtils.getConnection();
                Statement st = conn.createStatement();
                String str = "insert into user(First_name,Last_name,Mobile_no,Account_no,Email_id,Balance) values('"+firstName+"','"+lastName+"','"+mob+"',"+accountNumber+",'"+email+"',"+amount+")";
                int x=st.executeUpdate(str);
                System.out.println("Account is created : "+"User Name: "+firstName+" "+lastName+" , "+" Account Number : "+accountNumber);
                conn.close();
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }
        }
        else{
            System.out.println("Enter Your account Number");
            int account =sc.nextInt();
            System.out.println("Enter 1 to Check Balance");
            System.out.println("Enter 2 to Check account details");
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

            // task you have to implement.
            // 1. and new cases like  updating details of user ?
            //2. do transaction :->  enter amount you want to debut --> you have to minus this amount from the total balance but only when the balance is enough to do trasaction
//                                    you have to print message : --> that user has debut this amount ? and remaining balance is this much.
            //3. adding amount to the account : --> enter account number and amount you want to add :
//                                            have to print message that user have credited this much amount and total balance is this much.



        }
    }
}
