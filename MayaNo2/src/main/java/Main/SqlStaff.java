package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SqlStaff {
    
    private sqlconnect Connector = new sqlconnect();
    private Connection con ;
    private Scanner input;
    private popupBox box;
    private Authorizationsql regsql;
    public SqlStaff(){

    }   

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
            System.out.println("4. Exit");
            System.out.println("Enter the number you want >> \n");
            menu = input.nextInt();
            System.out.println("here");
            switch (menu) {
                case 1:
                    moduleMenu();
                    System.out.println();
                    break;
                case 2:
                    view();
                    System.out.println();
                    break;
                case 3:
                    stuClass();
                    System.out.println();
                    break;
                case 4:
                    keepGoing = false;
                    System.out.println("Exiting Staff page...");
                    break;
                default:
                    count++;
                    System.out.println("Invalid number, try again");
                    System.out.println();
                    if ( count >= 3){
                        keepGoing = false;
                        System.out.println("3 failed tries.\nForcefully exit...");
                    }
                    break;
            }
        } 
    }

    private void moduleMenu(){
        String menu = "";
        //log = new Authorization();
        regsql = new Authorizationsql();
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
                    if (regsql.statusCheck()) {
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
                    if (regsql.statusCheck()) {
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

    private String code,name, act;
    private int numOcc;

    private boolean moduleAdder( String specifiedName){
        input = new Scanner(System.in);
        final String ACT1 = "Lecture" ,ACT2 = "Tutorial",ACT3 = "Lab";
        String moduleCode ,moduleName ,Activities = ACT1 ,module ,band = "Band 2";
        int numofOcc  = 1 ,credits = 1 ,numAct = 1;
        int [] inACT;
        String [] ACT;
        boolean ret = false;
        

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
        System.out.println("Please enter the number of occurrences > ");
        numofOcc = input.nextInt();
        System.out.println();
        
        // ask the number of credit hours
        System.out.println("Please enter the number of credits > ");
        credits = input.nextInt();
        System.out.println();
        
        // this will determine how many columns that specific 
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

        module = moduleCode + "," + moduleName + "," + numofOcc + "," + credits + "," + Activities;

        
        if (numAct == 1) {
            Activities = ACT[0];
        } else if (numAct == 2) {
            Activities = ACT[0] + " & " + ACT[1];
        }

        // requirements for english courses
        if (specifiedName.equals("English")){
            System.out.println();
            System.out.println("Please enter the Band requirement for this module");
            System.out.println("If it has two requirements, the minimum requirement is needed");
            System.out.println("Example : Band 5");
            input.nextLine();
            band = input.nextLine();
            module += ","+band;
        }

        con = Connector.connector();
        try{
            // maybe the table is like, each course can be repeated but with the difference of
            // lecturer name and date and time
            // meaning the id is not unique
            // just do one by one instead of variables
            String query = "";
            PreparedStatement ps = null;
            if (specifiedName.equals("English")){
                query = "insert into english_module (code,name,band,numOcc,numCredit,act_type) values(?,?,?,?,?,?)";
                ps = con.prepareStatement(query);
                ps.setString(1, moduleCode);
                ps.setString(2, moduleName);
                ps.setString(3, band);
                ps.setInt(4, numofOcc);
                ps.setInt(5, credits);
                ps.setString(6, Activities);
            }
            else if (specifiedName.equals("Normal")){
                query = "insert into normal_module (code,name,numOcc,numCredit,act_type) values(?,?,?,?,?)";
                ps = con.prepareStatement(query);
                ps.setString(1, moduleCode);
                ps.setString(2, moduleName);
                ps.setInt(3, numofOcc);
                ps.setInt(4, credits);
                ps.setString(5, Activities);
            }
            else if (specifiedName.equals("Specialization")){
                query = "insert into specialization_module (code,name,numOcc,numCredit,act_type) values(?,?,?,?,?)";
                ps = con.prepareStatement(query);
                ps.setString(1, moduleCode);
                ps.setString(2, moduleName);
                ps.setInt(3, numofOcc);
                ps.setInt(4, credits);
                ps.setString(5, Activities);
            }

            boolean success = ps.execute();
            if(!success){
                con.close();
                System.out.println(module);
                ret = !success;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        code = moduleCode;
        name = moduleName;
        numOcc = numofOcc;
        act = Activities;
        return ret;
    }

    private String addModule(){
        
        input = new Scanner(System.in);
        String ret = "Unsuccessfull Module Addition" ,specifiedName;
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

        // maybe when adding the entries terus mintak the lecture information
        switch(option.toUpperCase()){
            case "A":
            //addenglish entries
                specifiedName = "English";
                if(moduleAdder(specifiedName)){
                    con = Connector.connector();
                    try{
                        String query = "insert into modules(name,code,occ,type) values (?,?,?,?)";
                        PreparedStatement ps = con.prepareStatement(query);
                        ps.setString(1, name);
                        ps.setString(2, code);
                        ps.setInt(3, numOcc);
                        ps.setString(4, act);
                        if(!ps.execute()){
                            con.close();
                            ret = "Successful Module Addition";
                        }
                    } catch(SQLException ex){
                        ex.printStackTrace();
                        System.out.println(ex.getMessage());
                    }
                }
                break;
            
            case "B":
            // add normal entries
                specifiedName = "Normal";
                if(moduleAdder(specifiedName)){
                    con = Connector.connector();
                    try{
                        String query = "insert into modules(name,code,occ,type) values (?,?,?,?)";
                        PreparedStatement ps = con.prepareStatement(query);
                        ps.setString(1, name);
                        ps.setString(2, code);
                        ps.setInt(3, numOcc);
                        ps.setString(4, act);
                        if(!ps.execute()){
                            con.close();
                            ret = "Successful Module Addition";
                        }
                    } catch(SQLException ex){
                        ex.printStackTrace();
                        System.out.println(ex.getMessage());
                    }
                }
                break;

            case "C":
            // add specialization entries
                specifiedName = "Specialization";
                if(moduleAdder(specifiedName)){
                    con = Connector.connector();
                    try{
                        String query = "insert into modules(name,code,occ,type) values (?,?,?,?)";
                        PreparedStatement ps = con.prepareStatement(query);
                        ps.setString(1, name);
                        ps.setString(2, code);
                        ps.setInt(3, numOcc);
                        ps.setString(4, act);
                        if(!ps.execute()){
                            con.close();
                            ret = "Successful Module Addition";
                        }
                    } catch(SQLException ex){
                        ex.printStackTrace();
                        System.out.println(ex.getMessage());
                    }
                }
                break;

            case "R":
                return "Excited";

            default:
                System.out.println("Invalid option");
                break;
        }

        return ret;
    }

    private String deleteModule(){
        input = new Scanner(System.in);
        String inmoduleCode , ret ="Failed to delete\nModule did not exist";
        System.out.println("MAYA 2.0");
        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println("Please enter the module code that you want to remove");
        System.out.println("R) to return");
        inmoduleCode = input.nextLine();
        
        if(inmoduleCode.toUpperCase().equals("R")){
            return "Exited";
        }
        inmoduleCode = inmoduleCode.toUpperCase();

        //start with deleting the entries

        return ret;
    }

    private String editModule(){
        input = new Scanner(System.in);
        String moduleCode , ret ="Failed to add new items";
        System.out.println();
        System.out.println("MAYA 2.0");
        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println("Enter the Module code that you want to edit >>");
        System.out.println("R) to return");
        moduleCode = input.nextLine();
        if(moduleCode.toUpperCase().equals("R"))
            return "Exited";

        //start with editing the contents of each module entries or maybe change existing entries
            
        return ret;
    }
  
    private void view(){
        input = new Scanner(System.in);
    }

    private void stuClass(){
        input = new Scanner (System.in);
    }
}
