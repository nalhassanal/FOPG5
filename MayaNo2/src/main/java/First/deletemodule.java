package First;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author Haziq
 */

public class deletemodule {
    void deletemodule(String studentmatrix)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Delete your module");
                
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
                
                String[] Smodulecode = new String[100];
                String[] Smodulename = new String[100];
                String[] Smodulewithname = new String[100];
                String[] Stotalocc = new String [100];
                int [] Scredithour = new int [100];
                String[] Smodulemode = new String[100];
                String[] Smodulesplit;
                
                String[] engmodulecode = new String[100];
                String[] engmodulename = new String[100];
                String[] engmodulewithname = new String[100];
                String[] engtotalocc = new String [100];
                int[] engcredithour = new int [100];
                String[] engmodulemode = new String[100];
                String[] engband = new String[100];
                String[] engmodulesplit;
                
                String[] subjectassigned = new String[10];
                
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


                
                try {
                File testfile = new File("lecturertest.txt");
                if (!testfile.exists()) {
                    testfile.createNewFile();
                }
                PrintWriter writer = new PrintWriter(new FileOutputStream(testfile));

                for(int i = 0;i<lecturernameview.length;i++)
                {
                    if(userdelete.equals(moduleselectview[i]))
                    {
                        writer.println(lecturernameview[i]);
                    }
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Error");
            }
            
            String[] lecturernamesearch = new String[2];//actually, maximum lecturers teaching a subject was initially 2,but sometimes maybe tuto and lab has different lecture so we take a carefull step to prevent from error array length
            try 
            {
                File testfile = new File("lecturertest.txt");//yang ni aku guna file write sebab xleh nak buat double array sebab x sync dgn apa yg aku nak, aku just nak nama 2 lectrer tapi kalau buat guna 2 array dia jadi x tersusun
                if (!testfile.exists())
                {
                    testfile.createNewFile();
                }
                BufferedReader reader = new BufferedReader(new FileReader(testfile));
                String read;
                for (int m = 0; m < 3; m++) 
                {
                    read = reader.readLine();
                    if (read != null) 
                    {
                        lecturernamesearch[m] = read; 
                    }
                }
                

                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String lecturernamesame;
            int size = 200;// 200 because estimate students that 1 lecturer teach is 200
            String[] studentdetail = new String[size];
            String[] studentsplit;
            String[] studentmodule = new String[size];
            String[] studentmode = new String[size];
            String[] studentocc = new String[size];
            String[] studentmatrixno = new String[size];
            String[] studentname = new String[size];
            if(lecturernamesearch[0].equals(lecturernamesearch[1]))
            {
                lecturernamesame = lecturernamesearch[0];
                
                try
                {
                    File lecturerfile = new File(lecturernamesame+".txt");
                    BufferedReader reader = new BufferedReader(new FileReader(lecturerfile));
                    
                    for( int t = 0; t< size; t++)
                        {
                            studentdetail[t] = reader.readLine();
                            if(studentdetail[t] != null)
                            {
                                studentsplit = studentdetail[t].split(",");
                                studentmodule[t] = studentsplit[0];
                                studentmode[t] = studentsplit[1];
                                studentocc[t] = studentsplit[2];
                                studentmatrixno[t] = studentsplit[3];
                                studentname[t] = studentsplit[4];
                            }

                        }     
                        reader.close();
                }
                catch(IOException e)
                {
                    System.out.println("error");
                }
                try
                {
                        File oldFile = new File(lecturernamesame+".txt");
                        File deletefile = new File("temporarylecturer.txt");
                        if(!deletefile.exists())
                        {
                             deletefile.createNewFile();
                        }
                        PrintWriter writer = new PrintWriter(new FileOutputStream(deletefile,true));

                        for(int m = 0; m < size; m++)
                        {
                             if(studentname[m] != null)
                             {
                                 if(!((studentmatrix.equals(studentmatrixno[m]))&&(userdelete.equals(studentmodule[m]))))
                                 {
                                    writer.print(studentmodule[m]+",");
                                    writer.print(studentmode[m]+",");
                                    writer.print(studentocc[m]+",");
                                    writer.print(studentmatrixno[m]+",");
                                    writer.println(studentname[m]);
                                    System.out.println(studentname[m]);
                                 }
                             }
                             else
                             {
                                writer.close();
                             }

                        }

                        
                    
                        oldFile.delete();
                        File newFile = new File(lecturernamesame+".txt");
                        deletefile.renameTo(newFile);
                }
                
                catch(IOException e)
                {
                    System.out.println("error");
                }
                
            }
            else
            {
                for(int i = 0 ; i<2;i++)
                {
                    try
                    {
                        File lecturerfile = new File(lecturernamesearch[i]+".txt");
                        BufferedReader reader = new BufferedReader(new FileReader(lecturerfile));

                        for( int t = 0; t< size; t++)
                            {
                                studentdetail[t] = reader.readLine();
                                if(studentdetail[t] != null)
                                {
                                    studentsplit = studentdetail[t].split(",");
                                    studentmodule[t] = studentsplit[0];
                                    studentmode[t] = studentsplit[1];
                                    studentocc[t] = studentsplit[2];
                                    studentmatrixno[t] = studentsplit[3];
                                    studentname[t] = studentsplit[4];
                                }

                            }     
                            reader.close();
                    }
                    catch(IOException e)
                    {
                        System.out.println("error");
                    }
                    try
                    {
                            File oldFile = new File(lecturernamesearch[i]+".txt");
                            File deletefile = new File("temporarylecturer.txt");
                            if(!deletefile.exists())
                            {
                                 deletefile.createNewFile();
                            }
                            PrintWriter writer = new PrintWriter(new FileOutputStream(deletefile,true));

                            for(int m = 0; m < size; m++)
                            {
                                 if(studentname[m] != null)
                                 {
                                     if(!((studentmatrix.equals(studentmatrixno[m]))&&(userdelete.equals(studentmodule[m]))))
                                     {
                                        writer.print(studentmodule[m]+",");
                                        writer.print(studentmode[m]+",");
                                        writer.print(studentocc[m]+",");
                                        writer.print(studentmatrixno[m]+",");
                                        writer.println(studentname[m]);
                                        System.out.println(studentname[m]);
                                     }
                                 }
                                 else
                                 {
                                    writer.close();
                                 }

                            }



                            oldFile.delete();
                            File newFile = new File(lecturernamesearch[i]+".txt");
                            deletefile.renameTo(newFile);
                    }

                    catch(IOException e)
                    {
                        System.out.println("error");
                    }
                }
            }
            
                String[] studentassigned = new String[30];
                String[] moduleregistered = new String[30];
                String[] modulecredithourregistered = new String[30];
                String[] studentsplitter;
                
                try
                {
                    File studentchecklist = new File(studentmatrix+"checklist.txt");
                    BufferedReader reader = new BufferedReader(new FileReader(studentchecklist));
                    for( int t = 0; t< 30; t++)
                    {
                        studentassigned[t] = reader.readLine();
                        if(studentassigned[t] != null)
                        {
                            studentsplitter = studentassigned[t].split(",");
                            moduleregistered[t] = studentsplitter[0];
                            modulecredithourregistered[t] = studentsplitter[1];
                        }
                    }     
                    reader.close();
                }
                catch(IOException e)
                {
                    System.out.println("error");
                }
                
                try
                {
                    File oldFile = new File(studentmatrix+"checklist.txt");
                    File deletefile = new File("temporarychecklist.txt");
                    if(!deletefile.exists())
                    {
                         deletefile.createNewFile();
                    }
                    PrintWriter writer = new PrintWriter(new FileOutputStream(deletefile,true));

                    for(int m = 0; m < 30; m++)
                    {
                         if(moduleregistered[m] != null)
                         {
                             if(!userdelete.equals(moduleregistered[m]))
                             {
                                 writer.print(moduleregistered[m]+",");
                                 writer.println(modulecredithourregistered[m]);
                             }
                         }
                    }


                    writer.close();
                    oldFile.delete();
                    File newFile = new File(studentmatrix+"checklist.txt");
                    deletefile.renameTo(newFile);
                }
                catch(IOException e)
                {
                    System.out.println("error");
                }
                 
                
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
    }
}
