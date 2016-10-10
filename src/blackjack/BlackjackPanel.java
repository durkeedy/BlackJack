package blackjack;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class BlackjackPanel extends JPanel {

	private JLabel betLabel;
	private JLabel handLabel;

	private BlackjackModel model;

	private JButton playButton;
	private JButton quitButton;
	private JButton optionsButton;
	private JButton hitButton;
	private JButton stayButton;

	private JLabel logoLabel;

	private ButtonListener bListener;

	private JPanel northPanel;
	private JPanel southPanel;

	private int bet;
	private String betString;
	
	private JPanel mainPanel;
	
	private final Dimension dim = new Dimension(100, 50);
	private final Dimension panelDim = new Dimension(100, 100);
	
	GridBagConstraints c;

	public BlackjackPanel() {
		
		bListener = new ButtonListener();

		betLabel = new JLabel();
		betLabel.setHorizontalAlignment(SwingConstants.CENTER);
		handLabel = new JLabel();
		handLabel.setHorizontalAlignment(SwingConstants.CENTER);

		playButton = new JButton("Play");
		playButton.addActionListener(bListener);
		playButton.setPreferredSize(dim);
		quitButton = new JButton("Quit");
		quitButton.addActionListener(bListener);
		quitButton.setPreferredSize(dim);
		optionsButton = new JButton("Options");
		optionsButton.addActionListener(bListener);
		optionsButton.setPreferredSize(dim);
		hitButton = new JButton("Hit");
		hitButton.addActionListener(bListener);
		
		stayButton = new JButton("Stay");
		stayButton.addActionListener(bListener);

		mainPanel = new JPanel();
		
		mainPanel.setLayout(new GridBagLayout());
		c = new GridBagConstraints();

		southPanel = new JPanel();
//		southPanel.setLayout(new GridLayout(3, 1));
//		southPanel.setPreferredSize(panelDim);

		logoLabel = new JLabel("BLACKJACK \n\n\n");

		displayMenu();
		
		model = new BlackjackModel();

	}

	private void displayGame() {
//		mainPanel.removeAll();
		mainPanel.removeAll();
//		northPanel.removeAll();

//		northPanel.add(logoLabel);
		c.gridx = 0;
		c.gridy = 1;
		mainPanel.add(hitButton, c);
		c.gridx = 1;
		c.gridy = 1;
		mainPanel.add(betLabel, c);
		c.gridx = 2;
		c.gridy = 1;
		mainPanel.add(stayButton, c);
		c.gridx = 1;
		c.gridy = 5;
		mainPanel.add(handLabel, c);
		add(mainPanel);
//		mainPanel.add(northPanel, BorderLayout.NORTH);
//		mainPanel.add(southPanel, BorderLayout.SOUTH);
//		add(mainPanel, BorderLayout.CENTER);

		validateBet();
		betLabel.setText(betString);
		showHand(model.getPlayerHand());
		
//		mainPanel.revalidate();
//		mainPanel.repaint();

	}

	private void displayMenu() {
//		mainPanel.removeAll();
//		mainPanel.revalidate();
//		mainPanel.repaint();
		c.gridx = 1;
		c.gridy = 1;
		mainPanel.add(playButton, c);
		c.gridx = 1;
		c.gridy = 2;
		mainPanel.add(optionsButton, c);
		c.gridx = 1;
		c.gridy = 3;
		mainPanel.add(quitButton, c);
		c.gridx = 1;
		c.gridy = 0;
		mainPanel.add(logoLabel, c);

		add(mainPanel);

	}

	private static boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private void validateBet() {
		String betString = JOptionPane
				.showInputDialog(null, "Place your bet: ");
		if (isInteger(betString)) {
			this.betString = betString;
			this.bet = Integer.parseInt(betString);
		} else {
			JOptionPane.showMessageDialog(null,
					"Please type a valid integer! Try again.");
			validateBet();
		}
	}

	private void showHand(Hand h){
		handLabel.setText("");
		for(int i = 0; i < h.getSize(); i++){
			handLabel.setText(handLabel.getText() + "  " + h.getCard(i).toString());	
		}
		mainPanel.repaint();
	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == playButton) {
				displayGame();
			} else if (event.getSource() == quitButton) {
				System.exit(0);
			} else if (event.getSource() == optionsButton) {

			} else if (event.getSource() == hitButton) {
				model.hitCard(model.getPlayerHand());
				showHand(model.getPlayerHand());
			} else if (event.getSource() == stayButton) {

			}
		}
	}

}
