package blackjack;

import java.awt.Component;

import javax.swing.JFrame;

public class BlackjackGUI {
	public static void main(String args[]){
		JFrame frame = new JFrame("BlackJack");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BlackjackPanel panel = new BlackjackPanel();
		frame.getContentPane().add(panel);
		
		frame.setSize(650, 740);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
