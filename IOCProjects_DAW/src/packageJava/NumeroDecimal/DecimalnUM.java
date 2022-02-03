
package packageJava.NumeroDecimal;

import javax.swing.JOptionPane;

public class DecimalnUM {
    public static void decimalVerified() {

         String question = JOptionPane.showInputDialog("indique valor");
        boolean respuesta = false;
        double num = Double.parseDouble(question);
        do {
                try{
                    if(num % 2 != 0){
                        int numero = (int) num;
                        JOptionPane.showMessageDialog(null, "Es un número decimal " + num + " pero ha sido casteado y ahora es " + numero);
                        respuesta = true;
                    }     
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "necesita introducer un número decimal para comprobas y castear");
                     }
                question = JOptionPane.showInputDialog("necesita introducer un número decimal para comprobar y castear");
                num = Double.parseDouble(question);       
       } while(!respuesta);
    }
}
