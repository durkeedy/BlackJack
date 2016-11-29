package blackjack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Creates a JPanel for our game.
 */
public class BlackjackPanel extends JPanel {
	/**
	 * Helps in deserialization. Keeps away from unexpected
	 * InvalidClassExceptions
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * A JLabel for the bet.
	 */
	private JLabel betLabel;
	/**
	 * Creates a JLabel for player 1's money.
	 */
	private JLabel money1Label;
	/**
	 * Creates a JLabel for player 2's money.
	 */
	private JLabel money2Label;
	/**
	 * Creates a JLabel for player 3's money.
	 */
	private JLabel money3Label;
	/**
	 * Creates a BlackjackModel.
	 */
	private BlackjackModel model;
	/**
	 * Creates a play JButton.
	 */
	private JButton playButton;
	/**
	 * Creates a quit JButton.
	 */
	private JButton quitButton;
	/**
	 * Creates an options JButton.
	 */
	private JButton optionsButton;
	/**
	 * Creates a hit JButton.
	 */
	private JButton hitButton;
	/**
	 * Creates a stay JButton.
	 */
	private JButton stayButton;
	/**
	 * Creates a logo JLabel.
	 */
	private JLabel logoLabel;
	/**
	 * Creates a ButtonListener.
	 */
	private ButtonListener bListener;
	/**
	 * Creates a north JPanel.
	 */
	private JPanel northPanel;
	/**
	 * Creates a south JPanel.
	 */
	private JPanel southPanel;
	/**
	 * Creates a south JPanel.
	 */
	private JPanel eastPanel;
	/**
	 * Creates a south JPanel.
	 */
	private JPanel westPanel;
	/**
	 * Creates a main JPanel.
	 */
	private JPanel mainPanel;
	/**
	 * an integer to keep track of player 1's bet.
	 */
	private int bet1;
	/**
	 * an integer to keep track of player 2's bet.
	 */
	private int bet2;
	/**
	 * an integer to keep track of player 3's bet.
	 */
	private int bet3;
	/**
	 * an integer to keep track of the number of players.
	 */
	private int numPlayers = 3;
	/**
	 * a double to keep track of player 1's money.
	 */
	private double money1;
	/**
	 * a double to keep track of player 2's money.
	 */
	private double money2;
	/**
	 * a double to keep track of player 3's money.
	 */
	private double money3;
	/**
	 * The starting amount of money.
	 */
	private static final double STARTINGMONEY = 500.0;
	/**
	 * The height of a card.
	 */
	private static final int CARDHEIGHT = 150;
	/**
	 * The width of a card.
	 */
	private static final int CARDWIDTH = 100;
	/**
	 * The height of the logo.
	 */
	private static final int LOGOHEIGHT = 150;
	/**
	 * The width of the logo.
	 */
	private static final int LOGOWIDTH = 400;
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
	 * The maximum number in blackjack.
	 */
	private static final int BLACKJACK = 21;
	/**
	 * The integer five.
	 */
	private static final int FIVE = 5;
	/**
	 * the dimensions of a button.
	 */
	private final Dimension buttonDim = new Dimension(100, 50);
	/**
	 * creates a new GridBagConstraints.
	 */
	private GridBagConstraints c;
	/**
	 * A formatter to format doubles.
	 */
	private NumberFormat formatter;

	/**
	 * The constructor for a BlackjackPanel.
	 */
	public BlackjackPanel() {

		bListener = new ButtonListener();

		money1 = STARTINGMONEY;
		money2 = STARTINGMONEY;
		money3 = STARTINGMONEY;

		betLabel = new JLabel();
		betLabel.setHorizontalAlignment(SwingConstants.CENTER);
		money1Label = new JLabel();
		money1Label.setHorizontalAlignment(SwingConstants.CENTER);
		money1Label.setVerticalAlignment(SwingConstants.NORTH);
		money2Label = new JLabel();
		money2Label.setHorizontalAlignment(SwingConstants.CENTER);
		money3Label = new JLabel();
		money3Label.setHorizontalAlignment(SwingConstants.CENTER);
		money3Label.setVerticalAlignment(SwingConstants.NORTH);

		playButton = new JButton("Play");
		playButton.addActionListener(bListener);
		playButton.setPreferredSize(buttonDim);
		quitButton = new JButton("Quit");
		quitButton.addActionListener(bListener);
		quitButton.setPreferredSize(buttonDim);
		optionsButton = new JButton("Options");
		optionsButton.addActionListener(bListener);
		optionsButton.setPreferredSize(buttonDim);
		hitButton = new JButton("Hit");
		hitButton.addActionListener(bListener);

		stayButton = new JButton("Stay");
		stayButton.addActionListener(bListener);

		mainPanel = new JPanel();

		mainPanel.setLayout(new GridBagLayout());
		c = new GridBagConstraints();

		southPanel = new JPanel();
		northPanel = new JPanel();
		eastPanel = new JPanel();
		westPanel = new JPanel();
		Color color = new Color(RED, GREEN, BLUE);
		northPanel.setBackground(color);
		southPanel.setBackground(color);
		eastPanel.setBackground(color);
		westPanel.setBackground(color);
		mainPanel.setBackground(color);
		southPanel.setLayout(new GridBagLayout());
		eastPanel.setLayout(new GridBagLayout());
		westPanel.setLayout(new GridBagLayout());
		northPanel.setLayout(new GridBagLayout());

		// http://www.sidebolt.com/app/blackjack/
		logoLabel = new JLabel(
				getScaledImage(new ImageIcon("PNG-cards-1.3/blackjack_logo.png").getImage(), LOGOHEIGHT, LOGOWIDTH));

		displayMenu();

	}

