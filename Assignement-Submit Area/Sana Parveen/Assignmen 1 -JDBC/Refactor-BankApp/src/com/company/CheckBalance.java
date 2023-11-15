package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckBalance {

    private static String query ="select balance from user where Account_no=";
    private static Connection conn= DBUtils.getConnection();

    public static void checkBalance(Integer accountNumber) throws SQLException {
        Statement st = conn.createStatement();
        // Similar to 2D array
        ResultSet rs=st.executeQuery(query+accountNumber); //  [2000]
        while(rs.next()) {
            System.out.println("User Account Total Balance: " + rs.getInt(1));
        }
        conn.close();

    }
}