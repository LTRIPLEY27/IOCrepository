/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package newpackage.Prove.UF1;

import newpackage.Prove.UF1.UF4.Veler;
import newpackage.Prove.UF1.UF4.Vaixell;
/**
 *
 * @author isabe
 */
public class UF4 {

    /**
     * @param args the command line arguments
     */
   
    
    public static void main(String[] args) {
        UF4 programm = new UF4();
        programm.start();
    }

    public void start() {
       
        
        //Veler velero = new Veler("LOVE", 4, 5, 9);
        
        Veler vele;
        vele = new Veler("LOVE", 8, 5, 9);
        
        System.out.println(vele.toString());
        System.out.println(vele.matricular());
    
    }
    
    /**/ 
        //UF4 Ejercicio 1
//Donada las següents classe:
public class Veler extends Vaixell {
    int veles; //Total de veles
    public Veler(String nom, float eslora, int cabines, int veles) {
    super(nom, eslora, cabines);
    this.veles = veles;
}
    public int getVeles() {
        return veles;
    }
    public void setVeles(int veles) {
        this.veles = veles;
    }
    @Override
    public String toString() {
        return super.toString()+ ", Veles=" + veles;
    }
}
/*On el retorn del mètode toString són els valors separats per comes de tots els atributs de
l'objecte de tipus veler que crida al mètode, heu d'implementar la superclasse abstracta Vaixell
de la que hereta la classe Veler.
Podeu treballar al vostre IDE, i després copiar en l'espai de resposta el codi final. Si us cal, per
solucionar la pregunta, podeu copiar el codi de l'enunciat en el vostre IDE, estalviareu temps.*/

public class Vaixell implements Matricula {
    //nom, eslora, cabines
    private String nom;
    private float eslora;
    private int cabines;
    
    public Vaixell(String nom, float eslora, int cabines) {
        this.nom = nom;
        this.eslora = eslora;
        this.cabines = cabines;
    }
    
     public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public float getEslora() {
        return this.eslora;
    }
    public void setEslora(float eslora) {
        this.eslora = eslora;
    }
    public int getCabines() {
        return this.cabines;
    }
    public void setEslora(int cabines) {
        this.cabines = cabines;
    }
    
    @Override
    public String toString() {
        return "Nom = " + nom + ", Eslora = " + eslora + ", Cabines =" + cabines;
    }

        @Override
        public String matricular() {
            String matricula;
            
            System.out.println("Ingrese matricula ");
            matricula = ASK.next();
            
            return matricula;
        }
    }
  }

    

