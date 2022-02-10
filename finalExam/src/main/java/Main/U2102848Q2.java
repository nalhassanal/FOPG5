package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Hassanal
 */
public class U2102848Q2 {
    public static void main(String[] args) {
        String filename = "Diving.txt";
        String diverName;
        String diverCountry;
        double [] diverScore = new double[7];
        double diverDifficulty ;
        double finalScore = 0 , score;
        int count;
        count = 0;
        U2102848Diving [] obj;
        obj = new U2102848Diving[5];
        
        try{
            File file = new File(filename); 
            Scanner inputStream = new Scanner ( new FileInputStream (file));
            
            while (inputStream.hasNextLine()){
                String firstName = inputStream.next();
                String lastName = inputStream.nextLine();
                diverName = firstName + lastName;
                diverCountry = inputStream.nextLine();
                
                System.out.println("Diver : "+ diverName + " ( " + diverCountry + " )");
                // three attempts 
                for ( int attempt = 0 ; attempt < 3 ; attempt++){
                    
                    // prints out individual scores 
                    System.out.print("Judges Scores : ");
                    for(int i = 0; i < 7 ; i++){
                        diverScore [i] =  Double.parseDouble(inputStream.next());
                        System.out.print(diverScore[i] +" ");
                    }
                    System.out.println();
                    // prints out difficulty
                    System.out.print("Difficulty : ");
                    diverDifficulty = Double.parseDouble(inputStream.next());
                    System.out.print(diverDifficulty);
                    
                    obj [count] = new U2102848Diving (diverName,diverCountry, diverScore,diverDifficulty) ;
                    
                    System.out.println();
                    score = obj[count].calculateScore();
                    finalScore += score;
                    if ( attempt == 2){
                        System.out.printf("Final score : %.2f\n" , finalScore);
                        System.out.println();
                        obj[count].setFinalScore(finalScore);
                    }
                }      
                finalScore=0;
                count++;
            }
            inputStream.close();
        } catch ( IOException ex){
            System.out.println("IO error " + ex.getMessage());
        }
        winner(obj);
    }
    public static void winner(U2102848Diving[] a){
        int count = a.length; // 5
        double [] totalScore = new double[count];
        String [] name = new String[count];
        String [] country = new String[count];
        
        //initialize totalScore
        for (int i = 0; i< count ; i++){
            totalScore [i] = a[i].getFinalScore();
        }
        // initialize name
        for (int i = 0; i< count ; i++){
            name [i] = a[i].getName();
        }
        //initialize country
        for (int i = 0; i< count ; i++){
            country [i] = a[i].getCountry();
        }
        //comparing totalScore
        for ( int pass = 1 ; pass < a.length; pass++){
            for ( int i = 0 ; i < a.length - 1 ; i++){
                if ( totalScore[i] > totalScore[i+1]){
                   // Score
                    double temp = totalScore[i];
                    totalScore[i] = totalScore[i+1];
                    totalScore[i+1]= temp;
                    
                    // name
                    String tempname = name[i];
                    name[i] = name[i+1];
                    name[i+1] = tempname;
                    
                    // country
                    String tempCountry = country[i];
                    country[i] = country[i+1];
                    country[i+1] = tempCountry;
                }
            }
        }
        // display
        System.out.println("Gold : " + name[4] +" (" +country[4]+") " + " score : "+totalScore[4]);
        System.out.println("Silver : " + name[3] +" (" +country[3]+") "+ " score : "+totalScore[3]);
        System.out.println("Bronze : " + name[2] +" (" +country[2]+") "+ " score : "+totalScore[2]);
    }
}
