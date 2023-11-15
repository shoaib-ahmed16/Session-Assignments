package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
    public static Connection getConnection(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception exc){
            System.out.println(exc.getMessage());
        }
        try{
            String url ="jdbc:mysql://localhost:3306/shanabankapp";
            conn= DriverManager.getConnection(url,"root","Passward");
        }catch(Exception exc){
            System.out.println(exc.getMessage());
        }
        return conn;
    }
}
