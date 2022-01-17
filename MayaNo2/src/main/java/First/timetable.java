package First;

import java.util.*;
import java.io.*;

/**
 *
 * @author Haziq
 */

public class timetable {
    public void printtimetable(String studentmatrix)
    {
        //declare scanner
        Scanner sc = new Scanner (System.in);
        //create array for the subject for index 0 to 49(for 5 days and 10 hours of class for each days, so 5 x 10 = 50)
        String[] subject = new String[50];
        //read the student time table and transfer th data into the specified time array(the subject array)
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(studentmatrix+"timetable.txt"));
            String line;
                for(int i = 0; i< 49; i++)
                {
                    subject[i] = reader.readLine();
                }
            
            reader.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        

        //print the timmetable (by using the format index 0 - 9 is for Monday, 10 - 19 for Tuesday,20 - 29 for Wednesday,30 - 39 for Thursday and 40 - 49 for Friday)        
        System.out.println("My timetable");
        System.out.println("________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.print("Day/Time");
        //this is for the time (top of the time table)
        for(int i = 9 ; i <= 18 ; i++)
        {
            
            if(i<12)
                System.out.printf("%15s :00 a.m",i);
            else if(i==12)
                System.out.printf("%15s :00 p.m",i);
            else if(i>12)
                System.out.printf("%15s :00 p.m",(i-12));
        }
        System.out.println("\n");
        System.out.println("________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("\n");
        System.out.printf("%-22s","Monday");
        for(int i = 0 ; i<9;i++)
        {
            System.out.printf("%-23s",subject[i]);
        }
        System.out.println("\n");
        System.out.println("________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("\n");
        System.out.printf("%-22s","Tuesday");
        for(int i = 10 ; i<19;i++)
        {
            System.out.printf("%-23s",subject[i]);
        }
        System.out.println("\n");
        System.out.println("________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("\n");
        System.out.printf("%-22s","Wednesday");
        for(int i = 20 ; i<29;i++)
        {
            System.out.printf("%-23s",subject[i]);
        }
        System.out.println("\n");
        System.out.println("________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("\n");
        System.out.printf("%-22s","Thursday");
        for(int i = 30 ; i<39;i++)
        {
            System.out.printf("%-23s",subject[i]);
        }
        System.out.println("\n");
        System.out.println("________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("\n");
        System.out.printf("%-22s","Friday");
        for(int i = 40 ; i<49;i++)
        {
            System.out.printf("%-23s",subject[i]);
        }
        System.out.println("\n");
        System.out.println("________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("\n");
        

    }
}


