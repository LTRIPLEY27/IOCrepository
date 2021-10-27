/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03.Ejercicios;

import java.util.Scanner;

/**
 *
 * @author hellz
 */
public class POO_Clases_Herencia {
      
     private String color;
        private double tamaño;
        private boolean  asientos;
        
        
        public POO_Clases_Herencia(String color, double tamaño, boolean asiento) {
            
            this.color = color;
            this.tamaño = tamaño;
            this.asientos = asiento;
            
        }
        
        public void setColor(String color) {
            this.color = color;
        }
        
        public String getCOlor() {
            return this.color;
        }
        
        public void setTamaño(double tamaño) {
            this.tamaño = tamaño;
        }
        
        public double getTamaño() {
            return this.tamaño;
        }
        
        public void setAsiento(boolean asiento) {
            this.asientos = asiento;
        }
        
        public boolean getAsiento() {
            return this.asientos;
        }
        
        @Override
        public String toString() {
            
            return "El coche dispone d elas siguientes caracteristicas: \n  Color: " + this.color + "\n Tamaño : " + this.tamaño + "\n Asientos: " + this.asientos;
        }
       
    public static void main(String[] args) {
        
    POO_Clases_Herencia coche = new POO_Clases_Herencia ("red", 23, true); // ES NECESARIO INICIALIZAR EL OBJETO Y LUEGO AGREGARLE LA PROPIEDAD
    Scanner Recibe = new Scanner(System.in);
    
    String color;
    double tamaño;
    boolean asientos;
    
    System.out.println("Color?");
    color = Recibe.nextLine();
    //coche.setColor(color);
       
       System.out.println("Tamaño?");
       tamaño = Recibe.nextDouble();
      // coche.setTamaño(tamaño);
       
       System.out.println("Asientos?");
       asientos = Recibe.nextBoolean();
       //coche.setAsiento(asientos);
 
       //System.out.println(color);

       coche = new POO_Clases_Herencia(color, tamaño, asientos);
       
       Furgoneta furgo = new Furgoneta(false, 3000);
       
       System.out.println(coche.toString());
    
    } 
    
    public class Coche {
        
       
    }
}
