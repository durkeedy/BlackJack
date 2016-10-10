package blackjack;

import javax.swing.ImageIcon;

public class Card {
	
	//public enum Suit {HEARTS, DIAMONDS, CLUBS, SPADES}
	//public enum Rank {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}
	
	private final Suit suit;
	private final Rank rank;
	private ImageIcon image;
	
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
	public void setImage(ImageIcon i){
		
	}
	
	public ImageIcon getImage(){
		return image;
	}
	
	@Override
	public String toString(){
		return getRank().getValue() + " of " + getSuit();
	}
	
}
