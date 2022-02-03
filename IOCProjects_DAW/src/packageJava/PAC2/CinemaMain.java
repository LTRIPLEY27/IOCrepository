
package packageJava.PAC2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import packageJava.Android.Android;
/*
@autor = Isabel Calzadilla
*/

public class CinemaMain {

    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        Cinema cine;
        List <Cinema> movies = new ArrayList<Cinema>();
        System.out.println("Desea comprar entradas para el cine? \nMarque 1. para sí  \nMarque 2 para no");
        int response = ask.nextInt();
        if(response == 1){
            do{
                System.out.println("Indique nombre de película");
                String movie = ask.next();
                System.out.println("Indique costo de entrada");
                double paycheck = ask.nextDouble();
                System.out.println("Indique hora en el siguiente formato (dia/hora/min)");
                String time = ask.next();
                System.out.println("Indique cantidad de entradas?");
                int quantity = ask.nextInt();
                cine = new Cinema(movie, paycheck, time, quantity);
                movies.add(cine);// SE PUEDEN CREAR TANTOS OBJETOS COMO DESEEMOS PUES SE ALMACENARÁ EN UN ARRAYLIST DE OBJETOS
                System.out.println("Desea comprar entradas para el cine? \nMarque 1. para sí  \nMarque 2 para no");
                response = ask.nextInt();
            }while(response == 1);
        }else{
             System.out.println("Hasta Luego");
        }
        
        Cinema cine1 = new Cinema("E.T", 5.5, "28/02/2022", 6);// CREACIÓN DE OBJETO MANUAL
        
        for(Cinema movie : movies){//IMPRESION DEL ARRAYLIST DE OBJETOS
            System.out.println(movie.toString());   
        }
        
        System.out.println("Total  " + cine1.getTotalCost());
        System.out.println(cine1.toString());
        
        movies.add(cine1);
        
        for(Cinema movie : movies){//IMPRESION DEL ARRAYLIST DE OBJETOS CON EL OBJETO EXTERNO ADHERIDO
            System.out.println(movie.toString());   
        }
    }
    
}
