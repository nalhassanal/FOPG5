package Main;

/**
 *
 * @author Hassanal
 */

import java.util.Random;
public class U2102848Q1 {
    public static void main(String[] args) {
        /*
        Generate 3 random price values (100.00-300.00) and display the price values in two
decimal places.
        */
        q1();
        
        /*
        Generate 5 random even-numbered years (1990-2030) and display the years
        */
        q2();
        
        /*
        Generate 1 random car plate number and display 
        the car plate number. The car plate
        number begin with 5 digits and end with
        two uppercase letters.
        */
        q3();
        
        /*
        Generate 1 random word and display the word.
        The word consists of maximum 8
    characters and each character must be from a-z or A-Z.
        */
        q4();
    }
    
    public static void q1 (){
        Random rand = new Random();
        System.out.print("3 random price values : ");
        for ( int i = 0 ; i < 3 ; i++){
            float num1 = rand.nextFloat() + 100;
            float num2 = rand.nextFloat() + 300;
            System.out.printf("%.2f " , num2 - num1);
        }
        System.out.println("");
    }
    
    public static void q2(){
        Random rand = new Random();
        System.out.print("5 Random even-numbered years :");
        int [] randYear = new int [5];
      
        for ( int i = 0; i < 5 ; i++){
            randYear[i] = 1990 + rand.nextInt(40);
            while ( randYear [i] % 2 != 0){
                randYear[i] = 1990 + rand.nextInt(40);
            }
            System.out.print(randYear[i] + " ");
        }
        System.out.println("");
    }
    
    public static void q3(){
        Random rand = new Random();
        String plate = "";
        int [] num = new int [5];
        char ranLetter;
        
        //to make 5 digit initial
        for ( int i = 0 ; i < 5; i++){
            if ( i == 0){
                num[i] = rand.nextInt(10);    
                while ( num[i] == 0)
                    num[i] = rand.nextInt(10);
            }
            else 
                 num[i] = rand.nextInt(10);
            
            plate += Integer.toString(num[i]);
        }
        
        //to make the last two uppercase letter
        for (int i = 0 ; i < 2 ;i++){
            ranLetter = ( char ) (rand.nextInt(25) + 'A');
            plate += ranLetter;
        }
        System.out.print("Car Plate Number : ");
        System.out.print(plate);
        System.out.println("");
    }
    
    public static void q4(){
        Random rand = new Random();
        String word = "";
        char randLetter;
        for ( int i = 0 ; i < 8;i++){
            randLetter = (char) (rand.nextInt(57) + 'A');
            while ( randLetter == '[' || randLetter == ']' ||
                    randLetter == '`' ||randLetter == '\\' ||
                    randLetter == '_' || randLetter == '^'){
                randLetter = (char) (rand.nextInt(57) + 'A');
            }
            
            word += randLetter;
        }
        System.out.print("Random Word : ");
        System.out.print(word);
        System.out.println("");
    }
}
