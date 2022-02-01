
package packageJava;

import java.util.Scanner;

/**
 *
 * @author isabel
 */
public class CalculaDenominador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner ask = new Scanner(System.in);
        System.out.println("indique numerador");
        int num1 = ask.nextInt();
        System.out.println("indique denominador");
        int num2 = ask.nextInt();
        System.out.println((num2 != 0 ? ("La división es igual a = " + num1 / num2) : "No se puede dividir por cero"));
    }
    
}
