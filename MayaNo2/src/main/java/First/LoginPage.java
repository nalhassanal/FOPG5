package First;

/**
 *
 * @author Hassanal
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginPage {

    public LoginPage() {
    }
    
    public void staffRegister() {
        //this method will ask users input for information
        //this method creates two files, staff and staffCredentials
        //student stores all staff information
        //staffCredentials is used explicitly by student login 
        Scanner input = new Scanner(System.in);
        String mail ="", username ="", password, fullname, staff, status ="Lecturer";
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
        System.out.println("Please enter your password");
        password = input.nextLine();
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

    public void studentRegister() {
        //this method will ask users input for information
        //this method creates two files, student and studentCredentials
        //student stores all student information
        //studentCredentials is used explicitly by student login 
        Scanner input = new Scanner(System.in);
        String mail ="", matrixNum, password, fullname, student , programme ="Bachelor of Computer Science (Data Science)", muet = "Band 2";
        int muetNum,programmeNum;
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
                System.out.println("Email example username@siswa.um.edu.my");
                keepGoing = true;
            }
        }
        System.out.println("Please enter your Matrix Number");
        matrixNum = input.nextLine();
        System.out.println("Please enter your password");
        password = input.nextLine();
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
                programme = "Bachelor of Computer Science (Computer System and Network";
                break;
            case 4:
                programme = "Bachelor of Computer Science (Software Engineering)";
                break;
            case 5:
                programme = "Bachelor of Information Technology (Information Systems";
                break;
            case 6:
                programme = "Bachelor of Information Technology (Multimedia)";
                break;
        }
        System.out.println("Please enter your MUET band (3,4,5,6)");
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

        try {
            String filename = "student.txt";
            // creates new file if not there
            // if file exists it will do nothing
            File file = new File(filename);
            // appends existing file
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(file, true));
            //adds the string studentinto the file
            outputStream.println(student);
            //flushes PrintWriter
            //clear the stream of any element that may be or maybe not inside the stream            
            outputStream.flush();
            //closes the file connection
            outputStream.close();
        } catch (IOException ex) {
            System.out.println("IO Error " + ex.getMessage());
        }

        try {
            String filename = "studentCredentials.txt";
            // creates new file if not there
            // if file exists it will do nothing
            File file = new File(filename);
            // appends existing file
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(file, true));
            //adds the credentials into the file
            outputStream.println(matrixNum);
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

    private String userInput;
    public String staffLogin() {
        // this method will read from staffCredential file 
        // will ask for staff input for username and password
        // and will check every element in the file
        // to compare with given input
        Scanner in = new Scanner(System.in);
        String passInput;
        int count = 0;
        System.out.println("Please enter your username and password");
        userInput = in.nextLine();
        passInput = in.nextLine();
        
        try {
            String filename = "staffCredentials.txt";
            // to read contents of file
            Scanner inputStream = new Scanner(new FileInputStream(filename));

            
            while (inputStream.hasNextLine()) {
                if (userInput.equals(inputStream.nextLine())) {//line 1
                    count = 1;
                    if (passInput.equals(inputStream.nextLine())) {// line 2
                        count = 2;
                    }
                } else {
                    inputStream.nextLine();// skip line 2
                    count = 0;
                }
            }

            inputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
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

    public String studentLogin() {
        // this method will read from studentCredential file 
        // will ask for student input for matrix num and password
        // and will check every element in the file
        // to compare with given input
        Scanner in = new Scanner(System.in);
        String userInput, passInput;
        int count = 0;
        System.out.println("Please enter your matrix number and password");
        userInput = in.nextLine();
        passInput = in.nextLine();

        try {
            String filename = "studentCredentials.txt";

            Scanner inputStream = new Scanner(new FileInputStream(filename));

            while (inputStream.hasNextLine()) {
                if (userInput.equals(inputStream.nextLine())) {
                    count = 1;
                    if (passInput.equals(inputStream.nextLine())) {
                        count = 2;
                    }
                } else {
                    inputStream.nextLine();
                    count = 0;
                }
            }

            inputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("IO error " + ex.getMessage());
        }

        if (count == 2) {
            return "Login successful";
        } else if (count == 1) {
            return "Login unsuccessful\nwrong password";
        } else {
            return "User is not registered";
        }
    }
    
    public boolean staffTest(){
        // if staff status is associate prof and prof only return true
        //staff = username + "," + mail + "," + fullname + "," + password + "," +status;
        String inUser = userInput;
        int position =4;
        String filename = "staff.txt";
        boolean ret = false;
        try{
            String [] data;
            String currentLine;
            File file = new File(filename);
            Scanner inputStream = new Scanner (new FileInputStream(file));
            while(inputStream.hasNextLine()){
                currentLine = inputStream.nextLine();
                data = currentLine.split(",");
                
                if (data[0].equals(inUser) ){
                    if(data[position].equals("Associate Professor") || data[position].equals("Professor")){
                         ret = true;
                        
                    }
                    else
                         ret = false;
                }
                
            }
            inputStream.close();
        } catch(FileNotFoundException ex){
            System.out.println("IO Error "+ex.getMessage());
            return false;
        }
        return ret;
    }
}