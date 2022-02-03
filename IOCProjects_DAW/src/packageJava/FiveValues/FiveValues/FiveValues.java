package packageJava.FiveValues.FiveValues;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class FiveValues {

    public static void startProgram(){
        String question = JOptionPane.showInputDialog("Indique la opcion de su preferencia \n1.- Verificar Números \n2.- Verificar Letras \n3.- Salir");
        int aux = Integer.parseInt(question);
        if(aux != 3){
            do{
                switch(aux){
                    case 1:
                        numbersVerified();
                        break;
                    case 2:
                        stringsVerified();
                        break;
                }
                question = JOptionPane.showInputDialog("Indique la opcion de su preferencia \n1.- Verificar Números \n2.- Verificar Letras \n3.- Salir");
                aux = Integer.parseInt(question);
            }while(aux != 3);
        }else{
            JOptionPane.showMessageDialog(null, "Hasta luego");
        }
    }
    
    public static void numbersVerified(){
        ArrayList <String> numbers = new ArrayList <String>();
        int cont = 0;
        String question = JOptionPane.showInputDialog("Indique valor");
        do{
            try{
                if(Character.isDigit(question.charAt(0))){
                    numbers.add(question);
                    cont++;
                }
            }catch(Exception ex){

            }
            question = JOptionPane.showInputDialog("Indique valor");
        }while(cont < 5);
        
        for(String valor : numbers){
            System.out.println(valor);
        }
    }
        
    
    public static void stringsVerified(){
        ArrayList letters = new ArrayList();
    }
}
