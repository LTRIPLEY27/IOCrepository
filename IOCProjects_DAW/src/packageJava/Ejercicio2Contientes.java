
package packageJava;

import java.util.Scanner;

public class Ejercicio2Contientes {

    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        System.out.println("Indique un número del 1 al 5 para indicar un continente \n 1. Contiente américano \n 2. Continente europeo \n 3. Contiente africano \n 4. Contiente asiático \n 5. Continente Oceanía");
        int num = ask.nextInt();
        
        switch(num){
            case 1: System.out.println("La ciudad mas grande de América es : Ciudad de México,  tiene 23.5 millones de habitantes.");
                break;
            case 2: System.out.println("La ciudad mas grande de Europa es : Estambul, Turquía, con 14.7 millones de habitantes.");
                break;
            case 3: System.out.println("La ciudad mas grande de África es : El Cairo, Egipto, con 20.0 millones de habitantes.");
                break;
            case 4: System.out.println("La ciudad mas grande de Asia es : Tokio, Japón, con 37.4 millones de habitantes");
                break;
            case 5: System.out.println("La ciudad mas grande de Oceanía es : Sídney, Australia, con 4.7 millones de habitantes.");
                break;
            default:
                System.out.println("Indique una opción válida");
                break;
    }
    }
    
}
