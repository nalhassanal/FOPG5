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
public class Student implements Register{
    
    public Student(){
    }
    
    @Override
    public void reg(){
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
    }
    @Override
    public String login(){
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
            System.out.println("File not found "+ex.getMessage());
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
}