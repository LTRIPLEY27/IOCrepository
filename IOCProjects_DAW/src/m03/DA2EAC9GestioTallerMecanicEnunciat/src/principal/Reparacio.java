/*
 * Classe que defineix una reparació. Una reparació es defineix pel seu codi identificador,
 * la data d'inici i de fi de la reparació en format dd/mm/aaaa, on dd és el dia, mm és el 
 * mes i aaaa és l'any, el preu de la reparació, el client o clienta que ha demanat la reparació, un
 * vector amb els mecànics i mecàniques que s'encarreguen de la reparació i un vector amb els recanvis fets 
 * servir en la reparació.
 */
package principal;

import areesTaller.Client;
import areesTaller.Mecanic;
import areesTaller.Recanvi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Isabel Calzadilla
 */
public class Reparacio implements Component{

    private String codi;
    private String dataInici;
    private String dataFi;
    private double preu;
    private Client client; 
    private Map<String, ArrayList> maps = new HashMap();  // INTERCAMBIO DEL ARRAY POR EL HASMAP, PROVEYENCO COMO "KEY" EL OBJETO


    /*
     TODO CONSTRUCTOR
    
     Paràmetres: valors per tots els atributs de la classe menys el client, preu i els vectors.
    
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres
     */
    public Reparacio(String codi, String dataInici, String dataFi) {
        this.codi = codi;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
        maps.put("mecanics", new ArrayList<Mecanic>());// CLAVE Y ARRAYLIST QUE ALMACENA A MECANIC
        maps.put("recanvis", new ArrayList<Recanvi>());// EL MAP SE INCIAI EN EL CONSTRUCTOR SEGUN ENUNCIADO
    }

    /*
     TODO Heu d'implementar tots els mètodes accessors possibles.
     */
    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getDataInici() {
        return dataInici;
    }

    public void setDataInici(String dataInici) {
        this.dataInici = dataInici;
    }

    public String getDataFi() {
        return dataFi;
    }

    public void setDataFi(String dataFi) {
        this.dataFi = dataFi;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // MÉTODOS DE ACCESO DE TIPO MAP
    public Map<String, ArrayList> getMaps() {
        return maps;
    }
    
    public void setMaps(Map <String, ArrayList> maps) {
        this.maps = maps;
    }
    /*
    TODO
    Paràmetres: cap
    
    Accions:
    - Demanar a l'usuari les dades per consola per crear un nou recanvi. Les dades
    a demanar són les que passem per paràmetre en el constructor.
    
    Nota: De moment suposarem que el format de les dates són correctes.
    
    Retorn: El nou recanvi creat.
     */
    public static Reparacio addReparacio() {

        String codi, dataInici, dataFi;

        System.out.println("\nCodi identificador de la reparació:");
        codi = DADES.next();
        System.out.println("\nData d'incic de la reparació:");
        dataInici = DADES.next();
        System.out.println("\nData de fi de la reparació:");
        dataFi = DADES.next();

        return new Reparacio(codi, dataInici, dataFi);
    }

    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual i
       modificar els atributs corresponents d'aquest objecte. Els únics atributs que
       modificarem són els que hem inicialitzat en el constructor amb els paràmetres passats.    
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.   
    
     Nota: De moment suposarem que el format de les dates són correctes.
     
    Retorn: cap
     */
    public void updateComponent() {
        System.out.println("\nCodi identificador de la reparació: " + codi);
        System.out.println("\nEntra el nou codi identificador:");
        codi = DADES.next();
        System.out.println("\nData d'incic de la reparació: " + dataInici);
        System.out.println("\nEntra la nova data d'inici:");
        dataInici = DADES.next();
        System.out.println("\nData de fi de la reparació: " + dataFi);
        System.out.println("\nEntra la nova data de fi:");
        dataFi = DADES.next();
    }

    /*
     TODO
    
     Paràmetres: mecanic a assignar
    
     Accions:
    
     - Si el mecànic passat o mecànica passada com a paràmetre no ha estat assignat o assignada
       a la reparació actual, s'afegeix al vector de mecanics i s'actualitza la posició del vector.    
     - Si el mecànic o mecànica ja està assignat o assignada a la reparació actual, no fem res.
    
     Retorn: cap
     */
    public void addMecanic(Mecanic mecanic) throws GestorTallerMecanicException{ // SE DEBE DE HACER EL LLAMADO A LA EXCEPCION

        if(maps.get("mecanics").contains(mecanic.getNif())) {//RECORRE EL MAP CON LA CLAVE Y LA LISTA INTERNA DEL ARRAYLIS UBICANDO SI EL NIF ESTA O NO REPETIDO
            throw new GestorTallerMecanicException("3");// EN CASO DE CUMPLIRSE EL IF DISPARA LA EXCEPCION
        } else {
            maps.get("mecanics").add(mecanic);
        }
    }

    /*
     TODO
    
     Paràmetres: recanvi a assignar
    
     Accions:
    
     - Si el recanvi passat com a paràmetre no ha estat assignat a la reparació actual, 
       s'afegeix al vector de recanvis i s'actualitza la posició del vector.    
     - Si el recanvi ja està assignat a la reparació actual, no fem res.
    
     Retorn: cap
     */
    public void addRecanvi(Recanvi recanvi) throws GestorTallerMecanicException {


        if(maps.get("recanvis").contains(recanvi.getCodi())) {// VERIFICA SI EL CODIGO YA ESTA SIGNADO
            throw new GestorTallerMecanicException("4");
            
        } else {
            maps.get("recanvis").add(recanvi);
        }

    }

    /*
     TODO
    
     Paràmetres: total d'hores invertides en la reparació
    
     Accions:
    
     - S'ha d'assignar a l'atribut preu el preu de la reparació el qual es calcula sumant 
       els preus dels recanvis fets servir en la repració més el nombre d'hores invertides
       en la reparació, què són les passades per paràmetre, per el preu de cada hora que
       és de 60.5.
    
     Retorn: cap
     */
    public void addPreu(int totalHores) {

        double preuRecanvis = 0;

        for (int i = 0; i < maps.get("recanvis").size(); i++) {
            
            // ES NECESARIO CASTEAR EL OBJETO DEL MAPS PUES NO DETERMINA A CUAL REFIERE, DE ESTA FORMA Y CUIDAR LOS PARENTESIS
             preuRecanvis+= ((Recanvi) maps.get("recanvis").get(i)).getPreu();// ASIGNO EL VALOR DEL MAP Y ARRAY LIST ESPECIFICO A LA VARIABLE
        }

        preu = preuRecanvis + 60.5 * totalHores;
    }

    public void showComponent() {
        System.out.println("\nLes dades de la reparació amb codi identificador " + codi + " són:");

        System.out.println("\nData d'inici: " + dataInici);

        System.out.println("\nData de fi: " + dataFi);

        System.out.println("\nPreu: " + preu);

        if (client != null) {
            System.out.println("\nClient: ");
            client.showComponent();
        }

        if(maps.get("mecanics").isEmpty()) {
            for (int i = 0; i < maps.get("mecanics").size(); i++) {
            ((Mecanic)maps.get("mecanics").get(i)).showComponent();
            }
        } else {
            System.out.println("\n El mecánico no se encuentra asignado");
        }
        
        
        if(maps.get("recanvis").isEmpty()) {
            for (int i = 0; i < maps.get("recanvis").size(); i++) {
            ((Recanvi) maps.get("recanvis").get(i)).showComponent();
        }
        } else {
            System.out.println("\n El mecánico no se encuentra asignado");
        }

        
    }

}
