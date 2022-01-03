/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaExercises.Hierarchy_And_Super.Polimorfismo;

/**
 *
 * @author isabe
 */
public class Empleado {
    
    private String name;
    private double sueldo;
    private int nacimiento;
    
    public Empleado(String name, double sueldo, int fecha) {
 
        this.name = name;
        this.sueldo = sueldo;
        this.nacimiento = fecha;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    public double getSueldo() {
        return this.sueldo;
    }
    
    public void setNacimiento(int fecha) {
        this.nacimiento = fecha;
    }
    
    public int getNacimiento() {
        return this.nacimiento;
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
        return "Los datos del empleado son: \n Nombre: " + this.name + "\n Sueldo:  " + this.sueldo + "\n Nacimiento : " + this.nacimiento + "\n El sueldo con aumento es igual a : " + subeSueldo();

    }
   
}
