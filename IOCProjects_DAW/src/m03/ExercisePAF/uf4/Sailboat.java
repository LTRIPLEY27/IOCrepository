/*
 * Donde el retorno del método toString son los valores separados por comas de todos los atributos de
el objeto de tipo velero que llama al método, debe implementar la superclase abstracta Barco
de la que hereda la clase Velero.

Puede trabajar en su IDE, y luego copiar en el espacio de respuesta el código final. Si es necesario,
para solucionar la pregunta, puede copiar el código del enunciado en su IDE, ahorrará tiempo.
 */
package m03.ExercisePAF.uf4;

/**
 *
 * @author isabe
 */
public class Sailboat extends Boat {
    
    
    int veles; //Total de veles

    public Sailboat(String nom, float eslora, int cabines, int veles) {
        super(nom, eslora, cabines);
        this.veles = veles;
    }   

    public int getVeles() {
        return veles;
    }

    public void setVeles(int veles) {
        this.veles = veles;
    }    

    public String toString() {
        return super.toString()+ ", Veles=" + veles;
    }

    
    
}

