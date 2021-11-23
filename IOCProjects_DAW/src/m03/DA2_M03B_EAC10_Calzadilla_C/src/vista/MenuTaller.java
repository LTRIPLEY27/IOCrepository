package vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author fta
 */
public class MenuTaller {

    private JFrame frame;

    private JButton[] menuButtons = new JButton[6];

    private final int AMPLADA = 800;
    private final int ALCADA = 600;

    public MenuTaller() {
        /*
        TODO
        
        Amb els atributs d'aquesta classe, heu de fer el següent (no afegiu cap listener a cap control)
            
            - Heu de crear l'objecte JFrame amb títol "Menú Tallers" i layout Grid d'una columna
            
            - Heu de crear els botons del formulari. Cada botó serà un element de l'array de botons amb les següents etiquetes:
                        "0. Sortir"
                        "1. Alta Taller"
                        "2. Seleccionar Taller"
                        "3. Llistar Tallers"
                        "4. Carregar Taller"
                        "5. Desar Taller"
            
            - Heu d'afegir-ho tot al frame
        
            - Heu de fer visible el frame amb l'amplada i alçada de les constants AMPLADA i ALCADA, i fer que la finestra es tanqui 
            quan l'usuari ho fa amb el control "X" de la finestra. Per fer tot això, heu de cridar al mètode showFinestra() d'aquesta
            classe.        
         */
        
        this.frame = new JFrame("Menú Tallers"); // OBJETO JFRAME
        
        this.frame.setLayout(new GridLayout(0, 1)); // VERIFICAR SI CONSTITUYE UNA COLUMNA
        
        this.menuButtons[0] = new JButton("0. Sortir" );
        
        this.menuButtons[1] = new JButton("1. Alta Taller");
        
        this.menuButtons[2] = new JButton("2. Seleccionar Taller");
        
        this.menuButtons[3] = new JButton("3. Llistar Tallers");
        
        this.menuButtons[4] = new JButton("4. Carregar Taller");
        
        this.menuButtons[5] = new JButton("5. Desar Taller");
        
        for(JButton boton : menuButtons) {
            this.frame.add(boton);
        }

       showFinestra();
    }
    
    private void showFinestra(){
        //Es mostra la finestra amb propietats per defecte
        frame.setSize(AMPLADA, ALCADA);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // SALE DE LA APLICACION, CONSTANTE DE CLASE
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
