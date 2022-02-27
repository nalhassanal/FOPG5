package Main;


import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;

/**
 *
 * @author Hassanal
 */
public class Main {
    
    /**
     * this is a static object for authorization class that is to be used by
     * register and log in method
     */
    static Authorization log = new Authorization();

    /**
     * this is a static object for staff class that is to be used by log in method
     */
    static Staff staff = new Staff();

    /**
     * this is a static object for student class that is to be used by log in method
     */
    static Student student = new Student();

    /**
     * this is a static object for getting user input
     */
    static Scanner in = new Scanner(System.in);

    /**
     * this is a static object for Chatbot class to be used in main method
     */
    static Chatbot bot = new Chatbot();

    /**
     * a static variable to be used by register and log in method as the type of user
     * either staff or student
     */
    static String type;

    /**
     * a static variable to be used by every loop in every method 
     * whenever applicable
     */
    static boolean keepGoing = true;

    /**
     * a static object for popupBox class to be used in any methods that needs it
     */
    static popupBox box;

    static Authorizationsql regSql = new Authorizationsql();
        
    /**
     * This main method is responsible for the main menu of the whole
     * application whenever a user wants to exit, must go through here
     *
     * @param args - not used
     */
    public static void main(String[] args){
        wait(100);
        consoleClear();
        box = new popupBox();
        box.infoBox("WELCOME TO MAYA 2.0", "MAYA");
        in = new Scanner(System.in);
        int i = 0;
        while(keepGoing){
            System.out.println("MAYA 2.0");
            System.out.println("--------------------------------------------------------");
            displayMenu();
            String choice = in.next();
            switch(choice.toUpperCase()){
                case "A" :
                    logIn();
                    break;

                case "B" :
                    register();
                    break;

                case "C" :
                    bot.ChatBot();
                    break;

                case "X" :
                    System.out.println("Exiting normally...");
                    wait(1000);
                    consoleClear();
                    keepGoing = false;                    
                    break;

                default :
                    i++;
                    if(i >= 3){
                        System.out.println("You entered wrong three times\nProgram exited....");
                        keepGoing = false;
                        break;
                    }
                    break;
            }
        }
        
    }
    
    /**
     * this is a delay method 
     * which functions to sleep the process for how many milliseconds 
     * also handles error in the case that the sleep gets interrupted
     * @param millisec
     */
    private static void wait(int millisec){
        try{
            Thread.sleep(millisec);
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * this consoleClear method uses a java robot
     * which automates the process of pressing CTRL + L together
     * to clear the console screen of netbeans IDE
     */
    private static void consoleClear(){
        try{
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key
            pressbot.keyPress(76); // Holds L key
            pressbot.keyRelease(17); // Releases CTRL key
            pressbot.keyRelease(76); // Releases L key
        } catch (AWTException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * this is a menu method for the main method
     */
    public static void displayMenu(){
        System.out.println();
        System.out.println("A) LOGIN ");
        System.out.println("B) REGISTER ");
        System.out.println("C) CHAT WITH HELPER");
        System.out.println("X) EXIT");
        System.out.println();
        System.out.println("Please choose one : ");
    }
    
    /**
     * this is just a log out statement
     */
    public static void logout(){
        System.out.println();
        System.out.println("Do you want to log out?");
        System.out.println();
    }
    
    /**
     * this is a register menu method, this is where
     * after user inputs their status will get redirected to the 
     * appropriate registration sequence
     * and after the sequence, it will continue to the log in method
     */
    public static void register(){
        box = new popupBox();
        box.infoBox("WELCOME TO REGISTRATION PAGE", "REGISTRATION PAGE");

        // asks user if they want to REGISTER as student or staff
        in = new Scanner(System.in);
        log = new Authorization();
        System.out.println("Do you want to register as student or staff? (student or staff)");
        type = in.nextLine();
        switch(type.toLowerCase()){
            case "staff":
                // log.staffRegister();
                regSql.staffRegister();
                System.out.println();
                System.out.println("--------------------------------------------------------");
                System.out.println();
                logIn();
                break;

            case "student":
                // log.studentRegister();
                regSql.studentRegister();
                System.out.println();
                System.out.println("--------------------------------------------------------");
                System.out.println();
                logIn();
                break;

            default:
                // error statement
                System.out.println("Error please reload program.");
                keepGoing = false;
                break;
        }
    }
    
    /**
     * this is the log in method, this is where
     * after user inputs their status, will get redirected 
     * to the appropriate log in sequence
     * if successful then user be redirected
     * to appropriate status menu
     * ie. staff or student
     * 
     * this method will also call the log out method and 
     * processes the logout sequence 
     * if user chooses to logout, it will end the program
     * else it will go back to their respective menus.
     */
    public static void logIn(){
        // asks user if they are student or staff
        
        box = new popupBox();
        box.infoBox("WELCOME TO LOGIN PAGE", "LOGIN PAGE");
        in = new Scanner(System.in);
        System.out.println("Are you a student or staff? (student or staff)");
        type = in.nextLine();
        switch(type.toLowerCase()){
            case "staff":
                //String login = log.staffLogin();
                String login = regSql.staffLogin();
                // this maybe need some confirmation
                if(login.equals("Login successful")){
                    // display login result
                    System.out.println(login);
                    wait(1000);
                    consoleClear();
                    staff.staff();
                    keepGoing = true;
                    while (keepGoing){
                        logout(); // maybe this needs loop
                        String logout = in.next();
                        if(logout.equalsIgnoreCase("yes")){
                            keepGoing = false;
                            System.out.println("Successful log out");
                            System.out.println("Exiting program...");
                            wait(2000);
                            consoleClear();
                            System.out.println();
                            System.out.println("Thank you for using our program");
                            System.out.println("Created by Group 5");
                            System.out.println("--------------------------------------------------------");
                        }
                        else
                            staff.staff(); 
                    }
                    
                }
                else{
                    System.out.println("Login unsuccessful");
                    System.out.println(login);
                    break;
                }
                break;
                
            case "student":
                //login = log.studentLogin();
                login = regSql.studentLogin();
                
                if(login.equals("Login successful")){
                    // display login result
                    System.out.println(login);
                    wait(1000);
                    consoleClear();
                    student.student();
                    keepGoing = true;
                    while (keepGoing){
                        logout();
                        String logout = in.next();
                        if(logout.equalsIgnoreCase("yes")){
                            keepGoing = false;
                            System.out.println("Successful log out");
                            System.out.println("Exiting program...");
                            wait(2000);
                            consoleClear();
                            System.out.println();
                            System.out.println("Thank you for using our program");
                            System.out.println("Created by Group 5");
                            System.out.println("--------------------------------------------------------");
                        }
                        else{
                            student.student();
                        }
                    }
                }
                else{
                    System.out.println("Login unsuccessful");
                    System.out.println(login);
                    break;
                }
                break;

            default:
                // error message
                System.out.println("Error please reload program.");
                keepGoing = false;
                break;
        }
    }
}