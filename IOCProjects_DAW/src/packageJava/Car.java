
package packageJava;

import java.util.Scanner;
import packageJava.Vehicles;

public class Car{
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        System.out.println("Indique Marca ?");
        String mark = ask.next();
        System.out.println("Indique Modelo ?");
        String model= ask.next();
        System.out.println("Indique Ruedas ?");
        int wheels = ask.nextInt();
        System.out.println("Indique Color ?");
        String color = ask.next();
        System.out.println("Indique si tiene mejoras (true) o no (false)?");
        boolean isOk = ask.nextBoolean();
  
        Vehicles car = new Vehicles(color, wheels, mark, model, isOk);
        System.out.println(car.toString());
    }  
}


