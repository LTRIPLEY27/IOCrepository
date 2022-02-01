/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package packageJava;

import java.util.Scanner;

/**
 *
 * @author isabe
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        System.out.println("Indique su edad");
        int age = ask.nextInt();
        if(age < 18) {
            System.out.println("Hasta luego");
        } else {
            System.out.println("quieres alquilar un coche");
            String respuesta = ask.next();
            if(respuesta.equals("si")) {
                System.out.println("Puedes llamar al número 999999");
            } else {
                System.out.println("Hasta luego");
            }
        }
    }
    
}
