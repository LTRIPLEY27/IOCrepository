package packageJava.RecapitulacionEjercicio;

import javax.swing.JOptionPane;

public class ProgramaTresNumeros {

    public static void main(String[] args) {
        String num1 = JOptionPane.showInputDialog("Indique el número 1");
        int numA = Integer.parseInt(num1);
        String num2 = JOptionPane.showInputDialog("Indique el número 2");
        int numB = Integer.parseInt(num2);
        String num3 = JOptionPane.showInputDialog("Indique el número 3");
        int numC = Integer.parseInt(num3);
       JOptionPane.showMessageDialog(null, ((numA + numB == numC) ? "La suma es igual al número3 =  " + numC  : "La suma no es igual al número3, el total de la suma de los tres números es  " + (numA + numB + numC)));
       
    }
    
}
