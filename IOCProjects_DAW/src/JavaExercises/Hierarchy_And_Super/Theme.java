/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JavaExercises.Hierarchy_And_Super;

import java.util.Scanner;

/**
 *
 * @author i.c
 */
public class Theme {

    /**
     * @param Parent Class
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner ask = new Scanner(System.in);
        String country;
        int caducity;
        int number;
        double temperature;
        int embase, code;
        
        System.out.println("ingrese la caducidad del producto");
        caducity = ask.nextInt();
        
        System.out.println("ingrese el número del producto");
        number = ask.nextInt();
        
        System.out.println("ingrese la fecha de embasado");
        embase = ask.nextInt();
        
        System.out.println("ingrese el país");
        country = ask.next();
        Products prod = new Products(caducity, number);
        
        FreshProduct fresh = new FreshProduct(caducity, number, embase, country);
        
        System.out.println(prod.toString());
        
        System.out.println("Las caracteristicas del producto fresco son: "+fresh.toString());
    }
    
}
