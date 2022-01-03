/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m03.ExercisePAF.uf4;

/**
 *
 * @author isabe
 */
public class ExceptionBoat extends Exception {
    private String codiExcepcio;

    public ExceptionBoat(String codiExcepcio) {

        this.codiExcepcio = codiExcepcio;

    }

    @Override
    public String getMessage() {

        switch (codiExcepcio) {
            case "0":
                return "El vaixell no està matriculat";
            default:
                return "El vaixell està matriculat";
        }
    }
}
