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
public class NumeroMayorDiferencia20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // programa que evalúa si hay números con diferencia a 20
        Scanner ask = new Scanner(System.in);
        System.out.println("indique num1");
        int num1 = ask.nextInt();
        System.out.println("indique num2");
        int num2 = ask.nextInt();
        System.out.println("indique num3");
        int num3 = ask.nextInt();
        System.out.println((num1 - num2 == 20 ? "el primer número es mayor al segundo 20 " : "El primer número no es mayor al segundo 20 "));
        System.out.println((num2 - num3 == 20 ? "el segundo número es mayor al tercero 20 " : "El segundo número no es mayor al tercero 20 "));
    }
    
}
