package blackjack;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BlackjackPanel extends JPanel {

	private JTextArea temp;
	
	private BlackjackModel model;

	private JButton play;
	private JButton quit;
	private JButton options;
	private JButton hit;
	private JButton stay;
	
	private JLabel logo;

	private ButtonListener bListener;

	private JPanel mainPanel;
	private JPanel northPanel;
	private JPanel southPanel;
	
	

	private int bet;

	public BlackjackPanel() {
		model = new BlackjackModel();
		
		bListener = new ButtonListener();

		temp = new JTextArea();
		
		play = new JButton("Play");
		play.addActionListener(bListener);
		quit = new JButton("Quit");
		quit.addActionListener(bListener);
		options = new JButton("Options");
		options.addActionListener(bListener);
		hit = new JButton("Hit");
		hit.addActionListener(bListener);
		stay = new JButton("Stay");
		stay.addActionListener(bListener);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		
		southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());
		
		logo = new JLabel("BLACKJACK \n\n\n");

		displayMenu();
		

	}
	
	private void displayGame(){
		mainPanel.removeAll();
		mainPanel.revalidate();
		mainPanel.repaint();
		
		southPanel.removeAll();
		northPanel.removeAll();
		
		southPanel.add(temp, BorderLayout.CENTER);
	}
	
	private void displayMenu(){
		mainPanel.removeAll();
		mainPanel.revalidate();
		mainPanel.repaint();
		
		southPanel.add(play, BorderLayout.NORTH);
		southPanel.add(quit, BorderLayout.SOUTH);
		southPanel.add(options, BorderLayout.CENTER);
		northPanel.add(logo, BorderLayout.NORTH);
		
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		add(mainPanel, BorderLayout.CENTER);
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == play){
				displayGame();
			}
			else if(quit == event.getSource()){
				System.exit(0); 
			}
			else if(event.getSource() == options){
				
			}
			else if(event.getSource() == hit){
				
			}
			else if(event.getSource() == stay){
				
			}
		}
	}

}
