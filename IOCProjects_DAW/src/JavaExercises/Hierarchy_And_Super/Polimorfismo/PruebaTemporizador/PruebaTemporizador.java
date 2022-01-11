/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JavaExercises.Hierarchy_And_Super.Polimorfismo.PruebaTemporizador;

import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*; // PAQUETE INTERFACE LISTENER
import java.util.*;

import javax.swing.Timer;

/**
 *
 * @author isabe
 */
public class PruebaTemporizador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                        // CADA 4 SEGUNDOS SE INVOCA LA ACCION "LISTENER"
                        
        GivetheTime oyente = new GivetheTime(); // CLASE QUE IMPLEMENTA LA INTERFACE
        
        //ActionListener oyente = new GivetheTime();
                        
        Timer tempo = new Timer(4000, oyente); // CLASE TIMER, PRIMER PARÁMETRO: FRECUENCIA, SEGUNDO: OBJETO TIPO INTERFACE
        
        tempo.start();
        
        JOptionPane.showMessageDialog(null, "Press start to stop");
        
        System.exit(0); // INSTRUCCION PARA DETENER EL PROGRAMA
    }
    
}

// Clase que implementa la interface ActionListener
class GivetheTime implements ActionListener {
    
    public void actionPerformed(ActionEvent e){
        Date now = new Date();
        
        System.out.println("hora cada 4 seg : " + now);
        
        Toolkit.getDefaultToolkit().beep(); // CLASE ABSTRACTA QUE DA SONIFDO PROGRAMADO
    }
}