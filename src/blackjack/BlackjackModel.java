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
	 * The instance variable for the first players hand.
	 */
	private Hand player1Hand;
	/**
	 * The instance variable for the second players hand.
	 */
	private Hand player2Hand;
	/**
	 * The instance variable for the third players hand.
	 */
	private Hand player3Hand;
	/**
	 * The instance variable for the dealers hand.
	 */
	private Hand dealerHand;
	/**
	 * The instance variable for the deck.
	 */
	private Deck d;
	/**
	 * The instance variable for the number of players.
	 */
	private int numPlayers=1;
	/**
	 * The instance variable for the status of the game.
	 */
	private GameStatus status;
	/**
	 * The instance variable for player 1's win status.
	 */
	private WinStatus player1WinStatus;
	/**
	 * The instance variable for player 2's win status.
	 */
	private WinStatus player2WinStatus;
	/**
	 * The instance variable for player 3's win status.
	 */
	private WinStatus player3WinStatus;
	/**
	 * The constructor for the model class which creates and shuffles the deck
	 * and deals the hands.
	 */
	public BlackjackModel(int numPlayers) {
		this.numPlayers=numPlayers;
		status = GameStatus.PLAYER1TURN;
		
		d = new Deck();
		player1Hand = new Hand();
		dealerHand = new Hand();
		if(numPlayers > 1){
			player2Hand = new Hand();
		}
		if(numPlayers > 2){
			player3Hand = new Hand();
		}
		d.shuffle();
		if(numPlayers == 1){
			dealHands(d, player1Hand, dealerHand);
		}
		else if(numPlayers == 2){
			dealHands(d, player1Hand, player2Hand, dealerHand);
		}
		else if(numPlayers == 3){
			dealHands(d, player1Hand, player2Hand, player3Hand, dealerHand);
		}
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
	 * Private method that deals two cards into each of the given hands
	 * from the given deck.
	 * 
	 * @param d the deck to deal from
	 * @param h1 the first hand to deal to
	 * @param h2 the second hand to deal to
	 */
	private static void dealHands(final Deck d, final Hand h1, final Hand h2, final Hand h3) {
		h1.addCard(d.topCard());
		h2.addCard(d.topCard());
		h3.addCard(d.topCard());
		h1.addCard(d.topCard());
		h2.addCard(d.topCard());
		h3.addCard(d.topCard());
	}
	/**
	 * Private method that deals two cards into each of the given hands
	 * from the given deck.
	 * 
	 * @param d the deck to deal from
	 * @param h1 the first hand to deal to
	 * @param h2 the second hand to deal to
	 */
	private static void dealHands(final Deck d, final Hand h1, final Hand h2, final Hand h3, final Hand h4) {
		h1.addCard(d.topCard());
		h2.addCard(d.topCard());
		h3.addCard(d.topCard());
		h4.addCard(d.topCard());
		h1.addCard(d.topCard());
		h2.addCard(d.topCard());
		h3.addCard(d.topCard());
		h4.addCard(d.topCard());
	}
	
	/**
	 * Adds the top card from the deck to the hand given as a parameter.
	 * 
	 * @param h the hand to add a card to
	 */
	public final void hitCard(final int player) {
		Hand h = getPlayerHand(player);
		h.addCard(d.topCard());
		if (h.checkBust()) {
			checkWinner(player);
		}
	}
	
	/**
	 * Returns the hand object of the player.
	 * @return playerHand the Hand object of the player
	 */
	public final Hand getPlayerHand(int playerNum) {
		if(playerNum==1){
			return player1Hand;
		}
		if(playerNum==2){
			return player2Hand;
		}
		if(playerNum==3){
			return player3Hand;
		}
		return null;	
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
			dealerHand.addCard(d.topCard());
		}
		for(int i=0; i<numPlayers; i++){
			checkWinner(i);
		}
	}
	/**
	 * Checks for who won the game based on the rules of blackjack 
	 * and then sets the status of the game to whichever is appropriate.
	 */
	public final void checkWinner(int player){
		final int blackjack = 21;
		Hand playerHand = getPlayerHand(player);
		WinStatus playerWinStatus;
		
		if (playerHand.checkBust()) {
			playerWinStatus = WinStatus.DEALERWIN;
		} else if (dealerHand.checkBust()) {
			playerWinStatus = WinStatus.PLAYERWIN;
		} else if (dealerHand.getHandValue() > playerHand.getHandValue()) {
			playerWinStatus = WinStatus.DEALERWIN;
		} else if (dealerHand.getHandValue() < playerHand.getHandValue()) {
			playerWinStatus = WinStatus.PLAYERWIN;
		} else if (dealerHand.getHandValue() == playerHand.getHandValue() 
				&& playerHand.getHandValue() == blackjack 
				&& playerHand.getSize() == 2 && dealerHand.getSize() != 2) {
			playerWinStatus = WinStatus.PLAYERWIN;
		} else if (dealerHand.getHandValue() == playerHand.getHandValue() 
				&& playerHand.getHandValue() == blackjack 
				&& playerHand.getSize() != 2 
				&& dealerHand.getSize() == 2) {
			playerWinStatus = WinStatus.DEALERWIN;
		} else {
			playerWinStatus = WinStatus.PUSH;
		}
		if(player == 1){
			player1WinStatus = playerWinStatus;
		}
		else if(player == 2){
			player2WinStatus = playerWinStatus;
		}
		else if(player == 3){
			player3WinStatus = playerWinStatus;
		}
	}
	/**
	 * Returns the current status of the game.
	 * @return status the status of the game
	 */
	public final GameStatus getStatus() {
		return status;
	}
	/**
	 * Sets the current status of the game.
	 */
	public final void setStatus( GameStatus status) {
		this.status = status;
	}
	
	public final WinStatus getWinStatus(int player){
		if (player == 1){
			return player1WinStatus;
		}
		else if (player == 2){
			return player2WinStatus;
		}
		else if (player == 3){
			return player3WinStatus;
		}
		else 
			return null;
	}

}
