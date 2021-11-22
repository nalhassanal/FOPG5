package javaapplication1;
import java.util.Scanner;
/**
 *
 * @author Haziq
 */
public class Lab_1 {
    public static void main(String[] args) {

        String input;
        int argsIndex = 1, prevIndex = 0;//tentukan
        Scanner sc = new Scanner(System.in);

        int a = 0, b = 0, c = 0;

        Double z = 0.00;
        Double r1 = 0.00;
        Double r2 = 0.00;

        System.out.println("Enter quadratic equation");
        input = sc.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-') {

                if (argsIndex == 1) {

                    for (int y = 0; y < i; y++) {
                        if (input.charAt(y) == 'x') {
                            if (input.substring(0, y) != "") { //pecahkan string//untuk 1x2
                                a = Integer.parseInt(input.substring(0, y));
                            } else {
                                a = 1;
                            }
                        }
                    }

                    prevIndex = i;
                    argsIndex++;
                }

                if (argsIndex == 2 && prevIndex != i) {

                    for (int y = prevIndex; y < i; y++) {
                        if (input.charAt(y) == 'x') {
                            if (input.charAt(prevIndex) == '+') {
                                if (input.substring(prevIndex + 1, y) != "") {
                                    b = Integer.parseInt(input.substring(prevIndex + 1, y));
                                } else {
                                    b = 1;
                                }
                            } else if (input.charAt(prevIndex) == '-') {
                                if (input.substring(prevIndex, y) != "") {
                                    b = Integer.parseInt(input.substring(prevIndex, y));
                                } else {
                                    b = -1;
                                }
                            }
                        }
                    }

                    if (input.charAt(i) == '+') {
                        c = Integer.parseInt(input.substring(i + 1, input.length()));
                    } else if (input.charAt(prevIndex) == '-') {
                        c = Integer.parseInt(input.substring(i, input.length()));
                    }

                    argsIndex++;
                }
            }
        }

        sc.close();

        z = Math.pow(b, 2) - 4 * a * c;
        r1 = (-b + Math.sqrt(z)) / (2 * a);
        r2 = (-b - Math.sqrt(z)) / (2 * a);

        if (Double.isNaN(r1) && Double.isNaN(r2)) {
            System.out.println("This quadratic equation has 0 root(s).");
            System.out.println("No solution");
        } else if (Math.round(r1) == Math.round(r2)) {
            System.out.println("This quadratic equation has 1 root(s).");
            System.out.println("x = " + r1);
        } else if (Math.round(r1) != Math.round(r2)) {
            System.out.println("This quadratic equation has 2 root(s).");
            System.out.println("x = " + r1);
            System.out.println("x = " + r2);
        }

    }

}