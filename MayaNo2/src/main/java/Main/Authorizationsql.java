package Main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Authorizationsql {
    
    public Authorizationsql(){
    }
    
    sqlconnect Conn = new sqlconnect();
    
    Connection con = Conn.connector();

    public void staffRegister(){
        @SuppressWarnings("resource")
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
        //input.close();
    }

    public void studentRegister() {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        
        String mail ="", matrixNum, password = "", fullname, student , programme ="Bachelor of Computer Science (Data Science)", muet = "Band 2";
        int muetNum,programmeNum;
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
                System.out.println("Email example username@siswa.um.edu.my");
                keepGoing = true;
            }
        }
        System.out.println("Please enter your Matrix Number");
        matrixNum = input.nextLine();
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
        System.out.println("Please choose your programme");
        System.out.println("1. AI\n2. DATA SCIENCE\n3. COMPUTER SYSTEM AND NETWORK\n"
                + "4. SOFTWARE ENGINEERING\n5. INFORMATION SYSTEMS\n6. MULTIMEDIA COMPUTING");
        programmeNum = input.nextInt();
        switch (programmeNum){
            case 1:
                programme = "Bachelor of Computer Science (Artificial Intelligence)";
                break;
            case 2:
                programme = "Bachelor of Computer Science (Data Science)";
                break;
            case 3:
                programme = "Bachelor of Computer Science (Computer System and Network)";
                break;
            case 4:
                programme = "Bachelor of Computer Science (Software Engineering)";
                break;
            case 5:
                programme = "Bachelor of Information Technology (Information Systems)";
                break;
            case 6:
                programme = "Bachelor of Information Technology (Multimedia)";
                break;
        }
        System.out.println("Please enter your MUET band (2,3,4,5,6)");
        muetNum = input.nextInt();
        
        switch(muetNum){
            case 2:
                muet = "Band 2";
                break;
            case 3:
                muet = "Band 3";
                break;
            case 4:
                muet = "Band 4";
                break;
            case 5:
                muet = "Band 5/6";
                break;
            case 6:
                muet = "Band 5/6";
                break;
        }
        
        //making all credentials into one string
        student = matrixNum + "," + mail + "," + fullname + "," + password
                +"," +programme +"," +muet;
        
        String query = "insert into student (name,password,matrixnum,mail,programme,muet) values (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, fullname);
            ps.setString(2, password);
            ps.setString(3, matrixNum);
            ps.setString(4, mail);
            ps.setString(5, programme);
            ps.setString(6, muet);
            
            Boolean success = ps.execute();
            if (success) {
                con.close();
                System.out.println(student);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }

        //input.close();        

    }

    public String staffLogin() {
        String Name = "",password = "",username= "";
        
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        
        String userInput;
        String passInput;
        int count = 0;
        System.out.println("Please enter your username and password");
        userInput = in.nextLine();
        passInput = in.nextLine();

        String query = "select * from staff";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                Name = rs.getString("name");
                password = rs.getString("password");
                username = rs.getString("username");
                if ( userInput.equals(username) ){
                    count = 1;
                    if ( passInput.equals(password)){
                        count = 2;
                        // for logging purposes
                        try{
                            String filename = "loggerStaff.txt";
                            File file = new File(filename);
                            PrintWriter outputStream = new PrintWriter(new FileOutputStream(file));
                            if (!Name.equals(null)){
                                outputStream.println(Name);
                                outputStream.println(username);
                            }
                            outputStream.flush();
                            outputStream.close();
                        } catch(IOException ex){
                            System.out.println("IO Error "+ex.getMessage());
                        }
                        break;
                    }
                }
                else{
                    count = 0;
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        
        if (count == 2) {
            //in.close();
            //popupBox.infoBox("Login Successful" , "Login");
            return "Login successful";
        } else if (count == 1) {
            //in.close();
            //popupBox.infoBox("Login Unsuccessful", "Login");
            return "Login unsuccessful\nwrong password";
        } else {
            //in.close();
           // popupBox.infoBox("User is not registered", "Login");
            return "User is not registered";
        }
    }

    public String studentLogin() {
        String matrixNum, password;
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        
        String userInput, passInput;
        int count = 0;
        System.out.println("Please enter your matrix number and password");
        userInput = in.nextLine();
        passInput = in.nextLine();

        String query = "select * from student";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                matrixNum = rs.getString("matrixnum");
                password = rs.getString("password");
                if ( userInput.equals(matrixNum) ){
                    count = 1;
                    if ( passInput.equals(password)){
                        count = 2;
                        try{
                            String filename = "loggerStu.txt";
                            File file = new File(filename);
                            PrintWriter outputStream = new PrintWriter(new FileOutputStream(file));
                            outputStream.print(userInput);
                            outputStream.flush();
                            outputStream.close();
                        } catch(IOException ex){
                            System.out.println("IO Error "+ex.getMessage());
                        }
                        break;
                    }
                }
                else{
                    count = 0;
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }

        if (count == 2) {
            //in.close();
            return "Login successful";
        } else if (count == 1) {
            //in.close();
            return "Login unsuccessful\nwrong password";
        } else {
            //in.close();
            return "User is not registered";
        }
    }
}
