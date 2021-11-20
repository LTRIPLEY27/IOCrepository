/*
 * Classe que defineix un taller. Un taller es defineix pel seu CIF, nom, adreça, 
 * un vector de mecànics i mecàniques, un vector de clients i clientes, un vector de recanvis 
 * i un vector de reparacions. 
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
public class Taller implements Component {

  // EL METODO ESTATIC FINAL DE LA CLASE SCANNER SE SUPRIME AL IMPLEMENTAR LA INTERFACE

    private String cif;
    private String nom;
    private String adreca;
    
    private Component[] components = new Component[4400];
    private int pComponents = 0; 

    /*
     TODO CONSTRUCTOR
    
     Paràmetres: valors per tots els atributs de la classe menys els vectors.
    
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
    public Taller(String cif, String nom, String adreça) {
        this.cif = cif;
        this.nom = nom;
        this.adreca = adreça;
    }

    /*
     TODO Heu d'implementar tots els mètodes accessors possibles.
     */
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }
    
    public int getpComponents() {
        return this.pComponents;
    }

    public void setpComponents(int pComponents) {
        this.pComponents = pComponents;
    }
    
    public Component[] getComponents() {
        return this.components;
    }

    public void setComponents(Component[] components) {
        this.components = components;
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

        String cif, nom, adreca;

        System.out.println("\nCIF del taller:");
        cif = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom del taller:");
        nom = DADES.nextLine();
        System.out.println("\nAdreça del taller:");
        adreca = DADES.nextLine();

        return new Taller(cif, nom, adreca);
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
    @Override
    public void updateComponent() {
        System.out.println("\nCIF del taller: " + cif);
        System.out.println("\nEntra el nou CIF:");
        cif = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom del taller: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();
        System.out.println("\nAdreça del taller: " + adreca);
        System.out.println("\nEntra la nova adreça:");
        adreca = DADES.nextLine();
    }

    @Override
    public void showComponent() {
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

        Client nouClient = Client.addClient();

        if (selectComponent(1, nouClient.getNif()) == -1) { // PARAMETROS QUE RECIBE EL METODO "SELECTCOMPONENT" PARA VERIFICAR EL TIPO DE CLASE AL QUE REFIERE EN EL ARRAY DE COMPONENTS
            components[pComponents] = nouClient;
            pComponents++;  // AUMENTA EL CONTADOR 
        } else {
            System.out.println("\nEl client o clienta ja existeix");
        }
    }

    public int selectComponent(int opcionComponent, String id) { // RECIBE POR PARAMETRO EL COMPONENTE (SEGUN EL TIPO QUE LE HAYAMOS INDICADO EN EL METODO DE CADA ELEMENTO DEL VECTOR : CLIENT = 1, MECANIC = 2 ...) + EL ID QUE APLIQUE.

        if (id == null) {     //CONDICIONAL QUE VERIFICA LA CORRECTA LECTURA DEL ID Y QUE TENGA UNA VARIABLE
            switch(opcionComponent) {
                case 1:
                    System.out.println("\nNIF del client o clienta?:");
                    break;
                case 2:
                    System.out.println("\nNIF del mecànic o mecànica?:");
                    break;
                case 3:
                    System.out.println("\nCodi del recanvi?:");
                    break;
                case 4:
                    System.out.println("\nCodi identificador de la reparació?:");
                    break;
                default:
                    System.out.println("debe de solicitar una opcion valida");
                    break;
                    
            }
            
            id = DADES.nextLine(); // VERIFICA LA OPCION QUE APLIQUE
          
        }

        
        int pos = -1; // POSICION EN LA QUE ARRANCA
        
        for (int i = 0; i < pComponents; i++) {         // RECORRE EL ARRAY DE OBJETOS "COMPONENT"
            if (components[i] instanceof Client && opcionComponent == 1) { // CONDICIONAL QUE VERIFICA SI REFIERE A UN TIPO ESPECIFICO DE OBJETO CON EL "INSTANCEOF" Y EL VALOR DEL TIPO COINCIDEN
                if(((Client) components[i]).getNif().equals(id)) { // VERIFICA SI EL OBJETO CLIENT DEL ARRAY COMPONENTS REPITE O NO ID PARA CONSIDERAR O NO SI ESTA REGISTRADO
                    return i;
                }
            } else if(components[i] instanceof Mecanic && opcionComponent == 2) { // REPITE LA VALORIZACION PERO CON MECANICS
                if(((Mecanic) components[i]).getNif().equals(id)) {
                     return i;
                } 
            } else if(components[i] instanceof Recanvi && opcionComponent == 3) { // REPITE LA VALORIZACION PERO CON RECANVI
                if(((Recanvi) components[i]).getCodi().equals(id)) {
                     return i;
                }
        } else if(components[i] instanceof Reparacio && opcionComponent == 4) { // REPITE LA VALORIZACION PERO CON REPARACIO
                if(((Reparacio) components[i]).getCodi().equals(id)) {
                     return i;
                }
                
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

        Mecanic nouMecanic = Mecanic.addMecanic();

        if (selectComponent(2, nouMecanic.getNif()) == -1) {
            components[pComponents] = nouMecanic;
            pComponents++;
        } else {
            System.out.println("\nEl mecànic o mecànica ja existeix");
        }
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

        Recanvi nouRecanvi = Recanvi.addRecanvi();

        if (selectComponent(3, nouRecanvi.getCodi()) == -1) {
            components[pComponents] = nouRecanvi;
            pComponents++;
        } else {
            System.out.println("\nEl recanvi ja existeix");
        }
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

        Reparacio novaReparacio = Reparacio.addReparacio();

        if (selectComponent(4, novaReparacio.getCodi()) == -1) {
            components[pComponents] = novaReparacio;
            pComponents++;
        } else {
            System.out.println("\nLa reparació ja existeix");
        }
    }

    public void addClientReparacio() {

        Reparacio reparacioSel;
        int pos = selectComponent(4, null);   // LOS VALORES A VERIFICAR POR EL SELECT EN EL SWITCH

        if (pos >= 0) {

            reparacioSel = (Reparacio) this.getComponents()[pos];  //

            pos = selectComponent(1,null);

            if (pos >= 0) {
                reparacioSel.setClient((Client) this.getComponents() [pos]);  //SE ACTUALIZA EL CLIENT UTILIZANDO EL METODO DE REPARACIO "SETCLIENT" CON EL OBJETO CLIENT PASADO POR PARAMETROS
            } else {
                System.out.println("\nNo existeix aquest cient o clienta");
            }

        } else {
            System.out.println("\nNo existeix aquesta reparació");
        }

    }

    public void addMecanicReparacio() {

        Reparacio reparacioSel;
        int pos = selectComponent(4,null);

        if (pos >= 0) {

            reparacioSel = (Reparacio) this.getComponents()[pos];

            pos = selectComponent(2,null);

            if (pos >= 0) {
                reparacioSel.addMecanic((Mecanic) this.getComponents()[pos]);
            } else {
                System.out.println("\nNo existeix aquest mecànic o mecànica");
            }

        } else {
            System.out.println("\nNo existeix aquesta reparació");
        }

    }

    public void addRecanviReparacio() {

        Reparacio reparacioSel;
        int pos = selectComponent(4,null);

        if (pos >= 0) {

            reparacioSel = (Reparacio) this.getComponents()[pos];

            pos = selectComponent(3,null);

            if (pos >= 0) {
                
               Recanvi recanvi1 = (Recanvi) this.getComponents()[pos];

                if (!recanvi1.isAssignat()) {
                    reparacioSel.addRecanvi(recanvi1);
                    recanvi1.setAssignat(true);
                } else {
                    System.out.println("\nEl recanvi ja ha estat assignat");
                }
                
                
                
            } else {
                System.out.println("\nNo existeix aquest recanvi");
            }

        } else {
            System.out.println("\nNo existeix aquesta reparació");
        }

    }

    public void calcularPreuReparacio() {
        Reparacio reparacioSel;
        int pos = selectComponent(4,null);
        
       

        if (pos >= 0) {

            reparacioSel = (Reparacio) this.getComponents()[pos];

            System.out.println("\nQuantes hores s'han invertit en la reparació?");
            reparacioSel.addPreu(DADES.nextInt());

        } else {
            System.out.println("\nNo existeix aquesta reparació");
        }
    }

   
}
