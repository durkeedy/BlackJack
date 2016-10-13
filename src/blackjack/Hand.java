package blackjack;

import java.util.ArrayList;

/**
 * The class that creates the hand object which is just
 * an array of card objects.
 */
public class Hand {
	/**
	 * The instance variable for the array of card objects.
	 */
	private ArrayList<Card> hand;
	/**
	 * The constructor for the hand object.
	 */
	public Hand() {
		hand = new ArrayList<Card>();
	}
	/**
	 * Method that adds the designated card to the hand.
	 * @param c the card object to be added to the array list
	 */
	public final void addCard(final Card c) {
		hand.add(c);
	}
	/**
	 * Method that returns the total value of the hand by getting
	 * the rank of each card in the hand and totaling them up.
	 * @return total the total value of the hand
	 */
	public final int getHandValue() {
		int total = 0;
		final int aceValue = 11;
		boolean isAce = false;
		for (Card c: hand) {
			if (c.getRank() == Rank.ACE) {
				isAce = true;
			}
			total += c.getRank().getValue();
		} 
		if (isAce && total <= aceValue) {
			total += aceValue - 1;
		}
		return total;
	}
	
	/**
	 * Method that returns the size of the array list hand.
	 * @return int the size of the hand as an integer
	 */
	public final int getSize() {
		return hand.size();
	}
	/**
	 * Method that returns the card object located at the 
	 * given index.
	 * @param index the index in the array list to grab the card from
	 * @return Card the card at the given index in the array list
	 */
	public final Card getCard(final int index) {
		return hand.get(index);
	}
	/**
	 * Method that checks if the hand has "busted" (gone over 21).
	 * @return boolean true if player busts and false if not
	 */
	public final boolean checkBust() {
		final int bustCap = 21;
		return getHandValue() > bustCap;
	}
	
}
