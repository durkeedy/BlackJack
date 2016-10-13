package blackjack;

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BlackjackGUI {
	public static void main(String args[]){
//		BufferedImage img = null;
//		img = 
//		ImageIcon bg = new ImageIcon("PNG-cards-1.3/background.jpg");
		JFrame frame = new JFrame("BlackJack");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BlackjackPanel panel = new BlackjackPanel();
		Color color = new Color(50,139,50);
		panel.setBackground(color);
		frame.getContentPane().add(panel);
		frame.setSize(650, 740);
		frame.setResizable(false);
		frame.setVisible(true);
//		frame.setContentPane(new JLabel(bg));
//		frame.pack();
	}
}
