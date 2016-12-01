package blackjack;

import java.awt.Color;

import javax.swing.JFrame;
/**
 * Displays the GUI for our game.
 */
final class BlackjackGUI {
    /**
     * Empty constructor for this final class.
     */
    private BlackjackGUI() {
        //Does nothing but make Checkstyle happy
    }

    /**
     * The amount of RED in a user created color.
     */
    private static final int RED = 50;
    /**
     * The amount of Green in a user created color.
     */
    private static final int GREEN = 139;
    /**
     * The amount of BLUE in a user created color.
     */
    private static final int BLUE = 50;
    /**
     * The Width of the frame.
     */
    private static final int FRAMEW = 780;
    /**
     * The height of the frame.
     */
    private static final int FRAMEH = 540;

    /**
     * Displays the GUI for our game.
     * @param args lets eclipse run the main
     */
    public static void main(final String[] args) {
        
        
        JFrame frame = new JFrame("BlackJack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BlackjackPanel panel = new BlackjackPanel();        
        Color color = new Color(RED, GREEN, BLUE); 
        panel.setBackground(color);
        frame.getContentPane().add(panel);
        frame.setSize(FRAMEW, FRAMEH);
        frame.setResizable(true);
        frame.setVisible(true);

    }
}

