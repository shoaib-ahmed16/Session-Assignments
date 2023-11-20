package com.company;

import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws SQLException {

        System.out.println("Do you want add an Employee? YES OR NO");

        Scanner sc=InputTaker.input();
        String ans = sc.nextLine();

        if(ans.equalsIgnoreCase("yes"))
        {
            Employee_2 em2=new Employee_2();

            Random rn=new Random();
            em2.EmployeeId=1+ rn.nextInt(100000);

            System.out.println("Enter your First Name : ");
            em2.FirstName=sc.nextLine();

            System.out.println("Enter your LastName : ");
            em2.LastName=sc.nextLine();

            System.out.println("Enter your Salary : ");
            em2.Salary=sc.nextInt();

            System.out.println("Enter your Age: ");
            em2.Age=sc.nextInt();
            sc.nextLine();

            System.out.println("Enter your Department : ");
            em2.Department=sc.nextLine();

            System.out.println("Enter your ManagerName : ");
            em2.ManagerName= sc.nextLine();

            System.out.println("Enter your JoiningDate : ");
            em2.JoiningDate=sc.nextLine();

            System.out.println("Enter your MaritialStatus : ");
            em2.MaritialStatus=sc.nextLine();

            System.out.println(" Enter your DateofBirth : ");
            em2.DateofBirth=sc.nextLine();

            Employee_2.addEmployee(em2);


        }

        else{
            System.out.println("Enter 1 to get the Employee Details by ManagerName");
            System.out.println("Enter 2 to get the Employee Details by Salary");
            System.out.println("Enter 3 to get the Employee Details by EmployeeId");
            System.out.println("Enter 4 to give the Bonus 50000 who work more than 2 yrs ");
            System.out.println("Enter 5 to wish him happy birthday");
            System.out.println("Enter 6 to check the maritial Status of the Employee");
            System.out.println("Enter 7 to get employee details whose salary greater than their manager");

            int choice=sc.nextInt();
//            Employee em = new Employee_2();

            switch(choice){
                case 1: {
                    Employee_2.employeeByManager();
                    break;
                }
                case 2:{
                    Employee_2.employeeBySalary();
                    break;
                }
                case 3:{
                        Employee_2.employeeById() ;
                        break;
                }
                case 4:{
                    Employee_2.giveBonous();
                    break;
                }
                case 5:{
                    Employee_2.birthdayWish();
                    break;
                }
                case 6:{
                    Employee_2.updateMarriage();
                }
                case 7 :{
                    Employee_2.getEmployeeByMngrSalary();
                }
            }
        }

    }
}
