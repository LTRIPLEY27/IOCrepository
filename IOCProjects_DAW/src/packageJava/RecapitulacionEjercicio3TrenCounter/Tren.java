
package packageJava.RecapitulacionEjercicio3TrenCounter;

import java.util.Scanner;

public class Tren {
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        int cont = 0;
        System.out.println("Indique la cantidad de pasajeros que ha abordado el tren");
        int total = ask.nextInt();
        while(cont < 2){
            System.out.println("Indique la cantidad de pasajeros que ha abandonado  el tren en la estación");
            int numParada = ask.nextInt();
            if(numParada< total){
                total -= numParada;
                cont++;
            }else{
                System.out.println("La cantidad excede a los pasajeros del tren");
                break;
            }
        }
       System.out.println("La cantidad de pasajeros que quedan en el tren es igual a " + total);
    }
    
}
