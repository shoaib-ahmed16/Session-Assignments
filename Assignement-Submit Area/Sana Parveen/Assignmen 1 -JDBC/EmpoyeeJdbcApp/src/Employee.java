import java.sql.SQLException;
import java.util.Date;

public interface Employee {
    //public void employee(int employee_id, String FirstName, String LastName, String Department,String Joining_date,int salary,int age,String marriage_status,String Date_OF_Birth);
    public void addEmplyee(Employee_Operations emp_OprObj);
    public void getEmployeebyManager(String MngrNme) throws SQLException;
    public void getEmployeebySalary(int Salary) throws SQLException;
    public void getEmployeebyId(int EmpId) throws  SQLException;
    public void Givebonous() throws SQLException;
    public void updateMarriageStatus(int Emp_id,String Marr_status) throws SQLException;
    public void wishBirthday(String Emp_DOB) throws SQLException;
    public void getEmpByMngrSalry()throws SQLException;

}
