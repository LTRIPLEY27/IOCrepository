/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JavaExercises.Hierarchy_And_Super.Polimorfismo;

import java.util.Scanner;

/**
 *
 * @author isabe
 */
public class MainEmpleado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       Scanner ask = new Scanner(System.in); 
       String name;
       int fecha;
       double sueldo;
        
        //Empleado emple1 = new Empleado("Darrin", 6700, 87);
        //Jefatura boss = new Jefatura("Steven Universe", 8900, 83);
        
        Estudiante estu = new Estudiante("Elena", 1989, 90210, "Filosofia");
        
        
        
        Empleado [] employees = new Empleado[2]; 
       
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Nombre ?");
            name = ask.next();
            
            System.out.println("Sueldo ?");
            sueldo = ask.nextDouble();
            
            System.out.println("Año nacimiento ?");
            fecha = ask.nextInt();
            
            employees[i] = new Empleado(name, sueldo, fecha);
            
            employees[i].setSubeSueldo();
        }
        
       // emple1.setSubeSueldo();
        //System.out.println(emple1.toString());
        
        //boss.setIncentive(1000);
        //System.out.println(boss.toString() +"\n Y sueldo con el incentivo es : " + boss.getSueldoBoss());
        
        //Jefatura boss = (Jefatura) employees[1]; // CASTING DE OBJETOS PARA USO DE MÉTODOS CON EL POLIMORFISMO
        
        //boss.setIncentive(5600);
        
        
        for(Empleado employee : employees) {
            System.out.println(employee.toString());
        }
        
        System.out.println(estu.toString());
    }
    
}
