package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Hassanal
 */
public class Staff implements Register{

    public Staff() {
    }
    
    @Override
    public void reg(){
        //this method will ask users input for information
        //this method creates two files, staff and staffCredentials
        //student stores all staff information
        //staffCredentials is used explicitly by student login 
        Scanner input = new Scanner(System.in);
        String mail ="", username ="", password ="", fullname, staff, status ="Professor";
        int statusNum;
        // asking user credentials
        System.out.println("Please enter your Full Name");
        fullname = input.nextLine();
        boolean keepGoing = true;
        while (keepGoing){
            System.out.println("Please enter your Univerisity Email");
            mail = input.nextLine();
            Checker check = new Checker(mail);
            if (check.emailCheck(mail))
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
            if(check.emailCheck(mail))
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
        
        //maybe add salutations
        //making all credentials into one string
        staff = username + "," + mail + "," + fullname + "," + password + "," +status;

        // add a checking for existing user
        // use if
        // if true execute try catch
        // else print user already exist and continue to login
        // method(username);
        if(existingStaff(username)){
            try {
                String filename = "staff.txt";
                // creates new file if not there
                // if file exists it will do nothing
                File file = new File(filename);

                // appends existing file
                PrintWriter outputStream = new PrintWriter(new FileOutputStream(file, true));

                //adds the string staff into the file
                outputStream.println(staff);

                //flushes PrintWriter
                //clear the stream of any element that may be or maybe not inside the stream
                outputStream.flush();
                //closes the file connection
                outputStream.close();
            } catch (IOException ex) {
                System.out.println("IO Error " + ex.getMessage());
            }

            try {
                String filename = "staffCredentials.txt";
                // creates new file if not there
                // if file exists it will do nothing
                File file = new File(filename);
                // appends existing file
                PrintWriter outputStream = new PrintWriter(new FileOutputStream(file, true));
                //adds the string staff into the file
                outputStream.println(username);
                outputStream.println(password);
                //flushes PrintWriter
                //clear the stream of any element that may be or maybe not inside the stream
                outputStream.flush();
                //closes the file connection
                outputStream.close();
            } catch (IOException ex) {
                System.out.println("IO Error " + ex.getMessage());
            }
        }
        else{
            System.out.println("The user is already registered");
            
        }
    }
    
    @Override
    public String login(){
        // this method will read from staffCredential file 
        // will ask for staff input for username and password
        // and will check every element in the file
        // to compare with given input
        Scanner in = new Scanner(System.in);
        String userInput;
        String passInput;
        int count = 0;
        System.out.println("Please enter your username and password");
        userInput = in.nextLine();
        passInput = in.nextLine();
        
        try{
            String filename = "logger.txt";
            File file = new File(filename);
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(file));
            outputStream.print(userInput);
            outputStream.flush();
            outputStream.close();
        } catch(IOException ex){
            System.out.println("IO Error "+ex.getMessage());
        }
        
        try {
            String filename = "staffCredentials.txt";
            // to read contents of file
            Scanner inputStream = new Scanner(new FileInputStream(filename));

            
            while (inputStream.hasNextLine()) {
                if (userInput.equals(inputStream.nextLine())) {//line 1
                    count = 1;
                    if (passInput.equals(inputStream.nextLine())) {// line 2
                        count = 2;
                        break; 
                    }
                } else {
                    inputStream.nextLine();// skip line 2
                    count = 0;
                }
            }

            inputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found " +ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IO error " + ex.getMessage());
        }
        
        if (count == 2) {
            //popupBox.infoBox("Login Successful" , "Login");
            return "Login successful";
        } else if (count == 1) {
            //popupBox.infoBox("Login Unsuccessful", "Login");
            return "Login unsuccessful\nwrong password";
        } else {
           // popupBox.infoBox("User is not registered", "Login");
            return "User is not registered";
        }
    }
    
    private boolean existingStaff(String name){
        String filename = "staff.txt";
        File file = new File(filename);
        String currentLine;
        String data[];
        boolean ret = true;
        try{
            Scanner inputStream = new Scanner(new FileInputStream(file));
            while(inputStream.hasNextLine()){
                currentLine = inputStream.nextLine();
                data = currentLine.split(",");
                if(name.equals(data[0]))
                    ret = false;
                else
                    ret = true;
            }
        } catch(FileNotFoundException ex){
            System.out.println("File not found " +ex.getMessage());
        }
        return ret;
    }
}