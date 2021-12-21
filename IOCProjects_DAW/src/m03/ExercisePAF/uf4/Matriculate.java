/*
 *Dada la siguiente interfaz

public interface Matricula {
    public String matricular();
}

Implémenla en la clase Barco, teniendo en cuenta que el método matricular() debe pedir a
el usuario que introduzca la matrícula del barco que devolverá el método.
 
 */
package m03.ExercisePAF.uf4;

import java.util.Scanner;

/**
 *
 * @author isabe
 */
public interface Matriculate {
    public final static Scanner ask = new Scanner(System.in);
    public String matricular();
}
