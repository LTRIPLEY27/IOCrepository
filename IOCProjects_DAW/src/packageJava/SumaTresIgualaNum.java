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
public class SumaTresIgualaNum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // VERIFICAR SI LA SUMA DE DOS NUMEROS ES IGUAL AL TERCERO
        Scanner ask = new Scanner(System.in);
        System.out.println("indique num1");
        int num1 = ask.nextInt();
        System.out.println("indique num2");
        int num2 = ask.nextInt();
        System.out.println("indique num3");
        int num3 = ask.nextInt();
        System.out.println((num1 + num2 == num3 ? "La suma es igual al número3 =  " + num3: "La suma no es igual al número3 =   " + num3));
    }
    
}
