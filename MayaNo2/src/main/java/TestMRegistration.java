/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.io.*;
import java.util.*;
public class TestMRegistration {
    public static void main(String[] args)
    {
        String studentinfo;
        String[] studentsplit;
        String studentmatrix = null;
        String studentemail = null;
        String studentname = null;
        String studentpassword = null;
        String studentprogramme = null;
        String studentmuet = null;
        String specialcourse = null;
        String[] course_registered = new String [10];
        int j = 1;
        
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
        
        Scanner sc = new Scanner(System.in);
        //read student account info
        try
        {
            //COMPARE USERNAME FROM LLOGGER FILE;
            BufferedReader reader = new BufferedReader(new FileReader("student.txt"));

                    studentinfo = reader.readLine();
                    studentsplit = studentinfo.split(",");
                    studentmatrix = studentsplit[0];
                    studentemail = studentsplit[1];
                    studentname = studentsplit[2];
                    studentpassword = studentsplit[3];//not useful here
                    studentprogramme = studentsplit[4];
                    studentmuet = studentsplit[5];  
                    
            reader.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        //read module list(common module)
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
        //FOR SPECIAL
        String[] Smodulecode = new String[100];
        String[] Smodulename = new String[100];
        String[] Smodulewithname = new String[100];
        String[] Stotalocc = new String [100];
        int [] Scredithour = new int [100];
        String[] Smodulemode = new String[100];
        String[] Smodulesplit;
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
        
        //for english course
        String[] engmodulecode = new String[100];
        String[] engmodulename = new String[100];
        String[] engmodulewithname = new String[100];
        String[] engtotalocc = new String [100];
        int[] engcredithour = new int [100];
        String[] engmodulemode = new String[100];
        String[] engband = new String[100];
        String[] engmodulesplit;
        
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("Englishcourselist.txt"));
            
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
        
        
        
        //specialization course for the student
        if(studentprogramme.equals("Bachelor of Computer Science (Computer System and Network)"))
        {
            specialcourse = "WIC3002";//specialization course
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
        else if(studentprogramme.equals("Bachelor of Information Technology Multimedia)"))
        {
            specialcourse = "WIG3007";
        }
        else if(studentprogramme.equals("Bachelor of Computer Science (Data Science)"))
        {
            specialcourse = "WIH3003";
        }
        
        course_registered[0] = specialcourse;
        System.out.println("Main Course:" + specialcourse);
        
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
        
        String modeselect = null;
        String occ_select = null;
        String lecturer_select = null; 
        String day_select = null; 
        String time_select = null; 
        
        int pick_occ;
        //search module
        System.out.println("Enter 1 to add module, 2 to delete module, 3 to view module registered, 4 to exit");//1 to view all, 2 to search, 3 to add, 4 to drop, 5 to exit
        int selection = sc.nextInt();
        while(selection == 1 || selection == 2 || selection == 3)
        {
            //add module
            while(selection == 1)
            {
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
                
                
                
                
                String[] time = new String [30];
                String [] timesplit;
                int [] oldtimestart = new int[30];
                int [] oldtimeend = new int[30];
                String[] day = new String[30];
                String[] subjectlist = new String[30];
                String[] moduleviewsplit;
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
                
                
                
                
                
                
                
                
                
                
                
                System.out.println("English Courses:");
                for(int i = 0; i < engmodulecode.length;i++)
                {
                    if(engmodulewithname[i] != null)
                    System.out.println(engcredithour[i] + " Credit | " + engmodulecode[i] + " | " + engmodulename[i]);
                }
                System.out.println("Enter 1 to add Main course, 2 to add Specialization course, 3 to add English course");
                int selecttype = sc.nextInt();
                
                if(selecttype == 1)
                {    
                    System.out.println("Please enter the module you wanted to register (example: WIX2002):");
                    String userinputmodule = sc.next();

                    //read checklist file(for each student they have checklist txt to prevent them register same module)
                    String[] read = new String[15];
                    String[] readsplit;
                    int[] credithournum = new int [read.length];

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
                                userinputmodule = null;
                                break;
                            }
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

                    for(int i =0; i < modulecode.length; i++)
                    {
                        if(userinputmodule == null)
                        break;
                        else if(userinputmodule.equals(modulecode[i]))
                        {
                            int total_credit_hour_test = total_credit_hour + numcredithour[i];
                            if(total_credit_hour_test>22)
                            {
                                System.out.println("You have exceeding the credit hour limit!");
                                break;
                            }
                            moduleselect = modulecode[i];
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

                            for(int m = 0; m < subjectocc.length; m++)
                            {
                                if(subjectocc[m] !=null)
                                {
                                    subjectoccnum[m] = Integer.parseInt(subjectocc[m]);
                                }
                            }

                            for(int m = 0; m < subjectmode.length;m++)
                            {
                                if(subjectoccnum[m] != 0 || modesubject[m] != null)
                                {
                                    System.out.printf("\nOccurance %d - %S \n",subjectoccnum[m], modesubject[m]);
                                    System.out.println("Lecturer name : " + lecturername[m]);
                                    System.out.printf("Time : %s , %s \n",subjectday[m],subjecttime[m]);

                                }
                            }

                            System.out.println("Please select an occurance");
                            pick_occ = sc.nextInt();
                            
                            //int[][] newendtime = new int[subjectday.length][day.length];
                            
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
                            
                            
                            
                            
                            String lecturerfile = null;
                            System.out.println("This is your occurance selection: ");        


                            for(int k = 0; k< subjectoccnum.length;k++)
                            {
                                if(pick_occ == subjectoccnum[k])
                                {
                                    System.out.printf("\nOccurance %d - %S \n",subjectoccnum[k], modesubject[k]);
                                    System.out.println("Lecturer name : " + lecturername[k]);
                                    System.out.printf("Time : %s , %s \n",subjectday[k],subjecttime[k]);
                                }
                            }
                            System.out.println("Sure? 1 to confirm 0 to cancel");
                            int confirmation = sc.nextInt();

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
                                                File lectfile = new File(lecturerfile+userinputmodule+".txt");
                                                if(!lectfile.exists())
                                                {
                                                    lectfile.createNewFile();
                                                }
                                                PrintWriter writer = new PrintWriter(new FileOutputStream(lectfile,true));
                                                if(subjectmode[m] != null)
                                                writer.println(studentmatrix+","+studentname+","+pick_occ+","+subjectmode[m]);//DIA PRINT BAMYAK KALI NULL!
                                                writer.close();
                                        }
                                    }
                                    
                                }
                                catch(IOException e)
                                {
                                    System.out.println("Error");
                                }
                                
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
                            else if(confirmation == 0)
                            {
                                break;
                            }//TO HERE (I MOVE IT INSIDE IF)
                        }
                        /*else
                        {
                            break;//HOW TO ADD ERROR MESSAGR ONLY ONCE?
                        }*/
                    }
                }
                else if(selecttype == 2)
                {
                //specializationmodulelist
                    System.out.println("Please enter the module you wanted to register (example: WIC3002):");
                    String userinputmodule = sc.next();
                    
                    if(!userinputmodule.equals(specialcourse))
                    {
                        System.out.println("You cannot register this module.");
                        break;
                    }
                    
                    String[] read = new String[15];
                    String[] readsplit;
                    int[] credithournum = new int [read.length];
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
                                userinputmodule = null;
                                break;
                            }
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
                            int total_credit_hour_test = total_credit_hour + Scredithour[i];
                            if(total_credit_hour_test>22)
                            {
                                System.out.println("You have exceeding the credit hour limit!");
                                break;
                            }
                            moduleselect = Smodulecode[i];
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

