package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    public static Connection getConnection()
    {
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
      }
      catch(ClassNotFoundException cnf){
          System.out.println(cnf.getMessage());
      }

      String url="jdbc:mysql://localhost:3306/employeeApp";
      try{
          Connection conn= DriverManager.getConnection(url,"root","Passward");
          return conn;
      }
      catch(SQLException sqle){
          System.out.println(sqle.getMessage());
      }

      return null;
    }

}
