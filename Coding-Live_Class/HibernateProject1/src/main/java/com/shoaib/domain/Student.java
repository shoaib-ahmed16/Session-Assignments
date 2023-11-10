package com.shoaib.domain;

import jakarta.persistence.*;

@Entity //
@Table(name = "students_record")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Integer age;
    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "total_marks")
    private Long marks;

    public Long getStudId() {
        return studId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Long getMarks() {
        return marks;
    }

    public void setMarks(Long marks) {
        this.marks = marks;
    }

    public Student(){

    }

    public Student(String firstName, String lastName, Integer age, String fatherName, String motherName,Long marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.marks=marks;
    }
    public Student( String firstName, String lastName, Integer age,String fatherName,Long marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.fatherName = fatherName;
        this.marks=marks;
    }
    public Student(String firstName, String lastName, Integer age,Long marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.marks=marks;
    }
    public Student(String firstName, String lastName,Long marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.marks=marks;
    }
    public Student(String firstName,Long marks) {
        this.firstName = firstName;
        this.marks=marks;
    }

    @Override
    public String toString() {
        return "Student :: [" +
                "studId=" + studId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", marks=" + marks +
                ']';
    }
}
