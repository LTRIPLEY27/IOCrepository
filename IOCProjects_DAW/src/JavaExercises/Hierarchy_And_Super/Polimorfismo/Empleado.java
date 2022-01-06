/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaExercises.Hierarchy_And_Super.Polimorfismo;

/**
 *
 * @author isabe
 */                                                 // LA INTERFAZ "COMPARABLE" REFIERE A LA INTERFAZ PREDEFINIDA EN LA API DE JAVA
public class Empleado extends Persona implements Comparable {
    
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
                        //EL PARÁMETRO A RECIBIR POR EL MÉTODO DE LA INTERFAZ ES DE TIPO "OBJETO" PUES REFIERE AL ARRAY DE OBJETOS, SE PUEDE DEFINIR DE MÚLTIPLES MANERAS
    @Override // SE SOBREESCRIBE EL MÉTODO DE LA INTERFAZ DE LA API
    public int compareTo(Object objeto) {
        
        //VARIABLE OBJETO
        Empleado aux = (Empleado) objeto; // CASTING DEL OBJETO ENVIADO POR PARÁMETROS Y ALMACENADO EN UN OBJETO QUE GUARDARÁ LA COMPARATIVA
        
        //"PARAMETRO IMPLICITO" A COMPARAR DEL ARRAY DE OBJETOS  
        if(this.sueldo < aux.sueldo) {// COMPARATIVA DEL VALOR RECIBIDO Y ALMACENADO EN LA VARIABLE OBJETO
            return -1; // SI EL SUELDO ES MENOR AL ARGUMENTO ...
        }
        
        if(this.sueldo > aux.sueldo) {
            return 1;
        }
        
        return 0; // SI LAS CONDICIONES DE LAS IF ANTERIORES NO SE CUMPLEN, RETORNA EL 0 POR DESCARTES
    }
    
    @Override
    public String toString() {
        return "Los datos  son: \n Nombre: " + super.getName() + "\n Nacimiento : " + super.getNacimiento() + "\n Sueldo:  " + this.sueldo + "\n El sueldo con aumento es igual a : " + subeSueldo();

    }
   
}
