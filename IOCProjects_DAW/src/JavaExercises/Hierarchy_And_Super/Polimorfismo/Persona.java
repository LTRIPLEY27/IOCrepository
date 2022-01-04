/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaExercises.Hierarchy_And_Super.Polimorfismo;

/**
 *
 * @author isabe
 */
public abstract class Persona {
    private String name;
    private int nacimiento;
    
    
    public Persona(String name, int fecha) {
         this.name = name;
         this.nacimiento = fecha;
    }
    
     public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setNacimiento(int fecha) {
        this.nacimiento = fecha;
    }
    
    public int getNacimiento() {
        return this.nacimiento;
    }
    

     public abstract String toString();
     
}
