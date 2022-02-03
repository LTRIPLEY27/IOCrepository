
package packageJava.RecapitulacionEjercicio5;

public class Usuario extends Persona implements InterfaceCompra{

    public String destino;
    
    public Usuario(String name, int edad, String destino) {
        super(name, edad);
        this.destino = destino;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDestino = " + destino;
    }

    @Override
    public double darCambio() {
       return 0.0;
    }
    
    
}
