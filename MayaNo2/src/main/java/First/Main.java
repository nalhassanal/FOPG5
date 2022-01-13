package First;


import java.util.Scanner;

/**
 *
 * @author Hassanal
 */
public class Main {
        static LoginPage log = new LoginPage();
        static StaffPage staff = new StaffPage();
        static Scanner in = new Scanner(System.in);
        static String type;
        static boolean keepGoing = true;
        static popupBox box;
    public static void main(String[] args){
        box = new popupBox();
        box.infoBox("WELCOME TO MAYA 2.0", "MAYA");
        int typeNum;
        in = new Scanner(System.in);
        int i = 0;
        displayMenu();
        String choice = in.next();
        switch(choice.toUpperCase()){
            case "A" :
                logIn();
                break;
                
            case "B" :
                register();
                break;
                
            case "X" :
                System.out.println("Exiting normally...");
                break;
                
            default :
                i++;
                if(i >= 3){
                    System.out.println("You entered wrong three times\nProgram exited....");
                    break;
                }
                else
                    main(null);   
        }
        do{
            System.out.println("What do you want to do?");
            System.out.println("1. Login\n2. Register");
            typeNum = in.nextInt();
            
            switch(typeNum){
                case 1:
                    logIn();
                    break;
                case 2:
                    register();
                    break;
                default:
                    i++;
                    System.out.println("Invalid Input\nPlease Try Again");
                    main(null);
                    break;
            }
            // asks user if they want to log out
            System.out.println("do you want to log out? (yes or no)");
            type = in.nextLine();
            if("YES".equals(type) || "yes".equals(type) ||"Yes".equals(type))
                keepGoing = false;
            else if("NO".equals(type) || "no".equals(type) || "No".equals(type))
                main(null);
            
            // breaks the loop after 3 tries at START
            if ( i > 2){
                System.out.println("Please reload the program");
                keepGoing = false;
            }
        }while(keepGoing);
    }
    
    public static void displayMenu(){
        System.out.println();
        System.out.println("A) LOGIN ");
        System.out.println("B) REGISTER ");
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
        log = new LoginPage();
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
                    logout();
                    String logout = in.next();
                    if(logout.equalsIgnoreCase("yes")){
                        break;
                    }
                    else
                        staff.staff();
                }
                else{
                    System.out.println("Login unsuccessful");
                    System.out.println(login);
                    break;
                }
                
            case "student":
                login = log.studentLogin();
                // display login result
                System.out.println(login);
                //main(null);
                break;

            default:
                // error message
                System.out.println("Error please reload program.");
                keepGoing = false;
                break;
        }
    }
}