package packageJava.Androide;
public class Androide implements Verifica {
    private int servirCafe;
    private int servirComida;
    private boolean limpiar;
    private boolean recoger;
    private int pasearPerro;
    private boolean acunarBebe;
    private String lavarRopa;
    
    public Androide(){
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

    @Override
    public void sirveComida() {
        System.out.println("Mazinger ha preparado " + this.servirComida + " cantidad de comida para ti");
    }

    @Override
    public void limpiar() {
        if(this.limpiar){
            System.out.println("Mazinger ha limpiado todo");
        }
    }

    @Override
    public void recoge() {
        if(this.recoger){
            System.out.println("Mazinger ha recogido ");
        }
    }

    @Override
    public void pasearPerro() {
        System.out.println("Mazinger ha paseado " + this.servirComida + " cantidad de mascotas");
    }

    @Override
    public void acunarBebe() {
        if(this.acunarBebe){
            System.out.println("Mazinger ha arrullado satisfactoriamente al bebé ");
        }
    }

    @Override
    public void sirveCafe() {
         System.out.println("Mazinger ha preparado " + this.servirCafe + " cantidad de café para ti");
    }

    @Override
    public void lavarRopa() {
        System.out.println("Mazinger ha lavado " + this.lavarRopa + " cantidad de ropa para ti");
    }
    
    
}
