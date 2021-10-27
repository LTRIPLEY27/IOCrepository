/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m03.Ejercicios;

/**
 *
 * @author hellz
 */
public class Furgoneta extends POO_Clases_Herencia { // REFLEJO DE LA HERENCIA
    
    private boolean Asientos_Cuero;
    private int Sobrecarga;
    
    public Furgoneta( boolean cuero, int sobrecarga) {
        
        super(); // LLAMA AL CONSTRUCTOR DE LA CLASE PADRE
        
        this.Asientos_Cuero = cuero;
        this.Sobrecarga = sobrecarga;
    }
    
     public void setAsientosCuero(boolean cuero) {
            this.Asientos_Cuero = cuero;
        }
        
        public boolean getAsientosCuero() {
            return this.Asientos_Cuero;
        }
        
        public void setSobrecarga(int sobrecarga) {
            this.Sobrecarga = sobrecarga;
        }
        
        public int getSobrecarga() {
            return this.Sobrecarga;
        }
    
    @Override
        public String toString() {
            return "Los asientos son " + this.Asientos_Cuero + "y la sobrecarga es : " + this.Sobrecarga;
        }
}
