package packageJava.RecapitulacionEjercicio5;

public class Persona {
    
    protected String name;
    protected int edad;
    
    //POR DEFECTO
    public Persona() {
        this.name = "";
        this.edad = 0;
    }

    public Persona(String name, int edad) {
        this.name = name;
        this.edad = edad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return " \nNombre = " + name + "\nEdad = " + edad;
    }
    
}
