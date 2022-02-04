
package packageJava.RecapitulacionEjercicio5;

public class Usuario extends Persona implements InterfaceCompra{

    public String destino;
    public final int PRECIO = 4;
    
    public Usuario(String name, int edad, String destino) {
        super(name, edad);
        this.destino = destino;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDestino = " + destino;
    }

    @Override
    public double darCambio(double cantidad) {
       double cambio = cantidad - PRECIO;
       
       return cambio;
    }
    
    public boolean DestinoVerificado(){
        if(this.destino.equals("barcelona")){
           return true;
        }
        return false;//RESPONDE FALSE POR DEFECTO
    }
}
