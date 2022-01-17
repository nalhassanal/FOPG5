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
public class Staff {
    private popupBox box;//add gui
    private Scanner input;

    public Staff() {
    }
    
    // maybe add way to edit staff account
    // maybe delete account
    // when they delete, java deletes everything, in staff, staffcredential and also logger,
    // they might still be in the program, but cannot do important stuff like add module
    public void staff(){
        box = new popupBox();
        box.infoBox("WELCOME TO STAFF SECTION", "STAFF");
        input = new Scanner(System.in);
        int menu, count = 0;
        boolean keepGoing = true;
        while ( keepGoing){
            System.out.println("MAYA 2.0");
            System.out.println("--------------------------------------------------------");
            System.out.println();
            System.out.println("Welcome to the staff page!!");
            System.out.println("1. Modify Modules");
            System.out.println("2. View Modules");
            System.out.println("3. View Students in your classes");
            System.out.println("4. Return");
            System.out.println("Enter the number you want >> ");
            menu = input.nextInt();
            switch (menu) {
                case 1:
                    moduleMenu();
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
                    System.out.println("Exiting Staff page...");
                    break;
                default:
                    count++;
                    System.out.println("Invalid number, try again");
                    if ( count >= 3){
                        keepGoing = false;
                        System.out.println("3 failed tries.\nForcefully exit...");
                    }
                    break;
            }
        }        
    }
    private Authorization log;
    private void moduleMenu(){
        String menu = "";
        log = new Authorization();
        input = new Scanner(System.in);
        boolean keepGoing = true;
        while (keepGoing){
            System.out.println("MAYA 2.0");
            System.out.println("--------------------------------------------------------");
            System.out.println();
            System.out.println("What do you want to do here?");
            System.out.println("A) Create a new module");
            System.out.println("B) Delete existing module");
            System.out.println("C) Edit a module");
            System.out.println("R) Return");
            System.out.println("Enter the number you want >> ");
            menu = input.next();
            
            switch(menu.toUpperCase()){
                case "A":
                    if (log.staffTest()) {
                        String process = addModule();
                        System.out.println(process);
                        System.out.println();
                    } else {
                        System.out.println("You are not allowed access in section");
                        System.out.println("Please choose another number");
                        System.out.println();
                    }
                    break;
                    
                case "B":
                    if (log.staffTest()) {
                        String process = deleteModule();
                        System.out.println(process);
                        System.out.println();
                    } else {
                        System.out.println("You are not allowed access in section");
                        System.out.println("Please choose another number");
                        System.out.println();
                    }
                    break;
                    
                case "C":
                    String process = editModule();
                    System.out.println(process);
                    System.out.println();
                    break;
                    
                case "R":
                    keepGoing = false;
                    System.out.println("Returning to staff page...");
                    System.out.println();
                    break;
                    
                default:
                    System.out.println("Invalid Input\nPlease Try Again\n");
                    System.out.println();
                    break;                
            }
        }
    }
    
    private String moduleCode , moduleName , Activities , module;
    private int numofOcc  = 1, credits = 1, numAct = 1;
    private int [] inACT;
    private String [] ACT;
    private final String ACT1 = "Lecture" , ACT2 = "Tutorial", ACT3 = "Lab";
    
