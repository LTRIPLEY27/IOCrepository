package packageJava.AndroideVersion2;

import java.util.Scanner;
import javax.swing.JOptionPane;
import packageJava.Androide.Androide;

public class Vista {
    // MENÚ PRIMARIO
    public static void startProgram(){
        int cont = 0;
        String name = JOptionPane.showInputDialog("Hola, indique su nombre ");
        String question = JOptionPane.showInputDialog("Desea encender a HAL-9000?").toLowerCase();
            if(question.equals("si")){
                do{
                    String question1 = JOptionPane.showInputDialog("Hola,  " + name + "\n\nsoy HAL-9000, estoy para servirte.\nIndique su elección: \n1.- Robot modo defensa, Mazinger Z \n2.- Robot modo servicios, Robotina \n3.- Robot modo Jugador Data \n4.- Robot modo destrucción T-800  \n8.- Salir");
                    int option = Integer.parseInt(question1);
                    switch (option) {
                        case 1:
                            tunrOffMazinger();//LLAMA AL MÉTODO PARA CREAR EL OBJETO DE CLASE MAZINGER
                            cont++;
                            JOptionPane.showMessageDialog(null, "Tiene " + cont + " de bateria");
                            break;
                        case 2:
                            turnOffRobotina();//LLAMA AL MÉTODO PARA CREAR EL OBJETO DE CLASE ROBOTINA
                            cont++;
                            JOptionPane.showMessageDialog(null, "Tiene " + cont + " de bateria");
                            break;
                        case 3:
                            turnOffData();//LLAMA AL MÉTODO PARA CREAR EL OBJETO DE CLASE DATA
                            cont++;
                            JOptionPane.showMessageDialog(null, "Tiene " + cont + " de bateria");
                            break;
                        case 4:
                            turnOffTerminator();//LLAMA AL MÉTODO PARA CREAR EL OBJETO DE CLASE TERMINATOR
                            cont++;
                            JOptionPane.showMessageDialog(null, "Tiene " + cont + " de bateria");
                            break;
                        default:// CUALQUIER OPCIÓN EXTERNA CIERRA EL MENÚ
                           JOptionPane.showMessageDialog(null, "Hasta luego");
                           break;
                    }
                    question = JOptionPane.showInputDialog("Desea encender a HAL-9000").toLowerCase();
                         }while(cont < 3 && question.equals("si"));// CONDIICONAL DE 3 BATERIAS Y RESPUESTA AFIRMATIVA
        }else{//CONDICIONAL DE RESPUESTA INICIAL NO
            JOptionPane.showMessageDialog(null, "Hasta luego");
            }            
    }  
    
    //MÉTODO DEL OBJETO DE LA CLASE MAZINGER
    public static void tunrOffMazinger(){
         String question2 = JOptionPane.showInputDialog("indique el método elegido para defender \n1.- Ataque en V \n2.- Ataque directo \n3.- Ataque defensivo \n4.- Salir");
         int respuesta = Integer.parseInt(question2);
         if(respuesta != 4){
            MazingerZ mazinger = new MazingerZ(respuesta);
            mazinger.mazAtack();
         }    
    }
    
    //MÉTODO DEL OBJETO DE LA CLASE TERMINATOR
    public static void turnOffTerminator(){
        String year = JOptionPane.showInputDialog("indique el año donde desea que viaje");
        String humans = JOptionPane.showInputDialog("indique la cantidad de humanos que desea que elimine");
        String name = JOptionPane.showInputDialog("indique el nombre de los humanos");
        AndroideT800 terminator = new AndroideT800(year, humans, name);
        terminator.terminatorActivated();
    }
    
    //MÉTODO DEL OBJETO DE LA CLASE DATA
    public static void turnOffData(){
        String question = JOptionPane.showInputDialog("indique el juego a Data \n1.- Ajedrez \n2.- Go \n3.- Basketball \n4.- Salir");
        int respuesta = Integer.parseInt(question);
        if(respuesta != 4){
            String question1 = JOptionPane.showInputDialog("Indique cantidad de jugadores");
            int respuesta1 = Integer.parseInt(question1);
            Data data = new Data(respuesta, respuesta1);
            data.setPlayWithData();
        }
    }
        
    //MÉTODO DEL OBJETO DE LA CLASE ROBOTINA
    public static void turnOffRobotina(){
        Scanner ask = new Scanner(System.in);
        Robotina robotina = new Robotina();
        String question1 = JOptionPane.showInputDialog("Hola señor Sónico\nsoy Robotina y estoy para servirte.\nIndique su elección: \n1.- Servir comida \n2.- Servir café \n3.- Limpiar \n4.- Recoger \n5.- Pasear perro \n6.- Acunar bebé \n7.- Lavar la ropa \n8.- Salir");
                    int option = Integer.parseInt(question1);
                    switch (option) {
                        case 1:
                            String question2 = JOptionPane.showInputDialog("indique la cantidad de comida");
                            int respuesta = Integer.parseInt(question2);
                            robotina.setServirComida(respuesta);
                            robotina.sirveComida();
                            break;
                        case 2:
                            String question3 = JOptionPane.showInputDialog("indique la cantidad de café");
                            int respuesta1 = Integer.parseInt(question3);
                            robotina.setServirCafe(respuesta1);
                            robotina.sirveCafe();
                            break;
                        case 3:
                            String question4 = JOptionPane.showInputDialog("indique si desea que limpie todo");
                            robotina.setLimpiar(true);
                            robotina.limpiar();
                            break;
                        case 4:
                            String question5 = JOptionPane.showInputDialog("indique si desea que recoja algo por ti");
                            robotina.setRecoger(true);
                            robotina.recoge();
                            break;
                        case 5:
                            String question6 = JOptionPane.showInputDialog("indique cuantas mascotas desea que pasee");
                            int respuesta2 = Integer.parseInt(question6);
                            robotina.setPasearPerro(respuesta2);
                            robotina.pasearPerro();
                            break;
                        case 6:
                            String question7 = JOptionPane.showInputDialog("Desea que arrulle al bebé");
                            robotina.setAcunarBebe(true);
                            robotina.acunarBebe();
                            break;
                        case 7:
                            String question8 = JOptionPane.showInputDialog("indique cuanta ropa desea lavar, poca, mucha, mediana");
                            robotina.setLavarRopa(question8);
                            robotina.lavarRopa();
                            break;
                        default:
                           JOptionPane.showMessageDialog(null, "Hasta luego");
                           break;
                    }          
    }  
}