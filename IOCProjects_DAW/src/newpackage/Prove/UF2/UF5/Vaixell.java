/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.Prove.UF2.UF5;
/*TODO heu de comprovar si el vaixell passat per paràmetre està matriculat o no amb el
mètode escaient d'aquesta classe. En tots dos casos heu de llençar una excepció de tipus
ExcepcioVaixell amb el codi pertinent per després capturar l'excepció produïda pel vaixell
passat per paràmetre.
Quan captureu l'excepció, s'ha d'imprimir per pantalla el missatge corresponent al codi de
l'excepció definit en la classe ExcepcioVaixell.
*/
/**
 *
 * @author isabe
 */
public class Vaixell{
    private String matricula;
    private String nom;
    private float eslora; //llargada del vaixell
    private int cabines; //Total de cabines

public Vaixell(String matricula, String nom, float eslora, int cabines) {
    this.matricula=matricula;
    this.nom = nom;
    this.eslora = eslora;
    this.cabines = cabines;
}
    public String getNom() {
    return nom;

    }
    public void setNom(String nom) {
    this.nom = nom;
    }
    public float getEslora() {
    return eslora;
    }
    public void setEslora(float eslora) {
    this.eslora = eslora;
    }
    public int getCabines() {
    return cabines;
    }
    public void setCabines(int cabines) {
    this.cabines = cabines;
    }
    public String getMatricula() {
    return matricula;
    }
    public void setMatricula(String matricula) {
    this.matricula= matricula;
    }
    public String toString() {
    return "Nom=" + nom + "\nEslora=" + eslora + "\nCabines=" + cabines;
    }
    
    
    public void estaMatriculat(Vaixell vaixell) throws ExcepcioVaixell{ // CAPTA LA EXCEPCION DISPARANDAO UN TRHOW CON EL CÓDIGO DE LA MISMA
        
        try{
             if (vaixell.matricula == null){ //No està matriculat
                 throw new ExcepcioVaixell("0");
             } else {
                 throw new ExcepcioVaixell("1");
             }   
        } catch(ExcepcioVaixell e) {
             System.out.println("\n" + e.getMessage());
        }
       
    }}
