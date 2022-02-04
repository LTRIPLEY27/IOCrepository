
package packageJava.ExamenFinal;

import java.util.Scanner;

public class RecorrerString {

    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        
        System.out.println("indique la palabra a recorrer");
        String palabra = ask.next();
        
        for(int i = 0; i < palabra.length(); i++) {
            System.out.println("la letra es " + palabra.charAt(i) + " y es la vuelta " + (i + 1));
        }
        
    }
    
}
