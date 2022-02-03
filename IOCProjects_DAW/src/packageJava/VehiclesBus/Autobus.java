
package packageJava.VehiclesBus;

public class Autobus implements Rutas{
    private int ruedas;
    private String color;
    private int asientos;
    private double horaViaje;

    public Autobus(int ruedas, String color, int asientos) {
        this.ruedas = ruedas;
        this.color = color;
        this.asientos = asientos;
 
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    @Override
    public String toString() {
        return "Autobus{" + "ruedas=" + ruedas + ", color=" + color + ", asientos=" + asientos + '}';
    }

    public double getHoraViaje() {
        return horaViaje;
    }

    public void setHoraViaje(double horaViaje) {
      
        System.out.println("Indique la hora en la que desea abordar");
        this.horaViaje = ASK.nextDouble();

    }

    
    @Override
    public void recorrido() {
        if(this.horaViaje != 2 || this.horaViaje != 8){
            System.out.println("El horario que indica es incorrecto");
        }else{
             System.out.println("El horario que indica es correcto");
        }
    }

    
}
