/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PAF;

/**
 *
 * He de crear una jerarquía implementando la clase Infantil que implementa una atracción infantil de un parque de atracciones que hereda de la clase Atraccio. Además, para implementar la clase Infantil debes tener en cuenta: La clase Infantil tiene un atributo propio llamado alcadaMaxima de tipo double, que indica la altura máxima para acceder a la atracción. Esta jerarquía de clases debe implementar todos los métodos accesorios (get's y set's) por sus atributos. El método imprimirAtraccio() debe imprimir el valor de todos los atributos de la clase Infantil. Debes tener en cuenta el concepto de reutilización de código en Java. Podéis trabajar en vuestro IDE, y luego copiar en el espacio de respuesta el código final. Si os hace falta, para solucionar la pregunta, podéis copiar el código del enunciado en vuestro IDE, ahorraréis tiempo.
 */
public class Infantil extends Atraccio {
    
    private double alcadaMaxima;
    
    public Infantil(String nom, String zona, boolean teAccesMR, double alcada) {
        super(nom, zona, teAccesMR);
        this.alcadaMaxima = alcada;

    }
    
    // METODO DE ACCESO
    public void setAlcadaMaxima(double alcada) {
        this.alcadaMaxima = alcada;
    }
    
    public double getAlcadaMaxima() {
        return alcadaMaxima;
    }
    
    //@Override
    public void  imprimirAtraccio(){
        System.out.println("Nom: "+ super.getNom());
        System.out.println("Zona: "+super.getZona());
        System.out.println("Alcada máxima: "+ alcadaMaxima);
        
      /*  if(super.isTeAccesMR()){
          System.out.println("Accés Mobilitat Reduïda: Si");  
        } else{
          System.out.println("Accés Mobilitat Reduïda: No"); 
        }*/
        
    }
    }

