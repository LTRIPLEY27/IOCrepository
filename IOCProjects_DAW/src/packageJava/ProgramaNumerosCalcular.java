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
public class ProgramaNumerosCalcular {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Programa que calcule resta,suma,multiplicacion,media mas grande y mas pequeño
        Scanner ask = new Scanner(System.in);
        System.out.println("indique num 1");
        int num1 = ask.nextInt();
        System.out.println("indique num 2");
        int num2 = ask.nextInt();
         System.out.println("Indique un número del 1 al 5 para indicar su opción \n 1. Suma \n 2. Resta \n 3. Multiplicación \n 4. Media \n 5. Más grande \n6. Más pequeño");
        int num = ask.nextInt();
        
        switch(num){
            case 1: System.out.println("La suma es igual a " + (num1 + num2));
                break;
            case 2: System.out.println("La resta es igual a " + (num1 - num2));
                break;
            case 3: System.out.println("La multiplicación es igual a " + (num1 * num2));
                break;
            case 4: System.out.println("La media es igual a " + ((num1 + num2) / 2));
                break;
            case 5: System.out.println("El mayor es igual a " + (((num1 > num2)) ? num1 : num2));
                break;
            case 6: System.out.println("El menor es igual a " + (((num1 < num2)) ? num1 : num2));
                break;
            default:
                System.out.println("Indique una opción válida");
                break;
    }
    }
    
}
