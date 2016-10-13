package blackjack;

/**
 * Enum that holds the rank and value of each card.
 */
public enum Rank {
	/**
	 * Rank and value of Ace.
	 */
	ACE(1), 
	/**
	 * Rank and value of two.
	 */
	TWO(2), 
	/**
	 * Rank and value of three.
	 */
	THREE(3), 
	/**
	 * Rank and value of four.
	 */
	FOUR(4), 
	/**
	 * Rank and value of five.
	 */
	FIVE(5), 
	/**
	 * Rank and value of six.
	 */
	SIX(6), 
	/**
	 * Rank and value of seven.
	 */
	SEVEN(7), 
	/**
	 * Rank and value of eight.
	 */
	EIGHT(8), 
	/**
	 * Rank and value of nine.
	 */
	NINE(9), 
	/**
	 * Rank and value of ten.
	 */
	TEN(10), 
	/**
	 * Rank and value of Jack.
	 */
	JACK(10), 
	/**
	 * Rank and value of Queen.
	 */
	QUEEN(10), 
	/**
	 * Rank and value of King.
	 */
	KING(10);
	
	/**
	 * The instance variable for the value of a card.
	 */
	private int rank;
	/**
	 * Sets the value of the card to its rank.
	 * @param value the value to set to the card
	 */
	Rank(final int value) {
		rank = value;
	}
	/**
	 * Getter for the value of a card.
	 * @return rank the value of the card
	 */
	public int getValue() { 
		return rank;
	}
}