    private void addModuleFile(String specifiedName){
        System.out.println();
        // ask module code
        System.out.println("Please enter the module code > ");
        moduleCode = input.nextLine();
        System.out.println();
        // ask module name
        System.out.println("Please enter the module name > ");
        moduleName = input.nextLine();
        System.out.println();
        // ask the number of occurence
        System.out.println("Please enter the number of occurences > ");
        numofOcc = input.nextInt();
        System.out.println();
        // ask the number of credit hours
        System.out.println("Please enter the number of credits > ");
        credits = input.nextInt();
        System.out.println();
        // ask the number of activities
        System.out.println("How many activities will this module have?\n( 1 OR 2 )");
        numAct = input.nextInt();
        inACT = new int[numAct];
        ACT = new String[numAct];
        System.out.println();
        // ask the type of activities
        System.out.println("Please enter the activities type");
        System.out.println("1. Lecture\t2. Tutorial\t 3. Lab");
        for (int i = 0; i < numAct; i++) {
            inACT[i] = input.nextInt();
            switch (inACT[i]) {
                case 1:
                    // store the activity type into activity array
                    ACT[i] = ACT1;
                    break;
                case 2:
                    ACT[i] = ACT2;
                    break;
                case 3:
                    ACT[i] = ACT3;
                    break;
                default:
                    break;
            }
        }
        if (numAct == 1) {
            Activities = ACT[0];
        } else if (numAct == 2) {
            Activities = ACT[0] + " & " + ACT[1];
        }
        module = moduleCode + "," + moduleName + "," + numofOcc + "," + credits + "," + Activities;
        if (specifiedName.equals("English")){
            System.out.println();
            System.out.println("Please enter the Band requirement for this module");
            System.out.println("If it has two requirements, the minimum requirement is needed");
            System.out.println("Example : Band 5");
            String band = input.nextLine();
            
            module += "," + band;
        }
        
        if(moduleCheck(moduleCode)){
            try {
                String filename = specifiedName + "modulelist.txt";
                File file = new File(filename);
                PrintWriter outputStream = new PrintWriter(new FileOutputStream(file, true));
                outputStream.println(module);
                outputStream.flush();
                outputStream.close();

            } catch (IOException ex) {
                System.out.println("IO Error " + ex.getMessage());
            }
        }
        else{
            System.out.println();
            System.out.println("Module Already Exists");
            System.out.println();
        }
    }
    
    private boolean moduleCheck(String moduleCode){
        boolean result = true;
        String filename = moduleCode+".txt";
        File file = new File(filename);
        if(file.exists())
            result = false;
        else
            result = true;
        return result;
    }
    
    //  this method can only be accessed by higher ranking lecturers only
    private String addModule(){
        input = new Scanner(System.in);
        String ret = "Unsuccessfull Module Addition" , specifiedName;
        System.out.println("MAYA 2.0");
        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println("Welcome to add module!");
        System.out.println();
        System.out.println("A) add english course");
        System.out.println("B) add normal course");
        System.out.println("C) add specialization course");
        System.out.println("R) return");
        System.out.println("Please enter your choice :");
        String option = input.nextLine();
        
        switch(option.toUpperCase()){
            case "A":
                specifiedName = "English";
                addModuleFile( specifiedName);
                try {
                    // this is the file for all modules
                    String filename = "allModules.txt", moduleInfo;

                    File file = new File(filename);

                    PrintWriter outputStream = new PrintWriter(new FileOutputStream(file, true));
                    moduleInfo = moduleCode + "," + moduleName + "," + numofOcc + "," + credits + "," + Activities;

                    outputStream.println(moduleInfo);

                    ret = "Module Added successfully";
                    outputStream.flush();
                    outputStream.close();

                } catch (IOException ex) {
                    System.out.println("IO Error " + ex.getMessage());
                }
                break;

            case "B":
                specifiedName = "";
                addModuleFile(specifiedName);
                try {
                    // this is the file for all modules
                    String filename = "allModules.txt", moduleInfo;

                    File file = new File(filename);

                    PrintWriter outputStream = new PrintWriter(new FileOutputStream(file, true));
                    moduleInfo = moduleCode + "," + moduleName + "," + numofOcc + "," + credits + "," + Activities;

                    outputStream.println(moduleInfo);

                    ret = "Module Added successfully";
                    outputStream.flush();
                    outputStream.close();

                } catch (IOException ex) {
                    System.out.println("IO Error " + ex.getMessage());
                }
                break;

            case "C":
                specifiedName = "Specialization";
                addModuleFile(specifiedName);
                try {
                    // this is the file for all modules
                    String filename = "allModules.txt", moduleInfo;

                    File file = new File(filename);

                    PrintWriter outputStream = new PrintWriter(new FileOutputStream(file, true));
                    moduleInfo = moduleCode + "," + moduleName + "," + numofOcc + "," + credits + "," + Activities;

                    outputStream.println(moduleInfo);

                    ret = "Module Added successfully";
                    outputStream.flush();
                    outputStream.close();

                } catch (IOException ex) {
                    System.out.println("IO Error " + ex.getMessage());
                }
                break;
            case "R":
                return "Exited";
            default:
                System.out.println("Invalid option");
                break;
        } 
        return ret;
    }
    
