package persistencia;

import com.db4o.Db4oEmbedded;  // SE HA DE IMPORTAR LA CLASE Db4
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Predicate;


import java.sql.*;
import com.db4o.ObjectContainer;
import model.Taller;
import principal.GestorTallerMecanicException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

        

/**
 *
 * @author fta
 */
public class GestorDB4O implements ProveedorPersistencia {

    private ObjectContainer db;
    private Taller taller;

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }

    /*
     *TODO
     * 
     *Paràmetres: cap
     *
     *Acció:
     *  - Heu de crear / obrir la base de dades "EAC112122S1.db4o"
     *  - Aquesta base de dades ha de permetre que Taller s'actualitzi en cascada.
     *
     *Retorn: cap
     *
     */
    public void estableixConnexio() {
        
        EmbeddedConfiguration configura = Db4oEmbedded.newConfiguration();
        configura.common().objectClass(Taller.class).cascadeOnUpdate(true); // LLAMA A LA ACTUALIZACION EN CASCADA DE LA CLASE TALLER
        db = Db4oEmbedded.openFile(configura, "EAC112122S1.db4o"); // Con el DB4 abrimos el archivo de la base de datos y almacenamos en la variable del Object container
        
    }

    public void tancaConnexio() {
        db.close();
    }

    /*
     *TODO
     * 
     *Paràmetres: el nom del fitxer i el taller a desar
     *
     *Acció:
     *  - Heu d'establir la connexio i al final tancar-la.
     *  - Heu de desar l'objecte Taller passat per paràmetre sobre la base de dades 
     *    (heu d'inserir-la si no existia ja a la base de dades, o actualitzar-la en l'altre cas)
     *  - S'ha de fer la consulta de l'existència amb Predicate
     *
     *Retorn: cap
     *
     */
    @Override
    public void desarTaller(String nomFitxer, Taller pTaller) throws GestorTallerMecanicException {
        
        estableixConnexio(); // SE DEBE DE LLAMAR AL MÉTODO DE ESTABLECER CONEXION EN PRIMERA INSTANCIA, CASO CONTRARIO NO FUNCIONA.
        final String recibe = nomFitxer;
        
        List <Taller> tallers = db.query(new Predicate<Taller>() {
            @Override
            public boolean match(Taller taller) {
                return taller.getCif().equals(recibe); // COMPARA SI EL CIF COINCIDE CON OTRO EXISTENTE O NO
            }
            
        });
        
        if(tallers.size() != 1) {
            db.store(pTaller); // ACTUALIZA LA POSICION DEL ARRAY
            db.commit();
        } else {
            taller = tallers.iterator().next(); // LLAMAMOS AL ITERATOR DEFINIDO CON "PREDICATE"
            
            taller.setCif(pTaller.getCif()); // ACTUALIZAMOS LOS ATRIBUTOS DE TALLER
            taller.setNom(pTaller.getNom());
            taller.setAdreca(pTaller.getAdreca());
            
            db.store(taller);
            db.commit();
        }
        
        tancaConnexio();
    }

    /*
     *TODO
     * 
     *Paràmetres: el nom del fitxer on està guardatel taller
     *
     *Acció:
     *  - Heu d'establir la connexio i al final tancar-la.
     *  - Heu de carregar el taller des de la base de dades assignant-la a l'atribut taller.
     *    Si no existeix, llanceu l'excepció GestorTallerMecanicException amb codi "GestorDB4O.noExisteix"
     *  - S'ha de fer la consulta amb Predicate
     *
     *Retorn: cap
     *
     */
    @Override
    public void carregarTaller(String nomFitxer) throws GestorTallerMecanicException {
        
        estableixConnexio();
        
        final String carga = nomFitxer;
        
        List<Taller> tallers = db.query(new Predicate <Taller>() {
            @Override
            public boolean match(Taller taller) {
               return taller.getCif().equals(carga);
            }
            
        }); // HASTA ACÁ ES EL CIERRE DEL PREDICATE
        
        if(tallers.size() != 1) {
            
            throw new GestorTallerMecanicException("GestorDB4O.noExisteix"); // SE LANZA LA EXCEPCION QUE DEMANDA EL ENUNCIADO
        }
        else {
            taller = tallers.iterator().next();
        }
        
        tancaConnexio();
    }
}
