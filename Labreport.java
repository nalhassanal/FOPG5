package javaapplication1;
import java.util.Scanner;



public class Labreport{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        double a, b, c, z, r1, r2;
        
        System.out.println("Enter a value:");
        a = sc.nextInt();
        System.out.println("Enter b value:");
        b = sc.nextInt();
        System.out.println("Enter c value:");
        c = sc.nextInt();
        
        if((a>=-9 && a<=9 && a!=0)||(b>=-9 && b<=9 && b!=0)||(c>=-9 && c<=9 && c!=0))
        {
            z = (Math.pow(b,2)) - (4*a*c);
            
            if(z >= 0)
            {
                r1 = (-b +  Math.pow(z , 0.5))/(2*a);
                r2 = (-b -  Math.pow(z , 0.5))/(2*a);
                
                if(r1 == 0 && r2 !=0)
                {
                    System.out.println("This quadratic equation has 1 root(s). x=" + r2);
                }
                else if(r1 != 0 && r2 ==0)
                {
                    System.out.println("This quadratic equation has 1 root(s). x=" + r1);
                }
                 else if(r1 == r2)
                {
                    System.out.println("This quadratic equation has 1 root(s). x=" + r1);
                }
                else
                {
                    System.out.println("This quadratic equation has 2 root(s). x=" + r1 + ", x=" + r2);
                }
            }
            else
            {
                System.out.println("This quadratic equation has 0 root (s). No solution.");
            }
        
        }
        

}
}
