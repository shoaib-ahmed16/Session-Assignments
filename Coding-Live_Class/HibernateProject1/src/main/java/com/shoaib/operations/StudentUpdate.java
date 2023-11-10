package com.shoaib.operations;

import com.shoaib.domain.Student;
import com.shoaib.utils.InputTaker;

import java.util.Scanner;

public class StudentUpdate {
    private String firstName;

    private  String lastName;

    private Integer age;
    private String fatherName;
    private String motherName;
    private Long marks;
    private Scanner input= InputTaker.takeInput;
    Student oldStudObj = null;
    public void update(){
        System.out.println("Enter Student Id: ");
        Long id =Long.parseLong()
        System.out.println("Enter Student Id: ");
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

    }
}