                            for(int m = 0; m < subjectocc.length; m++)
                            {
                                if(subjectocc[m] !=null)
                                {
                                    subjectoccnum[m] = Integer.parseInt(subjectocc[m]);
                                }
                            }

                            for(int m = 0; m < subjectmode.length;m++)
                            {
                                if(subjectoccnum[m] != 0 || modesubject[m] != null)
                                {
                                    System.out.printf("\nOccurance %d - %S \n",subjectoccnum[m], modesubject[m]);
                                    System.out.println("Lecturer name : " + lecturername[m]);
                                    System.out.printf("Time : %s , %s \n",subjectday[m],subjecttime[m]);

                                }
                            }

                            System.out.println("Please select an occurance");
                            pick_occ = sc.nextInt();
                            
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


                            for(int k = 0; k< subjectoccnum.length;k++)
                            {
                                if(pick_occ == subjectoccnum[k])
                                {
                                    System.out.printf("\nOccurance %d - %S \n",subjectoccnum[k], modesubject[k]);
                                    System.out.println("Lecturer name : " + lecturername[k]);
                                    System.out.printf("Time : %s , %s \n",subjectday[k],subjecttime[k]);
                                }
                            }
                            System.out.println("Sure? 1 to confirm 0 to cancel");
                            int confirmation = sc.nextInt();

