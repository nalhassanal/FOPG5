package First;
/**
 *
 * @author Hassanal
 */
import java.util.*;
public class Main {
    public static void main(String [] args){
       String type, userID, userPass;
       userID = "U2102848";//initialize to some value
       userPass = "Hassanal";
       String ID, password;// this is for the user input
       Scanner in = new Scanner(System.in);
       boolean keepGoing = true;// this to make sure the loop keeps going
       int count=0;// this is to keep track of user trial
       while (keepGoing == true){
           count++;
            System.out.println("Are you student or staff?");// get input from user for student or staff
            type = in.nextLine();
            if ("student".equalsIgnoreCase(type)){//checks if the type is for students
                System.out.println("Enter user ID : ");//get input from user for their ID
                ID = in.nextLine();
                System.out.println("Enter user Password : ");//get input from user for their password
                password = in.nextLine();
                if ( ID.equalsIgnoreCase(userID) && password.equalsIgnoreCase(userPass)){// checks if both credentials are true
                    System.out.println("Welcome Student");
                    break;//breaks the loop and continue student part
                }
            }
            else if ("staff".equalsIgnoreCase(type)){// checks if the type is for staff
                 System.out.println("Enter user ID : ");// get input for staff ID
                 ID = in.nextLine();
                 System.out.println("Enter user Password : ");// get input for staff password
                 password = in.nextLine();
                 if ( ID.equalsIgnoreCase(userID) && password.equalsIgnoreCase(userPass)){// check if both credentials are true
                    System.out.println("Welcome Staff");
                    break;// breaks the loop and continue staff part
                 }
             }
            else {
                if(count <3)//give three tries to login
                System.out.println("Invalid. Try again!");
                else if (count == 3){ // more than 3 tries exit the loop
                    keepGoing = false;// make loop condition false
                    System.out.println("Exceeded 3 tries. Program exited.");
                }
            }
       }
    }
}
