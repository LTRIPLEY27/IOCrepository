/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PAF;

import java.util.List;

/**
 *
 * @author isabe
 */
/*public class ParcAtraccions {
    
    private String nom;
    private String adreca;
    
    /*TODO heu de crear un atribut anomenat parcAtraccions que sigui un List que 
    heu d'implementar mitjançant un ArrayList per guardar les atraccions del parc d'atraccions.
    */ 
   /* private List <Atraccio> parcAtraccions; // ATRIBUTO ARRAYLIST
    

    public ParcAtraccions(String nom, String adreca) {
        this.nom = nom;
        this.adreca = adreca;
    }
    
    
    // METODOS DE ACCESO NUVO ATRIBUTO
    
    public void setPort(List<Atraccio> parcAtraccions) {
        this.parcAtraccions = parcAtraccions;
    }
    
    // GETTER DE LA COLECCION
    public List<Atraccio> parcAtraccions() {
        return parcAtraccions;
    }


    public void afegirAtraccio(Atraccio atraccio){
        /*TODO
          Heu d'afegir al final de l'atribut creat l'atracció passada per paràmetre.*/
       /* parcAtraccions.add(atraccio);// metodo add
        
    }
    
    public void eliminarAtraccio(Atraccio atraccio){
        /*TODO
         Heu d'eliminar l'atracció passada per paràmetre si aquesta es troba en el
         parc d'atraccions.*/      
      /*  for( int i = 0; i < parcAtraccions.size(); i++) {
            if(atraccio.getNom().contains(parcAtraccions.get(i).getNom())) {//VERIFICA EL NOMBRE Y SI ESTA  LIST
                parcAtraccions.remove(atraccio);
            }
        }
        
    }
    
    public void modificarNomAtraccio(Atraccio atraccio, String nom){
        /*TODO
         Heu de modificar el nom de l'atracció passada com a primer paràmetre pel 
         nom passat com a segon paràmetre, si aquesta es troba en el parc d'atraccions.*/  
        
      /*  for( int i = 0; i < parcAtraccions.size(); i++) {
            if(atraccio.getNom().contains(parcAtraccions.get(i).getNom())) {
                atraccio.setNom(nom);
            }
            
        }
        
        
    }
}*/

public class ParcAtraccions {

    private Connection conn;

    /*TODO Heu d'assignar a l'atribut selAtraccionsSQL, la sentència SQL que retorni els
      noms de les atraccions del parc d'atraccions, d'una zona determinada amb accés per
      persones amb mobilitat reduïda, tenint en compte que el valor del camp corresponent a
      aquesta dada és 1 si existeix aquest accés.
    */
    private String selAtraccionsSQL = "SELECT nom FROM ParcAtraccions WHERE teAccesMR = 1";
    
    

    private PreparedStatement selAtraccionsSt;

    public void estableixConnexio() throws SQLException {
        /* TODO heu d'establir la connexió amb la base de dades i inicialitzar
           l'atribut selAtraccionsSt creant un nou PreparedStatement amb la sentència
           SQL de l'atribut selAtraccionsSQL, incorporant les sentències que hi falten 
           en aquest mètode.
         */

        String urlBaseDades = "jdbc:derby://localhost:1527/Port";
        String usuari = "root";
        String contrasenya = "root123";
        try {
            conn = DriverManager.getConnection(urlBaseDades, usuari,contrasenya); // -- 4 -- ESTABLECER LA CONEXIÓN CON LOS PARÁMETROS DE BASEDATOS, USUARIO Y CONTRASEÑA, EN ESE ORDEN  ¡¡¡¡¡
            selAtraccionsSt = conn.prepareStatement(selAtraccionsSQL);
        } catch (SQLException e) {
            conn = null;
            System.out.println(e.getMessage());
        }
    }
public void tancaConnexio() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            conn = null;
        }
    }

    public void mostrarNoms(String zona) throws SQLException {
        /* TODO heu de mostrar els noms de les atraccions amb accés per persones amb
         mobilitat reduïda fent servir el PreparedStatement, és a dir, heu d’executar 
         el select i recórrer el resultat per mostrar les dades segons els paràmetres introduïts.    
         */
        
        //LANZAMOS EXCEPCION PARA CAPTURAR CUALQUIER EVENTUALIDAD
        try {
            if (conn == null) {
                estableixConnexio();
            }
            // EL PREPAREDSTATETMENT ES EL MISMO YA INICIALIZADO EN LA CLASE CONEXION
  
            
            selAtraccionsSt.setInt(1, zona); // MÉTODOS DEL PREPAREDSTATEMENT PARA SETTEAR LOS VALORES A INTRODUCIR
      
            
            ResultSet parc = selAtraccionsSt.executeQuery();
            
            while(parc.next()) {// LA CONDICION DE SER ÚNICAMENTE 1 YA LA REALIZA EL STATEMENT CON LA CONSULTA
                    
                System.out.println(parc.getString(1)); // DEVUELVE LOS VALORES DEMANDADOS CON LOS PARÁMETROS DEFINIDOS
            }
            }
            conn.close();        
        }
        catch (SQLException e) {
            throw e;
        }
}}
    



        
        }
}