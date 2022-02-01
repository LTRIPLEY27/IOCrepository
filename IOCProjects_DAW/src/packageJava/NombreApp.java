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
public class NombreApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        String movies [] = new String [4];
        String respuesta;
        
        for(int i = 0; i < movies.length; i++) {
            System.out.println("indique 1 pelicula: " + i);
            movies[i] = ask.next();
        }
        
        System.out.println("Las opciones indicadas son: ");
        for(String res : movies) {
            System.out.print(res + " - ");
        }
        
        System.out.println("\nLa posicion 1 del array es " + movies[1]);
    }
    
}
