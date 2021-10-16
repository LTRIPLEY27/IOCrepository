/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03.Ejercicios;

/**
 *
 * @author hellz
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int [] array = {3,4,10,8,7};
        int aux = 0;
             
        for(int i = 0; i < array.length; i++) {
            for(int j = (i + 1); j < array.length; j++) { // el valor de j al estar contenido en i se ira incrementando y con ello la posicion
                if(array[i] < array[j]) { // si la posicion original es mayor a la siguiente
                aux = array[i]; // guarda posicion original
                array[i] = array[j]; // posicion original adquiere el valor de posicion siguiente
                array[j] = aux; // posicion siguiente adquiere el valor mayor, AL IR ITERANDO, LOS VALORES MAYORES SE CORRERAN A ULTIMAS INSTANCIAS Y DE ESA MANERA SE REORDENARA
                }
            }
            
        }
        
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " -- ");
        } 
    }



}