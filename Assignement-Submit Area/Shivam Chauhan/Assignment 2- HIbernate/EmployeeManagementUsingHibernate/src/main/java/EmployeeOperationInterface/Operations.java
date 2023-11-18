package EmployeeOperationInterface;

import EmployeeOperationClass.EmployeeExceptionalHandling;
import domain.Employee;

public interface Operations {
    public void addEmployee(Employee emp_obj) throws  EmployeeExceptionalHandling;
    public void getEmployeeByManagerName() throws RuntimeException;
    public void getEmployeeBySalary() throws RuntimeException;
    public void getEmployeeById() throws RuntimeException;
    public void giveBonus() throws RuntimeException;
    public void UpdateMarriageStatus() throws RuntimeException;
    public void wishBirthday() throws RuntimeException;
    public void getEmpByMngrSalry() throws RuntimeException;
}
