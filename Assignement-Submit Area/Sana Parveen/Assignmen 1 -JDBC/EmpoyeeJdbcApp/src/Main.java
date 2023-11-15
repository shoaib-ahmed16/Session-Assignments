import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException {

        System.out.println("Do you want to add an Employee in a company(yes/no)");

        Scanner sc = InputTaker.ScanerObj();

        String ans = sc.nextLine();

        if (ans.equalsIgnoreCase("yes")) {

            Employee_Operations emp_OprObj = new Employee_Operations();

            System.out.print("Enter First Name: ");
            emp_OprObj.FirstName = sc.nextLine();

            System.out.print("Enter Last Name: ");
            emp_OprObj.LastName = sc.nextLine();

            System.out.print("Enter Department: ");
            emp_OprObj.Department = sc.nextLine();

            System.out.print("Enter Joining Date: ");
            emp_OprObj.JoiningDate = sc.nextLine();

            System.out.print("Enter Salary: ");
            emp_OprObj.Salary = Integer.parseInt(sc.nextLine());


            System.out.print("Enter Manager Name: ");
            emp_OprObj.ManagerName = sc.nextLine();

            System.out.print("Enter Age: ");
            emp_OprObj.age = Integer.parseInt(sc.nextLine());


            System.out.print("Enter Marriage Status: ");
            emp_OprObj.marriageStatus = sc.nextLine();

            System.out.print("Enter Date of Birth: ");
            emp_OprObj.DateOfBirth = sc.nextLine();

            Random Rnd = new Random();
            emp_OprObj.Employee_id = 1 + Rnd.nextInt(9999999);

            emp_OprObj.addEmplyee(emp_OprObj);

        } else {
            System.out.println("Enter 1 to get employee details by Manager Name");
            System.out.println("Enter 2 to get employee details by Salary");
            System.out.println("Enter 3 to get employee details by Employee_id");
            System.out.println("Enter 4 to provide Bonous to an employee whose working period is more than 2 year ");
            System.out.println("Enter 5 to Update Employee Marriage Status to ");
            System.out.println("Enter 6 to wish happy birthday to All Employee have Birthday today");
            System.out.println("Enter 7 to get Employee details whose salary greater than their manager");

            int choice = sc.nextInt();
            Employee getByMangr = new Employee_Operations();

            switch (choice) {
                case 1: {
                    System.out.println("Please Enter Manager_Name");
                    String MngrNme = sc.nextLine();
                    getByMangr.getEmployeebyManager(MngrNme);
                }
                case 2: {
                    System.out.println("Please Enter Salary");
                    int Salary = sc.nextInt();
                    sc.nextLine();
                    getByMangr.getEmployeebySalary(Salary);
                }
                case 3: {
                    System.out.println("Please Enter Employee_id");
                    int EmpId = sc.nextInt();
                    getByMangr.getEmployeebyId(EmpId);
                }
                case 4: {

                    getByMangr.Givebonous();
                }
                case 5:{
                    System.out.println("Enter Employee_id");
                    int Emp_id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the marriage Status : (Married/Unmarried)");
                    String Marr_status = sc.nextLine();
                    getByMangr.updateMarriageStatus(Emp_id,Marr_status);
                }
                case 6:{

                    System.out.print("Enter a date of Birth (YYYY-MM-DD): ");
                    String Emp_DOB = sc.nextLine();
                    getByMangr.wishBirthday(Emp_DOB);
                }
                case 7:{
                    getByMangr.getEmpByMngrSalry();
                }

            }
        }


    }
}