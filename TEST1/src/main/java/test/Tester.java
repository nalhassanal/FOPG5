package test;

import java.util.Scanner;

/**
 *
 * @author Hassanal
 */
public class Tester {
    static Student student;
    static Staff staff;
    static Scanner input;
    
    public static void main(String[] args) {
        staff = new Staff();
        input = new Scanner(System.in);
        int menu;
        String process , choice;
        System.out.println("What to do?");
        System.out.println("1. Login\n2. Register");
        menu = input.nextInt();
        if(menu == 1){
            System.out.println("Are you staff or student");
            choice = input.next();
            if (choice.equalsIgnoreCase("staff")){
                process = staff.login();
                System.out.println(process);
            }
            else if(choice.equalsIgnoreCase("student")){
                process = student.login();
                System.out.println(process);
            }
        }    
        else if(menu == 2){
            System.out.println("Are you staff or student");
            choice = input.next();
            if (choice.equalsIgnoreCase("staff")){
                staff.reg();
                System.out.println("do you want to log in? ( 1 for yes ) ");
                menu = input.nextInt();
                if(menu == 1){
                    process = staff.login();
                    System.out.println(process);
                }   
            }
            else if(choice.equalsIgnoreCase("student")){
                student.reg();
                System.out.println("do you want to log in? ( 1 for yes ) ");
                menu = input.nextInt();
                if(menu == 1){
                    process = student.login();
                    System.out.println(process);
                }   
            }
        }       
    } 
}
