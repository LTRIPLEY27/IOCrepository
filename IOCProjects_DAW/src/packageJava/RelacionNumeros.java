package packageJava;

import java.util.Scanner;

/**
 *
 * @author isabe
 */
public class RelacionNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        System.out.println("indique num");
        int num1 = ask.nextInt();
        System.out.println("indique num");
        int num2 = ask.nextInt();
        System.out.println((num1 < num2 ? (num1 + " es menor a " + num2) : (num1 + " es mayor a " + num2)));
    }
    
}
