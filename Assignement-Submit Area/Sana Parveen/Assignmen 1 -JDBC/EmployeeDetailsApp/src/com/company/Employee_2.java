package com.company;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Employee_2 implements Employee{

    int EmployeeId;
    String FirstName;
    String LastName;
    int Salary;
    int Age;
    String Department;
    String ManagerName;
    String JoiningDate;
    String MaritialStatus;
    String DateofBirth;

    Scanner sc=InputTaker.input();

    public static void addEmployee( Employee_2 em2){
        validate(em2);
        try{
            addEmployeeToDataBase(em2);
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }


    public static void validate(Employee_2 em2){

        if(em2.EmployeeId==0)
        {
            throw new Exception("EmployeeId id not correct");
        }
        if(em2.FirstName.length()==0)
        {
            throw new Exception("Employee first Name not empty");
        }
        if(em2.LastName.length()==0)
        {
            throw new Exception("Employee first Name not empty");
        }
        if(em2.Salary<0)
        {
            throw new Exception("Incorrect Amount");
        }
        if(em2.Age<18)
        {
            throw new Exception("Age is not valid");
        }
        if(em2.Department.length()==0)
        {
            throw new Exception("Department Name is not empty");
        }
        if(em2.JoiningDate.length()==0)
        {
            throw new Exception("joining date cannot be empty");
        }
        if(em2.MaritialStatus.length()==0)
        {
            throw new Exception("Maritial ststus is not empty");
        }
        if(em2.DateofBirth.length()==0)
        {
            throw new Exception("Date of Birth is not empty");
        }
    }

    public static void addEmployeeToDataBase(Employee_2 em2) throws SQLException{

        Connection conn=JdbcConnection.getConnection();
//        String createTable= "CREATE TABLE Employee (EmployeeId INT PRIMARY KEY, FirstName VARCHAR(30) NOT NULL, LastName VARCHAR(30) NOT NULL,Age INT NOT NULL,Department VARCHAR(30) NOT NULL,ManagerName VARCHAR(30) NOT NULL, JoiningDate DATE NOT NULL, Salary INT NOT NULL,  MaritialStatus VARCHAR(20) NOT NULL, DateofBirth VARCHAR(30) NOT NULL)";

        String insertValue="INSERT INTO Employee(EmployeeId,FirstName,LastName,Age,Department,ManagerName,JoiningDate,Salary,MaritialStatus,DateofBirth) VALUES( ?,?,?,?,?,?,?,?,?,?)";

//        PreparedStatement pps=conn.prepareStatement(createTable);
//        pps.executeUpdate();
        PreparedStatement ps=conn.prepareStatement(insertValue);

        ps.setInt(1,em2.EmployeeId);
        ps.setString(2,em2.FirstName);
        ps.setString(3,em2.LastName);
        ps.setInt(4,em2.Age);
        ps.setString(5,em2.Department);
        ps.setString(6,em2.ManagerName);
        ps.setDate(7,Date.valueOf(em2.JoiningDate));
        ps.setInt(8,em2.Salary);
        ps.setString(9,em2.MaritialStatus);
        ps.setDate(10,Date.valueOf(em2.DateofBirth));
        ps.executeUpdate();

        System.out.println("Employee successful add to Database");
        conn.close();
    }


    public  static void employeeByManager() throws SQLException {

        Connection conn= JdbcConnection.getConnection();
        System.out.println("Please enter your manager name");

        Scanner sc=InputTaker.input();
        String ManagerName = sc.nextLine();

        String select = "SELECT * FROM Employee WHERE ManagerName = ?";

        PreparedStatement ps=conn.prepareStatement(select);
        ps.setString(1,ManagerName);

        ResultSet rs=ps.executeQuery();
        while(rs.next()){

            System.out.println("EmployeeId : " + rs.getInt("EmployeeId"));
            System.out.println("FirstName : " + rs.getString("FirstName"));
            System.out.println("LastName : " + rs.getString("LastName"));
            System.out.println("Age : " + rs.getInt("Age"));
            System.out.println("Department : " + rs.getString("Department"));
            System.out.println("ManagerName: " + rs.getString("ManagerName"));
            System.out.println("JoiningDate: " + rs.getString("JoiningDate"));
            System.out.println("Salary :  "+ rs.getInt("Salary"));
            System.out.println("MaritialStatus : " + rs.getString("MaritialStatus"));
            System.out.println("DateofBirth : " + rs.getString("DateofBirth"));
        }
        conn.close();
    }
    public static void employeeBySalary() throws SQLException{

        Connection conn= JdbcConnection.getConnection();
        System.out.println("Please enter your salary");

        Scanner sc=InputTaker.input();
        String employeeSalary = sc.nextLine();

        String select = "SELECT * FROM Employee WHERE Salary=?";

        PreparedStatement ps=conn.prepareStatement(select);
        ps.setString(1,employeeSalary);

        ResultSet rs=ps.executeQuery();
        while(rs.next()){

            System.out.println("EmployeeId : " + rs.getInt("EmployeeId"));
            System.out.println("FirstName : " + rs.getString("FirstName"));
            System.out.println("LastName : " + rs.getString("LastName"));
            System.out.println("Age : " + rs.getInt("Age"));
            System.out.println("Department : " + rs.getString("Department"));
            System.out.println("ManagerName: " + rs.getString("ManagerName"));
            System.out.println("JoiningDate: " + rs.getString("JoiningDate"));
            System.out.println("Salary :  "+ rs.getInt("Salary"));
            System.out.println("MaritialStatus : " + rs.getString("MaritialStatus"));
            System.out.println("DateofBirth : " + rs.getString("DateofBirth"));
        }
        conn.close();

    }

    public static void employeeById() throws SQLException{

        Connection conn= JdbcConnection.getConnection();
        System.out.println("Please enter your EmployeeId");

        Scanner sc=InputTaker.input();
        String id = sc.nextLine();

        String select = "SELECT * FROM Employee WHERE EmployeeId=?";

        PreparedStatement ps=conn.prepareStatement(select);
        ps.setString(1,id);

        ResultSet rs=ps.executeQuery();
        while(rs.next()){

            System.out.println("EmployeeId : " + rs.getInt("EmployeeId"));
            System.out.println("FirstName : " + rs.getString("FirstName"));
            System.out.println("LastName : " + rs.getString("LastName"));
            System.out.println("Age : " + rs.getInt("Age"));
            System.out.println("Department : " + rs.getString("Department"));
            System.out.println("ManagerName: " + rs.getString("ManagerName"));
            System.out.println("JoiningDate: " + rs.getString("JoiningDate"));
            System.out.println("Salary :  "+ rs.getInt("Salary"));
            System.out.println("MaritialStatus : " + rs.getString("MaritialStatus"));
            System.out.println("DateofBirth : " + rs.getString("DateofBirth"));
        }
        conn.close();


    }
    public static void giveBonous() throws SQLException{

        Connection conn= JdbcConnection.getConnection();
        LocalDate today=LocalDate.now();

        LocalDate DateBefore2Year = today.minusYears(2);

        Date DateBefore2YearAgo=Date.valueOf(DateBefore2Year);

        String query="select * from Employee where joiningDate<=?";

        PreparedStatement ps=conn.prepareStatement(query);
        ps.setDate(1,DateBefore2YearAgo);

        ResultSet rs=ps.executeQuery();
        while(rs.next()){

            int salary=rs.getInt("salary");

            int eid=rs.getInt("EmployeeId");

            int newsalary=salary+5000;

            String queryUpdate = "update Employee set Salary=? where EmployeeId=?";

            PreparedStatement ps1=conn.prepareStatement(queryUpdate);
            ps1.setInt(1,newsalary);
            ps1.setInt(2,eid);
            ps1.executeUpdate();

            System.out.println("EmployeeId : " + rs.getInt("EmployeeId"));
            System.out.println("FirstName : " + rs.getString("FirstName"));
            System.out.println("LastName : " + rs.getString("LastName"));
            System.out.println("Age : " + rs.getInt("Age"));
            System.out.println("JoiningDate : " + rs.getDate("JoiningDate"));
            System.out.println("old salary : " + rs.getInt("Salary"));
            System.out.println("new salary : " +newsalary);
            System.out.println();
        }
        conn.close();

    }

    public static void birthdayWish() throws SQLException{
        Connection conn=JdbcConnection.getConnection();

        String query=" select * from employee";

        PreparedStatement ps=conn.prepareStatement(query);

        ResultSet rs= ps.executeQuery();
        LocalDate date=LocalDate.now();
        while(rs.next()){
            String dateString = rs.getString("DateofBirth"); // Format: "YYYY-MM-DD"

            // Define a DateTimeFormatter for the expected date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // Parse the string date to a LocalDate object
            LocalDate empBirthday = LocalDate.parse(dateString, formatter);



            if(date.getMonth()==empBirthday.getMonth() && date.getDayOfMonth()==empBirthday.getDayOfMonth()){
                System.out.println("Happy Birthday To You : " + rs.getString("FirstName"));
            }
            else{

                long daysUntilBirthday;
                if (date.isAfter(empBirthday) ){
                    // Birthday has already passed for the current year
                    LocalDate nextBirthday = date.withYear(date.getYear() + 1);
                    daysUntilBirthday = ChronoUnit.DAYS.between(date, nextBirthday);
                } else {
                    daysUntilBirthday = ChronoUnit.DAYS.between(date,empBirthday);
                }
                System.out.println("Remaining Days" + daysUntilBirthday);
            }
        }
    }

    public static void updateMarriage() throws SQLException{

        Connection conn=JdbcConnection.getConnection();
        Scanner sc=InputTaker.input();

        System.out.println("Enter your EmployeeId");
        int employeeId=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your Marriage Status");
        String updateMarriage=sc.nextLine();


        String query="update Employee set MaritialStatus=? where EmployeeId=?";

        PreparedStatement ps=conn.prepareStatement(query);
        ps.setString(1,updateMarriage);
        ps.setInt(2,employeeId);
        ps.executeUpdate();

        System.out.println("MarriageStatus updated successfully to  : " + updateMarriage);
    }


    public  static void getEmployeeByMngrSalary() throws SQLException {
        Connection conn=JdbcConnection.getConnection();
        String selectQuery="SELECT  E1.EmployeeId,E1.FirstName, E1.LastName,E1.Salary, E1.ManagerName  FROM Employee AS E1 WHERE E1.Salary > ( SELECT E2.Salary  FROM Employee AS E2 Where E2.FirstName = E1.ManagerName )";
        PreparedStatement ps=conn.prepareStatement(selectQuery);
        ResultSet resultSet=ps.executeQuery();
        while(resultSet.next()){
            System.out.println("Employee_id :"+resultSet.getInt("EmployeeId"));
            System.out.println("Frist_Name :"+resultSet.getString("FirstName"));
            System.out.println("Last_Name:"+resultSet.getString("LastName"));
            System.out.println("Employee Salary :"+resultSet.getInt("Salary"));
            System.out.println("Manager Name :"+resultSet.getString("ManagerName"));
            System.out.println();
        }
        conn.close();
    }
}
