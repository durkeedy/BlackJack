package blackjack;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

public class Deck {
	
	ArrayList<Card> deck;
	private static ArrayList<ImageIcon> images;
	private int deckSize;
	
	public Deck(){
		deckSize = 52;
		deck = new ArrayList<Card>();
		images= createImages();
		for(Suit s: Suit.values()){
			for (Rank r: Rank.values()){
				Card c = new Card(r, s);
				deck.add(c);
			}
		}
		for(int i=0;i<52;i++){
			deck.get(i).setImage(images.get(i));
		}
	}
	
//	private static ImageIcon getScaledImage(Image scrImg, int w , int h){
//		Image img = scrImg;
//		BufferedImage bi = new BufferedImage(w, h,
//				BufferedImage.TYPE_INT_ARGB);
//		Graphics g = bi.createGraphics();
//		g.drawImage(img, 0, 0, w, h, null, null);
//		ImageIcon newIcon = new ImageIcon(bi);
//		return newIcon;
//	}
	
	private static ArrayList<ImageIcon> createImages(){
		images = new ArrayList<ImageIcon>();
		images.add(new ImageIcon("PNG-cards-1.3/ace_of_hearts"));
		images.add(new ImageIcon("PNG-cards-1.3/2_of_hearts"));
		images.add(new ImageIcon("PNG-cards-1.3/3_of_hearts"));
		images.add(new ImageIcon("PNG-cards-1.3/4_of_hearts"));
		images.add(new ImageIcon("PNG-cards-1.3/5_of_hearts"));
		images.add(new ImageIcon("PNG-cards-1.3/6_of_hearts"));
		images.add(new ImageIcon("PNG-cards-1.3/7_of_hearts"));
		images.add(new ImageIcon("PNG-cards-1.3/8_of_hearts"));
		images.add(new ImageIcon("PNG-cards-1.3/9_of_hearts"));
		images.add(new ImageIcon("PNG-cards-1.3/10_of_hearts"));
		images.add(new ImageIcon("PNG-cards-1.3/jack_of_hearts"));
		images.add(new ImageIcon("PNG-cards-1.3/queen_of_hearts"));
		images.add(new ImageIcon("PNG-cards-1.3/king_of_hearts"));
		images.add(new ImageIcon("PNG-cards-1.3/ace_of_diamonds"));
		images.add(new ImageIcon("PNG-cards-1.3/2_of_diamonds"));
		images.add(new ImageIcon("PNG-cards-1.3/3_of_diamonds"));
		images.add(new ImageIcon("PNG-cards-1.3/4_of_diamonds"));
		images.add(new ImageIcon("PNG-cards-1.3/5_of_diamonds"));
		images.add(new ImageIcon("PNG-cards-1.3/6_of_diamonds"));
		images.add(new ImageIcon("PNG-cards-1.3/7_of_diamonds"));
		images.add(new ImageIcon("PNG-cards-1.3/8_of_diamonds"));
		images.add(new ImageIcon("PNG-cards-1.3/9_of_diamonds"));
		images.add(new ImageIcon("PNG-cards-1.3/10_of_diamonds"));
		images.add(new ImageIcon("PNG-cards-1.3/jack_of_diamonds"));
		images.add(new ImageIcon("PNG-cards-1.3/queen_of_diamonds"));
		images.add(new ImageIcon("PNG-cards-1.3/king_of_diamonds"));
		images.add(new ImageIcon("PNG-cards-1.3/ace_of_spades"));
		images.add(new ImageIcon("PNG-cards-1.3/2_of_spades"));
		images.add(new ImageIcon("PNG-cards-1.3/3_of_spades"));
		images.add(new ImageIcon("PNG-cards-1.3/4_of_spades"));
		images.add(new ImageIcon("PNG-cards-1.3/5_of_spades"));
		images.add(new ImageIcon("PNG-cards-1.3/6_of_spades"));
		images.add(new ImageIcon("PNG-cards-1.3/7_of_spades"));
		images.add(new ImageIcon("PNG-cards-1.3/8_of_spades"));
		images.add(new ImageIcon("PNG-cards-1.3/9_of_spades"));
		images.add(new ImageIcon("PNG-cards-1.3/10_of_spades"));
		images.add(new ImageIcon("PNG-cards-1.3/jack_of_spades"));
		images.add(new ImageIcon("PNG-cards-1.3/queen_of_spades"));
		images.add(new ImageIcon("PNG-cards-1.3/king_of_spades"));
		images.add(new ImageIcon("PNG-cards-1.3/ace_of_clubs"));
		images.add(new ImageIcon("PNG-cards-1.3/2_of_clubs"));
		images.add(new ImageIcon("PNG-cards-1.3/3_of_clubs"));
		images.add(new ImageIcon("PNG-cards-1.3/4_of_clubs"));
		images.add(new ImageIcon("PNG-cards-1.3/5_of_clubs"));
		images.add(new ImageIcon("PNG-cards-1.3/6_of_clubs"));
		images.add(new ImageIcon("PNG-cards-1.3/7_of_clubs"));
		images.add(new ImageIcon("PNG-cards-1.3/8_of_clubs"));
		images.add(new ImageIcon("PNG-cards-1.3/9_of_clubs"));
		images.add(new ImageIcon("PNG-cards-1.3/10_of_clubs"));
		images.add(new ImageIcon("PNG-cards-1.3/jack_of_clubs"));
		images.add(new ImageIcon("PNG-cards-1.3/queen_of_clubs"));
		images.add(new ImageIcon("PNG-cards-1.3/king_of_clubs"));
		
		return images;
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
