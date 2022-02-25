package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Authorizationsql {
    
    public Authorizationsql(){
    }
    
    sqlconnect Conn = new sqlconnect();
    
    Connection con = Conn.connector();

    public void staffRegister(){
        Scanner input = new Scanner(System.in);
        String mail ="", username ="", password ="", fullname, staff, status ="Professor";
        int statusNum;
        // asking user credentials
        System.out.println("Please enter your Full Name (without /)");
        fullname = input.nextLine();
        boolean keepGoing = true;
        while (keepGoing){
            System.out.println("Please enter your Univerisity Email");
            mail = input.nextLine();
            Checker check = new Checker(mail);
            if (check.emailCheck())
                keepGoing = false;
            else{
                System.out.println("Invalid entry for email\nTry again\n");
                System.out.println("Email example username@um.edu.my");
                keepGoing = true;
            }
        }
        keepGoing = true;
        while (keepGoing){
            System.out.println("Please enter your preferred username");
            username = input.nextLine();
            Checker check = new Checker(username);
            if(check.usernameCheck())
                keepGoing = false;
            else{
                System.out.println("Invalid entry for username\nTry again\n");
                System.out.println("Username must be start with alphabet and not contain ( - & _ & .)");
                keepGoing = true;
            }
        }
        keepGoing = true;
        while(keepGoing){
            System.out.println("Please enter your password");
            password = input.nextLine();
            System.out.println("Please reenter your password");
            String pCheck = input.nextLine();
            if(password.equals(pCheck))
                keepGoing = false;
            else{
                System.out.println("Please try again");
                keepGoing = true;
            }
        }
        System.out.println("Please enter your status");
        System.out.println("1. Lecturer\n2. Senior Lecturer\n3. Associate Professor\n4. Professor");
        System.out.println("Choose only 1");
        statusNum = input.nextInt();
        
        switch(statusNum){
            case 1:
                status = "Lecturer";
                break;
            case 2:
                status = "Senior Lecturer";
                break;
            case 3:
                status = "Associate Professor";
                break;
            case 4:
                status = "Professor";
                break;
        }
        
        //making all credentials into one string
        staff = username + "," + mail + "," + fullname + "," + password + "," +status;
        String query = "insert into staff (name,password,mail,username,status) values (?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, fullname);
            ps.setString(2, password);
            ps.setString(3, mail);
            ps.setString(4, username);
            ps.setString(5, status);
            
            Boolean success = ps.execute();
            if (success) {
                con.close();
                System.out.println(staff);
            }
        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        input.close();
    }

    // do staff login
}
