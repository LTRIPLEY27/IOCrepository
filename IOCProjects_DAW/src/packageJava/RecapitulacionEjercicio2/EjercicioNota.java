
package packageJava.RecapitulacionEjercicio2;

import java.util.Scanner;

public class EjercicioNota {

    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        float suma = 0, num, media = 0;
        int media1 = 0;
        
        for(int i = 0; i < 3; i++){
            System.out.println("ingrese nota ejercicio " + (i + 1));
            num = ask.nextFloat();
            suma += num;
        } 
        media = suma / 3; // casteo
        media1 = (int) media;
        
        if(media1 >= 5){
            switch(media1){
                case 5:
                    System.out.println("Lo siento, no es muy prometedor su futuro, su media ha sido : " + media);
                    break;
                case 6:
                    System.out.println("Debe esforzarse más,  su media ha sido : " + media);
                    break;
                case 7:
                    System.out.println("Puede hacerlo mejor,  su media ha sido : " + media);
                    break;
                case 8:
                    System.out.println("Continue,  su media ha sido : " + media);
                    break;
                case 9:
                    System.out.println("Muy bien,  su media ha sido : " + media);
                    break;
                case 10:
                    System.out.println("Felicitaciones,  su media ha sido : " + media);
                    break;
            }
        } else {
            System.out.println("Lo siento, ha reprobado");
        }
    }
    
}
