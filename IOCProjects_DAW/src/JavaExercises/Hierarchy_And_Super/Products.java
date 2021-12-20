/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaExercises.Hierarchy_And_Super;

/**
 *
 * @author isabe
 */
public class Products {  // SUPERCLASS
    
    protected int caducity;
    protected int number;
    
    protected Products(int CADUCITY, int NUMBER) {
        this.caducity = CADUCITY;
        this.number = NUMBER;
        
    }
    
    protected void setCaducity(int CADUCITY) {
        this.caducity = CADUCITY;
    }
    
    protected int getCaducity() {
        return this.caducity;
    }
    
    protected void setNumber(int NUMBER) {
        this.number = NUMBER;
    }
    
    protected int getNumber() {
        return this.number;
    }
    
    @Override
    public String toString() {
        return this.caducity + "\n" + this.number;
    }
}
