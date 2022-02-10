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
    /*public addmodule()
    {

    }*/
    void addmodule(String studentmatrix){
        
        int studentsize = 100;
        String[] studentsplit;
        String[] studentinfo = new String[studentsize];
        String[] studentmatrixread = new String[studentsize];
        String[] studentemailread = new String[studentsize];
        String[] studentnameread = new String[studentsize];
        String[] studentpasswordread = new String[studentsize];;
        String[] studentprogrammeread = new String[studentsize];;
        String[] studentmuetread = new String[studentsize];;
        
        int j = 1;
        String studentname = null;
        String studentprogramme = null;
        String studentmuet = null;
        String specialcourse = null;
        
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
        for(int i = 0;i<studentsize;i++)
        {
            if(studentmatrix.equals(studentmatrixread[i]))
            {
                studentname = studentnameread[i];
                studentprogramme = studentprogrammeread[i];
                studentmuet = studentmuetread[i];
            }
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
        else if(studentprogramme.equals("Bachelor of Information Technology (Multimedia)"))
        {
            specialcourse = "WIG3007";
        }
        else if(studentprogramme.equals("Bachelor of Computer Science (Data Science)"))
        {
            specialcourse = "WIH3003";
        }
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
        String lecturerfile = null;
        int pick_occ;

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
                
                while(selecttype == 1)
                {    
                    System.out.println("Please enter the module you wanted to register (example: WIX2002):");
                    String userinputmodule = sc.next();

                    //read checklist file(for each student they have checklist txt to prevent them register same module)
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
                    userinputmodule = null;
                    break;
                }

                while(selecttype == 2)
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
                    userinputmodule = null;
                    break;
                }
                
                
                while(selecttype == 3)
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
                    userinputmodule = null;
                    break;
                }
                if(selecttype!=1&&selecttype!=2&&selecttype!=3)
                {
                    System.out.println("Wrong code!");
                }
    }
}
