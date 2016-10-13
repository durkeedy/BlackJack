package blackjack;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.Assert;
import org.junit.Test;

public class BlackJackTest {

	@Test
	public void testCardConstructor() {
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				Card c = new Card(r, s);
				Assert.assertNotNull(c);
			}
		}
	}

	@Test
	public void testCardGetters() {
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				Card c = new Card(r, s);
				Assert.assertEquals(s, c.getSuit());
				Assert.assertEquals(r, c.getRank());
			}
		}
	}

	@Test
	public void testCardValue() {
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				Card c = new Card(r, s);
				Assert.assertEquals(c.getRank().getValue(), r.getValue());
			}
		}
	}

	@Test
	public void testImagesCard() {
		Card c = new Card(Rank.TWO, Suit.CLUBS);
		ImageIcon image = new ImageIcon("PNG-card-1.3/2_of_clubs.png");
		c.setImage(image);
		Assert.assertEquals(image, c.getImageIcon());
	}

	@Test
	public void testDeckConstructor() {
		Deck d = new Deck();
		Assert.assertNotNull(d);
	}

	@Test
	public void testTopCard() {
		Deck d = new Deck();
		Assert.assertTrue(d.topCard() instanceof Card);
	}

	@Test
	public void testShuffle() {
		Deck d = new Deck();
		Deck e = new Deck();
		boolean equal = true;
		d.shuffle();
		for (int i = 0; i < 52; i++) {
			if (d.topCard().getRank() != e.topCard().getRank())
				equal = false;
		}
		Assert.assertFalse(equal);
	}

	@Test
	public void testHandConstructor() {
		Hand h = new Hand();
		Assert.assertNotNull(h);
	}

	@Test
	public void testHandAddCard() {
		int i = 0;
		Hand h = new Hand();
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				Card c = new Card(r, s);
				h.addCard(c);
				Assert.assertEquals(c, h.getCard(i));
				i++;
			}
		}
	}

	@Test
	public void testHandValueAceAs11() {
		Hand h = new Hand();
		int handValue = 0;
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				Card c = new Card(r, s);
				h.addCard(c);
				handValue += r.getValue();
				if (r.getValue() == 1)
					handValue += 10;
				if (handValue > 21) {
					h = new Hand();
					handValue = 0;
				}
				Assert.assertEquals(h.getHandValue(), handValue);
			}
		}
	}

	@Test
	public void testHandValueAceAs1() {
		Hand h = new Hand();
		Card c1 = new Card(Rank.TWO, Suit.CLUBS);
		Card c2 = new Card(Rank.KING, Suit.CLUBS);
		h.addCard(c1);
		h.addCard(c2);
		int handValue = 12;
		Assert.assertEquals(h.getHandValue(), handValue);
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				Card c = new Card(r, s);
				h.addCard(c);
				handValue += r.getValue();
				Assert.assertEquals(h.getHandValue(), handValue);

			}
		}
	}

	@Test
	public void testHandSize() {
		Hand h = new Hand();
		int i = 0;
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				Card c = new Card(r, s);
				h.addCard(c);
				i++;
				Assert.assertEquals(h.getSize(), i);
			}
		}
	}

	@Test
	public void testCheckBust() {
		Hand h = new Hand();
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				Card c = new Card(r, s);
				h.addCard(c);
				if (h.getHandValue() > 21)
					Assert.assertTrue(h.checkBust());
				else
					Assert.assertFalse(h.checkBust());
			}
		}
	}
}
