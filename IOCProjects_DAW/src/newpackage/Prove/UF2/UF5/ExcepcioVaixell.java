/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.Prove.UF2.UF5;

/**
 *
 * @author isabe
 */
public class ExcepcioVaixell extends Exception {
    private String codiExcepcio;
    public ExcepcioVaixell(String codiExcepcio) {
    this.codiExcepcio = codiExcepcio;
}

public String getMessage() {
    switch (codiExcepcio) {
        case "0":
            return "El vaixell no està matriculat";
        default:
        return "El vaixell està matriculat";
    }
}
}
