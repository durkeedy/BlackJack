package blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	ArrayList<Card> deck;
	private int deckSize;
	
	public Deck(){
		deckSize = 52;
		deck = new ArrayList<Card>();
		for (Rank r: Rank.values()){
			for(Suit s: Suit.values()){
				Card c = new Card(r, s);
				deck.add(c);
			}
		}
	}
	
	public void shuffle(){
		Collections.shuffle(deck);
	}
	
	public Card topCard(){
		Card temp = deck.get(0);
		deck.remove(0);
//		for (int i=1; i<deckSize;i++)
//		{
//			deck[i-1]=deck[i];
//		}
//		deckSize--;
		return temp;
	}
	
	
}
