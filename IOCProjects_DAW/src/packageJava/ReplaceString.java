package packageJava;

import java.util.Scanner;

/**
 *
 * @author isabe
 */
public class ReplaceString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // reemplaza cadena
        Scanner ask = new Scanner(System.in);
        System.out.println("Escribe palabra");
        String palabra = ask.nextLine();
        System.out.println("Escribe palabra a reemplazar");
        String palabr1 = ask.next();
        System.out.println("Indique el reemplazo");
        String aux = ask.next();
        String cadena = palabra.replaceAll(palabr1, aux);
        System.out.println(cadena);
        
    }
    
}
