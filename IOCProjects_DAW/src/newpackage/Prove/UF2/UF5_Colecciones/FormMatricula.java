/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.Prove.UF2.UF5_Colecciones;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import newpackage.Prove.UF2.UF5.Vaixell;


/**
 *
 * @author isabe
 */
public class FormMatricula implements ActionListener {
        private final int AMPLADA = 250;
        private final int ALCADA = 200;
        private JFrame finestra;
        private JLabel lMatricula;
        private JTextField tMatricula;
        private JButton matricular;

public FormMatricula() {
/*TODO Heu de crear una finestra com la que es mostra a la imatge, tenint en compte:
- L'atribut etiqueta, camp de text i botó han d'estar incrustats en la finestra directament.
- El nom del botó ha de ser "Matricular".
- El nom de la finestra ha de ser "Matriculació vaixell" i les seves mides la dels atributs
constants AMPLADA i ALCADA.
- El camp de text quan obrim la finestra mostrarà "7o-PM-1-01-11" què serà una
matrícula d'exemple.
- Heu de respectar el format de la finestra de la imatge.
*/
    
    finestra = new JFrame("Matriculació vaixell");// CREACION DE LA VENTANA CON EL VALOR DEL ATRIBURO "FINESTRA" Y NOMBRE DEL FORMULARIO
    finestra.setLayout(new GridLayout(0,1));
    
    lMatricula = new JLabel("Matricula");
    
    tMatricula = new JTextField("7o-PM-1-01-11"); // ES EL RECIPIENTE DEL TEXTO A INTRODUCIR POR ENDE SERÁ VACÍO
    matricular = new JButton("Matricular");
    
    // ADICIÓN DE ELEMENTOS AL FRAME
    
    finestra.add(lMatricula);
    finestra.add(tMatricula);
    finestra.add(matricular);
    
    finestra.setSize(AMPLADA, ALCADA);
    finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    finestra.setVisible(true); // hacer visible el frame
    
}

public void afegirListenerBotons() {
//TODO Heu d'afegir el listener al botó.
    matricular.addActionListener(this);// AÑADE UN LISTENER AL BOTÓN
    
}

        @Override
        public void actionPerformed(ActionEvent esdeveniment) {
    Vaixell nouVaixell = new Vaixell(null, "Vaixell", 13.5F, 4);
/*TODO

Quan premem el botó matricular del formulari, hem d'assignar a l'atribut matricula del
nouVaixell el valor introduït per l'usuari mitjançant el formulari.
*/
    if(esdeveniment.getSource() == matricular) {                                            // VERIFICA SI OCURRE EL EVENTO
        tMatricula.setText(String.valueOf(nouVaixell.getMatricula()));                      // TOMA EL VALOR DE LA CAJA TEXTO Y ADJUNTA EL NUEVO VALOR AL OBJETO
        
    }
}
}
