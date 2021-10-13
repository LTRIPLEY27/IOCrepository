/*
 * Classe que defineix un taller. Un taller es defineix pel seu CIF, nom, adreça, 
 * un vector de mecànics i mecàniques, un vector de clients i clientes, un vector de recanvis 
 * i un vector de reparacions. 
 */
package principal;

import areesTaller.Client;
import areesTaller.Mecanic;
import areesTaller.Recanvi;
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Taller{

    private String cif;
    private String nom;
    private String adreca;
    private Mecanic[] mecanics = new Mecanic[150];
    private int pMecanics = 0; //Priemra posició buida del vector mecanics
    private Client[] clients = new Client[250];
    private int pClients = 0; //Priemra posició buida del vector clients
    private Recanvi[] recanvis = new Recanvi[1500];
    private int pRecanvis = 0; //Priemra posició buida del vector recanvis
    private Reparacio[] reparacions = new Reparacio[2500];
    private int pReparacions = 0; //Priemra posició buida del vector reparacions
    
    public static final Scanner DADES = new Scanner(System.in);
    /*
     TODO CONSTRUCTOR
    
     Paràmetres: valors per tots els atributs de la classe menys els vectors.
    
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
    
    
    public Taller(String Cif, String Nom, String Adreca){//, int Pmecanics, int Pclients, int Precanvis, int Preparacions) {
        
        this.cif = Cif;
        this.nom = Nom;
        this.adreca = Adreca;
     
        
    }
    
    /*
     TODO Heu d'implementar tots els mètodes accessors possibles.
     */
    
    
    public void setCif(String Cif) {
        this.cif = Cif;
    }
    
    public String getCif() {
        return this.cif;
    }
    
     public void setNom(String Nom) {
        this.nom= Nom;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public void setAdreca(String Adreca) {
        this.adreca = Adreca;
    }
     
    public String getAdreca() {
        return this.adreca;
    }
    
    public void setpMecanics(int Pmecanics) {
        this.pMecanics = Pmecanics;
    }
     
    public int getpMecanics() {
        return this.pMecanics;
    }
    
    public void setpClient(int Pclients) {
        this.pClients = Pclients;
    }
     
    public int getpClients() {
        return this.pClients;
    }
    
    public void setpRecanvis(int Precanvis) {
        this.pRecanvis= Precanvis;
    }
     
    public int getpRecanvis() {
        return this.pRecanvis;
    }
    
    public void setpReparacions(int Preparacions) {
        this.pReparacions = Preparacions;
    }
     
    public int getpReparacions() {
        return this.pReparacions;
    }
    
    public void setMecanic (Mecanic[] mecanics) {
        this.mecanics = mecanics;
    }
    
    public Mecanic[] getMecanics() {
        return mecanics;
    }
    
     public void setClient(Client[] clients) {
        this.clients = clients;
    }
    
    public Client[] getClients() {
        return clients;
    }
    
     public void setRecanvi (Recanvi[] recanvis) {
        this.recanvis= recanvis;
    }
    
    public Recanvi[] getRecanvis() {
        return recanvis;
    }
    
     public void setReparacio (Reparacio[] reparacions) {
        this.reparacions = reparacions;
    }
    
    public Reparacio[] getReparacions() {
        return reparacions;
    }
    
    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari les dades per consola per crear un noou taller. Les dades
     a demanar són les que passem per paràmetre en el constructor.
     - També heu de tenir en compte que el nom i l'adreça, poden ser una frases, per exemple,
     Taller renovació o C/ Llarg, 15.
    
     Retorn: El nou taller creat.
     */
    public static Taller addTaller() {
        
        Taller taller;
        
        String Cif, Nom, Adreca;
        
        System.out.println("Ingrese CIF:");
        Cif = DADES.nextLine();
        
        System.out.println("Ingrese Nombre:");
        Nom = DADES.nextLine();
        
        System.out.println("Ingrese Direcion:");
        Adreca = DADES.nextLine();
        

        
        taller = new Taller(Cif, Nom, Adreca);
        
        return taller;
        
        
        
    }
    
    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual i
       modificar els atributs corresponents d'aquest objecte. Els únics atributs que
       modificarem són els que hem inicialitzat en el constructor amb els paràmetres passats.
     - També heu de tenir en compte que el nom i l'adreça, poden ser una frases, per exemple,
       Taller renovació o C/ Llarg, 15.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     
    Retorn: cap
     */
    public void updateTaller() {
        
        System.out.println("El Cif actual es : " + this.cif + "Ingrese nuevo CIF:");
        this.cif = DADES.nextLine();
        
        System.out.println("El  nuevo CIF es :" + this.cif);
        
        System.out.println("El Nombre actual es : " + this.nom + "Ingrese nuevo Nombre:");
        this.nom = DADES.nextLine();
        
        System.out.println("El  nuevo Nombre es :" + this.nom);
        
        System.out.println("La direccion actual es : " + this.adreca + "Ingrese nueva Direcion:");
        this.adreca = DADES.nextLine();
        
        System.out.println("La nueva Direccion es :" + this.adreca);
        
    }
    
    
    
    public void showTaller() {
        System.out.println("\nEl nom del taller amb CIF " + cif + " és:");
        System.out.println("\nNom del taller: " + nom);
        System.out.println("\nAdreça del taller: " + adreca);
    }
    
     /*
     CLIENT
     */
    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Afegeix un nou client o clienta al vector de clients del taller actual si aquest no existeix. 
       Per afegir-lo o afegir-la heu de fer servir el mètode de la classe Client escaient i per comprovar la seva 
       existència el mètode d'aquesta classe que ens ajuda en aquesta tasca.
     - Actualitza la posició del vector de clients si s'afegeix el client o clienta.
     - Mostra el missatge "El client o clienta ja existeix" si no s'ha afegit el client o clienta.
    
     Retorn: cap
     */
    public void addClient() {
        
        Client cliente = Client.addClient();// LLAMADA AL METODO ESTATICO DE LA CLASE CLIENTE PARA ADHERIR UN NUEVO CLIENTE.
    
                if(selectClient(cliente.getNif()) == -1) {
                    clients[pClients] = cliente;
                    pClients++;
                    System.out.println("s'afegeix el client o clienta");
                    }      
            else {
                System.out.println("El client o clienta ja existeix");
            }
    }

    public int selectClient(String nif) {
        
        if (nif == null) {
            System.out.println("\nNIF del client o clienta?:");
            nif = DADES.next();
        }

        for (int i = 0; i < pClients; i++) {
            if (clients[i].getNif().equals(nif)) {
                return i;
            }
        }

        return -1;
    }
    
    /*
     MECANICS
     */
    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Afegeix un nou mecànic o mecànica al vector de mecanics del taller actual si aquest no existeix. 
       Per afegir-lo o afegir-la heu de fer servir el mètode de la classe Mecanic escaient i per comprovar la seva 
       existència el mètode d'aquesta classe que ens ajuda en aquesta tasca.
     - Actualitza la posició del vector de mecanics si s'afegeix el mecànic o mecànica.
     - Mostra el missatge "El mecànic o mecànica ja existeix" si no s'ha afegit el mecànic o mecànica.
    
     Retorn: cap
     */
    public void addMecanic() {
        
        Mecanic mecanico = Mecanic.addMecanic(); // VARIABLE QUE ALMACENARA EL VALOR DE MECANICO A COMPROBAR
       
                    if(selectMecanic(mecanico.getNif()) == -1) {
                       mecanics[pMecanics] = mecanico;
                       pMecanics++;
                       System.out.println("s'afegeix el mecànic o mecànica");

                }
                 else {
                    System.out.println("El mecànic o mecànica ja existeix");
                }   

    }

    public int selectMecanic(String nif) {
        
        if (nif == null) {
            System.out.println("\nNIF del mecànic o mecànica?:");
            nif = DADES.next();
        }

        for (int i = 0; i < pMecanics; i++) {
            if (mecanics[i].getNif().equals(nif)) {
                return i;
            }
        }

        return -1;
    }
    
    /*
     RECANVIS
     */
    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Afegeix un nou recanvi al vector de recanvis del taller actual si aquest no existeix. 
       Per afegir-lo heu de fer servir el mètode de la classe Recanvi escaient i per comprovar la seva 
       existència el mètode d'aquesta classe que ens ajuda en aquesta tasca.
     - Actualitza la posició del vector de recanvis si s'afegeix el recanvi.
     - Mostra el missatge "El recanvi ja existeix" si no s'ha afegit el recanvi.
    
     Retorn: cap
     */
    public void addRecanvi() {  
        
        Recanvi recambio = Recanvi.addRecanvi();
                    if(selectRecanvi(recambio.getCodi()) == -1) {
                        recanvis[pRecanvis] = recambio;
                        pRecanvis++;
                        System.out.println("si s'afegeix el recanvi");
                }
                 else {
                    System.out.println("El recanvi ja existeix");
                }
    }

    public int selectRecanvi(String codi) {
        
        if (codi == null) {
            System.out.println("\nCodi del recanvi?:");
            codi = DADES.next();
        }

        for (int i = 0; i < pRecanvis; i++) {
            if (recanvis[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }
    
     /*
     REPARACIONS
     */
    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Afegeix una nova reparació al vector de reparacions del taller actual si aquesta no existeix. 
       Per afegir-la heu de fer servir el mètode de la classe Reparacio escaient i per comprovar la seva 
       existència el mètode d'aquesta classe que ens ajuda en aquesta tasca.
     - Actualitza la posició del vector de reparacions si s'afegeix la reparació.
     - Mostra el missatge "La reparació ja existeix" si no s'ha afegit la reparació.
    
     Retorn: cap
     */
    public void addReparacio() {
        
        Reparacio reparacion = Reparacio.addReparacio() ;
        
                    if(selectReparacio(reparacion.getCodi()) == -1) {
                        reparacions[pReparacions] = reparacion;
                        pReparacions++;
                    System.out.println("s'afegeix la reparació");
                }
                 else {
                    System.out.println("La reparació ja existeix");
                }
        
    }

    public int selectReparacio(String codi) {
        
        if (codi == null) {
            System.out.println("\nCodi identificador de la reparació?:");
            codi = DADES.next();
        }

        for (int i = 0; i < pReparacions; i++) {
            if (reparacions[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }
    
    public void addClientReparacio() {
        
        Reparacio reparacioSel;
        int pos = selectReparacio(null);

        if (pos >= 0) {

            reparacioSel = this.getReparacions()[pos];

            pos = selectClient(null);

            if (pos >= 0) {
                reparacioSel.setClient(this.getClients()[pos]);
            } else {
                System.out.println("\nNo existeix aquest cient o clienta");
            }

        } else {
            System.out.println("\nNo existeix aquesta reparació");
        }

    }
    
    public void addMecanicReparacio() {
        
        Reparacio reparacioSel;
        int pos = selectReparacio(null);

        if (pos >= 0) {

            reparacioSel = this.getReparacions()[pos];

            pos = selectMecanic(null);

            if (pos >= 0) {
                reparacioSel.addMecanic(this.getMecanics()[pos]);
            } else {
                System.out.println("\nNo existeix aquest mecànic o mecànica");
            }

        } else {
            System.out.println("\nNo existeix aquesta reparació");
        }

    }
    
    public void addRecanviReparacio() {   

        Reparacio reparacioSel;
        int pos = selectReparacio(null);

        if (pos >= 0) {

            reparacioSel = this.getReparacions()[pos];

            pos = selectRecanvi(null);

            if (pos >= 0) {
                
                if (this.getRecanvis()[pos].getAssignat()) {
                    System.out.println("\nEl recanvi ja ha estat assignat");
                } else {
                    reparacioSel.addRecanvi(this.getRecanvis()[pos]);
                    getRecanvis()[pos].setAssignat(true);
                }// else {
                   // System.out.println("\nEl recanvi ja ha estat assignat");
                //}
                
            } else {
                System.out.println("\nNo existeix aquest recanvi");
            }
            
        } else {
            System.out.println("\nNo existeix aquesta reparació");
        }

    }
    
    public void calcularPreuReparacio() {
        Reparacio reparacioSel;
        int pos = selectReparacio(null);

        if (pos >= 0) {

            reparacioSel = this.getReparacions()[pos];
            

            System.out.println("\nQuantes hores s'han invertit en la reparació?");
            reparacioSel.addPreu(DADES.nextInt());

        } else {
            System.out.println("\nNo existeix aquesta reparació");
        }
    }

 

    
}
