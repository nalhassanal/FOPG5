package First;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Haziq
 */
public class addmodule {
    //a method of addmodule was created and can be called by the addmodule class to the main class
    void addmodule(String studentmatrix)
    {
        //scanner being declared for user input
        Scanner sc = new Scanner(System.in);
        
        //some variable created at the beginning of the code so that it can be use all over the method
        //This array variable will be used to read all students information such as matrix number,programme and muet band from to be compare to a special logger of the student
        int studentsize = 100;
        String[] studentsplit;
        String[] studentinfo = new String[studentsize];
        String[] studentmatrixread = new String[studentsize];
        String[] studentemailread = new String[studentsize];
        String[] studentnameread = new String[studentsize];
        String[] studentpasswordread = new String[studentsize];;
        String[] studentprogrammeread = new String[studentsize];;
        String[] studentmuetread = new String[studentsize];;
        
        //this variable declaration is for fix information that will be used throughout the method
        String studentname = null;
        String studentprogramme = null;
        String studentmuet = null;
        String specialcourse = null;
        
        
        
        
       
        //this BufferedReader read all student info from student.txt file that and put it in the arraylist
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("student.txt"));
            for(int i = 0; i<100 ;i++)
            {
                
                    studentinfo[i] = reader.readLine();
                    if(studentinfo[i]!=null)
                    {
                        studentsplit = studentinfo[i].split(",");
                        studentmatrixread[i] = studentsplit[0];
                        studentemailread[i] = studentsplit[1];
                        studentnameread[i] = studentsplit[2];
                        studentprogrammeread[i] = studentsplit[4];
                        studentmuetread[i] = studentsplit[5]; 
                    }
            }
                    
            reader.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        //this loop is to compare the studentmatrix that being pass from main class to obtain the information of the user
        for(int i = 0;i<studentsize;i++)
        {
            if(studentmatrix.equals(studentmatrixread[i]))
            {
                studentname = studentnameread[i];
                studentprogramme = studentprogrammeread[i];
                studentmuet = studentmuetread[i];
            }
        }
        //there are 3 different file that store module list and its information which is for Main courses, Specialization courses, and English courses
        //this array variable being used for storing Main course module.
        String[] modulecode = new String[100];
        String[] modulename = new String[100];
        String[] modulewithname = new String[100];
        String[] totalocc = new String [100];
        String[] credithour = new String [100];
        String[] modulemode = new String[100];
        String[] modulesplit;
        int[] numtotalocc = new int[100];
        int[] numcredithour = new int[100];
        int credit = 0;
        int total_credit_hour = 0;
        
