package blackjack;

/**
 * The model class of the BlackJack Game, it 
 * controls all of the behind the scenes work 
 * such as shuffling the deck and dealing the hands 
 * and providing the panel class with the info 
 * needed to display output correctly to the user. 
 */
public class BlackjackModel {

	/**
	 * The instance variable for the players hand.
	 */
	private Hand playerHand;
	/**
	 * The instance variable for the dealers hand.
	 */
	private Hand dealerHand;
	/**
	 * The instance variable for the deck.
	 */
	private Deck d;
	/**
	 * The instance variable for the status of the game.
	 */
	private GameStatus status;

	/**
	 * The constructor for the model class which creates and shuffles the deck
	 * and deals the hands.
	 */
	public BlackjackModel() {
		status = GameStatus.INPROGRESS;
		d = new Deck();
		playerHand = new Hand();
		dealerHand = new Hand();
		d.shuffle();

		dealHands(d, playerHand, dealerHand);

	}

	/**
	 * Private method that deals two cards into each of the given hands
	 * from the given deck.
	 * 
	 * @param d the deck to deal from
	 * @param h1 the first hand to deal to
	 * @param h2 the second hand to deal to
	 */
	private static void dealHands(final Deck d, final Hand h1, final Hand h2) {
		h1.addCard(d.topCard());
		h2.addCard(d.topCard());	
		h1.addCard(d.topCard());
		h2.addCard(d.topCard());
	}
	
	/**
	 * Adds the top card from the deck to the hand given as a parameter.
	 * 
	 * @param h the hand to add a card to
	 */
	public final void hitCard(final Hand h) {
		h.addCard(d.topCard());
		if (h.checkBust()) {
			checkWinner();
		}
	}
	/**
	 * Returns the hand object of the player.
	 * @return playerHand the Hand object of the player
	 */
	public final Hand getPlayerHand() {
		return playerHand;
	}
	/**
	 * Returns the hand object of the dealer.
	 * @return dealerHand the Hand object of the dealer
	 */
	public final Hand getDealerHand() {
		return dealerHand;
	}
	/**
	 * Performs the AI of the dealer which is completely 
	 * dictated by the rules.
	 */
	public final void dealerAI() {
		final int dealerHitCap = 17;
		while (dealerHand.getHandValue() < dealerHitCap) {
			hitCard(dealerHand);
		}
		checkWinner();
	}
	/**
	 * Checks for who won the game based on the rules of blackjack 
	 * and then sets the status of the game to whichever is appropriate.
	 */
	public final void checkWinner() {
		final int blackjack = 21;
		if (playerHand.checkBust()) {
			status = GameStatus.DEALERWIN;
		} else if (dealerHand.checkBust()) {
			status = GameStatus.PLAYERWIN;
		} else if (dealerHand.getHandValue() > playerHand.getHandValue()) {
			status = GameStatus.DEALERWIN;
		} else if (dealerHand.getHandValue() < playerHand.getHandValue()) {
			status = GameStatus.PLAYERWIN;
		} else if (dealerHand.getHandValue() == playerHand.getHandValue() 
				&& playerHand.getHandValue() == blackjack 
				&& playerHand.getSize() == 2 && dealerHand.getSize() != 2) {
			status = GameStatus.PLAYERWIN;
		} else if (dealerHand.getHandValue() == playerHand.getHandValue() 
				&& playerHand.getHandValue() == blackjack 
				&& playerHand.getSize() != 2 
				&& dealerHand.getSize() == 2) {
			status = GameStatus.DEALERWIN;
		} else {
			status = GameStatus.PUSH;
		}
	}
	/**
	 * Returns the current status of the game.
	 * @return status the status of the game
	 */
	public final GameStatus getStatus() {
		return status;
	}



}
