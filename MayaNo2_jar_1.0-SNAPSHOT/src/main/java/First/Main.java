package First;


import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;

/**
 *
 * @author Hassanal
 */
public class Main {
        static authorization log = new authorization();
        static Staff staff = new Staff();
        static Student student = new Student();
        static Scanner in = new Scanner(System.in);
        static Chatbot bot = new Chatbot();
        static String type;
        static boolean keepGoing = true;
        static popupBox box;
    public static void main(String[] args){
        box = new popupBox();
        box.infoBox("WELCOME TO MAYA 2.0", "MAYA");
        in = new Scanner(System.in);
        int i = 0;
        while(keepGoing){
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
                    bot.Chatbot();
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
    
    private static void wait( int ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
            System.out.println(ex.getMessage());
        }
    }
    
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
    
    
    public static void displayMenu(){
        System.out.println();
        System.out.println("A) LOGIN ");
        System.out.println("B) REGISTER ");
        System.out.println("C) CHAT WITH HELPER");
        System.out.println("X) EXIT");
        System.out.println();
        System.out.println("Please choose one : ");
    }
    
    public static void logout(){
        System.out.println();
        System.out.println("Do you want to log out?");
        System.out.println();
    }
    
    public static void register(){
        box = new popupBox();
        box.infoBox("WELCOME TO REGISTRATION PAGE", "REGISTRATION PAGE");

        // asks user if they want to REGISTER as student or staff
        in = new Scanner(System.in);
        log = new authorization();
        System.out.println("Do you want to register as student or staff? (student or staff)");
        type = in.nextLine();
        switch(type.toLowerCase()){
            case "staff":
                log.staffRegister();
                logIn();
                break;

            case "student":
                log.studentRegister();
                logIn();
                break;

            default:
                // error statement
                System.out.println("Error please reload program.");
                keepGoing = false;
                break;
        }
    }
    
    public static void logIn(){
        // asks user if they are student or staff
        
        box = new popupBox();
        box.infoBox("WELCOME TO LOGIN PAGE", "LOGIN PAGE");
        in = new Scanner(System.in);
        System.out.println("Are you a student or staff? (student or staff)");
        type = in.nextLine();
        switch(type.toLowerCase()){
            case "staff":
                String login = log.staffLogin();
                // this maybe need some confirmation
                if(login.equals("Login successful")){
                    // display login result
                    System.out.println(login);
                    staff.staff();
                    keepGoing = true;
                    while (keepGoing){
                        logout(); // maybe this needs loop
                        String logout = in.next();
                        if(logout.equalsIgnoreCase("yes")){
                            keepGoing = false;
                            System.out.println("Exiting program...");
                            wait(1000);
                            consoleClear();
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
                login = log.studentLogin();
                
                if(login.equals("Login successful")){
                    // display login result
                    System.out.println(login);
                    student.student();
                    keepGoing = true;
                    while (keepGoing){
                        logout();
                        String logout = in.next();
                        if(logout.equalsIgnoreCase("yes")){
                            keepGoing = false;
                            System.out.println("Exiting program...");
                            wait(1000);
                            consoleClear();
                        }
                            
                        else{
                            wait(500);
                            student.student();
                        }
                    }
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