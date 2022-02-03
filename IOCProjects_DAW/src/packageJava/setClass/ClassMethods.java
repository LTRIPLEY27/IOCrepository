
package packageJava.setClass;

public class ClassMethods {
    private String tamany;
    private boolean mozzarella;
    private int cantidad;

    public ClassMethods(String tamany, boolean mozzarella, int cantidad) {
        this.tamany = tamany;
        this.mozzarella = mozzarella;
        this.cantidad = cantidad;
    }

    public String getTamany() {
        return tamany;
    }

    public void setTamany(String tamany) {
        this.tamany = tamany;
    }

    public boolean isMozzarella() {
        return mozzarella;
    }

    public void setMozzarella(boolean mozzarella) {
        this.mozzarella = mozzarella;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Caracteristicas Pizza = " + "\ntamaño =" + tamany + ", mozzarella = " + mozzarella + ", cantidad=" + cantidad ;
    }
    
    
}
