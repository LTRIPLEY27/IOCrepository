/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03.Swing.inicioaSwing;

/**
 *
 * @author hellz
 */

import javax.swing.*;


public class CreatingFrames {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        myFrame frame = new myFrame(); // INSTANCIACION DE LA CLASE FRAME CON EL MARCO DE LA INTERFAZ
        
        frame.setVisible(true); // MÉTODO PARA HACER VISIBLE
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // método para cerrar la ventana 
        
        
    }
    
}

class myFrame extends JFrame { // HEREDA DE LA CLASE JFRAME
    
    public myFrame() { // CONSTRUCTOR DE LA CLASE
        
        //setSize(600, 600); // MÉTODO DE LA CLASE SWING PARA DIMENSIONAR EL FRAME
        
        //setLocation(500, 200); // MÉTODO DE LA CLASE SWING PARA UBICAR LA VENTANA DONDE DISPONGAMOS, PLANO CARTESIANO
        
        setBounds(500,200,600,600); // MÉTODO QUE SINTENTIZA A setSize y setLocation
        
        setTitle("Aplicacion 1, hola java interfaz");
    }
}