/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PAF;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isabe
 */
public class MainPAF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Infantil parc = new Infantil("juan", "reus", false, 4100);
        
        parc.imprimirAtraccio();
        try {
            //parc.estaOberta();
            parc.teAccesMR();
            //parc.
            //System.out.println(imprimirAtraccio());
        } catch (ExcepcioAtraccio ex) {
            Logger.getLogger(MainPAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
