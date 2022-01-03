package Staff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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
            System.out.println("4. Exit");
            System.out.println("Enter the number you want >> ");
            menu = input.nextInt();
            switch (menu) {
                case 1:
                    module();
                    //staffPage(); // rename main as staffPage
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    stuClass();
                    break;
                case 4:
                    keepGoing = false;
                    break;
                default:
                    System.out.println("Invalid number, try again");
                    if ( count >= 3)
                        keepGoing = false;
                    break;
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
        System.out.println("4. Exit");
        System.out.println("Enter the number you want >> ");
        menu = input.nextInt();
        if ( menu == 1){
            String process = addModule();
            System.out.println(process);
            module();
        }
        else if ( menu == 2){
            deleteModule();
        }
        else if ( menu == 3){
            editModule();
        }
        else if ( menu == 4){
            //staffPage(); // rename main as staffPage
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
                    ACT [i] = ACT2;
                    break;
                case 3:
                    ACT [i] = ACT3;
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
            String filename = moduleCode + ".txt";
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
            outputStream.flush();
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
            outputStream.flush();
            outputStream.close();            
            
        } catch(IOException ex){
            System.out.println("IO Error " +ex.getMessage());
        }
        return ret;
    }
    
    private static void deleteModule(){
        input = new Scanner(System.in);
        
        String delete; 
        System.out.println("Please enter the module code that you want to delete");
        delete = input.nextLine();
        
        String filename = "output.txt";
        String filename1 = "allModules.txt";
        String filename2 = "delete.txt";
        try {
            File file = new File(filename2);
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(filename2,true));
            outputStream.println(delete);
            outputStream.flush();
            outputStream.close();
        } catch (IOException ex) {
            System.out.println("IO error "+ex.getMessage());
        }
        
        try{
            File file = new File(filename);
            File file1 = new File(filename1);
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(filename,true));

            Scanner inputStream = new Scanner(new FileInputStream(filename1));
            String line1 = inputStream.nextLine();
            
            while(inputStream.hasNextLine()){
                Scanner inputStream1 = new Scanner(new FileInputStream(filename2));
                String line2 = inputStream1.nextLine();
                
                while (inputStream1.hasNextLine()){
                    boolean flag = false;
                    if (line1.equals(line2)){
                        flag = true;
                        break;
                    }
                    else{
                        inputStream.nextLine();
                        inputStream.nextLine();
                        inputStream.nextLine();
                    }
                    line2 = inputStream1.nextLine();
                    if(!flag){
                        outputStream.println(line1);
                    }
                }
                line1 = inputStream.nextLine();
            }
            
//            if(file1.renameTo(file))
//                System.out.println("File succesffully renamed");
//            else
//                System.out.println("Failed");

            outputStream.flush();
            
            //closing connections
            inputStream.close();
            outputStream.close();
            System.out.println("File successful");
        } catch(IOException ex){
            System.out.println("IO error "+ex.getMessage());
        }
    }
    
    private static void editModule(){
        
    }
    
    private static void view(){
        
    }
    
    private static void stuClass(){
        
    }
    
}
/*
public static void deleteStudents() throws IOException, FileNotFoundException
{
    Scanner console = new Scanner(System.in);
    String SY, date;
    System.out.println("ENTER THE SCHOOL YEAR: SY: ");
    SY = console.next();

    int i = 0;

    Scanner print = new Scanner(new FileReader("Students- SY " + SY + " " + ".txt"));
    //display text file
    while(print.hasNextLine())
    {
        String stud= print.nextLine();
        System.out.println(stud);
    }   

    File inputFile = new File("Students- SY " + SY + " " + ".txt");
    File tempFile = new File("Students- SY " + SY + " " + ".txt.bak");

    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

    String remove;
    String currentLine;

    System.out.println("ENTER STUDENT's ID NUMBER TO BE DELETED:  ");
    remove = console.next();
    while((currentLine = reader.readLine()) != null)
    {
        String trimmedLine = currentLine.trim();
        if(!trimmedLine.startsWith(remove)) 
        {
            writer.write(String.format("%s%n",currentLine)); 

        }
    }  
    //close reader/writer
    writer.close();
    reader.close();
  //delete file
    if(inputFile.delete())
    {
        tempFile.renameTo(inputFile);
    }
    else
    {
        System.out.println("FAIL");
    }
*/

/*
            while(line1 != null){
                boolean flag = false;
                
               //BufferedReader br2 = new BufferedReader(new FileReader(filename2));
                Scanner inputStream1 = new Scanner(new FileInputStream(filename2));
                String line2 = inputStream1.nextLine();
                
                
                if(line1.equals(line2)){
                        flag = true;
                }
                
                // if flag = false
                // write line of filename1 to filename
                if(!flag)
                    outputStream.println(line1);
                /*while (line2 != null){
                    if(line1.equals(line2)){
                        flag = true;
                        break;
                    }
                    // update condition
                    line2 = inputStream1.next();
                }
                
                //update condition
                line1 = inputStream.nextLine();
                if(line1 == null)
                    System.out.println("Successfully deleted");
            }
            */