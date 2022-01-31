package packageJava.AndroideVersion2;
import javax.swing.JOptionPane;
/**
 *
 * @author isabel
 */
public class Androides implements Verificador{
 private int servirCafe;
    private int servirComida;
    private boolean limpiar;
    private boolean recoger;
    private int pasearPerro;
    private boolean acunarBebe;
    private String lavarRopa;
    private int ataque;
    private int juego;
    private int jugadores;
    private String any;
    private String humano;
    private String nombreHumano;
    
    public Androides(){// DEFECTO
    }
    
    public Androides(String year, String human, String name) {//CONSTRUCTOR TERMINATOR
        this.any = year;
        this.humano = human;
        this.nombreHumano = name;
    }
    
    public Androides(int juego, int jugadores){//CONSTRUCTOR DATA
        this.juego = juego;
        this.jugadores = jugadores;
    }

    public String getAny() {
        return any;
    }

    public void setAny(String any) {
        this.any = any;
    }

    public String getHumano() {
        return humano;
    }

    public void setHumano(String humano) {
        this.humano = humano;
    }

    public String getNombreHumano() {
        return nombreHumano;
    }

    public void setNombreHumano(String nombreHumano) {
        this.nombreHumano = nombreHumano;
    }
    
    //MÉTODO QUE RETORNA AL OBJETO TERMINATOR
    public void terminatorActivated(){
        JOptionPane.showMessageDialog(null, "Terminator ha ejecutado satisfactoriamente la orden de Skynet\n\n ha viajado al año " + this.any + "\n\n ha exterminados la cantidad de humanos =  " + this.humano + "\n\n con nombre = " + this.nombreHumano);
    }
   
    public int getJuego() {
        return juego;
    }

    public void setJuego(int juego) {
        this.juego = juego;
    }

    public int getJugadores() {
        return jugadores;
    }

    public void setJugadores(int jugadores) {
        this.jugadores = jugadores;
    }
    
    //MÉTODO QUE RETORNA AL OBJETO DATA
    public void setPlayWithData(){
        if(this.juego == 1){
            JOptionPane.showMessageDialog(null, "Data inicia y triunfa en 5 jugadas de Ajedrez con " + this.jugadores + " cantidad de jugadores");
        } if(this.juego == 2){
            JOptionPane.showMessageDialog(null, "Data inicia y triunfa en 55 jugadas de GO con " + this.jugadores + " cantidad de jugadores");
        } if(this.juego == 3){
            JOptionPane.showMessageDialog(null, "Data inicia y triunfa en 12 jugadas de Baloncesto con " + this.jugadores + " cantidad de jugadores");
        } 
    }
    
    public Androides(int respuesta){
        this.ataque = respuesta;
    }

    public int getAtaque() {
        return ataque;
    }
    
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    //MÉTODO QUE RETORNA AL MAZINGER
    public void mazAtack() {
        if(this.ataque == 1){
            JOptionPane.showMessageDialog(null, "Mazinger ha replegado un ataque en V");
        } if(this.ataque == 2){
            JOptionPane.showMessageDialog(null, "Mazinger ha replegado un ataque directo");
        } else{
            JOptionPane.showMessageDialog(null, "Mazinger ha replegado un ataque defensivo");
        }
    }
    
    public String getLavarRopa() {
        return lavarRopa;
    }

    public void setLavarRopa(String lavarRopa) {
        this.lavarRopa = lavarRopa;
    }

    public int isServirCafe() {
        return servirCafe;
    }

    public void setServirCafe(int servirCafe) {
        this.servirCafe = servirCafe;
    }

    public int getServirComida() {
        return servirComida;
    }

    public void setServirComida(int servirComida) {
        this.servirComida = servirComida;
    }

    public boolean isLimpiar() {
        return limpiar;
    }

    public void setLimpiar(boolean limpiar) {
        this.limpiar = limpiar;
    }

    public boolean isRecoger() {
        return recoger;
    }

    public void setRecoger(boolean recoger) {
        this.recoger = recoger;
    }

    public int isPasearPerro() {
        return pasearPerro;
    }

    public void setPasearPerro(int pasearPerro) {
        this.pasearPerro = pasearPerro;
    }

    public boolean isAcunarBebe() {
        return acunarBebe;
    }

    public void setAcunarBebe(boolean acunarBebe) {
        this.acunarBebe = acunarBebe;
    }

    //MÉTODOS QUE IMPLEMENTA ROBOTINA A TRAVES DE LA SUPERCLASE
    @Override
    public void sirveComida() {
        JOptionPane.showMessageDialog(null, "Señor Sónico, Robotina ha preparado " + this.servirComida + " cantidad de comida para ti");
    }

    @Override
    public void limpiar() {
        if(this.limpiar){
            JOptionPane.showMessageDialog(null, "Señor Sónico, Robotina ha limpiado todo ");
        }
    }

    @Override
    public void recoge() {
        if(this.recoger){
            JOptionPane.showMessageDialog(null, "Señor Sónico, Robotina ha recogido todo por usted");
        }
    }

    @Override
    public void pasearPerro() {
        JOptionPane.showMessageDialog(null, "Señor Sónico, Robotina ha paseado " + this.pasearPerro + " cantidad de mascotas por ti");
    }

    @Override
    public void acunarBebe() {
        if(this.acunarBebe){
            JOptionPane.showMessageDialog(null, "Señor Sónico, Robotina ha arrullado satisfactoriamente al bebé por usted");
        }
    }

    @Override
    public void sirveCafe() {
        JOptionPane.showMessageDialog(null, "Señor Sónico, Robotina ha preparado " + this.servirCafe + " cantidad de café para ti");
    }

    @Override
    public void lavarRopa() {
         JOptionPane.showMessageDialog(null, "Señor Sónico, Robotina ha lavado " + this.lavarRopa + " cantidad de ropa para ti");
    }
  
}

