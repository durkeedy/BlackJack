package blackjack;

public class Card {
	
//	public enum Suit {HEARTS, DIAMONDS, CLUBS, SPADES}
//	public enum Rank {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}
	
	private final Suit suit;
	private final Rank rank;
	
	public Card(Rank r, Suit s){
		rank = r;
		suit = s;
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}
	
	@Override
	public String toString(){
		return getRank() + " of " + getSuit();
	}
	
}
