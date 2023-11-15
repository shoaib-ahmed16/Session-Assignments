package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CreditAmount {
    private static Scanner sc=InputTaker.getScanner();
    private static Connection conn = DBUtils.getConnection();

    private static String queryToCreditAmmount ="UPDATE user set balance=";
    private static String closureToUpdateAmmount =" where Account_no =";
    private static String queryToGetAmmountDetails="select balance from user where Account_no =";
    public static void credit(int account)throws SQLException {
        System.out.println("Enter amount :");
        int addAmount = sc.nextInt();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(queryToGetAmmountDetails + account);
        int bal = 0;
        while (rs.next()) {
            bal = rs.getInt(1);
        }
        bal += addAmount;
        st.execute(queryToCreditAmmount + bal + closureToUpdateAmmount + account);
        System.out.println("User account balance : " + bal);
        System.out.println("Your account has be credited " + addAmount + " On date " + LocalDateTime.now());
        System.out.println("Your updated balance is " + bal);
    }
}
