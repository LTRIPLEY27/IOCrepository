/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JavaExercises.Hierarchy_And_Super.Polimorfismo;

/**
 *
 * @author isabe
 */
public class MainEmpleado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       // String name;
        //int sueldo, fecha;
        
        Empleado emple1 = new Empleado("Darrin", 6700, 87);
        Jefatura boss = new Jefatura("Steven Universe", 8900, 83);
        
        emple1.setSubeSueldo();
        System.out.println(emple1.toString());
        
        boss.setIncentive(1000);
        System.out.println(boss.toString() +"\n Y sueldo con el incentivo es : " + boss.getSueldoBoss());
    }
    
}
