package blackjack;

/**
 * Enum that defines the status of the game.
 */
public enum GameStatus {
	/**
	 * Status that the player wins.
	 */
	PLAYERWIN,
	/**
	 * Status that the dealer wins.
	 */
	DEALERWIN,
	/**
	 * Status of the game still in progress.
	 */
	INPROGRESS, 
	/**
	 * Status of the game in case of a tie.
	 */
	PUSH
}
