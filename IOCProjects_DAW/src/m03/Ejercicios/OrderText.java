/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03.Ejercicios;

import java.util.Scanner;

/**
 *
 * @author hellz
 * dado un texto, darle la vuelta e invertir el orden de sus caracteres sin usar metodos solo estructuras de control
 */
public class OrderText {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner ask = new Scanner(System.in);
        
        String texto;
        
        char aux;
        
        char [] auxi;
        
        
        System.out.println("ingrese texto");
        texto = ask.nextLine();
        
        auxi = new char[texto.length()];
       // System.out.print(auxi.length);
        System.out.print("");
        //System.out.print(texto);
       
        for(int i = texto.length()-1; i >= 0; i--) {
            aux = texto.charAt(i);
            //System.out.println(aux);
            
            auxi[i] = aux;
            System.out.print(auxi[i]);
            //System.out.println("no hace nada");
            
        }
        
        //for(int i = 0; i < auxi.length; i++) {
          //  System.out.print(i);
            //System.out.println("no hace nada");
    //}
    }
}
