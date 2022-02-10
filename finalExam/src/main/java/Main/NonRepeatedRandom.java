package Main;

/**
 *
 * @author Hassanal
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class NonRepeatedRandom {
    final static int size = 10000;
    
    public static void main(String[] args) {
        
        
        Random Rand = new Random();
        
        char RandomChar = ( char ) (25 + 'A');
        char kecik = (char) (29 + 'A');
        System.out.println(RandomChar);
        System.out.println(kecik);
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter how many rows : ");
        row = input.nextInt();
          
        //randNON();
        int [] copy = Arrays.copyOf(numSet, row);
        
        int [] copy1 = numSet.clone();
        

        Arrays.sort(copy);
        System.out.println("\nSorted >> ");
        for ( int i = 0 ; i < row ; i++){
            System.out.print(copy[i] + "\t");
        }

        System.out.println("\nMinimum >> ");
        System.out.println(copy[0]);
        
        System.out.println("\nMaximum >> ");
        System.out.println(copy[row-1]);
        
        System.out.println("\nAverage >> ");
    }
    
    static int [] numSet = new int [size];   
    static int row;
    
    public static void randNON(){
        Random Rand = new Random();
        
        int randomValue , randomIndex;
        for (int i = 0 ; i < numSet.length ; i++){
            numSet [i] = i;
        }

        System.out.println("\nRandom numbers >>");
        for ( int i = 0 ; i < row ; i++){
            randomIndex  = Rand.nextInt(10000);
            
            randomValue = numSet[randomIndex];            
            numSet[randomIndex] = numSet[i];
            numSet[i] = randomValue;
            
            System.out.print(numSet[i] + "\t");
        }
    }
}
