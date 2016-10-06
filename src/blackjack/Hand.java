package blackjack;

import java.util.ArrayList;

public class Hand {
	
	private ArrayList<Card> hand;
	
	public Hand(){
		hand = new ArrayList<Card>();
	}
	
	public void emptyHand(){
		
	}
	
	public void addCard(Card c){
		hand.add(c);
	}
	
//	public void removeCard(Card c){
//		
//	}
	
	public int getHandValue(){
		int total = 0;
		for(Card c: hand){
			total += c.getRank().getValue();
		}
		return total;
	}
	
	public int getSize(){
		return hand.size();
	}
	
	public Card getCard(int index){
		return hand.get(index);
	}
	
}
