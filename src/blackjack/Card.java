package blackjack;

import javax.swing.ImageIcon;

/**
 * Class that defines a card object and the operations to 
 * be done on it.
 */
public class Card {
	/**
	 * The instance variable for the suit of the card.
	 */
	private final Suit suit;
	/**
	 * The instance variable for the rank of the card.
	 */
	private final Rank rank;
	/**
	 * The instance variable for the image of the card to display.
	 */
	private ImageIcon image;
	/**
	 * The constructor for the card object that sets the rank and set.
	 * @param r the rank of the card
	 * @param s the suit of the card
	 * 
	 */
	public Card(final Rank r, final Suit s) {
		rank = r;
		suit = s;
	}
	/**
	 * The getter for the suit of the card.
	 * @return suit the suit of the card
	 */
	public final Suit getSuit() {
		return suit;
	}
	/**
	 * The getter for the rank of the card.
	 * @return rank the rank of the card
	 */
	public final Rank getRank() {
		return rank;
	}
	/**
	 * Method that sets the image of the card to the provided image.
	 * @param i the image icon to be set to the card
	 */
	public final void setImage(final ImageIcon i) {
		image = i;
	}
	/**
	 * Getter for the image icon of a card.
	 * @return image the image attached to a card object
	 */
	public final ImageIcon getImageIcon() {
		return image;
	}
	
	@Override
	public final String toString() {
		return getRank().getValue() + " of " + getSuit();
	}
	
}
