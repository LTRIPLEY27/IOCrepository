/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaExercises.Hierarchy_And_Super;

/**
 *
 * @author i.c
 */
public class FreshProduct extends Products { //SON 1
    private int embase_date;
    private String country;
    
    public FreshProduct(int CADUCITY, int NUMBER, int embassy, String countrye) {
        super(CADUCITY, NUMBER);
        this.embase_date = embassy;
        this.country = countrye;
    }
    
    private void setEmbase(int embassy) {
        this.embase_date = embassy;
    }
    
    private int getEmbase() {
        return this.embase_date;
    }
    
    private void setCountry(String countrye) {
        this.country = countrye;
    }
    
    private String getCountry() {
        return this.country;
    }
    
    public String toString() {
        return super.toString() + this.embase_date + this.country;
    }
    
}
