package Staff;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author Hassanal
 */
public class StaffPage {
    private static Scanner input;
    public static void main (String[] args){
        input = new Scanner(System.in);
        int menu, count = 0;
        boolean keepGoing = true;
        while ( keepGoing){
            count++;
            System.out.println("Welcome to the staff page!!");
            System.out.println("1. Modify Modules");
            System.out.println("2. View Modules");
            System.out.println("3. View Students in your classes");
            System.out.println("Enter the number you want >> ");
            menu = input.nextInt();
            if ( menu == 1){
                module();
                System.out.println("end program");
                break;
            }
            else if( menu == 2){

            }
            else if ( menu == 3){

            }
            else{
                System.out.println("Invalid number, try again");
                if ( count >= 3)
                    keepGoing = false;
            }
        }        
    }
    
    
    private static void module(){
        int menu = 0;
        input = new Scanner(System.in);
        System.out.println("What do you want to do here?");
        System.out.println("1. Create a new module");
        System.out.println("2. Delete existing module");
        System.out.println("3. Edit a module");
        System.out.println("Enter the number you want >> ");
        menu = input.nextInt();
        if ( menu == 1){
            String process = addModule();
            System.out.println(process);
        }
        else if ( menu == 2){
            
        }
        else if ( menu == 3){
            
        }
        else{
            System.out.println("invalid number , try again");
            module();
        }
    }
    
    private static String addModule(){
        input = new Scanner(System.in);
        int numofOcc = 1, credits = 1 , numAct;
        String moduleCode = "WIX1001", moduleName = "Computing Maths" , Activities = "Lab";
        String ret = "Unsuccessfull Module Addition";
        final String ACT1 = "Lecture", ACT2 = "Tutorial" , ACT3 = "Lab";
        System.out.println("Welcome to add module!");
        // ask module code
        System.out.println("Please enter the module code > ");
        moduleCode = input.nextLine();
        // ask module name
        System.out.println("Please enter the module name > ");
        moduleName = input.nextLine();
        // ask the number of occurence
        System.out.println("Please enter the number of occurences > ");
        numofOcc = input.nextInt();
        // ask the number of occurences
        System.out.println("Please enter the number of credits > ");
        credits = input.nextInt();
        // ask the number of activities
        System.out.println("How many activities will this module have?\n( must less than or equal to 2 )");
        numAct = input.nextInt();
        int [] inACT = new int [numAct];
        String [] ACT = new String [numAct];
        // ask the type of activities
        System.out.println("Please enter the activities type");
        System.out.println("1. Lecture\t2. Tutorial\t 3. Lab");
        for ( int i = 0 ; i < numAct ; i++){
            inACT [i] = input.nextInt();
            switch (inACT[i]) {
                case 1:
                    // store the activity type into activity array
                    ACT [i] = ACT1;
                    break;
                case 2:
                    ACT [i] = ACT1;
                    break;
                case 3:
                    ACT [i] = ACT1;
                    break;
                default:
                    break;
            }
        }
        if ( numAct == 1){
            Activities = ACT[0];
        }
        else if ( numAct == 2){
            Activities = ACT[0] +" & " +ACT[1];
        }
      
        try{
            String filename = moduleName + " occurence.txt";
            File file = new File(filename);
            
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(file,true));
            if ( numAct == 1){
                Activities = ACT[0];
            }
            else if ( numAct == 2){
                Activities = ACT[0] +" & " +ACT[1];
            }
            outputStream.println(moduleCode);
            outputStream.println(moduleName);
            outputStream.println(numofOcc);
            outputStream.close();
        } catch(IOException ex) {
            System.out.println("IO Error " +ex.getMessage());
        }
        
        try{
            String filename = "allModules.txt";
            
            File file = new File(filename);
            
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(file,true));
            
            outputStream.println(moduleCode);
            outputStream.println(moduleName);
            outputStream.println(numofOcc);
            outputStream.println(Activities);
            
            ret = "Module Added successfully";
            
            outputStream.close();            
            
        } catch(IOException ex){
            System.out.println("IO Error " +ex.getMessage());
            ret = "Failed to add Modules";
        }
        return ret;
    }
    
    private static void deleteModule(){
        
    }
    
    private static void editModule(){
        
    }
    
    private static void view(){
        
    }
    
    private static void stuClass(){
        
    }
    
}