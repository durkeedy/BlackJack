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
		boolean isAce = false;
		for(Card c: hand){
			if (c.getRank() == Rank.ACE)
				isAce = true;
			total += c.getRank().getValue();
		}
		if (isAce && total <= 11)
			total += 10;
		return total;
	}
	
	
	
	public int getSize(){
		return hand.size();
	}
	
	public Card getCard(int index){
		return hand.get(index);
	}
	
	public boolean checkBust(){
		return getHandValue() > 21;
	}
	
}
