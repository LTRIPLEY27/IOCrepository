/*
* Classe que defineix un recanvi utilitzat en una reparació. Es defineixen pel seu codi, 
* nom, fabricant que el fabrica i preu.
*/
package areesTaller;

import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Recanvi {
    
    private String codi;
    private String nom;
    private String fabricant;
    private double preu;    
    private boolean assignat;
    
    public static final Scanner DADES = new Scanner(System.in);

    /*
     TODO CONSTRUCTOR
    
     Paràmetres: valors per tots els atributs de la classe menys assignat.
    
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres.
     - Assignar a l'atribut assignat el valor fals, ja que quan es crea un recanvi
       aquest no s'ha assignat a cap reparació.    
     */

    public Recanvi(String code, String name, String fabric, double price) {
        
        this.codi = code;
        this.nom = name;
        this.fabricant = fabric;
        this.preu = price;
        this.assignat = false;    // POR DEFECTO
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
    
     public void setNom(String name) {
        this.nom = name;
    }
    
    public String getNom() {
        
        return this.nom;
    }
    
     public void setFabricant(String fabric) {
        this.fabricant = fabric;
    }
    
    public String getFabricant() {
        
        return this.fabricant;
    }
    
    public void setPreu(double price) {
        this.preu = price;
    }
    
    public double getPreu() {
        return this.preu;
    }
    
    //////////////// metodo get and set boolean?
    
    public void setAssignat(boolean signat) {
        this.assignat = signat;
    }
    
    public boolean getAssignat() {
        return this.assignat;
    }
    
    /*
    TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou recanvi. Les dades a demanar 
       són les que necessita el constructor.
     - També heu de tenir en compte que el nom o el fabricant poden ser una frase, per exemple, filtre d'oli
       o Würth components.
     
     Retorn: El nou recanvi creat.
     */
    public static Recanvi addRecanvi() {
        
        Recanvi recambio;
        
        String code, name, fabric;
        double price;
        boolean signat;
        
        System.out.println("Ingrese codigo");
        code = DADES.nextLine();
        
        System.out.println("Ingrese nombre");
        name = DADES.nextLine();
        
        System.out.println("Ingrese fabricante");
        fabric = DADES.nextLine();
        
        System.out.println("Ingrese precio");
        price = DADES.nextDouble();
        
 
        recambio = new Recanvi(code, name, fabric, price);
        
        return recambio;
    }
    
    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual i
       modificar els atributs corresponents d'aquest objecte.
     - També heu de tenir en compte que el nom o el fabricant poden ser una frase, per exemple, filtre d'oli
       o Würth components.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
    
    NOTA: EL valor de l'atribut assignat no es pot modificar.
     
    Retorn: cap
     */
    public void updateRecanvi() {
      
        String code, name, fabric;
        double price;
        
        System.out.println("Ingrese codigo");
        code = DADES.nextLine();
        
        setCodi(code);
        System.out.println("Codigo: " + getCodi());
        
        System.out.println("Ingrese nombre");
        name = DADES.nextLine();
        
        setNom(name);
        System.out.println("Nombre: " + getNom());
        
        System.out.println("Ingrese fabricante");
        fabric = DADES.nextLine();
        
        setFabricant(fabric);
        System.out.println("Fabricante: " + getFabricant());
        
        System.out.println("Ingrese precio");
        price = DADES.nextDouble();
        
        setPreu(price);
        System.out.println("Precio: " + getPreu());
   
        
    }
    
    public void showRecanvi() {
        System.out.println("\nLes dades del recanvi amb codi " + codi + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nFabricant: " + fabricant);
        System.out.println("\nPreu: " + preu);
        
        if(assignat){
          System.out.println("\nEl recnavi està assignat");  
        }else{
          System.out.println("\nEl recnavi no està assignat");   
        }
    }
}
