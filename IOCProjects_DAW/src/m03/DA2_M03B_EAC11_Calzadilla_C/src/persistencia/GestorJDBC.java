package persistencia;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Taller;
import principal.GestorTallerMecanicException;

import principal.Component; // ES IMPERATIVO IMPORTAR COMPONENT PARA PODER EDITAR LOS RECAMBIOS EN RELACION CON EL TALLER
import model.Recanvi; // DE IGUAL MANERA TAMBIEN SE DEBE DE IMPORTAR EL MODELO DE RECANVI PARA PODER EDITAR LA TABLA

/**
 *
 * @author fta
 */
public class GestorJDBC implements ProveedorPersistencia {

    private Taller taller;

    private Connection conn; //Connexió a la base de dades

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }

    /*
     PreparedStatement necessaris
     */

 /*
     * TODO
     *
     * Obtenir un taller
     * 
     * Sentència select de la taula tallers
     * Columnes: totes
     * Files: la del taller el CIF del qual coincideixi amb el passat per paràmetre
     *
     */
    private static String codiTallerSQL = ""
            + "SELECT * "
            + "FROM taller c " // verificar método
            + "WHERE c.cif = ?";

    private PreparedStatement codiTallerSt;

    /*
     * TODO
     *
     * Afegir un taller
     * 
     * Sentència per afegir un taller en la taula tallers
     * Els valors dels camps són els que es passaran per paràmetre
     *
     */
    private static String insereixTallerSQL = ""
            + "INSERT INTO taller(cif, nom, adresa) "
            + "VALUES (?, ?, ?)";      

    private PreparedStatement insereixTallerSt;

    /*
     * TODO
     *
     * Actualitzar un taller
     * 
     * Sentència per actualitzar un taller de la taula tallers
     * Files a actualitzar: la que corresponguin al CIF passat per paràmetre
     * Columnes a actualitzar: nom i adreca amb els altres valors passats per paràmetre
     *
     */
    private static String actualitzaTallerSQL = ""
            + "UPDATE taller "
            + " SET nom = ?, adresa = ? "
            + " WHERE cif = ?";

    private PreparedStatement actualitzaTallerSt;  // EL STATEMENT ES CON EL QUE SE HARÁ EL LLAMADO LUEGO LA CONEXXION EN EL PREPARE

    /*
     * TODO
     *
     * Eliminar recanvis (donat el codi d'un taller)
     * 
     * Sentència que elimina els recanvis de la taula recanvis relacionats amb un taller
     * Files a eliminar: les que es corresponguin al CIF del taller passat per paràmetre
     *
     */
    private static String eliminaRecanviSQL = ""
            + " DELETE FROM recanvis"
            + " WHERE codi = ?";

    private PreparedStatement eliminaRecanviSt;

    /*
     * TODO
     *
     * Afegir un recanvi
     * 
     * Sentència que afegix un recanvi a la taula de recanvis
     * Els valors dels camps són els que es passaran per paràmetre
     *
     */
    private static String insereixRecanviSQL = ""
            + " INSERT INTO recanvis(codi, nom, fabricant, preu, taller)"
            + "VALUES (?, ?, ?, ?, ?)"; // PARÁMETROS EQUIVALENTES A LOS ATRIBUTOS DE LA CLASE RECANVIS

    private PreparedStatement insereixRecanviSt;

    /*
     * TODO
     *
     * Seleccionar els recanvis d'un taller
     * 
     * Sentència que selecciona els recanvis de la taula recanvis d'un taller determinat
     * Columnes: totes
     * Files: totes les que el CIF del taller coincideixi amb el passat per paràmetre
     *
     */
    private static String selRecanvisSQL = ""
            + "SELECT *"
            + "FROM recanvis"
            + "WHERE recanvis = ?";

    private PreparedStatement selRecanvisSt;

    /*
     *TODO
     * 
     *Paràmetres: cap
     *
     *Acció:
     *  - Heu d'establir la connexio JDBC amb la base de dades EAC112122S1
     *  - Heu de crear els objectes PrepareStatement declarats com a atributs d'aquesta classe
     *    amb els respectius SQL declarats com a atributs just sobre cadascun d'ells.
     *  - Heu de fer el catch de les possibles excepcions (en aquest mètode no llançarem GestorTallerMecanicException,
     *    simplement, mostreu el missatge a consola de l'excepció capturada)
     *
     *Retorn: cap
     *
     */
    public void estableixConnexio() throws SQLException {
        String urlBaseDades = "jdbc:derby://localhost:1527/EAC112122S1";
        String usuari = "root";
        String contrasenya = "root123";
        
        try {
            
            conn = DriverManager.getConnection(urlBaseDades, usuari, contrasenya); // EL DRIVEMANAGER RECIBE LOS 3 PARÁMETROS DEFINIDOS: BASE DE DATOS, USUARIO Y CONTRASEÑA
            
            // LLAMADO A TODOS LOS MÉTODOS PREVIAMENTE DEFINIDOS PARA CAMBIO, SELECCION, ACTUALIZACION DE TALLERES Y RECAMBIOS
            codiTallerSt = conn.prepareStatement(codiTallerSQL);
            
            insereixTallerSt = conn.prepareStatement(insereixTallerSQL);  // REFERENCIA AL MÉTODO PREVIO DE "INSEREIX" CON PARAMETRO EL STRING SQL DEL MISMOs
            
            actualitzaTallerSt = conn.prepareStatement(actualitzaTallerSQL);
            
            eliminaRecanviSt = conn.prepareStatement(eliminaRecanviSQL);
            
            insereixRecanviSt = conn.prepareStatement(insereixRecanviSQL);
            selRecanvisSt = conn.prepareStatement(selRecanvisSQL);
            
            
            
            
        } catch (SQLException e) {
            conn = null;
            System.out.println(e.getMessage()); // CAPTURA DE LA SQL EXCEPTION Y MUESTRA EN PANTALLA
            throw e;//
        }
    }

    public void tancaConnexio() throws SQLException {
        try {
            conn.close();
        } finally {
            conn = null;
        }
    }

    /*
     *TODO
     * 
     *Paràmetres: el nom del fitxer i el taller a desar
     *
     *Acció:
     *  - Heu de desar el taller sobre la base de dades:
     *      - El taller s'ha de desar a la taula tallers (nomFitxer passat per paràmetre és el codi del taller)
     *      - Cada recanvi del taller, s'ha de desar com a registre de la taula recanvis.
     *      - Heu de tenir en compte que si el taller ja existeix, heu de fer el següent:
     *          - Actualitzar el registre taller ja existent
     *          - Eliminar tots els recanvis d'aquest taller de la taula tallers i després inserir els nous com si es tractes
     *            d'un nou taller.
     *  - Si al fer qualsevol operació es produeix una excepció, llavors heu de llançar l'excepció GestorTallerMecanicException amb codi "GestorJDBC.desar"
     *
     *Retorn: cap
     *
     */
    @Override
    public void desarTaller(String nomFitxer, Taller taller) throws GestorTallerMecanicException {

        try {
            
            if(conn == null) {   // VERIFICA SI LA CONEXXION ES NULA, EN CASO TAL, LLAMA AL MÉTODO DE ESTABLECERLA
                estableixConnexio();
            }
            
            codiTallerSt.setString(1, taller.getCif()); // MÉTODO RECIBE EL ATRIBUTO DEL CÓDIGO DE TALLER COMO PARÁMETRO
            ResultSet regTaller = codiTallerSt.executeQuery(); // RECIBE LA EJECUCION DEL QUERY CON EL CÓDIGO DEL TALLER
            
            if(regTaller.next()) { //COMPRUEBA SI EL TALLER CON DICHO CÓDIGO EXISTE O NO, HACIENDO USO DEL MÉTODO ".NEXT"
                
                // ES IMPERATIVO INTRODUCIR LOS PARÁMETROS EN EL ORDEN QUE LOS RECIBE EL QUERY Y EL STATETMENT
                actualitzaTallerSt.setString(1, taller.getNom()); // ACTUALIZA EL NOMBRE DEL TALLER (ATRIBUTO "NOM")
                actualitzaTallerSt.setString(2, taller.getAdreca());
                actualitzaTallerSt.setString(3, taller.getCif()); // EL "CIF" ES EL ÚLTIMO PARÁMETRO QUE RECIBE EL QUERY, YA QUE ES EL CONDICIONAL DEL WHERE
                
                eliminaRecanviSt.setString(1, taller.getCif()); // ELIMINA EL RECAMBIO CON EL CÓDIGO TALLER
                eliminaRecanviSt.executeUpdate(); // ACTUALIZA 
                
            } else { // EN CASO DE NO EXISTIR LO INSERTA EN LA TABLA TALLERS
                
                insereixTallerSt.setString(1, taller.getCif()); // PRIMER PARÁMETRO SEGÚN EL ORDEN QUE SE LE INDICO EN EL QUERY
                insereixTallerSt.setString(2, taller.getNom());
                insereixTallerSt.setString(3, taller.getAdreca());
                
                insereixTallerSt.executeUpdate(); // ES IMPRESCINDIBLE LUEGO DE LLAMAR A CADA PARÁMETRO QUE RECIBE EL QUERY, HACER EL LLAMADO AL MÉTODO DE "executeUpdate" PARA QUE REALICE LA ACTUALIZACION Y CONSULTA, EN CASO CONTRARIO NO REALIZA NADA, SIEMPRE COMO ÚLTIMO PASO LUEGO DE LOS PARÁMETROS
            }
            
            // INSERCION DE LOS RECAMBIOS CON LA PRELACIÓN DEL TALLER
            
            for(Component component : taller.getComponents()) {
                if(component != null && component instanceof Recanvi) { // SE DEBEN DE PREVIAMENTE IMPORTAL EL MODELO DE "RECANVI" Y EL "COMPONENT" PARA PODER RECORRER EL ARRAY Y MODIFICAR EL RECANVI
                    insereixRecanviSt.setString(1, ((Recanvi) component).getCodi()); //SE DEBE DE CASTEAR EL RECANVI DE COMPONENT ´PARA APUNTAR A LOS ATRIBUTOS
                    insereixRecanviSt.setString(2, ((Recanvi) component).getNom());
                    
                    insereixRecanviSt.setString(3, ((Recanvi) component).getFabricant());
                    insereixRecanviSt.setDouble(4, ((Recanvi) component).getPreu());
                    
                    insereixRecanviSt.setString(5, ((Recanvi) (Taller) component).getCif()); // LA CLAVE FORÁNEA ES EL CIF DEL TALLER
                    
                    insereixRecanviSt.executeUpdate();
                         
                    
                }
            }
           
            tancaConnexio(); // LLAMAMOS AL MÉTODO DE CIERRE DE CONEXION PARA NO MALGASTAR RECURSOS
            
        } catch(SQLException ex) {
            throw new GestorTallerMecanicException("GestorJDBC.desar");
        }
    }

    /*
     *TODO
     * 
     *Paràmetres: el nom del fitxer del taller
     *
     *Acció:
     *  - Heu de carregar el taller des de la base de dades (nomFitxer passat per paràmetre és el codi del taller)
     *  - Per fer això, heu de cercar el registre taller de la taula amb CIF = nomFitxer
     *  - A més, heu d'afegir els recanvis al taller a partir de la taula recanvis
     *  - Si al fer qualsevol operació es dona una excepció, llavors heu de llançar l'excepció GestorTallerMecanicException 
     *    amb codi "GestorJDBC.carregar"
     *  - Si el nomFitxer donat no existeix a la taula tallers (és a dir, el CIF = nomFitxer no existeix), llavors
     *    heu de llançar l'excepció GestorTallerMecanicException amb codi "GestorJDBC.noexist"
     *
     *Retorn: cap
     *
     */
    @Override
    public void carregarTaller(String nomFitxer) throws GestorTallerMecanicException {

        try {
            
            // SIEMPRE ES NECESARIO VERIFICAR SI ES NULL O NO PARA ATRAPAR CUALQUIER EXCEPTION
            if(conn == null) {
                estableixConnexio(); 
            }
            
           // codiTallerSt.setS
            
            codiTallerSt.setString(1, taller.getCif()); // VERIFICAMOS EL CODIGO DEL TALLER
            ResultSet regTaller = codiTallerSt.executeQuery();
            
            if(regTaller.next()) {
                
                taller = new Taller(regTaller.getString("codi"), regTaller.getString("nom"), regTaller.getString("adresa"));  // TOMA DE LOS ATRIBUTOS DE TALLER MEDIANTE EL RESULSET
                // RECANVI SELECCION
                
                selRecanvisSt.setString(1, taller.getCif());
                
                ResultSet regRecanvi = selRecanvisSt.executeQuery(); // ALMACENAMOS EL RESULTSET DEL RECAMBIO SELECCIONADO EN LA VARIABLE
                
                while(regRecanvi.next()) {
                    taller.addRecanvi(new Recanvi(regRecanvi.getString("codi"), regRecanvi.getString("nom"), regRecanvi.getString("fabricant"), regRecanvi.getDouble("preu"), regRecanvi.getBoolean("assignat")));  // ANEXO DEL RECANVI (CON TODOS SUS ATRIBUTOS A TALLER)
                    
                }
                
            } else {
                throw new GestorTallerMecanicException("GestorJDBC.noExisteix"); // LANZAMOS LA EXCEPTION EN CASO DE NO EXISTIR
            }
            
            
        } catch(SQLException ex) {
            throw new GestorTallerMecanicException("GestorJDBC.carregar");
        }
        
    }

}
