/*
* Classe que defineix un client o clienta del taller. Es defineixen pel seu NIF, nom, telèfon
* i correu electrònic.
 */
package areesTaller;

import java.util.Scanner;


/**
 *
 * @Maria Isabel Calzadilla
 */
public class Client {
    
    private String nif;
    private String nom;
    private String telefon;
    private String correu;
    
    public static final Scanner DADES = new Scanner(System.in);   // DECLARACION DE LA CONSTANTE SCANNER EN LA CLASE
    

    /*
     TODO CONSTRUCTOR
    
     Paràmetres: valors per tots els atributs de la classe.
    
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.    
     */

    /*
     TODO Heu d'implementar tots els mètodes accessors possibles.  
     */
    
    // DEFINICION DEL CONSTRUCTOR CON PARAMETROS 
    
    public Client(String dni, String name, String telephone, String mail) {
        
        this.nif = dni;
        this.nom = name;
        this.telefon = telephone;
        this.correu = mail;
        
    }
    
    
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
     - Demanar a l'usuari les dades per consola per crear un nou client o clienta. Les dades a demanar 
       són les que necessita el constructor.
     - També heu de tenir en compte que el nom pot ser una frase, per exemple, Maria Antonia.
     
     Retorn: El nou client creat o clienta creada.
     */
    
    
    
    public static Client addClient() {
        
        //DECLARACION DE LAS VARIABLES A ALMACENAR SEGUN LOS PARAMETROS
        
        
        String nif, name, telephone, mail;
        
        Client cliente;
       
                System.out.println("Ingrese su nif, cliente");
                nif = DADES.nextLine();
        
                System.out.println("Ingrese su Nombre, cliente");
                name = DADES.nextLine();
        
                System.out.println("Ingrese su Telefono, cliente");
                telephone = DADES.nextLine();
        
                System.out.println("Ingrese su Correo, cliente");
                mail = DADES.nextLine();
        
                cliente = new Client(nif, name, telephone, mail);

        
        return cliente;
        
    
        
        
      
    }
    
    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual i
       modificar els atributs corresponents d'aquest objecte.
     - També heu de tenir en compte que el nom pot ser una frase, per exemple, Maria Antonia.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     
    Retorn: cap
     */
    public void updateClient() {
        
        String nif, name, telephone, mail;
        
        //Client cliente;
       
                System.out.println("Ingrese su nif, cliente");
                nif = DADES.nextLine();
                
                setNif(nif);
                System.out.println("NIF: " + getNif());
        
                System.out.println("Ingrese su Nombre, cliente");
                name = DADES.nextLine();
                
                setNom(name);
                System.out.println("Nombre: " + getNom());
        
                System.out.println("Ingrese su Telefono, cliente");
                telephone = DADES.nextLine();
                
                setTelefon(telephone);
                System.out.println("Telefono: " + getTelefon());
        
                System.out.println("Ingrese su Correo, cliente");
                mail = DADES.nextLine();
                
                setCorreu(mail);
                System.out.println("Correo: " + getCorreu());
          
    }
    
    public void showClient() {
        System.out.println("\nLes dades del client o clienta amb NIF " + nif + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nTelèfon: " + telefon);
        System.out.println("\nCorreu electrònic: " + correu);
    }
}