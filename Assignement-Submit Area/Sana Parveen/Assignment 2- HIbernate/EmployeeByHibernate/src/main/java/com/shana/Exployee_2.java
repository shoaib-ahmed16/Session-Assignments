package com.shana;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class Exployee_2  implements Employee{
    Scanner sc=InputTaker.getScanner();


public void addEmployee(Employee_Entity empEntity) throws UserException {

    validate(empEntity);
    addEmployeeToDatabase(empEntity);
}

   public void validate(Employee_Entity empEntity) throws UserException {

    if(empEntity.getFirstName().isEmpty()){
        throw new UserException("Employee first name can not be empty");
    }
    if(empEntity.getLastName().isEmpty()){
        throw new UserException("Employee last name can not be empty");
    }
       if (empEntity.getDepartment().isEmpty()) {
           throw new UserException("Employee Department Name Can not Be Empty");
       }
       if (empEntity.getJoiningDate() == null) {
           throw new UserException("Employee JoiningDate Can not Be Empty");
       }
       if (empEntity.getSalary() < 0) {
           throw new UserException("Invalid amount ,it Must be in Positive Number");
       }
       if (empEntity.getManagerName().isEmpty()) {
           throw new UserException("Manager Name Can not Be Empty");
       }
       if (empEntity.getAge() < 18 || empEntity.getAge() > 60) {
           throw new UserException("Age Criteria is not fulfilled");
       }
       if (empEntity.getMarriage().isEmpty()) {
           throw new UserException("marriage status can not be empty");
       }
       if (empEntity.getDateofBirth() == null) {
           throw new UserException("Date of Birth can not be empty");
       }
       System.out.println("validation is valid");
   }


   public void addEmployeeToDatabase(Employee_Entity empEntity){

    if(empEntity!=null){
        EntityManager em=HibernateConn.conn();
        em.getTransaction().begin();
        em.persist(empEntity);
        em.getTransaction().commit();
    }
    else{
        throw new UserException("Employee object cannot be null");
    }
   }

   public void getEmployeeByManager() throws RuntimeException{
    EntityManager em=HibernateConn.conn();
       System.out.println("Please enter manager name : ");
       String ManagerName=sc.nextLine();
       String jQuery=" from Employee_Entity where ManagerName=?1";
       Query ans=em.createQuery(jQuery);
       ans.setParameter(1,ManagerName);

       List<Employee_Entity> list = ans.getResultList();

       for(Employee_Entity i:list){
           System.out.println(i);
       }
   }

    public void getEmployeeBySalary() throws RuntimeException{
        EntityManager em = HibernateConn.conn();
        System.out.println("Please enter salary : ");
        int empSalary=sc.nextInt();
        String jQuery=" from Employee_Entity where salary=?1";
        Query ans=em.createQuery(jQuery);
        ans.setParameter(1,empSalary);

        List<Employee_Entity> list = ans.getResultList();

        for(Employee_Entity i:list){
            System.out.println(i);
        }
    }


    public void getEmployeeById() throws RuntimeException{
        EntityManager em = HibernateConn.conn();
        System.out.println("Please enter Employee Id : ");
        int empId=sc.nextInt();
        String jQuery=" from Employee_Entity where EmployeeId=?1";
        Query ans=em.createQuery(jQuery);
        ans.setParameter(1,empId);

        List<Employee_Entity> list = ans.getResultList();

        for(Employee_Entity i:list){
            System.out.println(i);
        }
    }

    public void giveBonous() throws RuntimeException{

        EntityManager em=HibernateConn.conn();

        LocalDate today_date=LocalDate.now();

        LocalDate DateBefore2Year = today_date.minusYears(2);

        Date DateBefore2YearAgo = Date.valueOf(DateBefore2Year);

        String jQUERY="from Employee_Entity where JoiningDate<=?1";
        Query ans=em.createQuery(jQUERY);
        ans.setParameter(1,DateBefore2YearAgo);

        List<Employee_Entity> list =ans.getResultList();
        for(Employee_Entity i : list){

            int empId = i.getEmployeeId();
            int empSalary=i.getSalary();
            int updatedSalary=empSalary+5000;

            String updateQuery = "update Employee_Entity set salary=?1 where EmployeeId=?2";

            Query query2 = em.createQuery(updateQuery);
            query2.setParameter(1,updatedSalary);
            query2.setParameter(2,empId);

            em.getTransaction().begin();
            query2.executeUpdate();
            em.getTransaction().commit();

            System.out.println(empId);
            System.out.println(updatedSalary);
        }
}
    public void MarriageUpdate() throws RuntimeException{

        EntityManager em=HibernateConn.conn();
        System.out.println("Enter your EmployeeId : ");
        int employeeId=sc.nextInt();
        sc.nextLine();

        System.out.println("Enter your maritial status : ");
        String updateMarriage=sc.nextLine();

        String jQUERY="update Employee_Entity set Marriage=?1 where EmployeeId=?2";

        Query query=em.createQuery(jQUERY);

        query.setParameter(1,updateMarriage);
        query.setParameter(2,employeeId);

        em.getTransaction().begin();
        query.executeUpdate();
        em.getTransaction().commit();

        System.out.println("Marriage updated successfully : " + updateMarriage);

     }

     public void BirthdayWish() throws RuntimeException{

            EntityManager em=HibernateConn.conn();
            LocalDate todaydate=LocalDate.now();

            String query=" from Employee_Entity";
            Query query1=em.createQuery(query);
            List<Employee_Entity> list=query1.getResultList();

            for(Employee_Entity e:list){

               java.util.Date dt=  e.getDateofBirth();
                LocalDate localDate = dt.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

               if(todaydate.getMonth()== localDate.getMonth() && todaydate.getDayOfMonth()==localDate.getDayOfMonth()){
                   System.out.println("Happy Birthday to you "+ e.getFirstName());
               }
               else{
                   long daysUntilBirthday;
                   if (todaydate.isAfter(localDate) ){
                       // Birthday has already passed for the current year
                       LocalDate nextBirthday = localDate.withYear(todaydate.getYear() + 1);
                       daysUntilBirthday = ChronoUnit.DAYS.between(todaydate, nextBirthday);
                   } else {
                       daysUntilBirthday = ChronoUnit.DAYS.between(todaydate,localDate);
                   }
                   System.out.println("Remaining Days" + daysUntilBirthday);
               }
               }
        }

    public void getEmployeeByManagerSalary() throws RuntimeException{

    EntityManager em=HibernateConn.conn();
        String selectQuery="SELECT  E1.EmployeeId,E1.FirstName, E1.LastName,E1.salary, E1.ManagerName  FROM Employee_Entity AS E1 WHERE E1.salary > ( SELECT E2.salary  FROM Employee_Entity AS E2 Where E2.FirstName = E1.ManagerName )";


        List<Object[]> resultList = em.createQuery(selectQuery, Object[].class).getResultList();

        for(Object[] e:resultList){

            System.out.println("Employee_id :"+e[0]);
            System.out.println("FirstName :"+e[1]);
            System.out.println("Lastname :"+e[2]);
            System.out.println("Salary"+e[3]);
            System.out.println("ManagerName"+e[4]);
        }
    }
}









