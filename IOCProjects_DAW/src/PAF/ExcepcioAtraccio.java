/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PAF;

/**
 *
 * @author isabe
 */
public class ExcepcioAtraccio extends Exception {

    private String codiExcepcio;

    public ExcepcioAtraccio(String codiExcepcio) {

        this.codiExcepcio = codiExcepcio;

    }

    public String getMessage() {

        switch (codiExcepcio) {
            case "0":
                return "L'atracció no té accés per persones amb mobilitat reduïda";
            default:
                return "L'atracció té accés per persones amb mobilitat reduïda";
        }

    }

}
