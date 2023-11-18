package EmployeeOperationClass;
import EmployeeOperationInterface.Operations;
import domain.Employee;
import utils.ConnUtils;
import utils.InputTaker;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class EmployeeOperation implements Operations {
    Scanner sc = InputTaker.takeInput;
    public void addEmployee(Employee emp_obj) throws EmployeeExceptionalHandling {

        validate(emp_obj);
        try {
            addEmployeeToDatabase(emp_obj);
        } catch (SQLException msg) {
            System.out.println(msg.getMessage());
        }
    }

    public void validate(Employee emp_obj) throws EmployeeExceptionalHandling {

        if (emp_obj.getFirstName().isEmpty()) {
            throw new EmployeeExceptionalHandling("Employee First Name Can not Be Empty");
        }
        if (emp_obj.getLastName().isEmpty()) {
            throw new EmployeeExceptionalHandling("Employee Last Name Can not Be Empty");
        }
        if (emp_obj.getDepartment().isEmpty()) {
            throw new EmployeeExceptionalHandling("Employee Department Name Can not Be Empty");
        }
        if (emp_obj.getJoiningDate() == null) {
            throw new EmployeeExceptionalHandling("Employee JoiningDate Can not Be Empty");
        }
        if (emp_obj.getSalary() < 0) {
            throw new EmployeeExceptionalHandling("Invalid amount ,it Must be in Positive Number");
        }
        if (emp_obj.getManagerName().isEmpty()) {
            throw new EmployeeExceptionalHandling("Manager Name Can not Be Empty");
        }
        if (emp_obj.getAge() < 18 || emp_obj.getAge() > 58) {
            throw new EmployeeExceptionalHandling("Age Criteria is not fulfilled");
        }
        if (emp_obj.getMarriageStatus().isEmpty()) {
            throw new EmployeeExceptionalHandling("marriage status can not be empty");
        }
        if (emp_obj.getDateOfBirth() == null) {
            throw new EmployeeExceptionalHandling("Date of Birth can not be empty");
        }
//            if (emp_obj.getEmployeeId() == 0) {
//                throw new EmployeeExceptionalHandling("Employee Id is not generated");
//            }
    }
    public void addEmployeeToDatabase(Employee emp_obj) throws SQLException, EmployeeExceptionalHandling {

        if (emp_obj != null) {
            EntityManager em = ConnUtils.getEm();
            try {
                em.getTransaction().begin();
                em.persist(emp_obj);
                em.getTransaction().commit();
                em.close();
                System.out.println("Employee Record is Saved Successfully");
            } catch (Exception exc) {
                throw new EmployeeExceptionalHandling(exc.getMessage());
            }
        } else
            throw new EmployeeExceptionalHandling("Employee object cannot be null");
    }
    public void getEmployeeByManagerName() throws RuntimeException {
        EntityManager em = ConnUtils.getEm();
        Scanner sc1=new Scanner(System.in);
        System.out.println("Please Enter Manager name :");
        String Mangrname = sc1.nextLine();
        String jpql= "from Employee where ManagerName=?1";
        Query q= em.createQuery(jpql);
        q.setParameter(1, Mangrname);

        List<Employee> list= q.getResultList();
        for(Employee acc:list){
            System.out.println(acc);
        }
    }
    public void getEmployeeBySalary() throws RuntimeException{
        EntityManager em = ConnUtils.getEm();
        System.out.println("Please Enter Employee salary :");
        int Salary = sc.nextInt();
        String jpql= "from Employee where salary=?1";
        Query q= em.createQuery(jpql);
        q.setParameter(1, Salary);

        List<Employee> list= q.getResultList();
        for(Employee acc:list)
        {
            System.out.println(acc);
        }
    }
    public void getEmployeeById() throws RuntimeException{
        EntityManager em = ConnUtils.getEm();
        System.out.println("Please Enter Employee Id :");
        int Emp_Id = sc.nextInt();

        String jpql= "from Employee where EmployeeId=?1";
        TypedQuery<Employee> q= em.createQuery(jpql,Employee.class);
        q.setParameter(1,Emp_Id);

        Employee acc= q.getSingleResult();

        System.out.println(acc);
    }
    public void giveBonus() throws RuntimeException{
        EntityManager em = ConnUtils.getEm();
        LocalDate date = LocalDate.now();
        LocalDate DateBefore2Year = date.minus(Period.ofYears(2));
        String jpql= "from Employee where JoiningDate<=?1";
        Query q= em.createQuery(jpql);
        q.setParameter(1, DateBefore2Year);

        List<Employee> list= q.getResultList();

        for(Employee acc:list)
        {
           int emp_Id=acc.getEmployeeId();
           int emp_Salry=acc.getSalary();
           int Updated_Salry=emp_Salry+5000;

            String Update_jpql= "update Employee set Salary=?1 where EmployeeId=?2";

            Query q2= em.createQuery(Update_jpql);
            q2.setParameter(1, Updated_Salry);
            q2.setParameter(2, emp_Id);

            em.getTransaction().begin();
            int x=q2.executeUpdate();
            em.getTransaction().commit();

            System.out.println("###########record updated#########");
            System.out.println("Current Salary :"+emp_Salry );
            System.out.println("Salary After Bonus :"+Updated_Salry);
        }
    }

    public void UpdateMarriageStatus() throws RuntimeException{
        EntityManager em = ConnUtils.getEm();

        System.out.println("Please Enter Employee_Id :");
        int emp_Id=sc.nextInt();
        sc.nextLine();

        System.out.println("Please Enter (Single/Married)");
        String emp_status=sc.nextLine();

        String Update_jpql= "update Employee set marriageStatus=?1 where EmployeeId=?2";
        Query q= em.createQuery(Update_jpql);
        q.setParameter(1, emp_status);
        q.setParameter(2, emp_Id);

        em.getTransaction().begin();
        int x=q.executeUpdate();
        em.getTransaction().commit();

        System.out.println(x+"marriage status updated successfully");
    }

    public void wishBirthday() throws RuntimeException{
        EntityManager em = ConnUtils.getEm();

        LocalDate todayDate= LocalDate.now();
        String jpql= "from Employee ";
        Query q= em.createQuery(jpql);

        List<Employee> list= q.getResultList();

        for(Employee acc:list){

            if(todayDate.getMonth()==acc.getDateOfBirth().getMonth() && todayDate.getDayOfMonth()==acc.getDateOfBirth().getDayOfMonth()){
                // It's the employee's birthday!
                System.out.println("Happy Birthday, " + acc.getFirstName() + " " + acc.getLastName() + " (Employee ID: " + acc.getEmployeeId()+ ")!");
            }else{
                long daysUntilBirthday;
                if (todayDate.isAfter(acc.getDateOfBirth())) {
                    // Birthday has already passed for the current year
                    LocalDate nextBirthday = acc.getDateOfBirth().withYear(todayDate.getYear() + 1);
                    daysUntilBirthday = ChronoUnit.DAYS.between(todayDate, nextBirthday);
                } else {
                    daysUntilBirthday = ChronoUnit.DAYS.between(todayDate, acc.getDateOfBirth());
                }

                System.out.println("Employee ID: " + acc.getEmployeeId());
                System.out.println("First Name: " + acc.getFirstName());
                System.out.println("Last Name: " + acc.getLastName());
                System.out.println("Date of Birth: " + acc.getDateOfBirth());
                System.out.println("Days left until the birthday: " + daysUntilBirthday);
                System.out.println();
            }

        }
    }
    public void getEmpByMngrSalry() throws RuntimeException{

        EntityManager em = ConnUtils.getEm();
        String jpql= "SELECT  E1.EmployeeId,E1.FirstName, E1.LastName,E1.Salary, E1.ManagerName  FROM Employee AS E1 WHERE E1.Salary > ( SELECT E2.Salary  FROM Employee AS E2 Where E2.FirstName = E1.ManagerName )";
        List<Object[]> resultList = em.createQuery(jpql, Object[].class).getResultList();

        for (Object[] result : resultList) {
            System.out.println("EmployeeId"+result[0]);
            System.out.println("First_Name"+result[1]);
            System.out.println("Last_Name"+result[2]);
            System.out.println("Salary"+result[3]);
            System.out.println("Manager_Name"+result[4]);
        }
    }
}




