package packageJava;

public class Vehicles {
    
    private String color;
    private int ruedas;
    private String marca;
    private String modelo;
    private boolean havePlus;
    
    public Vehicles(String color, int ruedas, String marca, String modelo,boolean havePlus ){
        this.color = color;
        this.ruedas = ruedas;
        this.marca = marca;
        this.modelo = modelo;
        this.havePlus = havePlus;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public String getColor(){
        return this.color;
    }
     public void setRruedas(int ruedas){
        this.ruedas = ruedas;
    }
    
    public int getRuedas(){
        return this.ruedas;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public String getMarca(){
        return this.marca;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public String getModelo(){
        return this.modelo;
    }
    
    public void setPlus(boolean havePlus){
        this.havePlus = havePlus;
    }
    
    public boolean getPlus(){
        return this.havePlus;
    }
    
    public String toString(){
        return "Marca = " + this.marca + "\nModelo = " + this.modelo + "\nColor = " + this.color + "\nRuedas = " + this.ruedas + "\nTiene mejoras = " + this.havePlus;
    }

}
