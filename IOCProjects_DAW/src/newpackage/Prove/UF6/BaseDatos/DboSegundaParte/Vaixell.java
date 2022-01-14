/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.Prove.UF6.BaseDatos.DboSegundaParte;

import java.sql.DriverManager;
import java.sql.SQLException;
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

    public String getMatricula() {
        return matricula;
        }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
        }
/*
        Els objectius són:
        Establir la connexió amb la base de dades (recordeu que a db4O és amb un openFile)
        Afegir 4 vaixells a la base de dades.
        Mostrar totes les dades dels vaixells amb 4 cabines.

        Per aconseguir els objectius demanats, completeu el codi de la classe Port segons les
        indicacions dels comentaris “TODO”.
        Podeu treballar al vostre IDE, i després copiar en l'espai de resposta el codi final. Si us cal, per
        solucionar la pregunta, podeu copiar el codi de l'enunciat en el vostre IDE, estalviareu temps.*/

public class PortDb {
        private ObjectContainer db;

        public void estableixConnexio() throws SQLException{
        /* TODO Heu d'establir la connexió amb la base de dades Port */
            String urlBaseDades = "jdbc:derby://localhost:1527/Port";
            String usuari = "root";
            String contrasenya = "root123";

        
            try {
                
                db = (ObjectContainer) DriverManager.getConnection(urlBaseDades, usuari,contrasenya); // SUSTITUIMOS LA CLASE CONNECTION POR EMBEDED
                
            } catch() {
                
            }
            
            
        }

        public void tancaConnexio() {
        db.close();
        }

        public void crear() {
        /* TODO Heu de'afegir els 4 vaixells de l'array a la base de dades Port */

        Vaixell[] vaixells = {
        new Vaixell(null,"Vaixell 1", 5, 1),

        new Vaixell(null,"Vaixell 2", 10, 2),
        new Vaixell(null,"Vaixell 3", 13.5F, 4),
        new Vaixell(null,"Vaixell 4", 21.5F, 4)
        };
        }

        public void mostrarDades() {
        /* TODO
        Heu de mostrar totes les dades dels vaixells amb 4 cabines.
        */
        }
        }