        //this try-catch and BufferedaReader being used to read Main courses information from modulelist.txt and store it in the array that has been declared earlier
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("modulelist.txt"));
            
                for(int i = 0; i< modulewithname.length; i++)
                {
                    modulewithname[i] = reader.readLine();
                    
                    if(modulewithname[i]!=null)
                    {
                        modulesplit = modulewithname[i].split(",");
                        modulecode[i] = modulesplit[0];
                        modulename[i] = modulesplit[1];
                        totalocc[i] = modulesplit[2];
                        credithour[i] = modulesplit[3];
                        modulemode[i] = modulesplit[4];
                        
                    }
                    
                }
            
            reader.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        //change String occ and credit hour to int
        for(int i =0;i<100;i++)
        {
            if(credithour[i] !=null || totalocc[i]!=null)
            {
                numtotalocc[i] = Integer.parseInt(totalocc[i]);
                numcredithour[i] = Integer.parseInt(credithour[i]);
            }
        }
        //this array variable is being used for storing specialization courses module
        String[] Smodulecode = new String[100];
        String[] Smodulename = new String[100];
        String[] Smodulewithname = new String[100];
        String[] Stotalocc = new String [100];
        int [] Scredithour = new int [100];
        String[] Smodulemode = new String[100];
        String[] Smodulesplit;
        //same as before, try-catch BufferedReader being used to read specialization module information from specializationmodulelist.txt and store it in array form for the program
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("specializationmodulelist.txt"));
            
                for(int i = 0; i< Smodulewithname.length; i++)
                {
                    Smodulewithname[i] = reader.readLine();
                    
                    if(Smodulewithname[i]!=null)
                    {
                        Smodulesplit = Smodulewithname[i].split(",");
                        Smodulecode[i] = Smodulesplit[0];
                        Smodulename[i] = Smodulesplit[1];
                        Stotalocc[i] = Smodulesplit[2];
                        Scredithour[i] = Integer.parseInt(Smodulesplit[3]);
                        Smodulemode[i] = Smodulesplit[4];
                        
                    }
                    
                }
            
            reader.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        //fthis array variable is used for English course module
        String[] engmodulecode = new String[100];
        String[] engmodulename = new String[100];
        String[] engmodulewithname = new String[100];
        String[] engtotalocc = new String [100];
        int[] engcredithour = new int [100];
        String[] engmodulemode = new String[100];
        String[] engband = new String[100];
        String[] engmodulesplit;
        
        //try-catch BufferedReader for reading English module list from Englishmodulelist.txt and store it in array form
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("Englishmodulelist.txt"));
            
                for(int i = 0; i< engmodulewithname.length; i++)
                {
                    engmodulewithname[i] = reader.readLine();
                    
                    if(engmodulewithname[i]!=null)
                    {
                        engmodulesplit = engmodulewithname[i].split(",");
                        engmodulecode[i] = engmodulesplit[0];
                        engmodulename[i] = engmodulesplit[1];
                        engtotalocc[i] = engmodulesplit[2];
                        engcredithour[i] = Integer.parseInt(engmodulesplit[3]);
                        engmodulemode[i] = engmodulesplit[4];
                        engband[i] = engmodulesplit[5];
                        
                    }
                    
                }
            
            reader.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        
        
        //initialization of specialization course for the student based on their programme
        if(studentprogramme.equals("Bachelor of Computer Science (Computer System and Network)"))
        {
            specialcourse = "WIC3002";
        }
        else if(studentprogramme.equals("Bachelor of Computer Science (Artificial Intelligence)"))
        {
            specialcourse = "WID3007";
        }
        else if(studentprogramme.equals("Bachelor of Computer Science (Information Systems)"))
        {
            specialcourse = "WIE3007";
        }
        else if(studentprogramme.equals("Bachelor of Computer Science (Software Engineering)"))
        {
            specialcourse = "WIF3005";
        }
        else if(studentprogramme.equals("Bachelor of Information Technology (Multimedia)"))
        {
            specialcourse = "WIG3007";
        }
        else if(studentprogramme.equals("Bachelor of Computer Science (Data Science)"))
        {
            specialcourse = "WIH3003";
        }
        
        //this array variable and regular variable declaration is for all the purpose throughout the program
        String[] subjectassigned = new String[10];
        String[] subjectreader = new String[10];
        String[] subjectsplit;
        String[] subjectmode = new String[10];
        String[] subjectocc = new String[10];
        String[] lecturername = new String[10];
        String[] subjectday = new String[10];
        String[] subjecttime = new String[10];
        
        String[] modesubject= new String[subjectmode.length];
        int[] subjectoccnum = new int[subjectocc.length];
        String moduleselect = null;
        
        String lecturerfile = null;
        int pick_occ;

        String[] time = new String [30];
        String [] timesplit;
        int [] oldtimestart = new int[30];
        int [] oldtimeend = new int[30];
        String[] day = new String[30];
        String[] subjectlist = new String[30];
        String[] moduleviewsplit;
        
        //try-catcch block for creating a student module file to store all data for the subject module that has been registered by the student, this file also useful for reading the time for registered ->
        //module so that no time clash occurs when student register for a new class(Lecture, Tutorial and Lab)
        try
        {   
            File studentmodulefile = new File(studentmatrix+"modules.txt");
            if(!studentmodulefile.exists())
            {
                studentmodulefile.createNewFile();
            }
            BufferedReader reader = new BufferedReader(new FileReader(studentmatrix+"modules.txt"));

            for( int t = 0; t< 30; t++)
            {
                subjectlist[t] = reader.readLine();
                if(subjectlist[t] != null)
                {
                    moduleviewsplit = subjectlist[t].split(",");
                    day[t] = moduleviewsplit[4];
                    time[t] = moduleviewsplit[5];
                    timesplit = time[t].split(" - ");
                    oldtimestart[t] = Integer.parseInt(timesplit[0]);
                    oldtimeend[t] = Integer.parseInt(timesplit[1]);

                }

            }     
            reader.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        //these 3 loop is for showing all subject that has been created by the lecturer from the 3 file (main, specialization, english)
        System.out.println("Main Courses:");
        for(int i = 0; i< modulecode.length;i++)
        {
            if(modulewithname[i] != null)
            System.out.println(credithour[i] + " Credit | " + modulecode[i] + " | " + modulename[i]);
        }

        System.out.println("Specialization Courses:");
        for(int i = 0; i < Smodulecode.length;i++)
        {
            if(Smodulewithname[i] != null)
            System.out.println(Scredithour[i] + " Credit | " + Smodulecode[i] + " | " + Smodulename[i]);
        }

        System.out.println("English Courses:");
        for(int i = 0; i < engmodulecode.length;i++)
        {
            if(engmodulewithname[i] != null)
            System.out.println(engcredithour[i] + " Credit | " + engmodulecode[i] + " | " + engmodulename[i]);
        }
        
        //intruction for the user to enter an input int to choose what course group he/she wanted to add
        System.out.println("Enter 1 to add Main course, 2 to add Specialization course, 3 to add English course , 0 to Exit");
        int selecttype = sc.nextInt();
                
                //a while loop is created to make sure student can continuously add module
                //first group of code is for main courses module
                while(selecttype == 1)
                {    
                    System.out.println("Please enter the module you wanted to register (example: WIX2002):");
                    String userinputmodule = sc.next();

                    //read checklist file(for each student they have checklist txt to prevent them register same module), if they have assign for this module earlier, it will skip this input module session and proceed to continue add other module
                    String[] read = new String[15];
                    String[] readsplit;
                    int[] credithournum = new int [read.length];

                    int exception = 0;
                    //file studentmatrixchecklist.txt being read to check what module that the student has registered and skip this add module session to continue for another session
                    try
                    {   
                        File checklistfile = new File(studentmatrix+"checklist.txt");
                        if(!checklistfile.exists())
                        {
                            checklistfile.createNewFile();
                        }
                        BufferedReader reader = new BufferedReader(new FileReader(studentmatrix+"checklist.txt"));
                     
                        for( int t = 0; t< subjectassigned.length; t++)
                        {
                            read[t]= reader.readLine();
                            if(read[t] != null)
                            {
                                readsplit = read[t].split(",");
                                subjectassigned[t] = readsplit[0];
                                credithournum[t] = Integer.parseInt(readsplit[1]);
                            }
                            if(userinputmodule.equals(subjectassigned[t]))
                            {
                                System.out.println("You have assigned for this module!");
                                exception = 1;
                            }
                        }
                        if(exception == 1)
                        {
                            userinputmodule = null;
                            break;
                        }
                        reader.close();
                    }
                    
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    
                    
                    //this is the condition where student for information technology department only can assign to WIB2001 and student for computer science department only can assign WIA2001 although those are the same subject
                    int codereturn=0;
                    if(userinputmodule.equals("WIA2001"))
                    {
                        if(studentprogramme.equals("Bachelor of Information Technology (Multimedia)"))
                        {
                            System.out.println("You cannot assign for this module. For information technology student, you need to assign for WIB2001");
                            codereturn = 1;
                        }
                    }
                    if(userinputmodule.equals("WIB2001"))
                    {
                        if(!studentprogramme.equals("Bachelor of Information Technology (Multimedia)"))
                        {
                            System.out.println("You cannot assign for this module. For computer science student, you need to assign for WIA2001");
                            codereturn = 1;
                        }
                    }
                    if(codereturn == 1)
                    {
                        break;
                    }
                    //calculate total credit hour from checklist file so that student did not exceed 22 credit hours
                    total_credit_hour = 0;

                    for(int i = 0 ; i< read.length;i++)
                    {
                            total_credit_hour = total_credit_hour + credithournum[i];                        
                    }
                    //for loop to compare userinput with the main course module and if it is available the program will continue
                    for(int i =0; i < modulecode.length; i++)
                    {
                        if(userinputmodule == null)
                        break;
                        else if(userinputmodule.equals(modulecode[i]))
                        {
                            //calculate total credit hour including the new module that will be registered so that it is less than 22credit for the student to proceed adding the module
                            int total_credit_hour_test = total_credit_hour + numcredithour[i];
                            if(total_credit_hour_test>22)
                            {
                                System.out.println("You have exceeding the credit hour limit!");
                                break;
                            }
                            moduleselect = modulecode[i];
                            //read file from modulename.txt using user input moduleselect and bring out the information into array list so that it can be used in the program
                            try
                            {
                                BufferedReader reader = new BufferedReader(new FileReader(moduleselect+".txt"));

                                for( int l = 0; l< subjectreader.length; l++)
                                {
                                    subjectreader[l] = reader.readLine();
                                    
                                    if(subjectreader[l] != null)
                                    {
                                        subjectsplit = subjectreader[l].split(",");
                                        subjectmode[l] = subjectsplit[0];
                                        subjectocc[l] = subjectsplit[1];
                                        lecturername[l] = subjectsplit[2];
                                        subjectday[l] = subjectsplit[3];
                                        subjecttime[l] = subjectsplit[4];
                                    }
                                }

                            reader.close();
                            }
                            catch(IOException e)
                            {
                                e.printStackTrace();
                            }
                            //int the files, Lecture mode is declared as "L", Tutorial as "T" and Tutorial/Lab as "TL", so this for loop is to convert it into more user friendly information to be print out
                            for(int m =0; m < subjectmode.length; m++)
                            {
                                if(subjectmode[m]!=null)
                                {
                                    if(subjectmode[m].equals("L"))
                                        modesubject[m] = "LECTURE";
                                    else if(subjectmode[m].equals("T"))
                                        modesubject[m] = "TUTORIAL";
                                    else if(subjectmode[m].equals("TL"))
                                        modesubject[m] = "TUTORIAL/LAB";
                                }
                            }
                            //for loop to convert String subjectoccnum that being read from file into int datatype so that it can be use in the program more relevantly
                            for(int m = 0; m < subjectocc.length; m++)
                            {
                                if(subjectocc[m] !=null)
                                {
                                    subjectoccnum[m] = Integer.parseInt(subjectocc[m]);
                                }
                            }
                            //for loop to print all occ(available class) for the student to choose to add into their module registered
                            for(int m = 0; m < subjectmode.length;m++)
                            {
                                if(subjectoccnum[m] != 0 || modesubject[m] != null)
                                {
                                    System.out.printf("\nOccurance %d - %S \n",subjectoccnum[m], modesubject[m]);
                                    System.out.println("Lecturer name : " + lecturername[m]);
                                    System.out.printf("Time : %s , %s \n",subjectday[m],subjecttime[m]);

                                }
                            }
                            
                            //student input for occ that they wanted to add for their class
                            System.out.println("Please select an occurance");
                            pick_occ = sc.nextInt();
                            
                            //this group of code is to prevent time clash of the classes, when there was a subject that the student has assigned has same time as the new one that will be add, it will =>
                            //print information that the student has another class at that time and exit the process of adding the new subject
                            int returncode = 0;
                            for(int m = 0;m < subjectday.length;m++ )
                            {
                                if(pick_occ == subjectoccnum[m])
                                {
                                    for(int n = 0; n<day.length;n++)
                                    {
                                        if(day[n] != null)
                                        {
                                            if(day[n].equals(subjectday[m]))
                                            {
                                                String[] split = subjecttime[m].split(" - ");
                                                int newstarttime = Integer.parseInt(split[0]);
                                                int newendtime = Integer.parseInt(split[1]); 
                                                if(((newstarttime>=oldtimestart[n]) && (newstarttime<oldtimeend[n]))||((newendtime>oldtimestart[n])&&(newendtime<=oldtimeend[n])))
                                                {
                                                    System.out.println("You have another class assign for this time!");
                                                    returncode = 1;
                                                    
                                                }
                                            }
                                        }
                                    } 
                                }
                            }
                            //reset the array so that no old data being use for next session
                            if(returncode==1)
                            {
                                for(int l = 0; l<subjectmode.length;l++)
                                {
                                    subjectmode[l] = null;
                                    subjectocc[l] = null;
                                    lecturername[l] = null;
                                    subjectday[l] = null;
                                    subjecttime[l] = null;
                                    subjectoccnum[l]= 0;
                                    modesubject[l] = null;
                                }
                                break;
                            }
                            
                            
                            
                            
                            
                            System.out.println("This is your occurance selection: ");        

                            //reprint the occ(class) that the student has chose 
                            for(int k = 0; k< subjectoccnum.length;k++)
                            {
                                if(pick_occ == subjectoccnum[k])
                                {
                                    System.out.printf("\nOccurance %d - %S \n",subjectoccnum[k], modesubject[k]);
                                    System.out.println("Lecturer name : " + lecturername[k]);
                                    System.out.printf("Time : %s , %s \n",subjectday[k],subjecttime[k]);
                                }
                            }
                            //asking confirmation from the student to add the module
                            System.out.println("Sure? 1 to confirm 0 to cancel");
                            int confirmation = sc.nextInt();
                            //get the  credit of the module that being registered
                            if(confirmation == 1)
                            {   
                                for(int m = 0; m< credithour.length ;m++)
                                {
                                    if(modulecode[m]!=null)
                                    {
                                        if(userinputmodule.equals(modulecode[m]))
                                        {
                                            credit = numcredithour[m];
                                        }
                                    }
                                }
                                //write data (module name and credit) to the checklist file so that the student can continue adding or not based on the checklist condition 
                                try
                                {
                                    File studentfile = new File(studentmatrix+"checklist.txt");
                                    if(!studentfile.exists())
                                    {
                                        studentfile.createNewFile();
                                    }
                                    PrintWriter writer = new PrintWriter(new FileOutputStream(studentfile,true));
                                    writer.println(moduleselect+","+credit);
                                    writer.close();
                                }
                                catch(IOException e)
                                {
                                    System.out.println("Error");
                                }
                                //write module detail(occ, lecturername,day,time) into the student's module file to store the data
                                try
                                {
                                    File studentfile = new File(studentmatrix+"modules.txt");
                                    if(!studentfile.exists())
                                    {
                                        studentfile.createNewFile();
                                    }
                                    PrintWriter writer = new PrintWriter(new FileOutputStream(studentfile,true));

                                    for(int k = 0; k< subjectoccnum.length;k++)
                                    {
                                        if(pick_occ == subjectoccnum[k])
                                        {
                                        writer.print(moduleselect+",");
                                        writer.print(subjectmode[k]+",");
                                        writer.print(subjectocc[k]+",");
                                        writer.print(lecturername[k]+",");
                                        writer.print(subjectday[k]+",");
                                        writer.println(subjecttime[k]);
                                        }
                                    }
                                    writer.close();
                                }
                                catch(IOException e)
                                {
                                    System.out.println("Error");
                                }

                                //write the student name into the lecturer's file so that the lecturer can see the student name that he/she teach
                                try
                                {
                                    for(int m = 0;m<subjectoccnum.length;m++)
                                    {
                                        if(pick_occ == subjectoccnum[m])
                                        {
                                            File lecturerfilestudent = new File(lecturername[m]+".txt");
                                            PrintWriter writer = new PrintWriter(new FileOutputStream(lecturerfilestudent,true));
                                            if(!lecturerfilestudent.exists())
                                            {
                                                lecturerfilestudent.createNewFile();
                                            }
                                            writer.println(moduleselect+","+subjectmode[m]+","+pick_occ+","+studentmatrix+","+studentname);
                                            writer.close();
                                        }
                                    }
                                }
                                catch(IOException e)
                                {
                                    System.out.println("Error");
                                }
                                //reset the array so that old data not being used for next session
                                for(int l = 0; l<subjectmode.length;l++)
                                {
                                    subjectmode[l] = null;
                                    subjectocc[l] = null;
                                    lecturername[l] = null;
                                    subjectday[l] = null;
                                    subjecttime[l] = null;
                                    subjectoccnum[l]= 0;
                                    modesubject[l] = null;
                                }

                            }
                            //if student did not confirm to add the occ, it will end the session and proceed to next session
                            else if(confirmation == 0)
                            {
                                break;
                            }
                        }
                    }
                    //break if user input is null
                    userinputmodule = null;
                    break;
                }
                //second selection for Specialization courses module
                while(selecttype == 2)
                {
                //specializationmodulelist
                    //userinput for the subject they want to add
                    System.out.println("Please enter the module you wanted to register (example: WIC3002):");
                    String userinputmodule = sc.next();
                    
                    //condition for the student to *only* register for their specialiaztion course module, not other programme specialization couurse module
                    if(!userinputmodule.equals(specialcourse))
                    {
                        System.out.println("You cannot register this module.");
                        break;
                    }
                    //check the checklis file to determine either the student can register for this module or not based on their registered course and total credit hour
                    
                    String[] read = new String[15];
                    String[] readsplit;
                    int[] credithournum = new int [read.length];
                    int exception = 0;
                    try
                    {   
                        File checklistfile = new File(studentmatrix+"checklist.txt");
                        if(!checklistfile.exists())
                        {
                            checklistfile.createNewFile();
                        }
                        BufferedReader reader = new BufferedReader(new FileReader(studentmatrix+"checklist.txt"));
                        
                        
                        for( int t = 0; t< subjectassigned.length; t++)
                        {
                            read[t]= reader.readLine();
                            if(read[t] != null)
                            {
                                readsplit = read[t].split(",");
                                subjectassigned[t] = readsplit[0];
                                credithournum[t] = Integer.parseInt(readsplit[1]);
                            }
                            if(userinputmodule.equals(subjectassigned[t]))
                            {
                                System.out.println("You have assigned for this module!");
                                exception = 1;
                            }
                            
                        }

                        if(exception == 1)
                            {
                                userinputmodule = null;
                                break;
                            }
                        reader.close();
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    
                    
                    //calculate total credit hour from checklist file so that student did not exceed 22 credit hours
                    total_credit_hour = 0;

                    for(int i = 0 ; i< read.length;i++)
                    {
                            total_credit_hour = total_credit_hour + credithournum[i];                        
                    }
                    for(int i =0; i < Smodulecode.length; i++)
                    {
                        if(userinputmodule == null)
                        break;
                        else if(userinputmodule.equals(Smodulecode[i]))
                        {
                            //add total credit hour with the newly-will-add module so the total credit hour not exceeding 22 including the module that will be add by the student
                            int total_credit_hour_test = total_credit_hour + Scredithour[i];
                            if(total_credit_hour_test>22)
                            {
                                System.out.println("You have exceeding the credit hour limit!");
                                break;
                            }
                            //set the specialization course module code into a fix variable to be use
                            moduleselect = Smodulecode[i];
                            //read the module file to get information about the subject
                            try
                            {
                                BufferedReader reader = new BufferedReader(new FileReader(moduleselect+".txt"));

                                for( int l = 0; l< subjectreader.length; l++)
                                {
                                    subjectreader[l] = reader.readLine();
                                    
                                    if(subjectreader[l] != null)
                                    {
                                        subjectsplit = subjectreader[l].split(",");
                                        subjectmode[l] = subjectsplit[0];
                                        subjectocc[l] = subjectsplit[1];
                                        lecturername[l] = subjectsplit[2];
                                        subjectday[l] = subjectsplit[3];
                                        subjecttime[l] = subjectsplit[4];
                                    }
                                }

                            reader.close();
                            }
                            catch(IOException e)
                            {
                                e.printStackTrace();
                            }
                            //change shortform into more user friendly data that can be read
                            for(int m =0; m < subjectmode.length; m++)
                            {
                                if(subjectmode[m]!=null)
                                {
                                    if(subjectmode[m].equals("L"))
                                        modesubject[m] = "LECTURE";
                                    else if(subjectmode[m].equals("T"))
                                        modesubject[m] = "TUTORIAL";
                                    else if(subjectmode[m].equals("TL"))
                                        modesubject[m] = "TUTORIAL/LAB";
                                        
                                }
                            }
                            //change the String subjectoccnum into int to be used more effectively in the program
                            for(int m = 0; m < subjectocc.length; m++)
                            {
                                if(subjectocc[m] !=null)
                                {
                                    subjectoccnum[m] = Integer.parseInt(subjectocc[m]);
                                }
                            }
                            //print all available occurance for the subject
                            for(int m = 0; m < subjectmode.length;m++)
                            {
                                if(subjectoccnum[m] != 0 || modesubject[m] != null)
                                {
                                    System.out.printf("\nOccurance %d - %S \n",subjectoccnum[m], modesubject[m]);
                                    System.out.println("Lecturer name : " + lecturername[m]);
                                    System.out.printf("Time : %s , %s \n",subjectday[m],subjecttime[m]);

                                }
                            }
                            //userinput to select occurance that they want to add to their list
                            System.out.println("Please select an occurance");
                            pick_occ = sc.nextInt();
                            
                            //block of code to prevent from time clash of the subject
                            int returncode = 0;
                            for(int m = 0;m < subjectday.length;m++ )
                            {
                                if(pick_occ == subjectoccnum[m])
                                {
                                    for(int n = 0; n<day.length;n++)
                                    {
                                        if(day[n] != null)
                                        {
                                            if(day[n].equals(subjectday[m]))
                                            {
                                                String[] split = subjecttime[m].split(" - ");
                                                int newstarttime = Integer.parseInt(split[0]);
                                                int newendtime = Integer.parseInt(split[1]); 
                                                if(((newstarttime>=oldtimestart[n]) && (newstarttime<oldtimeend[n]))||((newendtime>oldtimestart[n])&&(newendtime<=oldtimeend[n])))
                                                {
                                                    System.out.println("You have another class assign for this time!");
                                                    returncode = 1;
                                                    
                                                }
                                            }
                                        }
                                    } 
                                }
                            }
                            //if there are time clash, will exit the add session and reset all the array so the old data will not being use for next session
                            if(returncode==1)
                            {
                                for(int l = 0; l<subjectmode.length;l++)
                                {
                                    subjectmode[l] = null;
                                    subjectocc[l] = null;
                                    lecturername[l] = null;
                                    subjectday[l] = null;
                                    subjecttime[l] = null;
                                    subjectoccnum[l]= 0;
                                    modesubject[l] = null;
                                }
                                break;
                            }

                            System.out.println("This is your occurance selection: ");        
                            //reprint student selection of occurance

                            for(int k = 0; k< subjectoccnum.length;k++)
                            {
                                if(pick_occ == subjectoccnum[k])
                                {
                                    System.out.printf("\nOccurance %d - %S \n",subjectoccnum[k], modesubject[k]);
                                    System.out.println("Lecturer name : " + lecturername[k]);
                                    System.out.printf("Time : %s , %s \n",subjectday[k],subjecttime[k]);
                                }
                            }
                            
                            //getting student confirmation to add the occurance or not
                            System.out.println("Sure? 1 to confirm 0 to cancel");
                            int confirmation = sc.nextInt();
                            //if the student want to proceed
                            if(confirmation == 1)
                            {   
                                //set the credit to fix variable to be used for next operation
                                for(int m = 0; m< Scredithour.length ;m++)
                                {
                                    if(Smodulecode[m]!=null)
                                    {
                                        if(userinputmodule.equals(Smodulecode[m]))
                                        {
                                            credit = Scredithour[m];
                                        }
                                    }
                                }
                                //write the module code and credit so that student cannot add this module again and the credit for student not to exceed 22 credit while adding new module in the future
                                try
                                {
                                    File studentfile = new File(studentmatrix+"checklist.txt");
                                    if(!studentfile.exists())
                                    {
                                        studentfile.createNewFile();
                                    }
                                    PrintWriter writer = new PrintWriter(new FileOutputStream(studentfile,true));
                                    writer.println(moduleselect+","+credit);
                                    writer.close();
                                }
                                catch(IOException e)
                                {
                                    System.out.println("Error");
                                }
                                //write the module detail in the student module file to store the data for future use
                                try
                                {
                                    File studentfile = new File(studentmatrix+"modules.txt");
                                    if(!studentfile.exists())
                                    {
                                        studentfile.createNewFile();
                                    }
                                    PrintWriter writer = new PrintWriter(new FileOutputStream(studentfile,true));

                                    for(int k = 0; k< subjectoccnum.length;k++)
                                    {
                                        if(pick_occ == subjectoccnum[k])
                                        {
                                        writer.print(moduleselect+",");
                                        writer.print(subjectmode[k]+",");
                                        writer.print(subjectocc[k]+",");
                                        writer.print(lecturername[k]+",");
                                        writer.print(subjectday[k]+",");
                                        writer.println(subjecttime[k]);
                                        }
                                    }
                                    writer.close();
                                }
                                catch(IOException e)
                                {
                                    System.out.println("Error");
                                }
                                //write the student name into the lecturer's file so that the lecturer can see who he/she teach
                                try
                                {
                                    for(int m = 0; m<subjectoccnum.length;m++)
                                    {
                                        if(pick_occ == subjectoccnum[m])
                                        {
                                            lecturerfile = lecturername[m];
                                        }
                                            
                                        if(lecturerfile!=null)
                                        {
                                                File lectfile = new File(lecturerfile+".txt");
                                                if(!lectfile.exists())
                                                {
                                                    lectfile.createNewFile();
                                                }
                                                PrintWriter writer = new PrintWriter(new FileOutputStream(lectfile,true));
                                                if(subjectmode[m] != null)
                                                writer.println(moduleselect+","+subjectmode[m]+","+pick_occ+","+studentmatrix+","+studentname);
                                                writer.close();
                                        }
                                    }
                                    
                                }
                                catch(IOException e)
                                {
                                    System.out.println("Error");
                                }
                                //reset the array so old data not being use for next session
                                for(int l = 0; l<subjectmode.length;l++)
                                {
                                    subjectmode[l] = null;
                                    subjectocc[l] = null;
                                    lecturername[l] = null;
                                    subjectday[l] = null;
                                    subjecttime[l] = null;
                                    subjectoccnum[l]= 0;
                                    modesubject[l] = null;
                                }
                                

                            }
                            //when user cancel to add the occurance, exite the session and proceed to next session
                            else if(confirmation == 0)
                            {
                                break;
                            }
                            
                        }
                        
                    }
                    //exit the session if user input is null
                    userinputmodule = null;
                    break;
                }
                
                //selsection for English course subject
                while(selecttype == 3)
                {
                    //userinput for the module that the student want to add 
                    System.out.println("Please enter the module you wanted to register (example: GLT1018):");
                    String userinputmodule = sc.next();
                    //get the band needed for the subject for the condition student to register the module
                    String[] read = new String[15];
                    String[] readsplit;
                    int[] credithournum = new int [read.length];
                    String bandneeded = null;
                    for(int i = 0;i<engmodulecode.length;i++)
                    {
                        if(engmodulecode[i]!=null)
                        {
                          if(userinputmodule.equals(engmodulecode[i])) 
                          {
                            bandneeded = engband[i];
                          }
                        }
                        
                    }
                    //if student band meet reguirement of the subject, continue, else, break
                    if(!studentmuet.equals(bandneeded))
                    {
                        System.out.println("You cannot assign for this module."+"Band needed: "+bandneeded); 
                        break;
                        
                    }
                    //read checklist file to confirm that the student has assigned for the module or not and make sure student total credit hour not exceeding 22
                    int exception = 0;
                    try
                    {   
                        File checklistfile = new File(studentmatrix+"checklist.txt");
                        if(!checklistfile.exists())
                        {
                            checklistfile.createNewFile();
                        }
                        BufferedReader reader = new BufferedReader(new FileReader(studentmatrix+"checklist.txt"));

                        for( int t = 0; t< subjectassigned.length; t++)
                        {
                            read[t]= reader.readLine();
                            if(read[t] != null)
                            {
                                readsplit = read[t].split(",");
                                subjectassigned[t] = readsplit[0];
                                credithournum[t] = Integer.parseInt(readsplit[1]);
                            }
                            if(userinputmodule.equals(subjectassigned[t]))
                            {
                                System.out.println("You have assigned for this module!");
                                exception = 1;
                            }
                        }
                        if(exception == 1)
                        {
                            userinputmodule = null;
                            break;
                        }


                        reader.close();
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    //calculate total credit hour from checklist file so that student did not exceed 22 credit hours
                    total_credit_hour = 0;

                    for(int i = 0 ; i< read.length;i++)
                    {
                            total_credit_hour = total_credit_hour + credithournum[i];                        
                    }

                    for(int i =0; i < engmodulecode.length; i++)
                    {
                        if(userinputmodule == null)
                        break;
                        else if(userinputmodule.equals(engmodulecode[i]))
                        {
                            //total credit hour including new subject to be add ,if total more that 22, exit the session and proceed to next session
                            int total_credit_hour_test = total_credit_hour + engcredithour[i];
                            if(total_credit_hour_test>22)
                            {
                                System.out.println("You have exceeding the credit hour limit!");
                                break;
                            }
                            //read from the module file to get the information of the subject that being choose
                            moduleselect = engmodulecode[i];
                            try
                            {
                                BufferedReader reader = new BufferedReader(new FileReader(moduleselect+".txt"));

                                for( int l = 0; l< subjectreader.length; l++)
                                {
                                    subjectreader[l] = reader.readLine();

                                    if(subjectreader[l] != null)
                                    {
                                        subjectsplit = subjectreader[l].split(",");
                                        subjectmode[l] = subjectsplit[0];
                                        subjectocc[l] = subjectsplit[1];
                                        lecturername[l] = subjectsplit[2];
                                        subjectday[l] = subjectsplit[3];
                                        subjecttime[l] = subjectsplit[4];
                                    }
                                }

                            reader.close();
                            }
                            catch(IOException e)
                            {
                                e.printStackTrace();
                            }
                            //convert shortform to moreuserfriendly data to be read
                            for(int m =0; m < subjectmode.length; m++)
                            {
                                if(subjectmode[m]!=null)
                                {
                                    if(subjectmode[m].equals("L"))
                                        modesubject[m] = "LECTURE";
                                    else if(subjectmode[m].equals("T"))
                                        modesubject[m] = "TUTORIAL";
                                    else if(subjectmode[m].equals("TL"))
                                        modesubject[m] = "TUTORIAL/LAB";
                                }
                            }
                            //convert String subjectoccnum to int type so that it can be used more effectively for the program
                            for(int m = 0; m < subjectocc.length; m++)
                            {
                                if(subjectocc[m] !=null)
                                {
                                    subjectoccnum[m] = Integer.parseInt(subjectocc[m]);
                                }
                            }
                            //print all occurance available for the subject
                            for(int m = 0; m < subjectmode.length;m++)
                            {
                                if(subjectoccnum[m] != 0 || modesubject[m] != null)
                                {
                                    System.out.printf("\nOccurance %d - %S \n",subjectoccnum[m], modesubject[m]);
                                    System.out.println("Lecturer name : " + lecturername[m]);
                                    System.out.printf("Time : %s , %s \n",subjectday[m],subjecttime[m]);

                                }
                            }
                            //student pick an occ to be add to their list
                            System.out.println("Please select an occurance");
                            pick_occ = sc.nextInt();
                            //make sure no time clash if the student take this subject, if there is time clash, exit the current session and proceed to next session
                            int returncode = 0;
                            for(int m = 0;m < subjectday.length;m++ )
                            {
                                if(pick_occ == subjectoccnum[m])
                                {
                                    for(int n = 0; n<day.length;n++)
                                    {
                                        if(day[n] != null)
                                        {
                                            if(day[n].equals(subjectday[m]))
                                            {
                                                String[] split = subjecttime[m].split(" - ");
                                                int newstarttime = Integer.parseInt(split[0]);
                                                int newendtime = Integer.parseInt(split[1]); 
                                                if(((newstarttime>=oldtimestart[n]) && (newstarttime<oldtimeend[n]))||((newendtime>oldtimestart[n])&&(newendtime<=oldtimeend[n])))
                                                {
                                                    System.out.println("You have another class assign for this time!");
                                                    returncode = 1;
                                                    
                                                }
                                            }
                                        }
                                    } 
                                }
                            }
                            //if student cannot assign for the module, reset the array data so that old data not being used for next session
                            if(returncode==1)
                            {
                                for(int l = 0; l<subjectmode.length;l++)
                                {
                                    subjectmode[l] = null;
                                    subjectocc[l] = null;
                                    lecturername[l] = null;
                                    subjectday[l] = null;
                                    subjecttime[l] = null;
                                    subjectoccnum[l]= 0;
                                    modesubject[l] = null;
                                }
                                break;
                            }
 
                            System.out.println("This is your occurance selection: ");        
                            //reprint selected occurance for the student to confirm

                            for(int k = 0; k< subjectoccnum.length;k++)
                            {
                                if(pick_occ == subjectoccnum[k])
                                {
                                    System.out.printf("\nOccurance %d - %S \n",subjectoccnum[k], modesubject[k]);
                                    System.out.println("Lecturer name : " + lecturername[k]);
                                    System.out.printf("Time : %s , %s \n",subjectday[k],subjecttime[k]);
                                }
                            }
                            //student confirmamtion to add the module
                            System.out.println("Sure? 1 to confirm 0 to cancel");
                            int confirmation = sc.nextInt();
                            //student proceed
                            if(confirmation == 1)
                            {   
                                //set the credithour into a fix variable to be use for the program
                                for(int m = 0; m< credithournum.length ;m++)
                                {
                                    if(engmodulecode[m]!=null)
                                    {
                                        if(userinputmodule.equals(engmodulecode[m]))
                                        {
                                            credit = engcredithour[m];
                                        }
                                    }
                                }
                                //write the modulecode and credit to the checklist for student future use of adding and deleting subject
                                try
                                {
                                    File studentfile = new File(studentmatrix+"checklist.txt");
                                    if(!studentfile.exists())
                                    {
                                        studentfile.createNewFile();
                                    }
                                    PrintWriter writer = new PrintWriter(new FileOutputStream(studentfile,true));
                                    writer.println(moduleselect+","+credit);
                                    writer.close();
                                }
                                catch(IOException e)
                                {
                                    System.out.println("Error");
                                }
                                //add the module detail into student module file
                                try
                                {
                                    File studentfile = new File(studentmatrix+"modules.txt");
                                    if(!studentfile.exists())
                                    {
                                        studentfile.createNewFile();
                                    }
                                    PrintWriter writer = new PrintWriter(new FileOutputStream(studentfile,true));

                                    for(int k = 0; k< subjectoccnum.length;k++)
                                    {
                                        if(pick_occ == subjectoccnum[k])
                                        {
                                        writer.print(moduleselect+",");
                                        writer.print(subjectmode[k]+",");
                                        writer.print(subjectocc[k]+",");
                                        writer.print(lecturername[k]+",");
                                        writer.print(subjectday[k]+",");
                                        writer.println(subjecttime[k]);
                                        }
                                    }
                                    writer.close();
                                }
                                catch(IOException e)
                                {
                                    System.out.println("Error");
                                }
                                //add student name to lecturer file for the lecturer to see the students they teach
                                try
                                {
                                    for(int m = 0; m<subjectoccnum.length;m++)
                                    {
                                        if(pick_occ == subjectoccnum[m])
                                        {
                                            lecturerfile = lecturername[m];
                                        }
                                            
                                        if(lecturerfile!=null)
                                        {
                                                File lectfile = new File(lecturerfile+".txt");
                                                if(!lectfile.exists())
                                                {
                                                    lectfile.createNewFile();
                                                }
                                                PrintWriter writer = new PrintWriter(new FileOutputStream(lectfile,true));
                                                if(subjectmode[m] != null)
                                                writer.println(moduleselect+","+subjectmode[m]+","+pick_occ+","+studentmatrix+","+studentname);
                                                writer.close();
                                        }
                                    }
                                    
                                }
                                catch(IOException e)
                                {
                                    System.out.println("Error");
                                }
                                //at the end of the session, reset the array so that old data not being use for next session
                                for(int l = 0; l<subjectmode.length;l++)
                                {
                                    subjectmode[l] = null;
                                    subjectocc[l] = null;
                                    lecturername[l] = null;
                                    subjectday[l] = null;
                                    subjecttime[l] = null;
                                    subjectoccnum[l]= 0;
                                    modesubject[l] = null;
                                }

                            }
                            //if student cancel to add the occurance, ecit the session and proceed to next
                            else if(confirmation == 0)
                            {
                                break;
                            }
                        }
                    }
                    userinputmodule = null;
                    break;
                }
                //if the user enter wrong code, a message will appear
                if(selecttype!=1&&selecttype!=2&&selecttype!=3&&selecttype!=0)
                {
                    System.out.println("Wrong code!");
                }
                if(selecttype == 0)
                    System.out.println("Exited");
    }
}
