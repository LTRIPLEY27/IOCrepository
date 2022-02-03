package packageJava.Android;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AndroidApp {

    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        boolean act = false;
        Android cell;
        List <Android> cells = new ArrayList<Android>();
        System.out.println("Desea comprar teléfono? \nMarque 1. para sí  \n Marque 2 para no");
        int response = ask.nextInt();
        if(response == 1){
            do{
                System.out.println("Desea teléfono con teclado? (si) (no)");
                String respo = ask.next();
                if(respo.toLowerCase().equals("si")){
                    act = true;
                }
                System.out.println("Indique dimensión de la pantalla en pixeles (100 x 100) u otro");
                String screen = ask.next();
                System.out.println("Indique modeloo");
                String model = ask.next();
                 System.out.println("Indique año");
                int year = ask.nextInt();
                cell = new Android(act, screen, model, year);
                cells.add(cell);
                System.out.println("Desea comprar teléfono? \nMarque 1. para sí  \nMarque 2 para no");
                response = ask.nextInt();
            }while(response == 1);
        }else{
             System.out.println("Hasta Luego");
        }
        
        for(Android andri : cells){
            System.out.println(andri.toString());
        }
        
        if(30 > 30){
            System.out.println("true");
        }

    }
    
}
