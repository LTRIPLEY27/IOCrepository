/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaExercises.Hierarchy_And_Super.Polimorfismo;

/**
 *
 * @author isabe
 */
public class Estudiante extends Persona {
    
    private int matricula;
    private String carrera;
    
    public Estudiante(String name, int fecha, int matricula, String carrera){
        super(name, fecha);
        this.matricula = matricula;
        this.carrera = carrera;
    }

    
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    public String getCarrera() {
        return this.carrera;
    }
    
    public int getMatricula() {
        return this.matricula;
    }
    
    @Override
    public String toString() {
        return "Nombre : " + super.getName() + "\n Nacimiento: " + super.getNacimiento() + " \n Matricula: " + this.matricula + "\n Carrera: " + this.carrera;
    }
}
