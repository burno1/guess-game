package guessGame;

import javax.swing.JFrame;

/**
 *
 * @author Bruno Fernandes
 */
public class JogoGourmet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControllerMotorcycles controller = new ControllerMotorcycles();
        JFrame principal = ViewBike.getMainFrame(controller);
        principal.setVisible(true);
    }
    
}
