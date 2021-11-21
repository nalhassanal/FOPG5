/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.util.Scanner;

/**
 *
 * @author haika
 */
public class LabReport1Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        int a,b,c;
        
        System.out.println("Input first side of triangle: ");
        a = input.nextInt();
        System.out.println("Input second side of triangle: ");
        b = input.nextInt();
        System.out.println("Input third side of triangle: ");
        c = input.nextInt();
        
        //check for whether it is a triangle or not
        
        //not triangle
        if(a+b<=c || a+c<=b || b+c<=a){
            System.out.println("Triangle is invalid");
        }else{
        //check for equilateral triangle
            if(a==b && b==c){
                System.out.println("Equilateral triangle");
        //check for isoceles triangle
            }else if(a==b || b==c || c==a){
                System.out.println("Isoceles triangle");
        //check for scalene triangle
            }else if(a!=b || b!=c || c!=a){
                System.out.println("Scalene triangle");
            }
        }
    }
}
        
                  
   
    

