package com.shana;

import java.sql.SQLException;

public interface Employee {

    public void addEmployee(Employee_Entity empEntity) throws UserException;

    public void getEmployeeByManager() throws RuntimeException;
    public void getEmployeeBySalary() throws RuntimeException;
    public void getEmployeeById() throws RuntimeException;
    public void giveBonous() throws RuntimeException;
    public void MarriageUpdate() throws RuntimeException;
    public void BirthdayWish() throws RuntimeException;
    public void getEmployeeByManagerSalary() throws RuntimeException;

}
