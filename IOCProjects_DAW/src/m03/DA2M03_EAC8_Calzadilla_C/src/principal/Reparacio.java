/*
 * Classe que defineix una reparació. Una reparació es defineix pel seu codi identificador,
 * la data d'inici i de fi de la reparació en format dd/mm/aaaa, on dd és el dia, mm és el 
 * mes i aaaa és l'any, el preu de la reparació, el client o clienta que ha demanat la reparació, un
 * vector amb els mecànics i mecàniques que s'encarreguen de la reparació i un vector amb els recanvis fets 
 * servir en la reparació.
 */
package principal;

import java.util.Scanner;
import areesTaller.Client;
import areesTaller.Mecanic;
import areesTaller.Recanvi;

/**
 *
 * @author fta
 */
public class Reparacio implements Component{

    private String codi;
    private String dataInici;
    private String dataFi;
    private double preu;
    private Client client;
    private Mecanic[] mecanics = new Mecanic[10];
    private int pMecanics = 0; //Priemra posició buida del vector mecanics
    private Recanvi[] recanvis = new Recanvi[20];
    private int pRecanvis = 0; //Priemra posició buida del vector recanvis

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

    public Mecanic[] getMecanics() {
        return mecanics;
    }

    public void setMecanics(Mecanic[] mecanics) {
        this.mecanics = mecanics;
    }

    public int getpMecanics() {
        return pMecanics;
    }

    public void setpMecanics(int pMecanics) {
        this.pMecanics = pMecanics;
    }

    public Recanvi[] getRecanvis() {
        return recanvis;
    }

    public void setRecanvis(Recanvi[] recanvis) {
        this.recanvis = recanvis;
    }

    public int getpRecanvis() {
        return pRecanvis;
    }

    public void setpRecanvis(int pRecanvis) {
        this.pRecanvis = pRecanvis;
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
    @Override
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
    public void addMecanic(Mecanic mecanic) {

        boolean afegit = false;

        for (int i = 0; i < pMecanics && !afegit; i++) {
            if (mecanics[i].getNif().equals(mecanic.getNif())) {
                afegit = true;
            }
        }

        if (!afegit) {
            mecanics[pMecanics] = mecanic;
            pMecanics++;
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

        boolean afegit = false;

        for (int i = 0; i < pRecanvis && !afegit; i++) {
            if (recanvis[i].getCodi().equals(recanvi.getCodi())) {
                afegit = true;
            }
        }

        if (!afegit) {
            recanvis[pRecanvis] = recanvi;
            pRecanvis++;
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

        for (int i = 0; i < pRecanvis; i++) {
            preuRecanvis += recanvis[i].getPreu();
        }

        preu = preuRecanvis + 60.5 * totalHores;
    }

    @Override
    public void showComponent() {
        System.out.println("\nLes dades de la reparació amb codi identificador " + codi + " són:");

        System.out.println("\nData d'inici: " + dataInici);

        System.out.println("\nData de fi: " + dataFi);

        System.out.println("\nPreu: " + preu);

        if (client != null) {
            System.out.println("\nClient: ");
            client.showComponent();
        }

        for (int i = 0; i < pMecanics; i++) {
            mecanics[i].showComponent();
        }

        for (int i = 0; i < pRecanvis; i++) {
            recanvis[i].showComponent();
        }
    }



}
