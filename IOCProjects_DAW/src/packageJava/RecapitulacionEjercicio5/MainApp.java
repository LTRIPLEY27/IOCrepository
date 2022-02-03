package packageJava.RecapitulacionEjercicio5;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        Conductor conductor = new Conductor();
        Usuario usuario;
        String name;
        int edad;
        double cambio;
        String [] destinos = {"Tarragona", "Reus", "Vilanova"};
        System.out.println("Desea realizar compra de billete?");
        String question = ask.next();
        if(question.equals("si")){
           System.out.println("Hola, soy el conductor " + conductor.getName());
           System.out.println("Indiqueme su nombre");
           name = ask.next();
           
        }else{
            System.out.println("Adeu..");
         }
    }
    
}
