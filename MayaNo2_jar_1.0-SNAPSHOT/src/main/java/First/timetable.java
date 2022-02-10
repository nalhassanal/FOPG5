package First;

import java.util.*;
import java.io.*;

/**
 *
 * @author Haziq
 */

public class timetable {
    public timetable(){
        
    }
    public void printtimetable(String studentmatrix)
    {
        Scanner sc = new Scanner (System.in);
        String[] subject = new String[49];
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
        
        

                
        System.out.println("My timetable");
        System.out.println("________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.print("Day/Time");
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
        
        System.out.println("Enter 1 to add module, 2 to delete module, 3 to view module registered, 4 to exit");
        int selection = sc.nextInt();
    }
}


