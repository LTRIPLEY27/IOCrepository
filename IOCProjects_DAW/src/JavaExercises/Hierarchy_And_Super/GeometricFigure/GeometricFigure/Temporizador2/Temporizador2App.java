/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JavaExercises.Hierarchy_And_Super.GeometricFigure.GeometricFigure.Temporizador2;

/**
 *
 * @author isabe
 */

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;



public class Temporizador2App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Reloj clock = new Reloj(3000, true);
        
        clock.onRoad();
        
        JOptionPane.showMessageDialog(null, "Press Start to Stop");
        
        System.exit(0);
    }
    
}

class Reloj {
    
    private int intervalo;
    private boolean sonido;
    
    public Reloj(int intervalo, boolean sound) {
        this.intervalo = intervalo;
        this.sonido = sound;
    }
    
    public void onRoad() { // MÉTODO QUE DISPARARA AL RELOJ
                                // INSTANCIA DE LA CLASE INTERNA
        ActionListener oyente = new DameHora();
        Timer clock = new Timer(intervalo, oyente); // EL TEMPORIZADOR RECIBE EL INTERVALO DECLARADO COMO ATRIBUTO DE LA CLASE
        
        clock.start();
        
    }
    
    // CLASE INTERNA QUE IMPLEMENTA LA INTERFAZ ActionListener
    private class DameHora implements ActionListener {
        
        public void actionPerformed(ActionEvent event){
            Date now = new Date();
            
            System.out.println("Time is now with 3 sg more" + now);
            
            if(sonido) { // LA CLASE INTERNA HACE USO DE LOS ATRIBUTOS PRIVADOS DE LA CLASE EXTERNA, NOS HACE AHORRAR SETTERS Y GETTERS
                
                Toolkit.getDefaultToolkit().beep();
            }
            
        }
    }
}