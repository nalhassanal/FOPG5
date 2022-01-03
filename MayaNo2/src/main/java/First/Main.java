package First;


import java.util.Scanner;

/**
 *
 * @author Hassanal
 */
public class Main {
    public static void main(String[] args){
        LoginPage log = new LoginPage();
        Scanner in = new Scanner(System.in);
        String type;
        boolean keepGoing = true;
        
        while(keepGoing){
            int i = 0;
            i++;
            // asks user if they have account or not (START)
            System.out.println("Do you have account? (yes or no)");
            type = in.nextLine();
            if("NO".equals(type) || "no".equals(type) || "No".equals(type)){
                // asks user if they want to REGISTER as student or staff
                System.out.println("Do you want to register as student or staff? (student or staff)");
                type = in.nextLine();
                switch(type){
                    case "staff":
                        log.staffRegister();
                        // asks user if they want to continue AFTER REGISTER
                        System.out.println("do you want to continue? (yes or no)");
                        type = in.nextLine();
                        if("YES".equals(type) || "yes".equals(type) ||"Yes".equals(type))
                            keepGoing = true;
                        else if("no".equals(type) || "NO".equals(type) || type == "No")
                            keepGoing = false;
                        break;

                    case "student":
                        log.studentRegister();
                        // asks user if they want to continue AFTER REGISTER
                        System.out.println("do you want to continue? (yes or no)");
                        type = in.nextLine();
                        if("YES".equals(type) || "yes".equals(type) ||"Yes".equals(type))
                            keepGoing = true;
                        else if("NO".equals(type) || "no".equals(type) || "No".equals(type))
                            keepGoing = false;
                        break;

                    default:
                        // error statement
                        System.out.println("Error please reload program.");
                        keepGoing = false;
                        break;
                }
            }
            else if("YES".equals(type) || "yes".equals(type) ||"Yes".equals(type)){
                // asks user if they are student or staff
                System.out.println("Are you a student or staff? (student or staff)");
                type = in.nextLine();
                switch(type){
                    case "staff":
                        String login = log.staffLogin();
                        // display login result
                        System.out.println(login);
                        // asks user if they want to continue AFTER LOGIN
                        System.out.println("do you want to continue? (yes or no)");
                        type = in.nextLine();
                        if("YES".equals(type) || "yes".equals(type) ||"Yes".equals(type))
                            keepGoing = true;
                        else if("NO".equals(type) || "no".equals(type) || "No".equals(type))
                            keepGoing = false;
                        break;
                    
                    case "student":
                        login = log.studentLogin();
                        // display login result
                        System.out.println(login);
                        // asks user if they want to continue AFTER LOGIN
                        System.out.println("do you want to continue? (yes or no)");
                        type = in.nextLine();
                        if("YES".equals(type) || "yes".equals(type) ||"Yes".equals(type))
                            keepGoing = true;
                        else if("NO".equals(type) || "no".equals(type) || "No".equals(type))
                            keepGoing = false;
                        break;
                   
                    default:
                        // error message
                        System.out.println("Error please reload program.");
                        keepGoing = false;
                        break;
                }
            }
            
            // breaks the loop after 3 tries at START
            if ( i >= 3)
                keepGoing = false;
        }
    }
}