    private String deleteModule(){
        // this method is to perform delete module
        // can only delete modules one by one
        // asks user for the module code to be deleted
        
        input = new Scanner(System.in);
        String filename = "allModules.txt", moduleCode , ret ="Failed to delete\nModule did not exist";
        System.out.println("MAYA 2.0");
        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println("Please enter the module code that you want to remove");
        System.out.println("R) to return");
        moduleCode = input.nextLine();
        int position = 0;
        if(moduleCode.toUpperCase().equals("R")){
            return "Exited";
        }
        
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
    private String editModule(){
        input = new Scanner(System.in);
        String moduleCode , ret ="Failed to add new items";
        System.out.println("MAYA 2.0");
        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println("Enter the Module code that you want to edit >>");
        System.out.println("R) to return");
        moduleCode = input.nextLine();
        if(moduleCode.toUpperCase().equals("R"))
            return "Exited";
            
        
        String filename = moduleCode+".txt", filename1 = "allModules.txt", currentLine;
        String [] activities = {};
        int activitiesLen = 2;
        String [] data;
             
        File allModules = new File(filename1);
        
        // to get the type of activity
        try{
            Scanner inputStream = new Scanner(new FileInputStream(allModules));
            
            while(inputStream.hasNextLine()){
                currentLine = inputStream.nextLine();
                data = currentLine.split(",");
                if ( data[0].equals(moduleCode)){
                    activities = data[4].trim().split("&");
                    activitiesLen = activities.length;
                    break;
                }
            }
        } catch ( FileNotFoundException ex){
            System.out.println("File not found " +ex.getMessage());
        }
        
        File modulefile = new File(filename);
        int index;
        String name = "" , information;
        String day = "Monday",time = "9";
        String mode = "L";
        System.out.println();
        System.out.println("Please enter the index of this occurence");
        index = input.nextInt();
        for ( int i = 0; i<activitiesLen ; i++){
            System.out.println();
            System.out.println("Enter "+activities[i].trim() +" information >> ");
            System.out.println("Enter name > ");
            if ( activities[i].trim().equals("Tutorial")){
                System.out.println("Press Enter to continue");
            } else if( activities[i].trim().equals("Lab"))
                System.out.println("Press Enter to continue");
            input.nextLine();
            name = input.nextLine();
            
            System.out.println();
            System.out.println("Enter Day and time\nExample Monday, 0900 - 1000 >> ");
            day = input.nextLine();
            time = input.nextLine();
            
            if(activities[i].trim().equals("Lecture"))
                mode = "L";
            else if(activities[i].trim().equals("Tutorial"))
                mode = "T";
            else if(activities[i].trim().equals("Lab"))
                mode = "TL";
            information = mode+","+index+","+name+","+day.toUpperCase()+","+time;
            
            try{
                PrintWriter outputStream = new PrintWriter(new FileOutputStream(modulefile, true));
                outputStream.println(information);
                outputStream.flush();
                outputStream.close();
            } catch (IOException ex){
                System.out.println("IO Error " + ex.getMessage());
            }
            
            try{
                String filestaff = "staff.txt" ;
                String currentline , username="";
                String Data[];
                File staff = new File(filestaff);
                Scanner inputStream = new Scanner(new FileInputStream (staff));
                while(inputStream.hasNextLine()){
                    currentline = inputStream.nextLine();
                    Data = currentline.split(",");
                    if (Data[2].equals(name)){
                        username = Data [0];
                        break;
                    }
                }
                String userFile = username+".txt";
                File staffUser = new File(userFile);
                PrintWriter outputStream1 = new PrintWriter ( new FileOutputStream(staffUser,true));
                outputStream1.println(moduleCode);
                outputStream1.flush();
                outputStream1.close();               
                inputStream.close();
            } catch (IOException ex){
                System.out.println("IO Error " +ex.getMessage());
            }
            ret = "Successfully added new items";
            System.out.println(ret);
        }
       return "Successfully added All items";
    }
    
    private void view(){
        /*
        this view methods have two options
        1. is to view all created modules with the exception of activity info
        2. is to view modules taught by the staff
        this method accepts has no inputs and outputs the choice from the staff
        */
        
        boolean keepGoing = true;
        while (keepGoing){
            System.out.println("MAYA 2.0");
            System.out.println("--------------------------------------------------------");
            System.out.println();
            // option menu block
            System.out.println("Please choose an option:");
            System.out.println("A) View all modules");
            System.out.println("B) View modules taught by you");
            System.out.println("R) Return");
            Scanner staffinput = new Scanner(System.in);
            String choice = staffinput.next();
            // selection block
            switch (choice.toUpperCase()) {
                case "A":
                    File modules = new File("allmodules.txt");
                    try{
                        // this try block is to print all information in
                        // allmodules.txt
                        // with no seperation between different types of modules
                        Scanner inputStream = new Scanner(new FileInputStream(modules));
                        while (inputStream.hasNextLine()) {
                            System.out.println(inputStream.nextLine());
                            System.out.println();
                        }
                        inputStream.close();
                    }catch(FileNotFoundException e){
                        System.out.println("File not found " + e.getMessage());
                    }finally {
                        break;
                    }

                case "B":
                    String username = "" , currentLine;
                    // this block is to get the staff's name
                    // for next block purposes
                    try{
                        Scanner inputStream = new Scanner(new FileInputStream("loggerStaff.txt"));
                        username = inputStream.nextLine();
                        inputStream.close();
                    } catch (FileNotFoundException ex){
                        System.out.println("File not found " +ex.getMessage());
                    }
                    
                    // this block is to read from the staff's txt file
                    // and prints out all of their modules that they will be teaching
                    File moduleTaught = new File(username+".txt");
                    try{
                        Scanner inputStream = new Scanner(new FileInputStream(moduleTaught));
                        while (inputStream.hasNextLine()){
                            int i=1;
                            currentLine = inputStream.nextLine();
                            System.out.println( i +") " +currentLine); // just shows the module code only
                            System.out.println();
                            i++;
                        }
                        inputStream.close();
                    } catch(FileNotFoundException ex){
                        System.out.println("File not found "+ex.getMessage());
                    }
                    break;

                case "R":
                    // breaks the while loop and returns to staff main page
                    keepGoing = false;
                    System.out.println("Returning to staff page...");
                    System.out.println();
                    break;
                    
                default:
                    // error message that prompts user to try again
                    System.out.println("Invalid Input\nPlease Try Again\n");
                    System.out.println();
                    break;
            }
        }
    }

    private void stuClass(){
        /*
        This method can be accessed by all staff
        this method accepts nothing and returns with the full list of students
        under the staff's care
        */
        
        // this block is to get the staff's name
        // for next block purposes
        String username = "";
        try {
            Scanner inputStream = new Scanner(new FileInputStream("loggerStaff.txt"));
            inputStream.nextLine(); // skips username
            username = inputStream.nextLine();
            inputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found " + ex.getMessage());
        }
        
        // this block is to read from the staff's txt file
        // and prints out all of their modules and students in their care
        File moduleTaught = new File(username + ".txt");
        System.out.println("Here are all the students in all of your modules");
        try {
            Scanner inputStream = new Scanner(new FileInputStream(moduleTaught));
            String all;
            String [] allData , prevdata ={};
            int i = 0;
            while (inputStream.hasNextLine()) {
                all = inputStream.nextLine();
                allData = all.split(",");
                
                if ( i == 0){
                System.out.println();
                System.out.println("Module Code : ");
                System.out.println(allData[0]);
                }
                System.out.println(all); // prints out all the necessary info
                if( i > 0){
                    // if !("Wix1001".equals("Wix1002") then true
                    // this is just to seperate between two or more modules
                    if(!allData[0].equals(prevdata[0])){
                        System.out.println();
                        System.out.println("New Module Code : ");
                        System.out.println(allData[0]);
                    }
                }
                i++;
                prevdata = allData.clone(); // this is for comparing purposes
            }
            System.out.println("You have " +(i - 1) +" students in your class(es)");
            inputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found " + ex.getMessage());
        }
    }    
}