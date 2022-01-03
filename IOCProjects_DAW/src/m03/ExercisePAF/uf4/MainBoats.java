/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03.ExercisePAF.uf4;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isabe
 */
public class MainBoats {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        Scanner ask = new Scanner(System.in);
        
        String name;
        float eslora;
        int cabines, veles;
        
        System.out.println("ingrese datos, nombre:");
        name = ask.next();
        
        System.out.println("ingrese datos, eslora:");
        eslora = ask.nextFloat();
        
        System.out.println("ingrese datos, cabines:");
        cabines = ask.nextInt();
        
        System.out.println("ingrese datos, veles:");
        veles = ask.nextInt();
        
        Sailboat boat = new Sailboat(name, eslora, cabines, veles);
        
        System.out.println(boat.toString());
        
        System.out.println(boat.matricular());
        
        try {
            Boat.comprovarMatricula(boat);
        } catch (ExceptionBoat ex) {
            Logger.getLogger(MainBoats.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
