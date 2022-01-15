/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package First;

/**
 *
 * @author Hassanal
 */
import java.util.*;
import java.io.*;
public class Student {
    public Student(){
        
    }
    
    public static void student(){
        Scanner sc = new Scanner(System.in);
        /*
        addmodule addmoduleobject = new addmodule();
        deletemodule deletemoduleobject = new deletemodule();
        viewregistered viewregisteredobject = new viewregistered();
        timetabletest timetableobject = new timetabletest();
        timetableupdater timetableupdaterobject = new timetableupdater();
        */
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
        int count = 0;
        while (keepGoing){
            
            System.out.println();
            System.out.println("Welcome to Student page!!!");
            System.out.println("1)See all module\n2)add module\n3)delete module\n4)view course registered\n5)view timetable\n6)exit");
            System.out.println("What you want to do:");
            int userinput = sc.nextInt();

            switch(userinput){
                case 1:
                    System.out.println("Add module");
                    //addmoduleobject.addmodule();
                    break;

                case 2:
                    System.out.println("delete module");
                    //deletemoduleobject.deletemodule(studentmatrix);
                    break;

                case 3:
                    System.out.println("View Course Register");
                    //viewregisteredobject.registered(studentmatrix);
                    break;

                case 4:
                    System.out.println("View Course Register");
                    //viewregisteredobject.registered(studentmatrix);
                    break;

                case 5:
                    System.out.println("Timetable");
                    //timetableupdaterobject.updater(studentmatrix);
                    //timetableobject.printtimetable(studentmatrix);
                    break;

                case 6:
                    keepGoing = false;
                    System.out.println("Exiting Student page...");
                    System.out.println();
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
}