	/**
	 * a method that displays the start of the game.
	 */
	private void displayGame() {
		model = new BlackjackModel(numPlayers);
		mainPanel.removeAll();

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

		c.gridx = 1;
		c.gridy = FIVE + 1;
		mainPanel.add(southPanel, c);

		c.gridx = 2;
		c.gridy = FIVE;
		mainPanel.add(eastPanel, c);

		c.gridx = 0;
		c.gridy = FIVE;
		mainPanel.add(westPanel, c);

		c.gridx = 0;
		c.gridy = FIVE + 1;
		mainPanel.add(money3Label, c);

		c.gridx = 2;
		c.gridy = FIVE + 1;
		mainPanel.add(money1Label, c);

		c.gridx = 1;
		c.gridy = FIVE + 2;
		mainPanel.add(money2Label, c);

		add(mainPanel);
		validateBet(1);
		validateBet(2);
		validateBet(3);
		northPanel.removeAll();
		southPanel.removeAll();
		eastPanel.removeAll();
		westPanel.removeAll();
		formatter = NumberFormat.getCurrencyInstance();
		//betLabel.setText(formatter.format(bet));
		money1Label.setText(formatter.format(money1));
		money2Label.setText(formatter.format(money2));
		money3Label.setText(formatter.format(money3));
		for (int i = 1; i <= numPlayers; i++) {
			showPlayerHand(model.getPlayerHand(i));
		}
		showDealerHand(model.getDealerHand());

	}

	/**
	 * a helper method that displays the main menu.
	 */
	private void displayMenu() {
		mainPanel.removeAll();
		c.gridx = 1;
		c.gridy = 1;
		mainPanel.add(playButton, c);

		c.gridx = 1;
		c.gridy = 2;
		mainPanel.add(optionsButton, c);

		c.gridx = 1;
		c.gridy = FIVE - 2;
		mainPanel.add(quitButton, c);

		c.gridx = 1;
		c.gridy = 0;
		mainPanel.add(logoLabel, c);

		add(mainPanel);
		mainPanel.revalidate();
	}

