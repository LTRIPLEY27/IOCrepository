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
import java.util.Scanner;

/**
 *
 * @author Isabel Calzadilla
 */
public class Reparacio {

    private String codi;
    private String dataInici;
    private String dataFi;
    private double preu;
    private Client client;
    private Mecanic[] mecanics = new Mecanic[10];
    private int pMecanics = 0; //Priemra posició buida del vector mecanics
    private Recanvi[] recanvis = new Recanvi[20];
    private int pRecanvis = 0; //Priemra posició buida del vector recanvis
    public static final Scanner DADES = new Scanner(System.in);
    
    /*
     TODO CONSTRUCTOR
    
     Paràmetres: valors per tots els atributs de la classe menys el client, preu i els vectors.
    
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres
     */

    
    public Reparacio(String code, String dateBegin, String dateEnd) {
        
        this.codi = code;
        this.dataInici = dateBegin;
        this.dataFi = dateEnd;
        
    } 
    
    /*
     TODO Heu d'implementar tots els mètodes accessors possibles.
    */
    
    // METODOS DE ACCESO
    
    public void setCodi(String code) {
        this.codi = code;
    }
    
    public String getCodi() {
        return this.codi;
    }
    
    public void setdataInici(String dateBegin) {
        this.dataInici = dateBegin;
    }
    
    public String getdataInici() {
        return this.dataInici;
    }
    
    public void setdataFi(String dateEnd) {
        this.dataFi = dateEnd;
    }
    
    public String getdataFi() {
        return this.dataFi;
    }
    
    public void setPreu(double price) {
        this.preu = price;
    }
    
    public double getPreu() {
        return this.preu;
    }
    
    public void setpMecanics(int pMecanico) {
        this.pMecanics = pMecanico;
    }
    
    public int getpMecanics() {
        return this.pMecanics;
    }
    
    public void setpRecanvis (int pRecambio) {
        this.pRecanvis = pRecambio;
    }
    
    public void setMecanic(Mecanic[] mecanics) {
        this.mecanics = mecanics;
    }
    
    public Mecanic[] getMecanic() {
        return this.mecanics;
    }
    
    public void setRecanvis(Recanvi [] recanvis) {
        this.recanvis = recanvis;
    }
    
    public Recanvi[] getRecanvi() {
        return this.recanvis;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
    public Client getClient() {
        return this.client;
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
   
        Reparacio reparacion;
        
        String code, dateBegin, dateEnd;
     
        
        System.out.println("Ingrese codigo: ");
        code = DADES.nextLine();
        
        System.out.println("Ingrese fecha de inicio");
        dateBegin = DADES.nextLine();
        
        System.out.println("Ingrese fecha de finalizacion");
        dateEnd = DADES.nextLine();
                
        reparacion = new Reparacio(code, dateBegin, dateEnd);
        
        return reparacion;
        
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
    public void updateReparacio() {
       
        String code, dateBegin, dateEnd;
        
        System.out.println("Ingrese codigo: ");
        code = DADES.nextLine();
        
        this.codi = code;
        System.out.println("El nuevo codigo es: " + this.codi);
        
        System.out.println("Ingrese fecha de inicio");
        dateBegin = DADES.nextLine();
        
        this.dataInici = dateBegin;
        System.out.println("El nueva fecha es: " + this.dataInici);
        
        System.out.println("Ingrese fecha de finalizacion");
        dateEnd = DADES.nextLine();
        
        this.dataFi = dateEnd;
        System.out.println("El nueva fecha final es: " + this.dataFi);
        

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
    public void addMecanic(Mecanic mecanic) { // PARAMETRO QUE USA LA CLASE MECANICO

        
        for(int i = 0; i < pMecanics; i++) {
            if(mecanic.getNif().equals(mecanics[i].getNif())) {
                mecanics[i] = mecanic;
                pMecanics++;
            }
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
    public void addRecanvi(Recanvi recanvi) {

        for(int i = 0; i < pRecanvis; i++) {
            if(recanvi.getCodi().equals(recanvis[i].getCodi())) {
                recanvis[i] = recanvi;
                pRecanvis++;
            }
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
        
        double preuHoras = totalHores * 60.5;
        
        double preuRecanvis  = 0.0;
        
        for(int i = 0; i < pRecanvis; i++) {
            preuRecanvis +=  recanvis[pRecanvis].getPreu();  // SUMA DEL PRECIO DEL ARRAY RECANVIS
            System.out.println(recanvis[pRecanvis].getPreu());
        }
        
        this.preu = preuRecanvis + preuHoras; // VERIFICAR EL PRECIO DEL RECANVI
        
    }
    
    public void showReparacio() {
        System.out.println("\nLes dades de la reparació amb codi identificador " + codi + " són:");
        
        System.out.println("\nData d'inici: " + dataInici);
        
        System.out.println("\nData de fi: " + dataFi);

        System.out.println("\nPreu: " + preu);
        
        if (client != null) {
            System.out.println("\nClient: ");
            client.showClient();
        }
        
        for (int i = 0; i < pMecanics; i++) {
            mecanics[i].showMecanic();
        }

        for (int i = 0; i < pRecanvis; i++) {
            recanvis[i].showRecanvi();
        }
    }

}

