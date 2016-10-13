package blackjack;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
/**
 * The class that creates the deck object and the operations
 * that can be done to it.
 * 
 */
public class Deck {
	
	/**
	 * The instance variable for the deck array list.
	 */
	private ArrayList<Card> deck;
	/**
	 * The instance variable for the array list of images associated with
	 * each card in the deck.
	 */
	private ArrayList<ImageIcon> images;
	/**
	 * The final int that stores default deck size.
	 */
	private static final int DECKSIZE = 52;
	/**
	 * The instance variable for the players hand.
	 */
	public Deck() {
		deck = new ArrayList<Card>();
		images = createImages();
		for (Suit s: Suit.values()) {
			for (Rank r: Rank.values()) {
				Card c = new Card(r, s);
				deck.add(c);
			}
		}
		for (int i = 0; i < DECKSIZE; i++) {
			deck.get(i).setImage(images.get(i));
		}
	}
	/**
	 * Method that iterates over the deck unshuffled and adds the image
	 * associated with each card.
	 * @return images the array list holding each image associated with
	 * 					an unshuffled deck
	 */
	private ArrayList<ImageIcon> createImages() {
		images = new ArrayList<ImageIcon>();
		images.add(new ImageIcon("PNG-cards-1.3/ace_of_hearts.png"));
		images.add(new ImageIcon("PNG-cards-1.3/2_of_hearts.png"));
		images.add(new ImageIcon("PNG-cards-1.3/3_of_hearts.png"));
		images.add(new ImageIcon("PNG-cards-1.3/4_of_hearts.png"));
		images.add(new ImageIcon("PNG-cards-1.3/5_of_hearts.png"));
		images.add(new ImageIcon("PNG-cards-1.3/6_of_hearts.png"));
		images.add(new ImageIcon("PNG-cards-1.3/7_of_hearts.png"));
		images.add(new ImageIcon("PNG-cards-1.3/8_of_hearts.png"));
		images.add(new ImageIcon("PNG-cards-1.3/9_of_hearts.png"));
		images.add(new ImageIcon("PNG-cards-1.3/10_of_hearts.png"));
		images.add(new ImageIcon("PNG-cards-1.3/jack_of_hearts.png"));
		images.add(new ImageIcon("PNG-cards-1.3/queen_of_hearts.png"));
		images.add(new ImageIcon("PNG-cards-1.3/king_of_hearts.png"));
		images.add(new ImageIcon("PNG-cards-1.3/ace_of_diamonds.png"));
		images.add(new ImageIcon("PNG-cards-1.3/2_of_diamonds.png"));
		images.add(new ImageIcon("PNG-cards-1.3/3_of_diamonds.png"));
		images.add(new ImageIcon("PNG-cards-1.3/4_of_diamonds.png"));
		images.add(new ImageIcon("PNG-cards-1.3/5_of_diamonds.png"));
		images.add(new ImageIcon("PNG-cards-1.3/6_of_diamonds.png"));
		images.add(new ImageIcon("PNG-cards-1.3/7_of_diamonds.png"));
		images.add(new ImageIcon("PNG-cards-1.3/8_of_diamonds.png"));
		images.add(new ImageIcon("PNG-cards-1.3/9_of_diamonds.png"));
		images.add(new ImageIcon("PNG-cards-1.3/10_of_diamonds.png"));
		images.add(new ImageIcon("PNG-cards-1.3/jack_of_diamonds.png"));
		images.add(new ImageIcon("PNG-cards-1.3/queen_of_diamonds.png"));
		images.add(new ImageIcon("PNG-cards-1.3/king_of_diamonds.png"));
		images.add(new ImageIcon("PNG-cards-1.3/ace_of_spades.png"));
		images.add(new ImageIcon("PNG-cards-1.3/2_of_spades.png"));
		images.add(new ImageIcon("PNG-cards-1.3/3_of_spades.png"));
		images.add(new ImageIcon("PNG-cards-1.3/4_of_spades.png"));
		images.add(new ImageIcon("PNG-cards-1.3/5_of_spades.png"));
		images.add(new ImageIcon("PNG-cards-1.3/6_of_spades.png"));
		images.add(new ImageIcon("PNG-cards-1.3/7_of_spades.png"));
		images.add(new ImageIcon("PNG-cards-1.3/8_of_spades.png"));
		images.add(new ImageIcon("PNG-cards-1.3/9_of_spades.png"));
		images.add(new ImageIcon("PNG-cards-1.3/10_of_spades.png"));
		images.add(new ImageIcon("PNG-cards-1.3/jack_of_spades.png"));
		images.add(new ImageIcon("PNG-cards-1.3/queen_of_spades.png"));
		images.add(new ImageIcon("PNG-cards-1.3/king_of_spades.png"));
		images.add(new ImageIcon("PNG-cards-1.3/ace_of_clubs.png"));
		images.add(new ImageIcon("PNG-cards-1.3/2_of_clubs.png"));
		images.add(new ImageIcon("PNG-cards-1.3/3_of_clubs.png"));
		images.add(new ImageIcon("PNG-cards-1.3/4_of_clubs.png"));
		images.add(new ImageIcon("PNG-cards-1.3/5_of_clubs.png"));
		images.add(new ImageIcon("PNG-cards-1.3/6_of_clubs.png"));
		images.add(new ImageIcon("PNG-cards-1.3/7_of_clubs.png"));
		images.add(new ImageIcon("PNG-cards-1.3/8_of_clubs.png"));
		images.add(new ImageIcon("PNG-cards-1.3/9_of_clubs.png"));
		images.add(new ImageIcon("PNG-cards-1.3/10_of_clubs.png"));
		images.add(new ImageIcon("PNG-cards-1.3/jack_of_clubs.png"));
		images.add(new ImageIcon("PNG-cards-1.3/queen_of_clubs.png"));
		images.add(new ImageIcon("PNG-cards-1.3/king_of_clubs.png"));
		
		return images;
	}
	/**
	 * The method that shuffles the cards in the deck.
	 */
	public final void shuffle() {
		Collections.shuffle(deck);
	}
	/**
	 * The method that draws and returns the top card of the deck
	 * and removes it from the deck.
	 * @return Card the top card of the deck
	 */
	public final Card topCard() {
		Card temp = deck.get(0);
		deck.remove(0);
		return temp;
	}
	
	
}
