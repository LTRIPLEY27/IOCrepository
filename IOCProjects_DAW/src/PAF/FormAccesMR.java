/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PAF;

/**
 *
 * @author isabe
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author root
 */
public class FormAccesMR implements ActionListener {

    private final int AMPLADA = 400;
    private final int ALCADA = 200;

    private JFrame finestra;

    private JLabel pregunta;

    private JButton si;
    private JButton no;

    private boolean resposta;

    public FormAccesMR() {
        /*TODO Heu de crear una finestra com la que es mostra a la imatge, tenint en compte:
           - L'atribut etiqueta i els botons han d'estar incrustats en la finestra directament.
           - L'etiqueta ha de mostrar la pregunta "L'atracció té accés de mobilitat reduïda?"
           - El nom del botó si ha de ser "Sí" i el del botó no a de ser "No"
           - El nom de la finestra ha de ser "Accés de mobilitat reduïda" i les seves mides la dels 
             atributs constants AMPLADA i ALCADA.
           - Heu de respectar el format de la finestra de la imatge.
         */
        
        finestra = new JFrame("Accés de mobilitat reduïda");// NOM FINESTRA
        
        finestra.setLayout(new GridLayout(0,1));
        
        pregunta = new JLabel("L'atracció té accés de mobilitat reduïda?");
        
        
        si = new JButton("Sí");
        
        no = new JButton("No");
        
         // ADICIÓN DE ELEMENTOS AL FRAME
         
         finestra.add(pregunta);
         finestra.add(si);
         finestra.add(no);
         
         finestra.setSize(AMPLADA, ALCADA);
    	 finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    	 finestra.setVisible(true); // hacer visible el frame

    }

    public void afegirListenerBotons() {

        /*TODO
            Heu d'afegir el listener als botons.     
         */
        
        si.addActionListener(this);
        no.addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent esdeveniment) {

        /*TODO
        Quan premem el botó "Sí" assignarem a l'atribut resposta verdader, en cas 
        contrari fals.
         */
        
        if(esdeveniment.getSource() == si) {
            resposta = true;
        } else {
            resposta = false;
        }
    }
}
