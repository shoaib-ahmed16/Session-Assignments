import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Employee_Operations implements Employee {
    int Employee_id;
    String FirstName;
    String LastName;
    String Department;
    String JoiningDate;
    int Salary;
    String ManagerName;
    int age;
    String marriageStatus;
    String DateOfBirth;

    Scanner sc=InputTaker.ScanerObj();
    @Override
    public void addEmplyee(Employee_Operations emp_OprObj)
    {
        validate( emp_OprObj );
        try {
            addEmployeeToDatabase(emp_OprObj);
        } catch (SQLException msg) {
            System.out.println(msg.getMessage());
        }
    }

    public void validate(Employee_Operations emp_OprObj) {

        if (emp_OprObj.FirstName.length()== 0) {
            throw new EmployeeExceptionalHandling("Employee First Name Can not Be Empty");
        }
        if (emp_OprObj.LastName.length() == 0) {
            throw new EmployeeExceptionalHandling("Employee Last Name Can not Be Empty");
        }
        if (emp_OprObj.Department.length() == 0) {
            throw new EmployeeExceptionalHandling("Employee Department Name Can not Be Empty");
        }
        if (emp_OprObj.JoiningDate.length() == 0) {
            throw new EmployeeExceptionalHandling("Employee JoiningDate Can not Be Empty");
        }
        if (emp_OprObj.Salary < 0) {
            throw new EmployeeExceptionalHandling("Invalid amount ,it Must be in Positive Number");
        }
        if (emp_OprObj.ManagerName.length() == 0) {
            throw new EmployeeExceptionalHandling("Manager Name Can not Be Empty");
        }
        if (emp_OprObj.age < 18 ||emp_OprObj.age > 58) {
            throw new EmployeeExceptionalHandling("Age Criteria is not fulfilled");
        }
        if (emp_OprObj.marriageStatus.length() == 0) {
            throw new EmployeeExceptionalHandling("marriage status can not be emptry");
        }
        if (emp_OprObj.DateOfBirth.length() == 0) {
            throw new EmployeeExceptionalHandling("Date of Birth can not be emptry");
        }
        if (emp_OprObj.Employee_id == 0) {
            throw new EmployeeExceptionalHandling("Employee Id is not generated");
        }
    }

    public void addEmployeeToDatabase(Employee_Operations main_obj) throws SQLException {
        Connection conn = CreateConnection.getConnection();
//        String createTableSQL = "CREATE TABLE Employee (" +
//                "Employee_id INT PRIMARY KEY," +
//                "First_Name VARCHAR(30) NOT NULL," +
//                "Last_Name VARCHAR(30) NOT NULL," +
//                "Department VARCHAR(30) NOT NULL," +
//                "Joining_Date DATE NOT NULL," +
//                "Salary INT NOT NULL," +
//                "Manager_Name VARCHAR(30) NOT NULL," +
//                "AGE INT NOT NULL," +
//                "Marriage_Status VARCHAR(20) NOT NULL," +
//                "Date_Of_Birth VARCHAR(30) NOT NULL" +
//                ")";
        String insertQuery = "INSERT INTO Employee " +
                "(Employee_id, First_Name, Last_Name, Department, Joining_Date, Salary, Manager_Name, AGE, Marriage_Status, Date_Of_Birth) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement prestmt = conn.prepareStatement(insertQuery);

        prestmt.setInt(1, main_obj.Employee_id); // Set the Employee_id
        prestmt.setString(2, main_obj.FirstName); // Set the First_Name
        prestmt.setString(3, main_obj.LastName); // Set the Last_Name
        prestmt.setString(4, main_obj.Department); // Set the Department
        prestmt.setDate(5, Date.valueOf(main_obj.JoiningDate)); // Set the Joining_Date as a java.sql.Date
        prestmt.setInt(6, main_obj.Salary); // Set the Salary
        prestmt.setString(7,main_obj.ManagerName); // Set the Manager_Name
        prestmt.setInt(8,main_obj.age); // Set the AGE
        prestmt.setString(9, main_obj.marriageStatus); // Set the Marriage_Status
        prestmt.setDate(10, Date.valueOf(main_obj.DateOfBirth)); // Set the Date_Of_Birth
        prestmt.executeUpdate();

        System.out.println("Employee successfully added to Database");
        conn.close();
    }

    public void getEmployeebyManager(String MngrNme) throws SQLException {
        Connection conn = CreateConnection.getConnection();

        String selectQuery = "SELECT * FROM Employee WHERE Manager_Name = ?";

        PreparedStatement pstmt = conn.prepareStatement(selectQuery);
        pstmt.setString(1, MngrNme);

        ResultSet resultSet = pstmt.executeQuery();
        while (resultSet.next()) {
            System.out.println("Employee_Id :" + resultSet.getInt("Employee_id"));
            System.out.println("Employee FirstName :" + resultSet.getString("First_Name") + "  " + "Employee LastName :" + resultSet.getString("Last_Name"));
            System.out.println("Department_id :" + resultSet.getString("Department"));
            System.out.println("Joining_Date :" + resultSet.getDate("Joining_Date"));
            System.out.println("Salary :" + resultSet.getInt("Salary"));
            System.out.println("Age :" + resultSet.getInt("AGE"));
            System.out.println("Mariage_Status :" + resultSet.getString("Marriage_Status"));
            System.out.println("Date_of_Birth :" + resultSet.getString("Date_Of_Birth"));
        }
        conn.close();
    }

    @Override
    public void getEmployeebySalary(int Salary) throws SQLException {
        Connection conn = CreateConnection.getConnection();

        String selectQuery = "SELECT * FROM Employee WHERE Salary = ?";

        PreparedStatement prestmt = conn.prepareStatement(selectQuery);
        prestmt.setInt(1, Salary);

        ResultSet resultSet = prestmt.executeQuery();
        while (resultSet.next()) {
            System.out.println("Employee_Id :" + resultSet.getInt("Employee_id"));
            System.out.println("Employee FirstName :" + resultSet.getString("First_Name") + "  " + "Employee LastName :" + resultSet.getString("Last_Name"));
            System.out.println("Manager Name : " + resultSet.getString("Manager_Name"));
            System.out.println("Department_id :" + resultSet.getString("Department"));
            System.out.println("Joining_Date :" + resultSet.getDate("Joining_Date"));
            System.out.println("Age :" + resultSet.getInt("AGE"));
            System.out.println("Mariage_Status :" + resultSet.getString("Marriage_Status"));
            System.out.println("Date_of_Birth :" + resultSet.getString("Date_Of_Birth"));
            System.out.println();
        }
        conn.close();
    }

    public void getEmployeebyId(int EmpId) throws SQLException {
        Connection conn = CreateConnection.getConnection();

        String selectQuery = "SELECT * FROM Employee WHERE Employee_id = ?";
        PreparedStatement prestmt = conn.prepareStatement(selectQuery);
        prestmt.setInt(1, EmpId);

        ResultSet resultSet = prestmt.executeQuery();
        while (resultSet.next()) {

            System.out.println("Employee FirstName :" + resultSet.getString("First_Name") + "  " + "Employee LastName :" + resultSet.getString("Last_Name"));
            System.out.println("Manager Name : " + resultSet.getString("Manager_Name"));
            System.out.println("Salary :" + resultSet.getInt("Salary"));
            System.out.println("Department_id :" + resultSet.getString("Department"));
            System.out.println("Joining_Date :" + resultSet.getDate("Joining_Date"));
            System.out.println("Age :" + resultSet.getInt("AGE"));
            System.out.println("Mariage_Status :" + resultSet.getString("Marriage_Status"));
            System.out.println("Date_of_Birth :" + resultSet.getString("Date_Of_Birth"));
            System.out.println();
        }
        conn.close();
    }

    public void Givebonous() throws SQLException {
        Connection conn = CreateConnection.getConnection();

        String SelectQuery = "SELECT * from Employee Where Joining_Date <= ?";

        LocalDate date = LocalDate.now();

        LocalDate DateBefore2Year = date.minus(Period.ofYears(2));

        Date twoYearsAgoDate = Date.valueOf(DateBefore2Year);


        PreparedStatement prestmt = conn.prepareStatement(SelectQuery);

        prestmt.setDate(1, twoYearsAgoDate);

        ResultSet resultSet = prestmt.executeQuery();

        while (resultSet.next()) {
            int Salary = resultSet.getInt("Salary");
            int EmpId = resultSet.getInt("Employee_id");

            int New_salary = Salary + 5000;


            String UpdateQuery = "UPDATE EMPLOYEE SET Salary=? WHERE Employee_id=?";
            PreparedStatement UpdateStatement = conn.prepareStatement(UpdateQuery);
            UpdateStatement.setInt(1, New_salary);
            UpdateStatement.setInt(2, EmpId);
            UpdateStatement.executeUpdate();

            System.out.println("Employee ID: " + resultSet.getInt("Employee_id"));
            System.out.println("First Name: " + resultSet.getString("First_Name"));
            System.out.println("Last Name: " + resultSet.getString("Last_Name"));
            System.out.println("Joining Date: " + resultSet.getDate("Joining_Date"));
            System.out.println("Previous Salary: " + resultSet.getInt("Salary"));
            System.out.println("New Salary (with bonus): " + New_salary);

        }
        conn.close();
    }

    public void updateMarriageStatus(int Emp_id,String Marr_status) throws SQLException {
        Connection conn = CreateConnection.getConnection();

        String Update_Query = "UPDATE Employee SET Marriage_Status=? WHERE Employee_id=?";

        PreparedStatement update_stmt = conn.prepareStatement(Update_Query);
        update_stmt.setString(1, Marr_status);

        update_stmt.setInt(2, Emp_id);
        update_stmt.executeUpdate();

        System.out.println("Marriage Status Updated Succesfully To " + Marr_status);
    }

    public void wishBirthday(String Emp_DOB) throws SQLException {
        Connection conn = CreateConnection.getConnection();

        String selectQuery = "SELECT * FROM Employee WHERE Date_Of_Birth = ?";

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(Emp_DOB, dateFormatter);
        Date Emp_DOB_value=Date.valueOf(date);

        PreparedStatement prestmt = conn.prepareStatement(selectQuery);

        prestmt.setDate(1,Emp_DOB_value);

        ResultSet resultSet = prestmt.executeQuery();



        while (resultSet.next()) {
            int employeeId = resultSet.getInt("Employee_id");
            String firstName = resultSet.getString("First_Name");
            String lastName = resultSet.getString("Last_Name");

            LocalDate today_Date=LocalDate.now();



            if (today_Date.getMonth() == date.getMonth() && today_Date.getDayOfMonth() == date.getDayOfMonth()) {
                // It's the employee's birthday!
                System.out.println("Happy Birthday, " + firstName + " " + lastName + " (Employee ID: " + employeeId + ")!");
            } else {
                // Calculate the number of days left until their birthday
                LocalDate nextBirthday = LocalDate.of(today_Date.getYear(), today_Date.getMonth(), today_Date.getDayOfMonth());
                if (nextBirthday.isBefore(date)) {
                    nextBirthday = nextBirthday.plusYears(1);
                }
                long daysUntilBirthday = Period.between(date, nextBirthday).getDays();

                System.out.println("Employee ID: " + employeeId);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Date of Birth: " + date);
                System.out.println("Days left until the birthday: " + daysUntilBirthday);
                System.out.println();
            }
        }
        conn.close();
    }
    public void getEmpByMngrSalry() throws SQLException {
        Connection conn=CreateConnection.getConnection();
        String selectQuery="SELECT  E1.Employee_id,E1.First_Name, E1.Last_Name,E1.Salary, E1.Manager_Name  FROM employee AS E1 WHERE E1.Salary > ( SELECT E2.Salary  FROM employee AS E2 Where E2.First_Name = E1.Manager_Name )";

        PreparedStatement prestmt=conn.prepareStatement(selectQuery);
        ResultSet resultSet=prestmt.executeQuery();
        while(resultSet.next()){
            System.out.println("Employee_id :"+resultSet.getInt("Employee_id"));
            System.out.println("Frist_Name :"+resultSet.getString("First_Name"));
            System.out.println("Last_Name:"+resultSet.getString("Last_Name"));
            System.out.println("Employee Salary :"+resultSet.getInt("Salary"));
            System.out.println("Manager Name :"+resultSet.getString("Manager_Name"));
            System.out.println();
        }
        conn.close();

    }

}


