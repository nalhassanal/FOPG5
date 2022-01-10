package First;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author Hassanal
 */
public class StaffPage {
    private popupBox box;//add gui
    private Scanner input;

    public StaffPage() {
    }
    
    public void staff(){
        box = new popupBox();
        box.infoBox("WELCOME TO STAFF SECTION", "STAFF");
        input = new Scanner(System.in);
        int menu, count = 0;
        boolean keepGoing = true;
        while ( keepGoing){
            count++;
            System.out.println("Welcome to the staff page!!");
            System.out.println("1. Modify Modules");
            System.out.println("2. View Modules");
            System.out.println("3. View Students in your classes");
            System.out.println("4. Return");
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
    private LoginPage log;
    private void module(){
        int menu = 0;
        log = new LoginPage();
        input = new Scanner(System.in);
        System.out.println("What do you want to do here?");
        System.out.println("1. Create a new module");
        System.out.println("2. Delete existing module");
        System.out.println("3. Edit a module");
        System.out.println("4. Return");
        System.out.println("Enter the number you want >> ");
        menu = input.nextInt();
        if ( menu == 1){            
            if (log.staffTest() ){
                String process = addModule();
                System.out.println(process);
            }
            else{
                System.out.println("You are not allowed access in section");
                System.out.println("Please choose another number");
            }
            module();
            
        }
        else if ( menu == 2){
            if (log.staffTest()){
                String process = deleteModule();
                System.out.println(process);
            }
            else{
                System.out.println("You are not allowed access in section");
                System.out.println("Please choose another number");
            }
            module();
        }
        else if ( menu == 3){
            String process = editModule();
            System.out.println(process);
            module();
        }
        else if ( menu == 4){
            
        }
        else{
            System.out.println("invalid number , try again");
            module();
        }
    }
    
    // add how many expected target student in module
    // maybe this method can only be accessed by higher ranking lecturers only
    private String addModule(){
        input = new Scanner(System.in);
        int numAct , numofOcc , credits = 1 ;
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
        
        // ask the number of credit hours
        System.out.println("Please enter the number of credits > ");
        credits = input.nextInt();
       
        // ask the number of activities
        System.out.println("How many activities will this module have?\n( 1 OR 2 )");
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
            // this is the file for specific module
            String filename = moduleCode + ".txt";
            File file = new File(filename);
            
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(file,true));
            if ( numAct == 1){
                Activities = ACT[0];
            }
            else if ( numAct == 2){
                Activities = ACT[0] +" & " +ACT[1];
            }
            // info seperated by comma
            // additional info such as lecture name will 
            // added at editModule
            outputStream.println(moduleCode +","+moduleName+","+numAct+","+numofOcc);
            outputStream.flush();
            outputStream.close();
        } catch(IOException ex) {
            System.out.println("IO Error " +ex.getMessage());
        }
        
        try{
            // this is the file for all modules
            String filename = "allModules.txt", moduleInfo;
            
            File file = new File(filename);
            
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(file,true));
            moduleInfo = moduleCode + "," + moduleName +","+numofOcc+","+credits+","+Activities;
            
            outputStream.println(moduleInfo);
            
            ret = "Module Added successfully";
            outputStream.flush();
            outputStream.close();            
            
        } catch(IOException ex){
            System.out.println("IO Error " +ex.getMessage());
        }
        return ret;
    }
    
    private String deleteModule(){
        // this method is to perform delete module
        // can only delete modules one by one
        // asks user for the module code to be deleted
        
        input = new Scanner(System.in);
        String filename = "allModules.txt", moduleCode , ret ="Failed to delete\nModule did not exist";
        System.out.println("Please enter the module code that you want to remove");
        moduleCode = input.nextLine();
        int position = 0;
        
        String tempFile = "temp.txt";
        File oldFile = new File(filename); // creates a file object for allModules.txt
        // creates a temporary output file after we remove the term 
        File newFile = new File(tempFile);
        // creates a file object corresponding to the specific module
        File file = new File(moduleCode+".txt");
        String currentLine;
        String [] data;
        
        try{
            FileWriter fWriter = new FileWriter(tempFile, true);
            BufferedWriter buffWrite = new BufferedWriter(fWriter);
            PrintWriter outputStream = new PrintWriter(buffWrite,true);
            
            FileReader fReader = new FileReader(filename);
            BufferedReader buffReader = new BufferedReader(fReader); //faster reading compared to scanner 
            
            while ((currentLine = buffReader.readLine()) != null){
                
                data=currentLine.split(",");
                // when data in position 0 it is actually module code
                // so we compare the input with the data from text file
                // if data is not the same ( false )
                // we write the current line that buffered reader is reading
                // into the temporary file
                if (!(data[position].equals(moduleCode))){
                    outputStream.println(currentLine);
                }
            }

            outputStream.flush();
            outputStream.close();
            fWriter.close();
            buffWrite.close();
            buffReader.close();
            fReader.close();
            
            // delete unwanted files such as old allModules
            // and corresponding module file
            oldFile.delete();
            file.delete();
            // creates a dummy file that has the same name as allModule
            // then rename the temporary output file to be the same as dummy file name
            File temp = new File(filename);
            newFile.renameTo(temp);

            ret = "Successfully deleted module";
        } catch(IOException ex){
            System.out.println("IO Error "+ex.getMessage());
        } 
        return ret;
    }
    
    //maybe this method can be accessed by all lecturers
    private  String editModule(){
        input = new Scanner(System.in);
        String moduleCode , ret ="Failed to add new items";
        System.out.println("Enter the Module code that you want to edit >>");
        moduleCode = input.nextLine();
        String filename = moduleCode+".txt", currentLine;
        String [] data;
        int numAct = 1;
        File modulefile = new File(filename);     
        
        int index;
        String name;
        String day,time;
        String act2Name = "" ,act2day = "Monday",act2time = "0900 - 1100";
        try{
            // appends existing file
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(modulefile,true));
            Scanner inputStream = new Scanner(new FileInputStream(modulefile));
            // this block is to find the number of activities of the module
            currentLine = inputStream.nextLine();
            data = currentLine.split(",");
            numAct= Integer.parseInt(data[2]);
            
            System.out.println("Please enter the index of this occurence");
            index = input.nextInt();
            
            // this does not work for some reason
            System.out.println("Please enter the name for the Lecture activity"); 
            name = input.nextLine();

            System.out.println("Please enter the day and time will the Lecture occur\n"
                    + "Format : Monday\n1300 - 1500 (24 hour)");
            day = input.nextLine();
            time = input.nextLine();

            if (numAct > 1 ){
                System.out.println("Please enter the name for the Lab/Tutorial Activity");
                act2Name = input.nextLine();
                System.out.println("Please enter the day and time will the activity occur\n"
                    + "Format : Monday\n1300 - 1500 (24 hour)");
                act2day = input.nextLine();
                act2time = input.nextLine();
            }
            
            // prints all the input data
            outputStream.println("L,"+name +"," +day+","+time);
            if(numAct > 1){
                outputStream.println("T,"+index +"," +act2Name+",Day,"+act2day +",Time," +act2time);
            }
            else{
                outputStream.println("L,"+index +"," +name+",Day,"+day +",Time," +time);
            }
            
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            ret = "Successfully added new items";
        }catch(FileNotFoundException ex){
            System.out.println("IO Error " +ex.getMessage());
        }
        return ret;
    }
    
    private void view(){
        Scanner staffinput = new Scanner(System.in);
        System.out.println("Please choose an option:");
        System.out.println("1. View all modules");
        System.out.println("2. View modules taught occurrences taught by a specific lecturer");
        
        int choice = staffinput.nextInt();
        switch (choice) {
            case 1:
                System.out.println("here");
                break;
/*
                File modules = new File("allmodules.txt");
                Scanner scan = new Scanner(modules);
                while (scan.hasNextLine()) {
                    System.out.println(scan.nextLine());
                    break;
                }
*/
            case 2:
                System.out.println("here2");
                break;
                
            default :
                break;

        }
    }
    private void stuClass(){
        
    }
    
}