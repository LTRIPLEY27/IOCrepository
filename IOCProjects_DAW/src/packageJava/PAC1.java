
package packageJava;

import java.util.Scanner;

/**
 *
 * @author isabe
 */
public class PAC1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // PROGRAMA QUE DADA UNA EDAD CONCRETA DIGA SI ES MAYOR DE EDAD O NO
        Scanner ask = new Scanner(System.in);
        System.out.println("indique edad?");
        int age = ask.nextInt();
        System.out.println((age >= 18 ? " Es mayor de edad " : " Es menor de edad"));
    }
    
}
