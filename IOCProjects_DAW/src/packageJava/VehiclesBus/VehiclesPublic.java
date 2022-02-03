
package packageJava.VehiclesBus;
public class VehiclesPublic {
    public static void main(String[] args) {
        Autobus autobus = new Autobus(4, "amarillo", 34);
        System.out.println(autobus.toString());
        autobus.setHoraViaje(8);
        System.out.println(autobus.getHoraViaje());
        autobus.getHoraViaje();
        autobus.recorrido();
    }
    
}
