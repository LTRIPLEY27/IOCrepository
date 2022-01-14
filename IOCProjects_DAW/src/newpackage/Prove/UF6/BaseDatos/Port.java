/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.Prove.UF6.BaseDatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author isabe
 */
public class Port {

private Connection conn;

private String selVaixellsSQL = "SELECT nom FROM vaixells WHERE eslora>? and cabines=?";

private PreparedStatement selVaixellsSt;



// -- 1 -- PRIMER PASO, ESTABLECER CONEXION

public void estableixConnexio() throws SQLException {// -- 2 --  SE DEBE DE IMPREMENTAR LA EXCEPCION
    
/* TODO heu d'establir la connexió amb la base de dades i incialitzar
l'atribut selVaixellsSt creant un nou PreparedStatement amb la sentència
SQL de l'atribut selPortSQL, incorporant les sentències que hi falten
en aquest mètode.
*/

 ///    *** PREPARED STATEMENT ***
 
 


    String urlBaseDades = "jdbc:derby://localhost:1527/Port";
    String usuari = "root";
    String contrasenya = "root123";
        try {// -- 3 -- LANZAR UNA EXCEPCION PARA DISPARAR LA CONEXION Y CAPTURAR LOS ERRORES
            conn = DriverManager.getConnection(urlBaseDades, usuari,contrasenya); // -- 4 -- ESTABLECER LA CONEXIÓN CON LOS PARÁMETROS DE BASEDATOS, USUARIO Y CONTRASEÑA, EN ESE ORDEN  ¡¡¡¡¡
            
            // LUEGO DE LA CONEXION SE HA DE ESTABLECER LA SENTENCIA
            selVaixellsSt = conn.prepareStatement(selVaixellsSQL);
            
            
            
        } catch (SQLException e) { // -- 5 -- EL CATCH DEBE DE SER CON LA CLASE "SQLExcepcion"
        conn = null; // -- 6 -- EN CASO DE CAPTURA LA CONEXION ES NULL
        System.out.println(e.getMessage()); // -- 7 -- IMPRIMIR EL MENSAJE CAPTURADO.
        // throw e; *** VERIFICAR ESTO ***
         }
        }

public void tancaConnexio() throws SQLException { // *** VERIFICAR EL THROWS ***

        try {
        conn.close();
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        } finally {
        conn = null;
        }
        }





public void mostrarNoms(int valorA, int valorB) throws SQLException {
/* TODO heu de mostrar els noms dels vaixells amb una eslora major que el valorA
i el nombre de cabines igual al valorB passats per paràmetre, fent servir el
PreparedStatement, és a dir, heu d’executar el select i recórrer el resultat per
mostrar les dades segons els paràmetres introduïts.
*/
        
        try {
            if (conn == null) {
                estableixConnexio();
            }
            // EL PREPAREDSTATETMENT ES EL MISMO YA INICIALIZADO EN LA CLASE CONEXION
            
            selVaixellsSt.setInt(1, valorA); // MÉTODOS DEL PREPAREDSTATEMENT PARA SETTEAR LOS VALOS A INTRODUCIR
            selVaixellsSt.setInt(2, valorB);
            
            ResultSet vaix = selVaixellsSt.executeQuery(); // EJECUTA LA CONSULTA DEL QUERY CON LOS VALORES ACTUALIZADOS
            
            while(vaix.next()) {
                System.out.println(vaix.getString(1) + " " + vaix.getString(2)); // DEVUELVE LOS VALORES DEMANDADOS CON LOS PARÁMETROS DEFINIDOS
            }
            
            conn.close();        
        }
        catch (SQLException e) {
            throw e;
        }

    
}
}
