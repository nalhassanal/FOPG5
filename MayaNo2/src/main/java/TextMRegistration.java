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
        String main_course = null;
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
        int total_credit_hour = 3;
        
        Scanner sc = new Scanner(System.in);
        
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("student.txt"));

                    studentinfo = reader.readLine();
                    studentsplit = studentinfo.split(",");
                    studentmatrix = studentsplit[0];
                    studentemail = studentsplit[1];
                    studentname = studentsplit[2];
                    studentpassword = studentsplit[3];
                    studentprogramme = studentsplit[4];
                    studentmuet = studentsplit[5];  
                    
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
        for(int i =0;i<100;i++)
        {
            if(credithour[i] !=null || totalocc[i]!=null)
            {
                numtotalocc[i] = Integer.parseInt(totalocc[i]);
                numcredithour[i] = Integer.parseInt(credithour[i]);
            }
        }
        
        if(studentprogramme.equals("Bachelor of Computer Science (Computer System and Network)"))
        {
            main_course = "WIC3002";
        }
        else if(studentprogramme.equals("Bachelor of Computer Science (Artificial Intelligence)"))
        {
            main_course = "WID3007";
        }
        else if(studentprogramme.equals("Bachelor of Computer Science (Information Systems)"))
        {
            main_course = "WIE3007";
        }
        else if(studentprogramme.equals("Bachelor of Computer Science (Software Engineering)"))
        {
            main_course = "WIF3005";
        }
        else if(studentprogramme.equals("Bachelor of Information Technology Multimedia)"))
        {
            main_course = "WIG3007";
        }
        else if(studentprogramme.equals("Bachelor of Computer Science (Data Science)"))
        {
            main_course = "WIH3003";
        }
        
        course_registered[0] = main_course;
        System.out.println("Main Course:" + main_course);
        
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
        
        System.out.println("Enter 1 to add module, 2 to delete module, 3 to view module registered, 4 to exit");
        int selection = sc.nextInt();
        while(selection == 1 || selection == 2 || selection == 3)
        {
            while(selection == 1)
            {
                for(int i = 0; i< modulecode.length;i++)
                {
                    if(modulewithname[i] != null)
                    System.out.println(modulecode[i] + " | " + modulename[i]);
                }

                System.out.println("Please enter the module you wanted to register:");
                String userinputmodule = sc.next();
                
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
                        subjectassigned[t] = reader.readLine();

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
                
                
                
                for(int i =0; i < modulecode.length; i++)
                {
                    if(userinputmodule == null)
                    break;
                    
                    else if(userinputmodule.equals(modulecode[i]))//FROM HERE
                    {
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
                            try
                            {
                                File studentfile = new File(studentmatrix+"checklist.txt");
                                if(!studentfile.exists())
                                {
                                    studentfile.createNewFile();
                                }
                                PrintWriter writer = new PrintWriter(new FileOutputStream(studentfile,true));
                                writer.println(moduleselect);
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
                        }//TO HERE (I MOVE IT INSIDE IF)
                    }
                    /*else
                    {
                        break;//HOW TO ADD ERROR MESSAGR ONLY ONCE?
                    }*/
                }
                
                        
                        
                        /*total_credit_hour = total_credit_hour + numcredithour[i];
                        if(total_credit_hour<22)
                            course_registered[j] = modulecode[i];
                        else
                            System.out.println("You have exceed your maximum credit hours");

                    }

                System.out.println("Total credit hour :" +  total_credit_hour );
                for(int i =0 ; i<course_registered.length;i++)
                {
                    if(course_registered[i] != null)
                    System.out.println(course_registered[i]);
                }
                j++;
            /*try
            {
                String filename = "StuedntModule.txt";
                PrintWriter writer = new PrintWriter(new FileOutputStream(filename));
                    writer.println(addmodule);
                writer.close();1
            }
            catch(IOException e)
            {
                System.out.println("Error");
            }*/


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
                    }
                }
                
                for(int i = 0;i < moduleselectview.length;i++)
                {
                    if(moduleselectview[i] != null)
                    {
                        for(int k = 0; k < modulecode.length; k++ )
                            if(moduleselectview[i].equals(modulecode[k]))
                            {
                                modulenameview[i]= modulename[k];
                            }
                    }
                }
               
                for(int i = 0;i < 30; i++)
                {
                    if(moduleselectview[i]!=null)
                    {
                        System.out.printf("\nModule : %s - %S \n",moduleselectview[i], modulenameview[i]);
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
                                writer.print(subjectmode[i]+",");
                                writer.print(subjectocc[i]+",");
                                writer.print(lecturername[i]+",");
                                writer.print(subjectday[i]+",");
                                writer.println(subjecttime[i]);
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
                    }
                }
                
                for(int i = 0;i < moduleselectview.length;i++)
                {
                    if(moduleselectview[i] != null)
                    {
                        for(int k = 0; k < modulecode.length; k++ )
                            if(moduleselectview[i].equals(modulecode[k]))
                            {
                                modulenameview[i]= modulename[k];
                            }
                    }
                }
               
                for(int i = 0;i < 30; i++)
                {
                    if(moduleselectview[i]!=null)
                    {
                        System.out.printf("\nModule : %s - %S \n",moduleselectview[i], modulenameview[i]);
                        System.out.printf("Class Mode: %s \n",modesubjectview[i]);
                        System.out.println("Lecturer name : " + lecturernameview[i]);
                        System.out.printf("Time : %s , %s \n",subjectdayview[i],subjecttimeview[i]);
                    }
                }
                System.out.println("Enter 1 to add module, 2 to delete module, 3 to view module registered, 4 to exit");
                selection = sc.nextInt();
            }
        }
        
    }
}
