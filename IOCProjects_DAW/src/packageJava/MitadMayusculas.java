package packageJava;

import java.util.Scanner;

/**
 *
 * @author isabel
 */
public class MitadMayusculas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // frase mitad palabra mayuscula y mitad minusculas
        Scanner ask = new Scanner(System.in);
        System.out.println("Escribe palabra");
        String palabra = ask.next();
        String mayusculas = (palabra.substring(palabra.length() / 2).toUpperCase());
        String minusculas = (palabra.substring(0, palabra.length() / 2));
        System.out.println(minusculas);
        System.out.println(mayusculas);
        
    }
    
}
