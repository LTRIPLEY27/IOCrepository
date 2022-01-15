/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PAF;

/**
 *
 * @author isabe
 */
/*public abstract class Atraccio implements Obertura {
   
    private String nom; //Nom del parc
    private String zona; //zona del parc d'atraccions a la qual pertany l'atracció
    private boolean teAccesMR; //Indica si l'atracció té un accés especial per persones amb mobilitat reduïda
    private boolean estaOberta; // nuevo atributo booleano
    
    public Atraccio(String nom, String zona, boolean teAccesMR) {
        this.nom = nom;
        this.zona = zona;
        this.teAccesMR = teAccesMR;
    }
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getZona() {
        return zona;
    }
    public void setZona(String zona) {
        this.zona = zona;
    }
    public boolean isTeAccesMR() {
        return teAccesMR;
    }
    public void setTeAccesMR(boolean teAccesMR) {
        this.teAccesMR = teAccesMR;
    }
   

    
    public void imprimirAtraccio(){
        System.out.println("Nom: "+nom);
        System.out.println("Zona: "+zona);
        
        if(teAccesMR){
          System.out.println("Accés Mobilitat Reduïda: Si");  
        } else{
          System.out.println("Accés Mobilitat Reduïda: No"); 
        }
    }

    /*Implementela en la clase apropiada de la jerarquía formada por la superclase Atraccio del ejercicio anterior, y un conjunto de subclases, entre ellas la clase Infantil implementada también en el ejercicio anterior. El método esta () debe pedir al usuario si la atracción está abierta o no. Si el valor introducido es Si, se le asignará verdadero a un nuevo atributo de tipo booleano con nombre esta, y si el valor introducido es No, se le asignará el valor falso. No debes controlar si el usuario introduce un valor diferente de Sí o No, supondremos que siempre introduce Sí o No. Para decidir en qué clase la debe implementar, es decir, en la clase Atraccio o en la clase Infantil, debes tener en cuenta que cualquier atracción sea del tipo que sea puede estar abierta o cerrada. Podéis trabajar en vuestro IDE, y luego copiar en el espacio de respuesta el código final. Si os hace falta, para solucionar la pregunta, podéis copiar el código del enunciado en vuestro IDE, ahorraréis tiempo.*/
    /*
    @Override
   /* public void estaOberta() {
        
        String response;
        System.out.println("Indique si esta abierta o cerrada con valor si o no");
        response = ASK.next();
        
        if(response.equalsIgnoreCase("si")) {
            estaOberta =  true;
        } else {
            estaOberta = false;
        }
        
        System.out.println(estaOberta);
    }
    
}


public class Atraccio {

    private String nom;
    private String zona; //zona del parc d'atraccions a la qual pertany l'atracció
    private boolean teAccesMR; //Indica si l'atracció té un accés especial per persones amb mobilitat reduïda

    public Atraccio(String nom, String zona, boolean teAccesMR) {
        this.nom = nom;
        this.zona = zona;
        this.teAccesMR = teAccesMR;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public boolean isTeAccesMR() {
        return teAccesMR;
    }

    public void setTeAccesMR(boolean teAccesMR) {
        this.teAccesMR = teAccesMR;
    }

    public void teAccesMR() throws ExcepcioAtraccio {

        /*TODO debe comprobar si la atracción que llama a este método tiene acceso para personas con movilidad reducida o no. En ambos casos he de tirar una excepción de tipo ExcepcioAtraccio con el código pertinente para luego capturar la excepción producida. Cuando capture la excepción, se debe imprimir por pantalla el mensaje correspondiente al código de la excepción definido en la clase ExcepcioAtraccio.
         */
        
        /*try {
            if(teAccesMR == false) {
                throw new ExcepcioAtraccio("0");
            } else {
                throw new ExcepcioAtraccio("1");
            }
        } catch(ExcepcioAtraccio e) {
            System.out.println("\n" + e.getMessage());
        }
        }
    }*/

public class Atraccio {

    private String nom;
    private String zona; //zona del parc d'atraccions a la qual pertany l'atracció
    private boolean teAccesMR; //Indica si l'atracció té un accés especial per persones amb mobilitat reduïda

    public Atraccio(String nom, String zona, boolean teAccesMR) {
        this.nom = nom;
        this.zona = zona;
        this.teAccesMR = teAccesMR;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public boolean isTeAccesMR() {
        return teAccesMR;
    }

    public void setTeAccesMR(boolean teAccesMR) {
        this.teAccesMR = teAccesMR;
    }
}
