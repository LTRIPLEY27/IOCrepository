/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaExercises.Hierarchy_And_Super.Polimorfismo;

/**
 *
 * @author isabe
 */
public class Jefatura extends Empleado {

    private double sueldo;
    private double incentivo;
    
    public Jefatura(String name, double sueldo, int fecha) {
        super(name,sueldo, fecha);
    }
    
    public void setIncentive(double ince){
        this.incentivo = ince;
    }
    
   // ÈL MÈTODO GETSUELDO SE ESTÀ SOBREESCRIBIENDO DE LA CLASE PADRE.
    public double getSueldoBoss() {
        double sueldoBoss = super.getSueldo(); // SE ALMACENA EL MÈTODO DE LA SUPER CLASE (SUELDO DE "EMPLEADO")
        return this.incentivo + sueldoBoss; // RETORNA EL TOTAL DEL INCENTIVO + EL SUELDO DE LA SUPERCLASE
        
    }
    
    @Override
    public String toString() {
        return super.toString() + this.getSueldoBoss();
    }
    
}
