package Staff;

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
        
        // ask the number of credit hours
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
    
    private static void deleteModule(){
        // this method is to perform delete module
        // can only delete modules one by one
        // asks user for the module code to be deleted
        
        input = new Scanner(System.in);
        String filename = "allModules.txt", moduleCode;
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
            PrintWriter outputStream = new PrintWriter(buffWrite);
            
            FileReader fReader = new FileReader(filename);
            BufferedReader buffReader = new BufferedReader(fReader);
            
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
            
            //System.out.println("successfully deleted term");
            // delete unwanted files such as old allModules
            // and corresponding module file
            oldFile.delete();
            file.delete();
            // creates a dummy file that has the same name as allModule
            // then rename the temporary output file to be the same as dummy file name
            File temp = new File(filename);
            newFile.renameTo(temp);
            //System.out.println("Deleted old file");
        } catch(IOException ex){
            System.out.println("IO Error "+ex.getMessage());
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
        input = new Scanner(System.in);
        String delete;
        System.out.println("Enter module code that you want to delete");
        delete = input.nextLine();
        File deleteFile = null , outputFile;
        try{
        deleteFile = new File("Delete.txt");
        outputFile = new File("output.txt");
        
        PrintWriter outputStream2 = new PrintWriter(new FileOutputStream(deleteFile));
        PrintWriter outputStream3 = new PrintWriter(new FileOutputStream(outputFile));
        
        
            
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(deleteFile,true));
            outputStream.println(delete);
            
            outputStream.flush();
            outputStream.close();
            
            Scanner inputStream = new Scanner(new FileInputStream(deleteFile));
            Scanner inputStream1 = new Scanner(new FileInputStream("addModules.txt"));
            PrintWriter outputStream1 = new PrintWriter(new FileOutputStream(outputFile,true));
            
            while (inputStream1.hasNextLine()){
                String line1 = inputStream1.nextLine();
                
                while (inputStream.hasNextLine()){
                    String line = inputStream.nextLine();
                    if (line.equals(line1)){
                        System.out.println("found same string");
                        inputStream1.nextLine();
                        inputStream1.nextLine();
                        inputStream1.nextLine();
                    }
                    else{
                        System.out.println("no same string");
                        outputStream1.println(line1);
                    }
                }
            }
            
            if(outputFile.renameTo(inputFile))
                System.out.println("File succesffully renamed");
            else
                System.out.println("Failed");
            
            outputStream1.flush();
            outputStream1.close();
            inputStream.close();
            inputStream1.close();
            
            System.out.println("File process successful");
            
        } catch(IOException ex){
            System.out.println("IO Error " +ex.getMessage());
        }
        
*/