	/**
	 * A helper method that checks if an input string is an Integer.
	 * 
	 * @param input
	 *            an input String
	 * @return - if the String is an Integer
	 */
	private boolean isInteger(final String input) {
		try {
			return Integer.parseInt(input) > 0;
		} catch (NumberFormatException e) {
			if (input == null) {
				displayMenu();
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * a helper method that checks if the bet is valid.
	 */
	private void validateBet(int player) {
		if (player <= numPlayers) {
			double money = 0;
			int bet = 0;
			if (player == 1){
				money = money1;
			}
			else if (player == 2){
				money = money2;
			}
			else if (player == 3){
				money = money3;
			}
			String betString = JOptionPane.showInputDialog(null, "Place your bet: ");
			if (isInteger(betString)) {
				if (betString != null) {
					if (Integer.parseInt(betString) <= money) {
						bet = Integer.parseInt(betString);
						if (player == 1){
							bet1 = bet;
							money1 -= bet;
						}
						else if (player == 2){
							money2 -= bet;
							bet2 = bet;
						}
						else if (player == 3){
							money3 -= bet;
							bet3 = bet;
						}
					} else {
						JOptionPane.showMessageDialog(null, "Bet is too high! Try again.");
						validateBet(player);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Please type a valid number! Try again.");
				validateBet(player);
			}
		}
	}

	/**
	 * a helper method that calculates the earnings from the hand.
	 * 
	 * @param playerh
	 *            is the players hand
	 * @return the amount of money the player now has
	 */
	private double calculateMoney(final int player) {
		final double timeAndAHalf = 2.5;
		Hand playerh = model.getPlayerHand(player);
		double money = 0;
		int bet = 0;
		if (player == 1){
			money = money1;
			bet = bet1;
		}
		else if (player == 2){
			money = money2;
			bet = bet2;
		}
		else if (player == 3){
			money = money3;
			bet = bet3;
		}
		System.out.println(money);
		if (model.getWinStatus(player) == WinStatus.PLAYERWIN && playerh.getSize() == 2
				&& playerh.getHandValue() == BLACKJACK) {
			System.out.println("Blackjack " + player);
			money += (bet * timeAndAHalf);
		} else if (model.getWinStatus(player) == WinStatus.PLAYERWIN) {
			money += bet * 2;
			System.out.println("Win " + player);
		} else if (model.getWinStatus(player) == WinStatus.PUSH) {
			System.out.println("Push " + player);
			money += bet;
		}
		return money;

	}

	public int getNumPlayers() {
		return numPlayers;
	}

	/**
	 * a helper method that shows a players hand.
	 * 
	 * @param playerh
	 *            is the hand that is to be shown
	 */
	private void showPlayerHand(final Hand playerh) {
		if (numPlayers == 1) {
			southPanel.removeAll();
		} else if (numPlayers == 2 && playerh == model.getPlayerHand(2)) {
			westPanel.removeAll();
		} else if (playerh == model.getPlayerHand(1)) {
			eastPanel.removeAll();
		} else if (playerh == model.getPlayerHand(2)) {
			southPanel.removeAll();
		} else if (playerh == model.getPlayerHand(3)) {
			westPanel.removeAll();
		}

		JLabel temp;
		for (int i = 0; i < playerh.getSize(); i++) {
			c.gridx = i;
			c.gridy = FIVE + 1;
			temp = new JLabel(getScaledImage(playerh.getCard(i).getImageIcon().getImage(), CARDHEIGHT, CARDWIDTH));
			temp.setBorder(BorderFactory.createEmptyBorder(FIVE, FIVE, FIVE, FIVE));
			if (numPlayers == 1) {
				southPanel.add(temp, c);
			} else if (numPlayers == 2 && playerh == model.getPlayerHand(2)) {
				westPanel.add(temp, c);
			} else if (playerh == model.getPlayerHand(1)) {
				eastPanel.add(temp, c);
			} else if (playerh == model.getPlayerHand(2)) {
				southPanel.add(temp, c);
			} else if (playerh == model.getPlayerHand(3)) {
				westPanel.add(temp, c);
			}

		}
		if (numPlayers == 1) {
			southPanel.revalidate();
		} else if (numPlayers == 2 && playerh == model.getPlayerHand(2)) {
			westPanel.revalidate();
		} else if (playerh == model.getPlayerHand(1)) {
			eastPanel.revalidate();
		} else if (playerh == model.getPlayerHand(2)) {
			southPanel.revalidate();
		} else if (playerh == model.getPlayerHand(3)) {
			westPanel.revalidate();
		}

	}

	/**
	 * shows a hand with one card face up and one card face down.
	 * 
	 * @param dealerh
	 *            the hand to show
	 */
	private void showDealerHand(final Hand dealerh) {
		JLabel temp;
		c.gridx = 0;
		c.gridy = 0;
		temp = new JLabel(
				getScaledImage(new ImageIcon("PNG-cards-1.3/Card_back.png").getImage(), CARDHEIGHT, CARDWIDTH));
		temp.setBorder(BorderFactory.createEmptyBorder(FIVE, FIVE, FIVE, FIVE));
		northPanel.add(temp, c);
		c.gridx = 1;
		c.gridy = 0;
		temp = new JLabel(getScaledImage(dealerh.getCard(1).getImageIcon().getImage(), CARDHEIGHT, CARDWIDTH));
		temp.setBorder(BorderFactory.createEmptyBorder(FIVE, FIVE, FIVE, FIVE));
		northPanel.add(temp, c);
	}

	/**
	 * shows the dealers turn.
	 * 
	 * @param dealerh
	 *            the dealers hand
	 */
	private void showDealerTurn(final Hand dealerh) {
		northPanel.removeAll();
		JLabel temp;
		for (int i = 0; i < 2; i++) {
			c.gridx = i;
			c.gridy = 0;
			temp = new JLabel(getScaledImage(dealerh.getCard(i).getImageIcon().getImage(), CARDHEIGHT, CARDWIDTH));
			temp.setBorder(BorderFactory.createEmptyBorder(FIVE, FIVE, FIVE, FIVE));
			northPanel.add(temp, c);
		}
		northPanel.repaint();
		northPanel.revalidate();
		for (int i = 2; i < dealerh.getSize(); i++) {
			c.gridx = i;
			c.gridy = 0;
			temp = new JLabel(getScaledImage(dealerh.getCard(i).getImageIcon().getImage(), CARDHEIGHT, CARDWIDTH));
			temp.setBorder(BorderFactory.createEmptyBorder(FIVE, FIVE, FIVE, FIVE));
			northPanel.add(temp, c);
			northPanel.repaint();
		}
	}

	/**
	 * Resizes an images into an image of h height and w width.
	 * 
	 * @param scrImg
	 *            the image to resize
	 * @param h
	 *            the height
	 * @param w
	 *            the width
	 * @return the resized image
	 */
	private static ImageIcon getScaledImage(final Image scrImg, final int h, final int w) {
		Image img = scrImg;
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		g.drawImage(img, 0, 0, w, h, null, null);
		ImageIcon newIcon = new ImageIcon(bi);
		return newIcon;
	}

	/**
	 * Creates a button listener.
	 * 
	 * @author Daniel and Dylan
	 */
	private class ButtonListener implements ActionListener {
		/**
		 * the response from a yes_no_option.
		 */
		private int reply = 1;

		/**
		 * receives the actionEvent and processes it.
		 * 
		 * @param event
		 *            the event to be processed
		 */
		public void actionPerformed(final ActionEvent event) {
			int player = 1;

			if (event.getSource() == playButton) {
				displayGame();
			} else if (event.getSource() == quitButton) {
				System.exit(0);
			} else if (event.getSource() == optionsButton) {
				return;

			} else {
				if (model.getStatus() == GameStatus.PLAYER1TURN) {
					player = 1;
				} else if (model.getStatus() == GameStatus.PLAYER2TURN) {
					player = 2;
				} else if (model.getStatus() == GameStatus.PLAYER3TURN) {
					player = 3;
				}
			}
			if (event.getSource() == hitButton) {
				model.hitCard(player);
				showPlayerHand(model.getPlayerHand(player));
				if (model.getWinStatus(player) == WinStatus.DEALERWIN) {
					if (model.getStatus() == GameStatus.PLAYER1TURN && numPlayers > 1) {
						model.setStatus(GameStatus.PLAYER2TURN);
					} else if (model.getStatus() == GameStatus.PLAYER2TURN && numPlayers > 2) {
						model.setStatus(GameStatus.PLAYER3TURN);
					} else {
						model.dealerAI();
						showDealerTurn(model.getDealerHand());
						money1Label.setText(formatter.format(calculateMoney(1)));
						money2Label.setText(formatter.format(calculateMoney(2)));
						money3Label.setText(formatter.format(calculateMoney(3)));
					}
				}

			} else if (event.getSource() == stayButton) {
				if (model.getStatus() == GameStatus.PLAYER1TURN && numPlayers > 1) {
					model.setStatus(GameStatus.PLAYER2TURN);

				} else if (model.getStatus() == GameStatus.PLAYER2TURN && numPlayers > 2) {
					model.setStatus(GameStatus.PLAYER3TURN);

				} else {
					System.out.println("Dealers Turn");
					model.dealerAI();
					showDealerTurn(model.getDealerHand());
					money1Label.setText(formatter.format(calculateMoney(1)));
					money2Label.setText(formatter.format(calculateMoney(2)));
					money3Label.setText(formatter.format(calculateMoney(3)));
				}
			}
			// reply = JOptionPane.showConfirmDialog(null, "Dealer wins $" + bet
			// * 2 + ", continue playing?", null,
			// JOptionPane.YES_NO_OPTION);
			// } else if (model.getWinStatus() == WinStatus.PLAYERWIN &&
			// model.getPlayerHand().getSize() == 2
			// && model.getPlayerHand().getHandValue() == BLACKJACK) {
			// reply = JOptionPane.showConfirmDialog(null,
			// "BlackJack! You win " + formatter.format(bet * (FIVE / 2)) + ",
			// continue playing?", null,
			// JOptionPane.YES_NO_OPTION);
			// } else if (model.getWinStatus() == WinStatus.PLAYERWIN) {
			// reply = JOptionPane.showConfirmDialog(null, "You win $" + bet * 2
			// + ", continue playing?", null,
			// JOptionPane.YES_NO_OPTION);
			// } else if (model.getWinStatus() == WinStatus.PUSH) {
			// reply = JOptionPane.showConfirmDialog(null, "Push, you keep $" +
			// bet + ", continue playing?", null,
			// JOptionPane.YES_NO_OPTION);
			// } else {
			// return;
			// }
			// if (reply == JOptionPane.YES_OPTION) {
			// displayGame();
			// } else if (reply == JOptionPane.NO_OPTION) {
			// displayMenu();
			// }
		}
	}

}
