/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03.Swing.CenterFrame;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author hellz
 */
public class FrameCenter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        marcoCentrado marco = new marcoCentrado();
        
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}


class marcoCentrado extends JFrame{
    
    public marcoCentrado() {
        
        Toolkit miScreen = Toolkit.getDefaultToolkit(); // INDICA EL MEDIO DONDE SE EJECUTA EL FRAME
        
        Dimension pantalla = miScreen.getScreenSize(); // ACCEDE A LA DIMENSION DE LA PANTALLA, ES DE LA CLASE DIMENSION Y FUNCIONA CON LA CLASE TOOLKIT
        
        int AlturaPantalla = pantalla.height; // OBTENEMOS Y ALMACENAMOS EL ALTO DE LA PANTALLA EN LA VARIABLE
        
        int AnchoPantalla = pantalla.width; // ANCHO DE PANTALLA
        
        setSize(AnchoPantalla / 2, AlturaPantalla / 2);
        
        setLocation(AnchoPantalla / 4, AlturaPantalla / 4); // HACEMOS USO DE LOS MÉTODOS DE DIMENSION Y CONDICIONAMOS LA UBICACIÓN Y DIMENSIÓN DEL FRAME A CUALQUIER PANTALLA
        
        setTitle("segundo frame");
        
        Image miIcono = miScreen.getImage("///bowie.png");
        
        setIconImage(miIcono);
        
        setVisible(true);
    }
}