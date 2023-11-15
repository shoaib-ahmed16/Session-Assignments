package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

public class UpdateUserDetails {

    private static Scanner sc = InputTaker.getScanner();
    private static Connection conn = DBUtils.getConnection();

    private static String emailValidator = "@";
    private static String queryToUpdateEmail = "UPDATE user set Email_id='";
    private static String queryToUpdateMobile = "UPDATE user set Mobile_no='";

    private static String condClosure = "' where Account_no =";

    public static void updateDetails(int account) throws SQLException {
        sc.nextLine();
        System.out.println("Enter a if you want to update the Account Email ID");
        System.out.println("Enter b if you want to update the Account Mobile Number");
        String updateField = sc.nextLine();
        if (updateField.equalsIgnoreCase("a")) {
            updateEmailId(account);
        } else if (updateField.equalsIgnoreCase("b")) {
            updateMobileNumber(account);
        }
    }


    public static void updateEmailId(int account) throws SQLException {
        System.out.println("Enter Updated Email:");
        String email = sc.nextLine();
        if (!email.contains(emailValidator)) {
            throw new UserExceptionHandling("User provided Email Id is Invalid!!!");
        }
        Statement st = conn.createStatement();
        int x = st.executeUpdate(queryToUpdateEmail + email + condClosure + account);
        if (x > 0) {
            System.out.println("User Email is updated!!!");
            System.out.println("Your account Email is update To " + email + " On date " + LocalDateTime.now());
        } else {
            throw new UserExceptionHandling("Unknown Server error!!!");
        }

    }

    public static void updateMobileNumber(int account) throws SQLException, UserExceptionHandling {
        System.out.println("Enter Updated Mobile:");
        String mobile = sc.nextLine();
        Statement st = conn.createStatement();
        int x = st.executeUpdate(queryToUpdateMobile + mobile + condClosure + account);
        if (x > 0) {
            System.out.println("User Mobile Number is updated!!!");
            System.out.println("Your account Email is update To " + mobile + " On date " + LocalDateTime.now());
        } else
            throw new UserExceptionHandling("Unknown Server error!!!");
    }
}
