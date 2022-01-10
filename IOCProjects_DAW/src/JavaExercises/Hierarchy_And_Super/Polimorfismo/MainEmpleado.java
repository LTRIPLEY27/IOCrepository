/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JavaExercises.Hierarchy_And_Super.Polimorfismo;

import java.util.Arrays;
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
        
       // Estudiante estu = new Estudiante("Elena", 1989, 90210, "Filosofia");
        
        Persona [] employees = new Persona[3]; 
        
       // employees[0] = new Estudiante("Elena", 1989, 90210, "Filosofia");
        employees[0] = new Empleado("Arthur", 8700, 1994);
        employees[1] = new Empleado("Esther", 5400, 1997);
        employees[2] = new Jefatura("West", 24000, 1986);
       
      /*  for (int i = 0; i < employees.length; i++) {
            System.out.println("Nombre ?");
            name = ask.next();
            
            //System.out.println("Sueldo ?");
            //sueldo = ask.nextDouble();
            
            System.out.println("Año nacimiento ?");
            fecha = ask.nextInt();
            
            employees[i] = new Empleado(name, 8700, fecha);
            
            
        }*/
        
       // emple1.setSubeSueldo();
        //System.out.println(emple1.toString());
        
        //boss.setIncentive(1000);
        //System.out.println(boss.toString() +"\n Y sueldo con el incentivo es : " + boss.getSueldoBoss());
        
        //Jefatura boss = (Jefatura) employees[1]; // CASTING DE OBJETOS PARA USO DE MÉTODOS CON EL POLIMORFISMO
        
        //boss.setIncentive(5600);
        
        // USO DE LA CLASE "ARRAYS" Y DEL MÉTODO ESTÁTICO "SORT" PARA ORDENAR EL ARRAY "EMPLOYEES" COMO PARÁMETRO();
        Arrays.sort(employees);
        
        Empleado emple = new Jefatura("Esther", 1987, 2700);
        
        Jefatura boss = new Jefatura("Esther", 1987, 2700);
        
        Comparable emple1 = new Empleado("Ludwig", 1817, 89700); // INSTANCIA DE LA INTERFAZ A TRAVÉS DEL PRINCIPIO DE SUSTITUCION
       
        boss.Establece_bonus(55000);
        
        System.out.println("El jefe recibe : " + boss.Establece_bonus(500) + boss.getName());
        
        System.out.println(emple.Establece_bonus(200) + "Nombre " + emple.getName());
        
        if(emple instanceof Persona) { // COMPARA Y VERIFICA SI LA VARIABLE OBJETO ES DE UNA CLASE
            
            System.out.println("True is a Person instance");
        }
        
        if (emple1 instanceof Comparable){// COMPARA Y VERIFICA SI LA VARIABLE OBJETO ES DE UNA INTERFACE
            System.out.println("Weird, but is a instance of a Interfaz");
        }
        
        System.out.println(boss.Toma_decisiones("Aumento sueldo"));
        
        for(Persona employee : employees) {
        
            System.out.println(employee.toString());
        }
        
       // System.out.println(estu.toString());
    }
    
}
