package com.shana;

import jakarta.persistence.*;

import java.util.Date;


@Entity
   @Table(name= "Employee_Table")
   public class Employee_Entity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="Employee_Id")
   private int EmployeeId;

   @Column(name="First_Name")
   private String FirstName;

   @Column(name="Last_Name")
   private String LastName;

   @Column(name="Department_Name")
   private String Department;

   @Column(name="Joining_Date")
   private Date JoiningDate;

   @Column(name="Salary")
   private int salary;

   @Column(name="Manager_Name")
   private String ManagerName;

   @Column(name="Age")
   private int age;

   @Column(name="MaritialStatus")
   private String Marriage ;

   @Column(name="Date_of_Birth")
   private Date DateofBirth;

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

   public Date getJoiningDate() {
      return JoiningDate;
   }

   public void setJoiningDate(Date joiningDate) {
      JoiningDate = joiningDate;
   }

   public int getSalary() {
      return salary;
   }

   public void setSalary(int salary) {
      this.salary = salary;
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

   public String getMarriage() {
      return Marriage;
   }

   public void setMarriage(String marriage) {
      Marriage = marriage;
   }

   public Date getDateofBirth() {
      return DateofBirth;
   }

   public void setDateofBirth(Date dateofBirth) {
      DateofBirth = dateofBirth;
   }
   public Employee_Entity(){

   }

   @Override
   public String toString() {
      return "Employee_Entity{" +
              "EmployeeId=" + EmployeeId +
              ", FirstName='" + FirstName + '\'' +
              ", LastName='" + LastName + '\'' +
              ", Department='" + Department + '\'' +
              ", JoiningDate=" + JoiningDate +
              ", salary='" + salary + '\'' +
              ", ManagerName='" + ManagerName + '\'' +
              ", age='" + age + '\'' +
              ", Marriage='" + Marriage + '\'' +
              ", DateofBirth=" + DateofBirth +
              '}';
   }


}
