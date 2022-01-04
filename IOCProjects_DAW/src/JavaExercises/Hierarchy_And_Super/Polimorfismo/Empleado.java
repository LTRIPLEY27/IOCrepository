/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaExercises.Hierarchy_And_Super.Polimorfismo;

/**
 *
 * @author isabe
 */
public class Empleado extends Persona {
    
    private double sueldo;
    
    public Empleado(String name, double sueldo, int fecha) {
 
        super(name, fecha);
        this.sueldo = sueldo;
        
    }
    
    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    public double getSueldo() {
        return this.sueldo;
    }
    
    
    public double subeSueldo(){
        return this.sueldo;
    }
    
    public void setSubeSueldo() {
        double aux;
        aux = this.sueldo * 0.15;
        
        this.sueldo += aux;
    }
    
    @Override
    public String toString() {
        return "Los datos  son: \n Nombre: " + super.getName() + "\n Nacimiento : " + super.getNacimiento() + "\n Sueldo:  " + this.sueldo + "\n El sueldo con aumento es igual a : " + subeSueldo();

    }
   
}