                            if(confirmation == 1)
                            {   
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
                            else if(confirmation == 0)
                            {
                                break;
                            }
                        }
                    }
                }
                
                
                else if(selecttype == 3)
                {
                    System.out.println("Please enter the module you wanted to register (example: GLT1018):");
                    String userinputmodule = sc.next();

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
                    if(!studentmuet.equals(bandneeded))
                    {
                        System.out.println("You cannot assign for this module."+"Band needed: "+bandneeded); 
                        break;
                        
                    }
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
                                userinputmodule = null;
                                break;
                            }
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
                            int total_credit_hour_test = total_credit_hour + engcredithour[i];
                            if(total_credit_hour_test>22)
                            {
                                System.out.println("You have exceeding the credit hour limit!");
                                break;
                            }
                            
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

                            for(int m = 0; m < subjectocc.length; m++)
                            {
                                if(subjectocc[m] !=null)
                                {
                                    subjectoccnum[m] = Integer.parseInt(subjectocc[m]);
                                }
                            }

                            for(int m = 0; m < subjectmode.length;m++)
                            {
                                if(subjectoccnum[m] != 0 || modesubject[m] != null)
                                {
                                    System.out.printf("\nOccurance %d - %S \n",subjectoccnum[m], modesubject[m]);
                                    System.out.println("Lecturer name : " + lecturername[m]);
                                    System.out.printf("Time : %s , %s \n",subjectday[m],subjecttime[m]);

                                }
                            }

                            System.out.println("Please select an occurance");
                            pick_occ = sc.nextInt();
                            
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
                            //problem when break here is the array will not be empty and if the next subject has less array size it will print the remaining array that has been recorded

                            System.out.println("This is your occurance selection: ");        


                            for(int k = 0; k< subjectoccnum.length;k++)
                            {
                                if(pick_occ == subjectoccnum[k])
                                {
                                    System.out.printf("\nOccurance %d - %S \n",subjectoccnum[k], modesubject[k]);
                                    System.out.println("Lecturer name : " + lecturername[k]);
                                    System.out.printf("Time : %s , %s \n",subjectday[k],subjecttime[k]);
                                }
                            }
                            System.out.println("Sure? 1 to confirm 0 to cancel");
                            int confirmation = sc.nextInt();

                            if(confirmation == 1)
                            {   
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
                            else if(confirmation == 0)
                            {
                                break;
                            }
                        }
                    }
                }
                else
                {
                    System.out.println("Wrong code!");
                    break;
                }



                System.out.println("Do you wish to continue? (1 to continue, 2 to drop module, 3 to view module registered, 4 to exit)");
                selection = sc.nextInt();
            }
            while(selection==2)
            {
                System.out.println("Delete your module");
                
                String[] subjectlist = new String[30];
                String[] moduleselectview = new String [30];
                String[] subjectmodeview = new String [30];
                String[] subjectoccview = new String [30];
                String[] lecturernameview = new String [30];
                String[] subjectdayview = new String [30];
                String[] subjecttimeview = new String [30];
                String[] modulenameview = new String[30];
                String[] modesubjectview = new String[30];
                String[] moduleviewsplit;
                
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
                            moduleselectview[t] = moduleviewsplit[0];
                            subjectmodeview[t] = moduleviewsplit[1];
                            subjectoccview[t] = moduleviewsplit[2];
                            lecturernameview[t] = moduleviewsplit[3];
                            subjectdayview[t] = moduleviewsplit[4];
                            subjecttimeview[t] = moduleviewsplit[5];
                        }
                        
                    }     
                    reader.close();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
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
                for(int m =0; m < subjectmodeview.length; m++)
                {
                    if(subjectmodeview[m]!=null)
                    {
                        if(subjectmodeview[m].equals("L"))
                            modesubjectview[m] = "LECTURE";
                        else if(subjectmodeview[m].equals("T"))
                            modesubjectview[m] = "TUTORIAL";
                        else if(subjectmodeview[m].equals("TL"))
                            modesubjectview[m] = "TUTORIAL/LAB";
                    }
                }
                
                for(int i = 0;i < moduleselectview.length;i++)
                {
                    if(moduleselectview[i] != null)
                    {
                        for(int k = 0; k < modulecode.length; k++ )
                        {
                            if(moduleselectview[i].equals(modulecode[k]))
                            {
                                modulenameview[i]= modulename[k];
                            }
                            if(moduleselectview[i].equals(engmodulecode[k]))
                            {
                                modulenameview[i] = engmodulename[k];
                            }
                            if(moduleselectview[i].equals(Smodulecode[k]))
                            {
                                modulenameview[i] = Smodulename[k];
                            }
                            
                        }
                    }
                }
               
                for(int i = 0;i < 30; i++)
                {
                    if(moduleselectview[i]!=null)
                    {
                        System.out.printf("\nModule : %s - %S \n",moduleselectview[i], modulenameview[i]);
                        System.out.printf("Occurance: %s \n",subjectoccview[i]);
                        System.out.printf("Class Mode: %s \n",modesubjectview[i]);
                        System.out.println("Lecturer name : " + lecturernameview[i]);
                        System.out.printf("Time : %s , %s \n",subjectdayview[i],subjecttimeview[i]);
                    }
                }
                System.out.println("Enter the module code that you want to delete (example: WIX2002)");
                String userdelete = sc.next();
                
                try
                {
                    File oldFile = new File(studentmatrix+"modules.txt");
                    File deletefile = new File("temporary.txt");
                    if(!deletefile.exists())
                    {
                         deletefile.createNewFile();
                    }
                    PrintWriter writer = new PrintWriter(new FileOutputStream(deletefile,true));

                    for(int i = 0; i < moduleselectview.length; i++)
                    {
                         if(moduleselectview[i] != null)
                         {
                             if(!userdelete.equals(moduleselectview[i]))
                             {
                                writer.print(moduleselectview[i]+",");
                                writer.print(subjectmodeview[i]+",");
                                writer.print(subjectoccview[i]+",");
                                writer.print(lecturernameview[i]+",");
                                writer.print(subjectdayview[i]+",");
                                writer.println(subjecttimeview[i]);
                             }
                         }

                    }
                   
                   writer.close();
                   oldFile.delete();
                   File newFile = new File(studentmatrix+"modules.txt");
                   deletefile.renameTo(newFile);
                }
                catch(IOException e)
                {
                    System.out.println("Error");
                }
                
                try
                {   
                    File oldFile = new File(studentmatrix+"checklist.txt");
                    File deletefile = new File("temporarychecklist.txt");
                    String[] read = new String[subjectassigned.length];
                    String[] readsplit;
                    if(!deletefile.exists())
                    {
                         deletefile.createNewFile();
                    }
                    
                    PrintWriter writer = new PrintWriter(new FileOutputStream(deletefile,true));
                    
                    FileReader fReader = new FileReader(oldFile);
                    BufferedReader reader = new BufferedReader(fReader);
                    
                    for( int t = 0; t< subjectassigned.length; t++)
                    {
                        read[t] = reader.readLine();
                        
                        if(subjectassigned[t]!=null)
                        {
                            readsplit = read[t].split(",");
                            subjectassigned[t] = readsplit[0];
                            if(!userdelete.equals(subjectassigned[t]))
                            {
                                writer.println(read[t]);
                            }
                        }
                    }
                    
                    reader.close();
                    writer.close();
                    oldFile.delete();
                    File newFile = new File(studentmatrix+"checklist.txt");
                    deletefile.renameTo(newFile);
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                
                //DELTE CHECKLIS SKALI
                /*for(int i = 0; i < moduleselectview.length; i++)
                {
                    if(moduleselectview[i] != null)
                    {
                        if(userdelete.equals(moduleselectview[i]))
                        {
                            
                        }
                    }
                
                }*/
                System.out.println("Do you wish to continue? (1 to add module, 2 to continue, 3 to view module registered, 4 to exit)");
                selection = sc.nextInt();
            }
            while(selection==3)
            {
            
                System.out.println("This is your course");
                String[] read = new String[15];
                String[] readsplit;
                int[] credithournum = new int [read.length];
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
                    }
                    reader.close();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                total_credit_hour = 0;
                for(int i = 0 ; i< read.length;i++)
                {
                    total_credit_hour = total_credit_hour + credithournum[i];
                    
                }
                System.out.println("Total credit hours:" + total_credit_hour);
                String[] subjectlist = new String[30];
                String[] moduleselectview = new String [30];
                String[] subjectmodeview = new String [30];
                String[] subjectoccview = new String [30];
                String[] lecturernameview = new String [30];
                String[] subjectdayview = new String [30];
                String[] subjecttimeview = new String [30];
                String[] modulenameview = new String[30];
                String[] modesubjectview = new String[30];
                String[] moduleviewsplit;
                
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
                            moduleselectview[t] = moduleviewsplit[0];
                            subjectmodeview[t] = moduleviewsplit[1];
                            subjectoccview[t] = moduleviewsplit[2];
                            lecturernameview[t] = moduleviewsplit[3];
                            subjectdayview[t] = moduleviewsplit[4];
                            subjecttimeview[t] = moduleviewsplit[5];
                        }
                        
                    }     
                    reader.close();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                
                for(int m =0; m < subjectmodeview.length; m++)
                {
                    if(subjectmodeview[m]!=null)
                    {
                        if(subjectmodeview[m].equals("L"))
                            modesubjectview[m] = "LECTURE";
                        else if(subjectmodeview[m].equals("T"))
                            modesubjectview[m] = "TUTORIAL";
                        else if(subjectmodeview[m].equals("TL"))
                            modesubjectview[m] = "TUTORIAL/LAB";
                    }
                }
                
                for(int i = 0;i < moduleselectview.length;i++)
                {
                    if(moduleselectview[i] != null)
                    {
                        for(int k = 0; k < modulecode.length; k++ )
                        {
                            if(moduleselectview[i].equals(modulecode[k]))
                            {
                                modulenameview[i]= modulename[k];
                            }
                            if(moduleselectview[i].equals(engmodulecode[k]))
                            {
                                modulenameview[i]= engmodulename[k];
                            }
                            if(moduleselectview[i].equals(Smodulecode[k]))
                            {
                                modulenameview[i] = Smodulename[k];
                            }
                        }
                    }
                }
                
               
                for(int i = 0;i < 30; i++)
                {
                    if(moduleselectview[i]!=null)
                    {
                        System.out.printf("\nModule : %s - %S \n",moduleselectview[i], modulenameview[i]);
                        System.out.printf("Occurance: %s \n",subjectoccview[i]);
                        System.out.printf("Class Mode: %s \n",modesubjectview[i]);
                        System.out.println("Lecturer name : " + lecturernameview[i]);
                        System.out.printf("Time : %s , %s \n",subjectdayview[i],subjecttimeview[i]);
                    }
                }
                System.out.println("Enter 1 to add module, 2 to delete module, 3 to view module registered, 4 to exit");
                selection = sc.nextInt();
            }
            /*if(selection==4)
            {
                timetableobject.timetable(studentmatrix);
                
                System.out.println("Enter 1 to add module, 2 to delete module, 3 to view module registered, 4 to exit");
                selection = sc.nextInt();
            }*/
        }
        
    }
}
