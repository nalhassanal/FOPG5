package LabReport;
/**
 *
 * @author Hassanal
 */
import java.util.*;
public class LR2Question1 {
    public static double median (int [] arr){
        double median;
        int n = arr.length; // get the length of the array
        for (int i = 0; i < n-1; i++) // bubble sort
            for (int j = 0; j < n-i-1; j++) // to sort out the numbers entered
                if (arr[j] > arr[j+1]){
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        if ( n % 2 != 0){ // if size of array is not divisable by 2
            median = (double)arr[n/2];
            return median;
        }
        else{
            median = ((double) arr[(n+1)/2] + (double) arr[(n-1)/2]) /2;
            return median;
        }   
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int [] num;
        int n;
        double result;
        System.out.println("Please enter how many numbers?"); // size of array
        n = in.nextInt();
        num = new int[n]; //declare array object
        for ( int i = 0; i < n; i++){
            System.out.println("Enter the " +(i+1) +" number >> "); // get input for array
            num[i] = in.nextInt();
        }
        result = median(num); // pass array as argument
        System.out.println("The median of these "+n +" numbers is " +result);
    }
}
