package com.shoaib.operations;

import com.shoaib.domain.Student;
import com.shoaib.exception.StudentException;
import com.shoaib.utils.DBEMUtils;
import com.shoaib.utils.InputTaker;
import jakarta.persistence.EntityManager;
import org.hibernate.annotations.processing.SQL;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentCreate {

    private String firstName;

    private  String lastName;

    private Integer age;
    private String fatherName;
    private String motherName;
    private Long marks;
    private Scanner input= InputTaker.takeInput;
    public  void create(){
        System.out.println("Enter Student First Name: ");
        firstName=input.nextLine();

        System.out.println("Enter Student Last Name: ");
        lastName=input.nextLine();

        System.out.println("Enter Student Age: ");
        age =Integer.parseInt(input.nextLine());

        System.out.println("Enter Student Father Name: ");
        fatherName =input.nextLine();

        System.out.println("Enter Student Mother Name: ");
        motherName =input.nextLine();

        System.out.println("Enter Student Marks: ");
        marks =Long.parseLong(input.nextLine());

        Student stud = new Student(firstName,lastName,age,fatherName,motherName,marks);
        pushingChangesTodatabase(stud);

    }
    public void pushingChangesTodatabase(Student stud){
        if(stud!=null){
            EntityManager em = DBEMUtils.getEM();
            try{
                em.getTransaction().begin();
                em.persist(stud);
                em.getTransaction().commit();
                em.close();
                System.out.println("Student Records is save successfully");
            }catch (Exception exc){
                throw new StudentException(exc.getMessage());
            }
        }else
        throw new StudentException("Student Object Cannot be null");
    }
}
