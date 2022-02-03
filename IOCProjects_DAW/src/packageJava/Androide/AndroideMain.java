package packageJava.Androide;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class AndroideMain {
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        int cont = 0;
        Androide mazinger = new Androide();
        String name = JOptionPane.showInputDialog("Hola, indique su nombre ");
        String question = JOptionPane.showInputDialog("Desea encender a Mazinger");
            if(question.equals("si")){
                do{
                    String question1 = JOptionPane.showInputDialog("Hola,  " + name + "\n\nsoy Mazinger Z y estoy para servirte.\nIndique su elección: \n1.- Servir comida \n2.- Servir café \n3.- Limpiar \n4.- Recoger \n5.- Pasear perro \n6.- Acunar bebé \n7.- Lavar la ropa \n8.- Salir");
                    int option = Integer.parseInt(question1);
                    switch (option) {
                        case 1:
                            String question2 = JOptionPane.showInputDialog("indique la cantidad de comida");
                            int respuesta = Integer.parseInt(question2);
                            mazinger.setServirComida(respuesta);
                            mazinger.sirveComida();
                            cont++;
                            JOptionPane.showMessageDialog(null, "Tiene " + cont + " de bateria");
                            break;
                        case 2:
                            String question3 = JOptionPane.showInputDialog("indique la cantidad de café");
                            int respuesta1 = Integer.parseInt(question3);
                            mazinger.setServirCafe(respuesta1);
                            mazinger.sirveCafe();
                            cont++;
                            JOptionPane.showMessageDialog(null, "Tiene " + cont + " de bateria");
                            break;
                        case 3:
                            String question4 = JOptionPane.showInputDialog("indique si desea que limpie todo");
                            mazinger.setLimpiar(true);
                            mazinger.limpiar();
                            cont++;
                            JOptionPane.showMessageDialog(null, "Tiene " + cont + " de bateria");
                            break;
                        case 4:
                            String question5 = JOptionPane.showInputDialog("indique si desea que recoja algo por ti");
                            mazinger.setRecoger(true);
                            mazinger.recoge();
                            cont++;
                            JOptionPane.showMessageDialog(null, "Tiene " + cont + " de bateria");
                            break;
                        case 5:
                            String question6 = JOptionPane.showInputDialog("indique cuantas mascotas desea que pasee");
                            int respuesta2 = Integer.parseInt(question6);
                            mazinger.setPasearPerro(respuesta2);
                            mazinger.pasearPerro();
                            cont++;
                            JOptionPane.showMessageDialog(null, "Tiene " + cont + " de bateria");
                            break;
                        case 6:
                            String question7 = JOptionPane.showInputDialog("Desea que arrulle al bebé");
                            mazinger.setAcunarBebe(true);
                            mazinger.acunarBebe();
                            cont++;
                            JOptionPane.showMessageDialog(null, "Tiene " + cont + " de bateria");
                            break;
                        case 7:
                            String question8 = JOptionPane.showInputDialog("indique cuanta ropa desea lavar, poca, mucha, mediana");
                            mazinger.setLavarRopa(question8);
                            mazinger.lavarRopa();
                            cont++;
                            JOptionPane.showMessageDialog(null, "Tiene " + cont + " de bateria");
                            break;
                        default:
                           JOptionPane.showMessageDialog(null, "Hasta luego");
                           break;
                    }
                    question = JOptionPane.showInputDialog("Desea encender a Mazinger");
                         }while(cont < 3 && question.equals("si"));
                        }else{
                            JOptionPane.showMessageDialog(null, "Hasta luego");
                        }            
    }  
}
