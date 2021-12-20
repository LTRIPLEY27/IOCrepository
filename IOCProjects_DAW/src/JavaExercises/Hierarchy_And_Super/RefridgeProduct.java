/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaExercises.Hierarchy_And_Super;

/**
 *
 * @author isabe
 */
public class RefridgeProduct extends Products {
    private int code_supervising;
    
    private RefridgeProduct(int CADUCITY, int NUMBER, int code) {
        super(CADUCITY, NUMBER);
        this.code_supervising = code;
    }
    
    private void setCode(int code) {
        this.code_supervising = code;
    }
    
    private int getCode() {
        return this.code_supervising;
    }
    
    public String toString() {
        return super.toString() + this.code_supervising;
    }
}
