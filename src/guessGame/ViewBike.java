package guessGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno Fernandes
 */
public class ViewBike {

    public static int showMotorcycleQuestion(String description) {
        return JOptionPane.showConfirmDialog(
                null,
                "The bike you think about is " + description + "?",
                "Guess Game 1.0",
                JOptionPane.YES_NO_OPTION
        );
    }

    public static void showGuessed() {
        JOptionPane.showMessageDialog(
                null,
                "Allright!", 
                "Guess Game 1.0",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    
    
    public static String showNewBikeQuestion(){
        return JOptionPane.showInputDialog(
                null,
                "Which bike did you think?", 
                "Guess Game 1.0",
                JOptionPane.QUESTION_MESSAGE
        );
    }
    
    public static String showDifferenceQuestion(String newDescription, String currentDescription){
        return JOptionPane.showInputDialog(
                null,
                newDescription + " is ________ but " + currentDescription + " not.", 
                "Guess Game 1.0",
                JOptionPane.QUESTION_MESSAGE
        );
    }
    
    public static JFrame getMainFrame(ControllerMotorcycles controller) {
        JFrame frame;
        JLabel startLabel = new JLabel("Think on a motorcycle that you like.");
        startLabel.setBounds(55, 50, 280, 50);
        JButton startButton = new JButton("OK");
        startButton.setBounds(110, 100, 95, 30);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.initSearch();
            }
        });

        frame = new JFrame("Guess Game 1.0");
        frame.add(startButton);
        frame.add(startLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(330, 220);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        
        return frame;
    }
    
    
    
}
