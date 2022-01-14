/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.Prove.UF6.BaseDatos.DboSegundaParte;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Predicate;

/**
 *
 * @author isabe
 */
public class PortDb {
        private ObjectContainer db;

        public void estableixConnexio(){
        /* TODO Heu d'establir la connexió amb la base de dades Port */
            String urlBaseDades = "jdbc:derby://localhost:1527/Port";
            String usuari = "root";
            String contrasenya = "root123";

        
            try {
                
                db = (ObjectContainer) DriverManager.getConnection(urlBaseDades, usuari,contrasenya); // SUSTITUIMOS LA CLASE CONNECTION POR EMBEDED
                
            } catch(SQLException e) {
                db = null;
                System.out.println(e.getMessage());
            }
            
            
        }

        public void tancaConnexio() {
            db.close();
        }

        public void crear() {
        /* TODO Heu de'afegir els 4 vaixells de l'array a la base de dades Port */
        estableixConnexio();

        Vaixell[] vaixells = {
            new Vaixell(null,"Vaixell 1", 5, 1),
            new Vaixell(null,"Vaixell 2", 10, 2),
            new Vaixell(null,"Vaixell 3", 13.5F, 4),
            new Vaixell(null,"Vaixell 4", 21.5F, 4)
        };
        
        for(Vaixell vaix : vaixells) {
            db.store(vaix);
            db.commit();
            System.out.println(vaix.getNom() + vaix.getMatricula() + vaix.getCabines() + vaix.getEslora());
        }
        
        tancaConnexio();
        
        }

        public void mostrarDades() {
        /* TODO
        Heu de mostrar totes les dades dels vaixells amb 4 cabines.
        */
        
        estableixConnexio();
            
            ObjectSet <Vaixell> vaixells = db.query(new Predicate <Vaixell> () {
                
            public boolean match(Vaixell vaixel) {
                return vaixel.getCabines() == 4; // RETORNA TODO OBJETO CON ESE ATRIBUTO
            }
        
        });
            
            while (vaixells.hasNext) { 
                Vaixell vaixell = vaixells.next();
                System.out.println("Nom: " + vaixell.getNom() + " Matricula: " + vaixell.getMatricula() + " Eslora : " + vaixell.getEslora() + " Cabines :" +  vaixell.getCabines());
                
            }
        
            tancaConexio();
        }
        
}
     

