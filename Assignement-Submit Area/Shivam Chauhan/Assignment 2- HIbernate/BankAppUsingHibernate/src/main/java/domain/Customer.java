package domain;
import javax.persistence.*;
@Entity
@Table(name = "Customer_Data")
public class Customer {
    @Column(name = "First_Name")
    private String  firstname;
    @Column(name = "Last_Name")
    private String  lastname;
    @Column(name = "Mobile_Number")
    private String  mob;
    @Column(name = "Coustomer_Email")
    private String  email;
    private int   amount;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountNumber;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
    public Customer(){
    }

    @Override
    public String toString(){
        return "First_Name="+firstname+'\n'+
                "Last_Name="+lastname+'\n'+
                "Mobile_Number="+mob+'\n'+
                "Email_Id="+email+'\n'+
                "Amount="+amount+'\n'+
                "Account_Number="+accountNumber+'\n';
    }
}
