package com.shana;




import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity //
@Table(name ="BankUser_record")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Account_Number")
    private int accountNumber;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Mobile_No")
    private String mob;

    @Column(name = "Email_Id")
    private String email;

    @Column(name = "Amount")
    private int amount;



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

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }


    public Bank(){

    }

    public Bank(String firstName,String lastName,String mob,String email, int amount){
        this.firstName=firstName;
        this.lastName=lastName;
        this.mob=mob;
        this.email=email;
        this.amount=amount;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mob='" + mob + '\'' +
                ", email='" + email + '\'' +
                ", amount='" + amount + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }


}
