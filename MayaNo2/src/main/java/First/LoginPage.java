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
    public static void staffRegister(){
        //this method will ask users input for information
        //this method creates two files, staff and staffCredentials
        //student stores all staff information
        //staffCredentials is used explicitly by student login 
        Scanner input = new Scanner(System.in);
        String mail, username, password, fullname ,staff;
        // asking user credentials
        System.out.println("Please enter your Full Name");
        fullname = input.nextLine();
        System.out.println("Please enter your Univerisity Email");
        mail = input.nextLine();
        System.out.println("Please enter your preferred username");
        username = input.nextLine();
        System.out.println("Please enter your password");
        password = input.nextLine();
        
        //making all credentials into one string
        staff = username + " "+mail + " " +fullname +" "+password ;
        
        try{
            String filename = "staff";
            // creates new file if not there
            // if file exists it will do nothing
            File file = new File(filename);
            // appends existing file
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(file,true));
            //adds the string staff into the file
            outputStream.println(staff);
            //closes the file connection
            outputStream.close();
        }catch(IOException ex){
            System.out.println("IO Error " +ex.getMessage());
        }    
        
        try{
            String filename = "staffCredentials";
            // creates new file if not there
            // if file exists it will do nothing
            File file = new File(filename);
            // appends existing file
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(file,true));
            //adds the string staff into the file
            outputStream.println(username);
            outputStream.println(password);
            //closes the file connection
            outputStream.close();
        }catch(IOException ex){
            System.out.println("IO Error " +ex.getMessage());
        }
    }

    public static void studentRegister(){
        //this method will ask users input for information
        //this method creates two files, student and studentCredentials
        //student stores all student information
        //studentCredentials is used explicitly by student login 
        Scanner input = new Scanner(System.in);
        String mail, matrixNum, password, fullname ,student;
        // asking user credentials
        System.out.println("Please enter your Full Name");
        fullname = input.nextLine();
        System.out.println("Please enter your Univerisity Email");
        mail = input.nextLine();
        System.out.println("Please enter your Matrix Number");
        matrixNum = input.nextLine();
        System.out.println("Please enter your password");
        password = input.nextLine();
        
        //making all credentials into one string
        student = matrixNum + " " +mail + " " +fullname +" " +password ;
        
        try{
            String filename = "student";
            // creates new file if not there
            // if file exists it will do nothing
            File file = new File(filename);
            // appends existing file
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(file,true));
            //adds the string studentinto the file
            outputStream.println(student);
            //closes the file connection
            outputStream.close();
        }catch(IOException ex){
            System.out.println("IO Error " +ex.getMessage());
        } 
        
        try{
            String filename = "studentCredentials";
            // creates new file if not there
            // if file exists it will do nothing
            File file = new File(filename);
            // appends existing file
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(file,true));
            //adds the credentials into the file
            outputStream.println(matrixNum);
            outputStream.println(password);
            //closes the file connection
            outputStream.close();
        }catch(IOException ex){
            System.out.println("IO Error " +ex.getMessage());
        }
    }
    
    public static String staffLogin(){
        // this method will read from staffCredential file 
        // will ask for staff input for username and password
        // and will check every element in the file
        // to compare with given input
        Scanner in = new Scanner(System.in);
        String userInput, passInput;
        int count=0;
        System.out.println("Please enter your username and password");
        userInput = in.nextLine();
        passInput = in.nextLine();
        
        try {
            String filename = "staffCredentials";
            
            Scanner inputStream = new Scanner(new FileInputStream(filename));
            
            while (inputStream.hasNextLine()){
                if(userInput.equals(inputStream.nextLine())){
                    count = 1;
                    if(passInput.equals(inputStream.nextLine()))
                        count = 2;
                }
                else{
                    inputStream.nextLine();
                    count = 0;
                }
            }
            
            inputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            System.out.println("IO error "+ex.getMessage());
        }
        
        if (count == 2)
            return "Login successful";
        else if (count ==1)
            return "Login unsuccessful\nwrong password";
        else
            return "User is not registered";
    }
    
    public static String studentLogin(){
        // this method will read from studentCredential file 
        // will ask for student input for matrix num and password
        // and will check every element in the file
        // to compare with given input
        Scanner in = new Scanner(System.in);
        String userInput, passInput;
        int count=0;
        System.out.println("Please enter your matrix number and password");
        userInput = in.nextLine();
        passInput = in.nextLine();
        
        try {
            String filename = "studentCredentials";
            
            Scanner inputStream = new Scanner(new FileInputStream(filename));
            
            while (inputStream.hasNextLine()){
                if(userInput.equals(inputStream.nextLine())){
                    count = 1;
                    if(passInput.equals(inputStream.nextLine()))
                        count = 2;
                }
                else{
                    inputStream.nextLine();
                    count = 0;
                }
            }
            
            inputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            System.out.println("IO error "+ex.getMessage());
        }
        
        if (count == 2)
            return "Login successful";
        else if (count ==1)
            return "Login unsuccessful\nwrong password";
        else
            return "User is not registered";
    }
}