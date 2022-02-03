
package packageJava.RecapitulacionEjercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaExcursion {

    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        List <String> excursiones = new ArrayList <String>();
        
        // LLENADO DE LA LISTA MEDIANTE EL ARRAY
        for(int i = 0; i < 10; i++){
            System.out.println("Indique destino : ");
            String destiny = ask.next();
            excursiones.add(destiny);
        }
        System.out.println("Desea verificar la lista de destinos ?");
        String destiny = ask.next().toLowerCase();
        if(destiny.equals("si")){
            for(String excursion : excursiones){
                System.out.println("Quizas te podría interesar : ");
                System.out.println(excursion);
            }
        }else{
            System.out.println("Adiós");
        }
        
    }
    
}
