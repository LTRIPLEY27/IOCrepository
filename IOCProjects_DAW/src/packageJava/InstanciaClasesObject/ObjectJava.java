package packageJava.InstanciaClasesObject;
public class ObjectJava implements Cloneable{
    private double size;
    private String colour;
    private int quantity;

    public ObjectJava(double size, String colour, int quantity) {
        this.size = size;
        this.colour = colour;
        this.quantity = quantity;
    }

    protected Object clone() throws CloneNotSupportedException {//IMPLEMENTACIÓN DE LA INTERFAZ Y EL CONSTRUCTOR PARA CLONAR
        return super.clone();
    }
    
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void aumentaInventary(){
        while(this.quantity < 3){
            this.quantity++;
        }
    }
    

    @Override
    public String toString() {
        return "ObjectJava{" + "size=" + size + ", colour=" + colour + ", quantity=" + quantity + '}';
    }
    
    
}
