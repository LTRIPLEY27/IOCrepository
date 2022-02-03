/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package newpackage.Prove.UF2.UF5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isabe
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Vaixell barco = new Vaixell(null, "LOVERMAKER", 8, 9);
            
            barco.estaMatriculat();
            Vaixell.comprovarMatricula(barco);
        } catch (ExcepcioVaixell ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
