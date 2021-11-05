/*
 * Classe que defineix un taller. Un taller es defineix pel seu CIF, nom, adreça, 
 * un vector de mecànics i mecàniques, un vector de clients i clientes, un vector de recanvis 
 * i un vector de reparacions. 
 */
package principal;

import areesTaller.Client;
import areesTaller.Mecanic;
import areesTaller.Recanvi;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fta
 */
public class Taller implements Component {

    private String cif;
    private String nom;
    private String adreca;
    
    private ArrayList <Component> components = new ArrayList<>(); // DECLARACION DEL ARRAY
    

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

    public ArrayList<Component> getComponents() { // métodos de acceso del ARRAYLIST
        return components;
    }

    public void setArrayListComponents(ArrayList<Component> components) {
        this.components =  components;
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
    public void addClient(Client nouClient) throws GestorTallerMecanicException{
        
        if(nouClient == null) {
            nouClient = Client.addClient();
            }
        
            if(selectComponent(1, nouClient.getNif()) == -1) {
                components.add(nouClient);
            } else {
                throw new GestorTallerMecanicException("5");
            
        } 
            
            // UBICAR COMO PASAR EL XML A UN NUEVO CLIENTE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
      
       
            
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
    public void addMecanic(Mecanic nouMecanic) throws GestorTallerMecanicException {

        
        if(nouMecanic == null) {
            
           nouMecanic = Mecanic.addMecanic();
        } 
            if (selectComponent(2, nouMecanic.getNif()) == -1) {
            components.add(nouMecanic);  /// 
        } else {
           throw new GestorTallerMecanicException("6");
        }
             
             
             ////////////////
        
            
            /////////////////7 XML ADDMECANIC
      

       
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
    public void addRecanvi(Recanvi nouRecanvi) throws GestorTallerMecanicException{

        
        if(nouRecanvi == null) {
            nouRecanvi = Recanvi.addRecanvi();
        }
            if (selectComponent(3, nouRecanvi.getCodi()) == -1) {
            components.add(nouRecanvi);
        } else {
            throw new GestorTallerMecanicException("7");
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
    public void addReparacio(Reparacio novaReparacio)throws GestorTallerMecanicException {

        
        
        if(novaReparacio == null) {
            novaReparacio = Reparacio.addReparacio();
            
        }
            if (selectComponent(4, novaReparacio.getCodi()) == -1) {
            components.add(novaReparacio);
        } else {
            throw new GestorTallerMecanicException("8");
        }
        

        
    }

    
    public int selectComponent(int tipusComponent, String id) {

        if (id == null) {
            //Demanem quin tipus de component vol seleccionar i el seu identificador (id)
            switch (tipusComponent) {
                case 1:
                    System.out.println("NIF del client o de la clienta?:");
                    break;
                case 2:
                    System.out.println("NIF del mecànic o la mecànica?:");
                    break;
                case 3:
                    System.out.println("Codi del recanvi?:");
                    break;
                case 4:
                    System.out.println("Codi de la reparació?:");
                    break;
            }

            id = DADES.next();
        }

        int posElement = -1; //Posició que ocupa el component seleccionat dins el vector de components del taller

        //Seleccionem la posició que ocupa el component dins el vector de components
        // del taller
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i) instanceof Client && tipusComponent == 1) {
                if (((Client) components.get(i)).getNif().equals(id)) {// SE MODIFICAN LOS INDICIES ADECUANDOLOS A LOS MÉTODOS DE LOS ARRAYLIST
                    return i;
                }
            } else if (components.get(i) instanceof Mecanic && tipusComponent == 2) {
                if (((Mecanic) components.get(i)).getNif().equals(id)) {
                    return i;
                }
            } else if (components.get(i) instanceof Recanvi && tipusComponent == 3) {
                if (((Recanvi) components.get(i)).getCodi().equals(id)) {
                    return i;
                }
            } else if (components.get(i) instanceof Reparacio && tipusComponent == 4) {
                if (((Reparacio) components.get(i)).getCodi().equals(id)) {
                    return i;
                }
            }
        }

        return posElement;
    }

    public void addClientReparacio() throws GestorTallerMecanicException{

        Reparacio reparacioSel;
        int pos = selectComponent(4, null);

        if (pos >= 0) {

            reparacioSel = (Reparacio)components.get(pos);

            pos = selectComponent(1, null);

            if (pos >= 0) {
                reparacioSel.setClient((Client)components.get(pos));
            } else {
                System.out.println("\nNo existeix aquest client o clienta");
                throw new GestorTallerMecanicException("5");
            }

        } else {
            System.out.println("\nNo existeix aquesta reparació");
            throw new GestorTallerMecanicException("8");
        }

    }

    public void addMecanicReparacio() throws GestorTallerMecanicException{

        Reparacio reparacioSel;
        int pos = selectComponent(4, null);

        if (pos >= 0) {

            reparacioSel = (Reparacio)components.get(pos);

            pos = selectComponent(2, null);

            if (pos >= 0) {
                    reparacioSel.addMecanic((Mecanic)components.get(pos));
       
            } else {
                System.out.println("\nNo existeix aquest mecànic o mecànica");
                throw new GestorTallerMecanicException("6");
            }

        } else {
            System.out.println("\nNo existeix aquesta reparació");
                        throw new GestorTallerMecanicException("8");

        }

    }

    public void addRecanviReparacio() throws GestorTallerMecanicException {

        Reparacio reparacioSel;
        int pos = selectComponent(4, null);

        if (pos >= 0) {

            reparacioSel = (Reparacio)components.get(pos);

            pos = selectComponent(3, null);

            if (pos >= 0) {

                if (!((Recanvi)components.get(pos)).isAssignat()) {
                    reparacioSel.addRecanvi((Recanvi)components.get(pos));
                    ((Recanvi)components.get(pos)).setAssignat(true);
                } else {
                    System.out.println("\nEl recanvi ja ha estat assignat");
                    throw new GestorTallerMecanicException("7");
                }

            } else {
                System.out.println("\nNo existeix aquest recanvi");
                throw new GestorTallerMecanicException("8");
            }

        } else {
            System.out.println("\nNo existeix aquesta reparació");
        }

    }

    public void calcularPreuReparacio() {
        Reparacio reparacioSel;
        int pos = selectComponent(4, null);

        if (pos >= 0) {

            reparacioSel = (Reparacio)components.get(pos);

            System.out.println("\nQuantes hores s'han invertit en la reparació?");
            reparacioSel.addPreu(DADES.nextInt());

        } else {
            System.out.println("\nNo existeix aquesta reparació");
        }
    }
}
