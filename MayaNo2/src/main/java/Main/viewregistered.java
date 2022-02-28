package Main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Haziq
 */
public class viewregistered {
    public void registered(String studentmatrix)
    {
        System.out.println("This is your course");
        
        //declare array variable and normal variale for the usage of the method
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
        
        String[] modulecode = new String[100];
        String[] modulename = new String[100];
        String[] modulewithname = new String[100];
        String[] totalocc = new String [100];
        String[] credithour = new String [100];
        String[] modulemode = new String[100];
        String[] modulesplit;
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
        String[] read = new String[15];
        String[] readsplit;
        int[] credithournum = new int [read.length];
        int total_credit_hour = 0;
        //read student checklist file
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
        //calculate total credi hour base on data obtained from student checklist file
        total_credit_hour = 0;
        for(int i = 0 ; i< read.length;i++)
        {
            total_credit_hour = total_credit_hour + credithournum[i];

        }
        System.out.println("Total credit hours:" + total_credit_hour);
        //read student module file to get registered module information
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
        //read from Main course subject file
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
        //read from specialization module subject file
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
        //read from english module subject file
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
        //convert shortform to userfriendly String
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
        //search and set the module registered
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

        //print all module registered
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
        //sc.close();       
    }
}