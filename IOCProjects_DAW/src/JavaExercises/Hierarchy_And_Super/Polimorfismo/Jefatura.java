/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaExercises.Hierarchy_And_Super.Polimorfismo;

/**
 *
 * @author isabe
 */
public class Jefatura extends Empleado implements Jefes {

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

      @Override
    public String Toma_decisiones(String decision) {
       
        return "\n la DECISION HA SIDO :" + decision;
    }

    @Override
    public double Establece_bonus(double bonus) {
        
        double prima = 2000;
        
               // USO DE LA VARIABLE STATIC "bonus_base" 
        return Trabajadores.bonus_base + bonus + prima;
    }
    
}
