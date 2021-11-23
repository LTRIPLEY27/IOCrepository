package vista;

import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author fta
 */
public class MenuPrincipal {
    
    private JFrame frame;

    private JButton[] menuButtons = new JButton[3];

    private final int AMPLADA = 800;
    private final int ALCADA = 600;

    public MenuPrincipal() {
        
        /*
        TODO
        
        Amb els atributs d'aquesta classe, heu de fer el següent (no afegiu cap listener a cap control):
            
            - Heu de crear l'objecte JFrame amb títol "Menú Principal" i layout Grid d'una columna
            
            - Heu de crear els botons del formulari. Cada botó serà un element de l'array de botons amb les següents etiquetes:
                        "0. Sortir"
                        "1. Menú Tallers"
                        "2. Menú Recanvi"
        
            - Heu d'afegir-ho tot al frame
        
            - Heu de fer visible el frame amb l'amplada i alçada de les constants AMPLADA i ALCADA, i fer que la finestra es tanqui 
            quan l'usuari ho fa amb el control "X" de la finestra. Per fer tot això, heu de cridar al mètode showFinestra() d'aquesta
            classe.
        
        */   
        
        this.frame = new JFrame("Menú principal"); // INICIALIZACION DEL JFRAME PARA QUE SURTA LA VENTANA
        
        this.frame.setLayout(new GridLayout(0, 1));  // COLUMNAS
        
        this.menuButtons[0] = new JButton("0. Sortir"); // Creamos los botones del menú con la clase Jbutton
        this.menuButtons[1] = new JButton("1. Menú Tallers");
        this.menuButtons[2] = new JButton("2. Menú Recanvi");
        
        
        for(JButton botton : menuButtons) {
            
            this.frame.add(botton); // MIENTRAS RECORRE EL ARRAY DE MENUBUTTONS VA ADHIRIENDO LOS ELEMENTOS AL FRAME
            
        }
       
       showFinestra();// VERIFICAR
        
    }
    
    private void showFinestra(){
        //Es mostra la finestra amb propietats per defecte
        frame.setSize(AMPLADA, ALCADA);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton[] getMenuButtons() {
        return menuButtons;
    }

    public void setMenuButtons(JButton[] menuButtons) {
        this.menuButtons = menuButtons;
    }
}
