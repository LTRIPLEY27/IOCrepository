/*
* Classe que defineix un mecànic o mecànica que treballa al taller. Es defineixen pel seu NIF, nom, telèfon
* i el correu electrònic.
 */
package areesTaller;

import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Mecanic {
    
    private String nif;
    private String nom;
    private String telefon;
    private String correu;
    
    public static final Scanner DADES = new Scanner(System.in);

    /*
     TODO CONSTRUCTOR
    
     Paràmetres: valors per tots els atributs de la classe.
    
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.    
     */

    
    public Mecanic(String dni, String name, String telephone, String mail) {
        
        this.nif = dni;
        this.nom = name;
        this.telefon = telephone;
        this.correu = mail;
    }
    
    
    /*
     TODO Heu d'implementar tots els mètodes accessors possibles.  
     */
    
     // METODOS DE ACCESO
    
    public void setNif(String dni) {
        this.nif = dni;
    }
    
    public String getNif() {
        
        return this.nif;
    }
    
     public void setNom(String name) {
        this.nom = name;
    }
    
    public String getNom() {
        
        return this.nom;
    }
    
     public void setTelefon(String telephone) {
        this.telefon = telephone;
    }
    
    public String getTelefon() {
        
        return this.telefon;
    }
    
     public void setCorreu(String mail) {
        this.correu = mail;
    }
    
    public String getCorreu() {
        
        return this.correu;
    }
    
    
    /*
    TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou mecànic o mecànica. Les dades a demanar 
       són les que necessita el constructor.
     - També heu de tenir en compte que el nom pot ser una frase, per exemple, Josep Maria.
     
     Retorn: El nou mecànic creat o mecànica creada.
     */
    public static Mecanic addMecanic() {
        
        String nif, name, telephone, mail;
        
        Mecanic mecanico;
       
                System.out.println("Ingrese su nif");
                nif = DADES.next();
        
                System.out.println("Ingrese su Nombre");
                name = DADES.nextLine();
        
                System.out.println("Ingrese su Telefono");
                telephone = DADES.nextLine();
        
                System.out.println("Ingrese su Correo");
                mail = DADES.nextLine();
        
                mecanico = new Mecanic(nif, name, telephone, mail);

        
        return mecanico;
    }
    
    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual i
       modificar els atributs corresponents d'aquest objecte.
     - També heu de tenir en compte que el nom pot ser una frase, per exemple, Josep Maria.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     
    Retorn: cap
     */
    public void updateMecanic() {
        
          String nif, name, telephone, mail;
        
       
       
                System.out.println("Ingrese su nuevo nif");
                nif = DADES.next();
                
                setNif(nif);
                System.out.println("NIF: " + getNif());
        
                System.out.println("Ingrese su nuevo Nombre");
                name = DADES.nextLine();
                
                setNom(name);
                System.out.println("Nombre: " + getNom());
        
                System.out.println("Ingrese su nuevo Telefono");
                telephone = DADES.nextLine();
                
                setTelefon(telephone);
                System.out.println("Telefono: " + getTelefon());
        
                System.out.println("Ingrese su nuevo Correo");
                mail = DADES.nextLine();
                
                setCorreu(mail);
                System.out.println("Correo: " + getCorreu());
        
    }
    
    public void showMecanic() {
        System.out.println("\nLes dades del client o clienta amb NIF " + nif + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nTelèfon: " + telefon);
        System.out.println("\nCorreu electrònic: " + correu);
    }
}
