package LabReport;
/**
 *
 * @author Hassanal
 */
/*
Write a program to generate two cards randomly and display the bigger card between
them. The cards contain of two characteristic, color (Red, Blue, Green and Yellow)
and value (1-10). The rules to identify the bigger card as below:
a. The bigger the value, the bigger the card is, except 1 is bigger than 10.
b. If the card is the same value, the color will be used to get the bigger card.
Red > Blue > Green > Yellow
4>3>2>1
YOU ARE NOT ALLOWED TO USE ARRAY
*/
import java.util.*;
public class Question2 {

    public static void main(String[] args) {
        Random rand = new Random();
        int card1Color, card2Color ;
        int card1Number, card2Number;
        
        //for first characteristic (color)
        //String[] color = { "Red" , "Blue", "Green", "Yellow"};
        //card1Color = color[(int) (Math.random() * color.length)];
        card1Color = rand.nextInt(4)+1; // 4 is red 1 is yellow
        //System.out.println(card1Color);
        card2Color = rand.nextInt(4)+1; // 4 is red 1 is yellow
        //System.out.println(card2Color);
        
        //for second characteristics (number
        card1Number = rand.nextInt(10)+1;
        card1Number = 10;
       // System.out.println(card1Number);
        card2Number = rand.nextInt(10)+1;
        card2Number = 1;
       // System.out.println(card2Number);
       
        //print out card 1 characteristics
        switch (card1Color){
            case 1 : 
                System.out.println("Card 1 : Yellow " +card1Number);
                break;
            case 2 : 
                System.out.println("Card 1 : Green " +card1Number);
                break;
            case 3 : 
                System.out.println("Card 1 : Blue " +card1Number);
                break;
            case 4 : 
                System.out.println("Card 1 : Red " +card1Number);
                break; 
        }
        //print out card 2 characteristics
        switch (card2Color){
            case 1 : 
                System.out.println("Card 2 : Yellow " +card2Number);
                break;
            case 2 : 
                System.out.println("Card 2 : Green " +card2Number);
                break;
            case 3 : 
                System.out.println("Card 2 : Blue " +card2Number);
                break;
            case 4 : 
                System.out.println("Card 2 : Red " +card2Number);
                break; 
        }
        
        //testing which is bigger
        if (card1Number > card2Number){
            if ( card1Number == 10 && card2Number ==1){
                if (card1Color > card2Color){
                    System.out.println("Card 1 is bigger");
                }
            //System.out.println("Card 2 is bigger");
            }
            else{
                System.out.println("Card 2 is bigger");
            }
        }
        else{
            if(card2Color > card1Color){
                System.out.println("Card 2 is bigger");
            }
        }
    }
    
}
