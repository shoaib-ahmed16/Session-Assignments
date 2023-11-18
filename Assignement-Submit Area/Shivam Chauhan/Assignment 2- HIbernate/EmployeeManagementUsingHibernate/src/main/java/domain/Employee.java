package domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Employee_Data")
public class Employee {
    @Id
    @Column(name="Employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int EmployeeId;
    @Column(name="First_Name")
    private String FirstName;
    @Column(name="Last_Name")
    private  String LastName;
    @Column(name="Department_Name")
    private  String Department;
    @Column(name="Joining_Date")
    private LocalDate JoiningDate;
    @Column(name="Salary")
    private   int Salary;
    @Column(name="Manager_Name")
    private  String ManagerName;
    @Column(name="Age")
    private   int age;
    @Column(name="Marriage_Status")
    private   String marriageStatus;
    @Column(name="Date_Of_Birth")
    private LocalDate DateOfBirth;

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public LocalDate getJoiningDate() {
        return JoiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        JoiningDate = joiningDate;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public String getManagerName() {
        return ManagerName;
    }

    public void setManagerName(String managerName) {
        ManagerName = managerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(String marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public Employee(){

    }

    public String toString()
    {
        return "Employee_Id : "+EmployeeId+'\n'+
                "First_Name : "+FirstName+'\n'+
                "Last_Name : "+LastName+'\n'+
                "Department_Name : "+Department+'\n'+
                "Joining_Date : "+JoiningDate+'\n'+
                "Salary : "+Salary+'\n'+
                "Manager_Name : "+ManagerName+'\n'+
                "Age : "+age+'\n'+
                "Marriage_Status : "+marriageStatus+'\n'+
                "Date_Of_Birth : "+DateOfBirth+'\n';
    }

    }



