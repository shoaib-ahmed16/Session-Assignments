package com.employee;

import EmployeeOperationClass.EmployeeExceptionalHandling;
import EmployeeOperationClass.EmployeeOperation;
import EmployeeOperationInterface.Operations;
import domain.Employee;
import utils.InputTaker;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException, EmployeeExceptionalHandling {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Do you want to add an Employee in a company(yes/no)");
        Scanner sc = InputTaker.takeInput;
        String ans = sc.nextLine();

        EmployeeOperation emp_opr_obj=new EmployeeOperation();


        if (ans.equalsIgnoreCase("yes")) {

            Employee emp_obj= new Employee();

            System.out.print("Enter First Name: ");
            emp_obj.setFirstName(sc.nextLine());

            System.out.print("Enter Last Name: ");
            emp_obj.setLastName(sc.nextLine());

            System.out.print("Enter Department: ");
            emp_obj.setDepartment(sc.nextLine());

            System.out.print("Enter Joining Date (yyyy-MM-dd): ");
            String joinDate = sc.nextLine();
            LocalDate joindateValue = LocalDate.parse(joinDate,dateFormatter);
            emp_obj.setJoiningDate(joindateValue);


            System.out.print("Enter Salary: ");
            emp_obj.setSalary(Integer.parseInt(sc.nextLine()));


            System.out.print("Enter Manager Name: ");
            emp_obj.setManagerName(sc.nextLine());

            System.out.print("Enter Age: ");
            emp_obj.setAge(Integer.parseInt(sc.nextLine()));

            System.out.print("Enter Marriage Status: ");
            emp_obj.setMarriageStatus(sc.nextLine());

            System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
            String dateofbirth = sc.nextLine();
            LocalDate date = LocalDate.parse(dateofbirth,dateFormatter);
            emp_obj.setDateOfBirth(date);


            emp_opr_obj.addEmployee(emp_obj);

        }else{
            System.out.println("Enter 1 to get employee details by Manager Name");
            System.out.println("Enter 2 to get employee details by Salary");
            System.out.println("Enter 3 to get employee details by Employee_id");
            System.out.println("Enter 4 to provide Bonus to an employee whose working period is more than 2 year ");
            System.out.println("Enter 5 to Update Employee Marriage Status to ");
            System.out.println("Enter 6 to wish happy birthday to All Employee have Birthday today");
            System.out.println("Enter 7 to get Employee details whose salary greater than their manager");

            int choice=sc.nextInt();

            switch (choice){

                case 1:{
                    Operations getbymngrname=new EmployeeOperation();
                    getbymngrname.getEmployeeByManagerName();
                    break;
                }
                case 2:{
                    Operations getbymngrname=new EmployeeOperation();
                    getbymngrname.getEmployeeBySalary();
                    break;
                }
                case 3:{
                    Operations getbymngrname=new EmployeeOperation();
                    getbymngrname.getEmployeeById();
                    break;
                }
                case 4:{
                    Operations getbymngrname=new EmployeeOperation();
                    getbymngrname.giveBonus();
                    break;

                }
                case 5:{
                    Operations getbymngrname=new EmployeeOperation();
                    getbymngrname.UpdateMarriageStatus();
                    break;
                }
                case 6:{
                    Operations getbymngrname=new EmployeeOperation();
                    getbymngrname.wishBirthday();
                    break;
                }
                case 7:{
                    Operations getbymngrname=new EmployeeOperation();
                    getbymngrname.getEmpByMngrSalry();
                    break;
                }

            }

        }
    }
}