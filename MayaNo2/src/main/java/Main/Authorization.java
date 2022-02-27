package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hassanal
 */
public class Authorization {

    /**
     * empty constructor 
     */
    public Authorization() {
    }
    
    /**
     * this method will ask users input for information
     * this method creates two files, staff and staffCredentials
     * this method also calls the existing staff method to check for existing staff
     * to avoid two mirrored accounts being created
     * this method also uses the Checker object
     * to check the regular expression for email and username
     * 
     * student stores all staff information
     * staffCredentials is used explicitly by student login 
     */
    public void staffRegister() {
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
        //input.close();
    }

    /**
     * this method is to check for existing staff
     * in staff.txt file
     * this is in order to avoid double account registrations
     * @param name - comes from staff register name input
     * @return true if there is no same names in staff.txt file
     */
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
    
    /**
     * this method works in the same way as staffRegister method
     * where inside, 
     * this method will ask users input for information
     * inside, this method calls existingStudent method
     * to check for existing accounts to avoid
     * double registrations
     * 
     * this method creates two files, student and studentCredentials
     * student stores all student information
     * studentCredentials is used explicitly by student login 
     */
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

        if(existingStudent(matrixNum)){
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
        else{
            System.out.println("This user is already registered");
        }
        //input.close();
    }

    /**
     * this method is to check for existing students
     * in student.txt file
     * @param name - comes from student register name input
     * @return true if there is no same names in student.txt file
     */
    private boolean existingStudent(String name){
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
    
    /**
     * this method will read from staffCredential file 
     * will ask for staff input for username and password
     * and will check every element in the staffCredential.txt file
     * to compare with given input
     * @return the result of the comparison in the String representation
     * if return is "Login successful" staff account can continue to staff page
     * from main class
     */
    public String staffLogin() {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        
        String userInput;
        String passInput;
        int count = 0;
        System.out.println("Please enter your username and password");
        userInput = in.nextLine();
        passInput = in.nextLine();
        
        try{
            String [] data;
            String filename = "loggerStaff.txt" , currentLine , name = "";
            File file = new File(filename);
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(file));
            // this try catch block is to get the fullname
            try{
                Scanner inputStream = new Scanner ( new FileInputStream("staff.txt"));

                while (inputStream.hasNextLine()){
                    currentLine = inputStream.nextLine();
                    data = currentLine.split(",");
                    if(data[0].equals(userInput)){
                        name = data[2];
                    }
                }
                inputStream.close();
            } catch(FileNotFoundException ex){
                System.out.println("File not found "+ex.getMessage());
            }

            if (name != ""){
                outputStream.println(userInput);
                outputStream.println(name);
            }
            
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
            Logger.getLogger(Authorization.class.getName()).log(Level.SEVERE, null, ex);
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

    /**
     * this method will read from studentCredential file 
     * will ask for student input for matrix num and password
     * and will check every element in the studentCredential.txt file
     * to compare with given input
     * @return the result of the comparison in the String representation
     * if return is "Login successful" student account can continue to student page
     * from main class
     */
    public String studentLogin() {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
       
        String userInput, passInput;
        int count = 0;
        System.out.println("Please enter your matrix number and password");
        userInput = in.nextLine();
        passInput = in.nextLine();
        
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

        try {
            String filename = "studentCredentials.txt";

            Scanner inputStream = new Scanner(new FileInputStream(filename));

            while (inputStream.hasNextLine()) {
                if (userInput.equals(inputStream.nextLine())) {
                    count = 1;
                    if (passInput.equals(inputStream.nextLine())) {
                        count = 2;
                        break;
                    }
                } else {
                    inputStream.nextLine();
                    count = 0;
                }
            }

            inputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Authorization.class.getName()).log(Level.SEVERE, null, ex);
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
    
    /**
     * this is a method used in Staff class to differentiate between different types of
     * lecturer status
     * this is a security measure to avoid lower status lecturers to enter
     * certain parts to the staff page
     * @return if staff status is associate prof and prof only return true
     */
    public boolean staffTest(){
        //staff = username + "," + mail + "," + fullname + "," + password + "," +status;
        // get inUser from logger file
        String inUser = "";
        int position =4;
        String filename = "staff.txt";
        boolean ret = false;

        // to get inUser from logger
        try{
            String filename1 = "loggerStaff.txt";
            File file = new File(filename1);
            Scanner inputStream = new Scanner(new FileInputStream(file));
            inUser = inputStream.next();
            inputStream.close();
        }catch(FileNotFoundException ex){
            System.out.println("File Not Found "+ex.getMessage());
        }

        try{
            String [] data;
            String currentLine;
            File file = new File(filename);
            Scanner inputStream = new Scanner (new FileInputStream(file));
            while(inputStream.hasNextLine()){
                currentLine = inputStream.nextLine();
                data = currentLine.split(",");
                
                if (data[0].equals(inUser) ){
                    if(data[position].equalsIgnoreCase("Associate Professor")){
                         ret = true;
                         break;
                    }
                        
                    else if (data[position].equalsIgnoreCase("Professor")){
                        ret = true;
                         break;
                    }
                    else{
                        ret = false;
                        break;
                    }
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