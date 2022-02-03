package packageJava.VehiclesBus;

public class Taxi {
    private int cauchos;
    private int color;
    private int asientos;
    private double tamaño;

    public Taxi(int cauchos, int color, int asientos, double tamaño) {
        this.cauchos = cauchos;
        this.color = color;
        this.asientos = asientos;
        this.tamaño = tamaño;
    }

    
    
    public int getCauchos() {
        return cauchos;
    }

    public void setCauchos(int cauchos) {
        this.cauchos = cauchos;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return "Taxi{" + "cauchos=" + cauchos + ", color=" + color + ", asientos=" + asientos + ", tama\u00f1o=" + tamaño + '}';
    }

}
