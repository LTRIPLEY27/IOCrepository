/*
* Classe que defineix un client o clienta del taller. Es defineixen pel seu NIF, nom, telèfon
* i correu electrònic.
 */
package areesTaller;

import java.util.Scanner;


/**
 *
 * @author fta
 */
public class Client extends Persona{ // INSERCION DE LA HERENCIA DE CLIENTS DE PERSONA E IMPLEMENTACION DE LA INTERFACE COMPONENT
    
      

    /*
     TODO CONSTRUCTOR
    
     Paràmetres: valors per tots els atributs de la classe.
    
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.    
     */
    
    
    
    
    
    
    public Client(String nif, String nom, String telefon, String correo) {
        
        super(nif, nom, telefon, correo); //USO DE LA HERENCIA EN EL CONSTRUCTOR LLAMANDO A LA CLASE PERSONA
    }
    
    
    
    

    /*
     TODO Heu d'implementar tots els mètodes accessors possibles.  
     */
    
    // LOS METODOS DE ACCESO YA NO SON NECESARIOS PUES LO IMPLEMENTA LA CLASE PADRE: PERSONA.
    
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
        String nif, nom, telefon, correu;

        System.out.println("\nNIF del client o clienta:");
        nif = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom del client o clienta:");
        nom = DADES.nextLine();
        System.out.println("\nTelèfon del client o clienta:");
        telefon = DADES.next();        
        System.out.println("\nCorreu electrònic del client o clienta:");
        correu = DADES.next();

        return new Client(nif, nom, telefon, correu);
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
    
    
    
    // METODOS IMPLEMENTADOS DE LA INTERFACE
    
    
  


    
    
}