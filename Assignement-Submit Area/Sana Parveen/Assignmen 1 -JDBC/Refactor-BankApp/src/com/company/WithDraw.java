package com.company;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

public class WithDraw {
    private static Scanner sc=InputTaker.getScanner();
    private static Connection conn = DBUtils.getConnection();

    private static String queryToWithDrawAmmount ="UPDATE user set balance=";
    private static String closureToUpdateAmmount =" where Account_no =";
    private static String queryToGetAmmountDetails="select balance from user where Account_no =";

    public static void withDrawAmmount(int account)throws SQLException {
        System.out.println("Enter amount :");
        int debitAmount = sc.nextInt();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(queryToGetAmmountDetails + account);
        int bal = 0;
        while (rs.next()) {
            bal = rs.getInt(1);
        }
        if(bal<debitAmount){
            throw new UserExceptionHandling("We cannot fullfill this request as the debiting amount is more then the account balance.");
        }
        bal -= debitAmount;
        st.execute(queryToWithDrawAmmount + bal + closureToUpdateAmmount + account);
        System.out.println("User account balance : " + bal);
        System.out.println("Your account has be withdraw " + debitAmount + " On date " + LocalDateTime.now());
        System.out.println("Your updated balance is " + bal);
    }
}
