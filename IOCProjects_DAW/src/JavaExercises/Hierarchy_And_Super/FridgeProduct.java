/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaExercises.Hierarchy_And_Super;

/**
 *
 * @author isabe
 */
public class FridgeProduct extends Products{
    private double temperature_recommended;
    
    private FridgeProduct(int CADUCITY, int NUMBER, double temperature) {
        
        super(CADUCITY, NUMBER);
        this.temperature_recommended = temperature;
        
    }
    
    private void setTemperature(double temperature) {
        this.temperature_recommended = temperature;
    }
    
    private double getTemperature() {
        return this.temperature_recommended;
    }
    
    public String toString() {
        return super.toString() + this.temperature_recommended;
    }
}
