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
public class EdadTobogan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // SI ES MENOR A 8 NO PASA TOBOGAN
        Scanner ask = new Scanner(System.in);
        System.out.println("indique edad");
        int age = ask.nextInt();
        
        System.out.println(((age > 8) ? "Pasa al tobogan" : "no pasa al tobogan"));
    }
    
}
