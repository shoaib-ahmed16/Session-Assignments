package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDetails {
    private static String query ="select * from user where Account_no=";
    private static  Connection conn =DBUtils.getConnection();

    public static  void showDetails(int account)throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs=st.executeQuery(query+account);
        while(rs.next()) {
            System.out.println("User Name: " + rs.getString(1)+" "+rs.getString(2));
            System.out.println("User Mobile Number: " + rs.getString(3));
            System.out.println("User Email: " + rs.getString(5));
        }
        conn.close();
    }
}
