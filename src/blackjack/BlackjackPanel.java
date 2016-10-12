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
	private JLabel playerHandLabel;
	private JLabel dealerHandLabel;
	private JLabel winnerLabel;

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
		playerHandLabel = new JLabel();
		playerHandLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dealerHandLabel = new JLabel();
		dealerHandLabel.setHorizontalAlignment(SwingConstants.CENTER);
		winnerLabel = new JLabel();
		winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);

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
		northPanel = new JPanel();
		southPanel.setLayout(new GridBagLayout());
		northPanel.setLayout(new GridBagLayout());

		logoLabel = new JLabel("BLACKJACK \n\n\n");

		displayMenu();

	}

	private void displayGame() {
		model = new BlackjackModel();
		// mainPanel.removeAll();
		mainPanel.removeAll();
		northPanel.removeAll();
		southPanel.removeAll();

		// northPanel.add(logoLabel);
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
		c.gridy = 0;
		mainPanel.add(northPanel, c);
		// mainPanel.add(dealerHandLabel, c);
		c.gridx = 1;
		c.gridy = 5;
		mainPanel.add(southPanel, c);
		// add(southPanel, c);
		// mainPanel.add(playerHandLabel, c);
		// c.gridx = 1;
		// c.gridy = 6;
		// mainPanel.add(winnerLabel, c);
		add(mainPanel);
		// mainPanel.add(northPanel, BorderLayout.NORTH);
		// mainPanel.add(southPanel, BorderLayout.SOUTH);
		// add(mainPanel, BorderLayout.CENTER);

		validateBet();
		betLabel.setText(betString);
		showPlayerHand(model.getPlayerHand());
		showDealerHand(model.getDealerHand());

		mainPanel.revalidate();
		mainPanel.repaint();

	}

	private void displayMenu() {
		mainPanel.removeAll();
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
		mainPanel.revalidate();
		// mainPanel.repaint();

	}

	private boolean isInteger(String input) {
		try {
			if (Integer.parseInt(input) > 0)
				return true;
			else
				return false;
		} catch (NumberFormatException e) {
			if (input == null) {
				displayMenu();
				return true;
			} else
				return false;
		}
	}

	private void validateBet() {
		String betString = JOptionPane
				.showInputDialog(null, "Place your bet: ");
		if (isInteger(betString)) {
			this.betString = betString;
			if (betString != null)
				this.bet = Integer.parseInt(betString);

		} else {
			JOptionPane.showMessageDialog(null,
					"Please type a valid bet! Try again.");
			validateBet();
		}
	}

	private void showPlayerHand(Hand playerh) {
		// playerHandLabel.setText("");
		// dealerHandLabel.setText("");
		for (int i = 0; i < playerh.getSize(); i++) {
			c.gridx = i;
			c.gridy = 6;
			southPanel.add(
					new JLabel(getScaledImage(playerh.getCard(i).getImageIcon()
							.getImage(), 150, 100)), c);

		}
		southPanel.revalidate();

	}

	private void showDealerHand(Hand dealerh) {
		c.gridx = 0;
		c.gridy = 0;
		northPanel.add(
				new JLabel(getScaledImage(new ImageIcon(
						"PNG-cards-1.3/Card_back.png").getImage(), 150, 100)),
				c);
		c.gridx = 1;
		c.gridy = 0;
		northPanel.add(
				new JLabel(getScaledImage(dealerh.getCard(1).getImageIcon()
						.getImage(), 150, 100)), c);
	}

	private void showDealerTurn(Hand dealerh) {
		northPanel.removeAll();
		for (int i = 0; i < 2; i++) {
			c.gridx = i;
			c.gridy = 0;
			northPanel.add(
					new JLabel(getScaledImage(dealerh.getCard(i).getImageIcon()
							.getImage(), 150, 100)), c);
		}
		northPanel.repaint();
		northPanel.revalidate();
		for (int i = 2; i < dealerh.getSize(); i++) {
			c.gridx = i;
			c.gridy = 0;
			northPanel.add(
					new JLabel(getScaledImage(dealerh.getCard(i).getImageIcon()
							.getImage(), 150, 100)), c);
			northPanel.revalidate();
			northPanel.repaint();
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static ImageIcon getScaledImage(Image scrImg, int h, int w) {
		Image img = scrImg;
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		g.drawImage(img, 0, 0, w, h, null, null);
		ImageIcon newIcon = new ImageIcon(bi);
		return newIcon;
	}

	private class ButtonListener implements ActionListener {
		int reply = 1;

		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == playButton) {
				displayGame();
			} else if (event.getSource() == quitButton) {
				System.exit(0);
			} else if (event.getSource() == optionsButton) {

			} else if (event.getSource() == hitButton) {
				model.hitCard(model.getPlayerHand());
				showPlayerHand(model.getPlayerHand());
			} else if (event.getSource() == stayButton) {
				model.dealerAI();
				showDealerTurn(model.getDealerHand());
			}

			if (model.getStatus() == GameStatus.DEALERWIN) {
				reply = JOptionPane.showConfirmDialog(null, "Dealer wins "
						+ bet * 2 + ", continue playing?", null,
						JOptionPane.YES_NO_OPTION);
			} else if (model.getStatus() == GameStatus.PLAYERWIN) {
				reply = JOptionPane.showConfirmDialog(null, "You win " + bet
						* 2 + ", continue playing?", null,
						JOptionPane.YES_NO_OPTION);
			} else if (model.getStatus() == GameStatus.PUSH) {
				reply = JOptionPane.showConfirmDialog(null, "Push, you keep "
						+ bet + ", continue playing?", null,
						JOptionPane.YES_NO_OPTION);
			} else {
				return;
			}
			if (reply == JOptionPane.YES_OPTION)
				displayGame();
			else if (reply == JOptionPane.NO_OPTION)
				displayMenu();
		}
	}

}
