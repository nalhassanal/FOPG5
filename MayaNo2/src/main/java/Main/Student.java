/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author Hassanal
 */
import java.util.*;
import java.io.*;
public class Student {
    public Student(){
        
    }
    
    public void student(){
        popupBox box = new popupBox();

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        searchModule search = new searchModule();
        addmodule addmoduleobject = new addmodule();
        deletemodule deletemoduleobject = new deletemodule();
        viewregistered viewregisteredobject = new viewregistered();
        timetable timetableobject = new timetable();
        timetableupdater timetableupdaterobject = new timetableupdater();
        box.infoBox("WELCOME TO STUDENT PAGE", "STUDENT PAGE");
        String studentmatrix = "";
        try{
            String filename = "loggerStu.txt";
            Scanner inputStream = new Scanner(new FileInputStream (filename));
            studentmatrix = inputStream.nextLine();
            inputStream.close();
        } catch (FileNotFoundException ex){
            System.out.println("File not found "+ex.getMessage());
        }
        boolean keepGoing = true;
        int count ;
        while (keepGoing){
            count = 0;
            System.out.println();
            System.out.println("MAYA 2.0");
            System.out.println("--------------------------------------------------------");
            System.out.println();
            System.out.println("Welcome to Student page!!!");
            System.out.println("1)See all module\n2)add module\n3)delete module\n4)view course registered\n5)view timetable\n6)Search module\n7)exit");
            System.out.println("What you want to do:");
            int userinput;
            
            try {
                userinput = sc.nextInt();
            } catch (java.util.InputMismatchException ex) {
                System.out.println("Invalid Input " + ex.getMessage());
                userinput = 7;
            }
            
            switch(userinput){
                case 1:
                    System.out.println();
                    view();
                    System.out.println();
                    break;

                case 2:
                    System.out.println();
                    boolean inkeepGoing = true;
                    while (inkeepGoing){
                        addmoduleobject.addModule(studentmatrix);
                        System.out.println("Do you want to continue adding module?\n1) yes,2) no");
                        int input = sc.nextInt();
                        if ( input == 2)
                            inkeepGoing = false;
                        else {
                            inkeepGoing = true;
                        }
                        System.out.println();
                    }    
                    break;

                case 3:
                    System.out.println();
                    deletemoduleobject.deleteModule(studentmatrix);
                    System.out.println();
                    break;

                case 4:
                    System.out.println();
                    viewregisteredobject.registered(studentmatrix);
                    System.out.println();
                    break;

                case 5:
                    System.out.println();
                    timetableupdaterobject.updater(studentmatrix);
                    timetableobject.printtimetable(studentmatrix);
                    System.out.println();
                    break;

                case 6:
                    System.out.println();
                    inkeepGoing = true;
                    while(inkeepGoing){
                        search.SearchModule();
                        System.out.println("Do you want to continue searching?");
                        System.out.println("1) Yes or 2) No");
                        int input = sc.nextInt();
                        if ( input == 2)
                            inkeepGoing = false;
                        else if( input == 1)
                            inkeepGoing = true;
                        System.out.println();
                    }
                    break;
                
                case 7:
                    keepGoing = false;
                    System.out.println("Exiting Student page...");
                    System.out.println();
                    break;

                default:
                    count++;
                    System.out.println();
                    System.out.println("Invalid number, try again");
                    if ( count >= 3){
                        keepGoing = false;
                        System.out.println("3 failed tries.\nForcefully exit...");
                    }
                    System.out.println();
                    break;
            }
            
        }
        //sc.close();
    }
    // this method is to show all modules
    private void view(){
        String filename1 = "modulelist.txt" , filename2 = "Englishmodulelist.txt", filename3 = "Specializationmodulelist.txt";
        File modulelist = new File (filename1);
        File english = new File(filename2);
        File special = new File(filename3);
        
        try{
            Scanner inputStream = new Scanner ( new FileInputStream (modulelist));
            System.out.println();
            System.out.println("Main module list");
            while(inputStream.hasNextLine()){
                System.out.println(inputStream.nextLine());
            }
            inputStream.close();
        } catch (FileNotFoundException ex){
            System.out.println("file not found " +ex.getMessage());
        }
        
        try{
            Scanner inputStream = new Scanner ( new FileInputStream (english));
            System.out.println();
            System.out.println("English module list");
            while(inputStream.hasNextLine()){
                System.out.println(inputStream.nextLine());
            }
            inputStream.close();
        } catch (FileNotFoundException ex){
            System.out.println("file not found " +ex.getMessage());
        }
        
        try{
            Scanner inputStream = new Scanner ( new FileInputStream (special));
            System.out.println();
            System.out.println("Specialization module list");
            while(inputStream.hasNextLine()){
                System.out.println(inputStream.nextLine());
            }
            inputStream.close();
        } catch (FileNotFoundException ex){
            System.out.println("file not found " +ex.getMessage());
        }
    }
}