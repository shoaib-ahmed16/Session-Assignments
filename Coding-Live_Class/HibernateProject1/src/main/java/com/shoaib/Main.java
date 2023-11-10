package com.shoaib;

import com.shoaib.operations.StudentCreate;
import com.shoaib.utils.InputTaker;

import java.util.Scanner;

public class Main {

    private static Scanner input = InputTaker.takeInput;
    public static void main(String[] args) {
        System.out.println("Do you want to add New Student Records");
        System.out.println("Enter Yes/No");
        String opt1 = input.nextLine();
        if (opt1.equalsIgnoreCase("yes")) {
            new StudentCreate().create();
        } else {
            System.out.println("What Operation you want to perform Choose any out of the following:");
            System.out.println("Enter 1: Update Student details by Student Id");
            System.out.println("Enter 2: Show Student details by Id");
            System.out.println("Enter 3: Show All Student details (in sort order by Id)");
            System.out.println("Enter 4: Show All Student details (Name,Id, marks only)");
            System.out.println("Enter 5: Show All Student details ( in sort order by Name  whose marks is same) "); //Note first and 10 student Records with distint name.
            System.out.println("Enter 6: Show All Student details (in sort order by last Name)");
            System.out.println("Enter 7: Show All Student details (in sort order by fatherName)");
            System.out.println("Enter 8: Show All Student details (in sort order by Mother Name)");
            System.out.println("Enter 9: Delete the Student record by Id");
            Integer choose =Integer.parseInt(input.nextLine());
            switch (choose){
                case 1:{

                }break;
                case 2:{

                }break;
                case 3:{

                }break;
                case 4:{

                }break;
                case 5:{

                }break;
                case 6:{

                }break;
                case 7:{

                }break;
                case 8:{

                }break;
                case 9:{

                }break;
            }

        }
    }
}
