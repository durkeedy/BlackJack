package blackjack;
/**
 * Enum that defines the win status of each player.
 */
public enum WinStatus {
	/**
	 * Status that the game is still going.
	 */
	INPROGRESS,
	/**
	 * Status that the player wins.
	 */
	PLAYERWIN,
	/**
	 * Status that the dealer wins.
	 */
	DEALERWIN,
	/**
	 * Status of the game in case of a tie.
	 */
	PUSH
}
