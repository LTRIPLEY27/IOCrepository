/*
 *En ambos casos debe lanzar una excepción de tipo ExcepcioBarco
        con el código pertinente para después capturar la excepción producida por el barco pasado por parámetro.
        Al capturar la excepción, se debe imprimir por pantalla el mensaje correspondiente al código de la excepción
        definido en la clase ExcepcioBarco.
 */
package m03.ExercisePAF.uf4;

/**
 *
 * @author isabe
 */
public abstract class Boat implements Matriculate {
    
    protected String nom;
    protected float eslora;
    protected int cabines;
    
    protected Boat(String name, float eslo, int cabin) {
        this.nom = name;
        this.eslora = eslo;
        this.cabines = cabin;
    }
    
    protected void setNom(String name) {
        this.nom = name;
    }
    
    protected String getNom() {
        return this.nom;
    }
    
    protected void setEslora(float eslo) {
        this.eslora = eslo;
    }
    
    protected float getEslora() {
        return this.eslora;
    }
    
    protected void setCabines(int cabin) {
        this.cabines = cabin;
    }
    
    protected int getCabines() {
        return this.cabines;
    }
    
    public String matricular(){
        int matricula;
        
        System.out.println("introduzca la matrícula del barco");
        matricula = ask.nextInt();
        
        return "Matricula =" + matricula;
    }
    
    @Override
    public String toString() {
        return "Nom = " + getNom() + ", Eslora = " + getEslora() + ", Cabines = " + getCabines();
    }
    
}
