package blackjack;

public class BlackjackModel {
	
	
	
	public static void main(String args[]){
		Deck d = new Deck();
		Hand playerHand= new Hand();
		Hand dealerHand = new Hand();
		d.shuffle();
		
		dealHands(d, playerHand, dealerHand);
		showHand(playerHand);
		
		hitCard(d, playerHand);
		showHand(playerHand);
			
//		for(int i=0; i<52; i++)
//			System.out.println(d.topCard());
		
		
		//playerHand.addCard(d.topCard());
	}
	
	private static void dealHands(Deck d, Hand h1, Hand h2){
		h1.addCard(d.topCard());
		h2.addCard(d.topCard());	
		h1.addCard(d.topCard());
		h2.addCard(d.topCard());
	}
	
	private static void showHand(Hand h){
		for(int i = 0; i < h.getSize(); i++){
			System.out.println(h.getCard(i));
			
		}
	}
	
	private static void hitCard(Deck d, Hand h){
		h.addCard(d.topCard());
	}
}
