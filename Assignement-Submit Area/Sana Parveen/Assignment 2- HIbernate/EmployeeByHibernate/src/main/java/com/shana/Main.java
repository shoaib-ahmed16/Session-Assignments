package com.shana;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UserException, ParseException {

        System.out.println("Do you want to add an employee (yes/no)");
        Scanner sc=InputTaker.getScanner();
        String ans=sc.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Exployee_2 emp2 = new Exployee_2();

        if(ans.equalsIgnoreCase("yes")){

            Employee_Entity empEntity=new Employee_Entity();

            System.out.println("Enter your first Name : ");
            empEntity.setFirstName(sc.nextLine());

            System.out.println("Enter your Last Name : ");
            empEntity.setLastName(sc.nextLine());

            System.out.println("Enter your Manager Name : ");
            empEntity.setManagerName(sc.nextLine());

            System.out.println("Enter your Department Name : ");
            empEntity.setDepartment(sc.nextLine());

            System.out.println("Enter your Joining date (yyyy-mm-dd) : ");
            String date = sc.nextLine();
            Date parsedDate = dateFormat.parse(date);
            empEntity.setJoiningDate(parsedDate);

            System.out.println("Enter your salary : ");
            empEntity.setSalary(sc.nextInt());
            

            System.out.println("Enter your age : ");
            empEntity.setAge(sc.nextInt());
            sc.nextLine();

            System.out.println("Enter your Maritial status : ");
            empEntity.setMarriage(sc.nextLine());

            System.out.println("Enter your  Date of Birth : ");
            String birth = sc.nextLine();
            Date birthDate = dateFormat.parse(birth);
            empEntity.setDateofBirth(birthDate);
            

            emp2.addEmployee(empEntity);
        }
        else{
            System.out.println("Enter 1 to get employee details by Manager Name");
            System.out.println("Enter 2 to get employee details by Salary");
            System.out.println("Enter 3 to get employee details by Employee_id");
            System.out.println("Enter 4 to provide Bonus to an employee whose working period is more than 2 year ");
            System.out.println("Enter 5 to Update Employee Marriage Status to ");
            System.out.println("Enter 6 to wish happy birthday to All Employee have Birthday today");
            System.out.println("Enter 7 to get Employee details whose salary greater than their manager");

            int choice =sc.nextInt();

            switch(choice){

                case 1: {
                    emp2.getEmployeeByManager();
                    break;
                }
                case 2:{
                    emp2.getEmployeeBySalary();
                    break;
                }
                case 3:{
                    emp2.getEmployeeById();
                    break;
                }
                case 4:{
                    emp2.giveBonous();
                    break;
                }
                case 5:{
                    emp2.MarriageUpdate();
                    break;
                }
                case 6:{
                    emp2.BirthdayWish();
                    break;
                }
                case 7:{
                    emp2.getEmployeeByManagerSalary();
                    break;
                }

            }
        }


        }
    }

