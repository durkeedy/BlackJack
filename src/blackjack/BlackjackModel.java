package blackjack;

public class BlackjackModel {
	
	private Hand playerHand;
	private Hand dealerHand;
	private Deck d;
	private GameStatus status;
	
	public BlackjackModel(){
		status = GameStatus.INPROGRESS;
		d = new Deck();
		playerHand= new Hand();
		dealerHand = new Hand();
		d.shuffle();
		
		dealHands(d, playerHand, dealerHand);
		
		//showHand(playerHand);
		
		//showHand(playerHand);
//		System.out.println(playerHand.getHandValue());
		
	}
	
//	public static void main(String args[]){
//		Deck d = new Deck();
//		Hand playerHand= new Hand();
//		Hand dealerHand = new Hand();
//		d.shuffle();
//		
//		dealHands(d, playerHand, dealerHand);
//		showHand(playerHand);
//		
//		hitCard(d, playerHand);
//		showHand(playerHand);
//		System.out.println(playerHand.getHandValue());
			
//		for(int i=0; i<52; i++)
//			System.out.println(d.topCard());
		
		
		//playerHand.addCard(d.topCard());
	
	
	private static void dealHands(Deck d, Hand h1, Hand h2){
		h1.addCard(d.topCard());
		h2.addCard(d.topCard());	
		h1.addCard(d.topCard());
		h2.addCard(d.topCard());
	}
	
//	private static void showHand(Hand h){
//		for(int i = 0; i < h.getSize(); i++){
//			System.out.println(h.getCard(i));
//			
//		}
//	}
	
	public void hitCard(Hand h){
		h.addCard(d.topCard());
		if (h.checkBust())
			checkWinner();
	}

	public Hand getPlayerHand() {
		return playerHand;
	}

	public Hand getDealerHand() {
		return dealerHand;
	}
	
	public void dealerAI(){
		while (dealerHand.getHandValue() < 17){
			hitCard(dealerHand);
		}
		checkWinner();
	}
	
	public void checkWinner(){
		if (playerHand.checkBust())
			status = GameStatus.DEALERWIN;
		else if (dealerHand.checkBust())
			status = GameStatus.PLAYERWIN;
		else if (dealerHand.getHandValue() > playerHand.getHandValue())
			status = GameStatus.DEALERWIN;
		else if (dealerHand.getHandValue() < playerHand.getHandValue())
			status = GameStatus.PLAYERWIN;
		else if (dealerHand.getHandValue() == playerHand.getHandValue() && playerHand.getHandValue() == 21 && playerHand.getSize() == 2 && dealerHand.getSize() != 2)
			status = GameStatus.PLAYERWIN;
		else if (dealerHand.getHandValue() == playerHand.getHandValue() && playerHand.getHandValue() == 21 && playerHand.getSize() != 2 && dealerHand.getSize() == 2)
			status = GameStatus.DEALERWIN;
		else
			status = GameStatus.PUSH;
	}

	public GameStatus getStatus(){
		return status;
	}
	
	
	
}
