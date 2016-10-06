package blackjack;

public class BlackjackModel {
	
	private Hand playerHand;
	private Hand dealerHand;
	private Deck d;
	
	public BlackjackModel(){
		d = new Deck();
		playerHand= new Hand();
		dealerHand = new Hand();
		d.shuffle();
		
		dealHands(d, playerHand, dealerHand);
		//showHand(playerHand);
		
		//showHand(playerHand);
		System.out.println(playerHand.getHandValue());
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
	}

	public Hand getPlayerHand() {
		return playerHand;
	}

	public Hand getDealerHand() {
		return dealerHand;
	}
	
	public void dealerAI(){
		int dealerHandValue = dealerHand.getHandValue();
		int playerHandValue = playerHand.getHandValue();
		if (dealerHandValue < 17 || dealerHandValue <){
			
		}
	}

	
	
	
}
