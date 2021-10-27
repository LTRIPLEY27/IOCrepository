/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03.Ejercicios;

/**
 *
 * @author hellz
 */
public class OrderArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         int [] array = {3,4,10,8,7};
         
         int aux = 0;
         int x = 0;
         int y = x + 1;
         
         do {
             if(array[x] > array[y]) {
                 aux = array[x];
                 array[x] = array[y];
                 array[y] = aux;
                 x++;
                 y++;
             }
         }while(x < array.length && y < array.length);
         
         for(int i = 0; i < array.length; i++) {
             System.out.print(array[i] + "-");
         }
    }
    
}
