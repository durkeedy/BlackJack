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

	@Test
	public void testWinStatus1() {
		for (int players = 1; players < 4; players++) {
			boolean condition1 = false;
			boolean condition2 = false;
			boolean condition3 = false;
			while (condition1 == false || condition2 == false || condition3 == false) {
				BlackjackModel m = new BlackjackModel(players);
				Assert.assertEquals(m.getWinStatus(players), WinStatus.INPROGRESS);
				m.checkWinner(players);
				if (m.getDealerHand().getHandValue() > m.getPlayerHand(players).getHandValue()) {
					Assert.assertEquals(m.getWinStatus(players), WinStatus.DEALERWIN);
					condition1 = true;
				} else if (m.getDealerHand().getHandValue() < m.getPlayerHand(players).getHandValue()) {
					Assert.assertEquals(m.getWinStatus(players), WinStatus.PLAYERWIN);
					condition2 = true;
				} else if (m.getDealerHand().getHandValue() == m.getPlayerHand(players).getHandValue()) {
					Assert.assertEquals(m.getWinStatus(players), WinStatus.PUSH);
					condition3 = true;
				}
			}
			BlackjackModel m = new BlackjackModel(players);
			for (int i = 0; i < 15; i++)
				m.hitCard(players);

			Assert.assertEquals(m.getWinStatus(players), WinStatus.DEALERWIN);
		}
	}

	@Test
	public void testWinStatus() {
		WinStatus s = WinStatus.DEALERWIN;
		Assert.assertEquals(s, WinStatus.DEALERWIN);
		s = WinStatus.PLAYERWIN;
		Assert.assertEquals(s, WinStatus.PLAYERWIN);
		s = WinStatus.INPROGRESS;
		Assert.assertEquals(s, WinStatus.INPROGRESS);
		s = WinStatus.PUSH;
		Assert.assertEquals(s, WinStatus.PUSH);

	}

	@Test
	public void testCheckWinner() {
		for (int players = 1; players < 4; players++) {
			BlackjackModel m = new BlackjackModel(players);
			Assert.assertEquals(m.getWinStatus(players), WinStatus.INPROGRESS);
			int x = 21 - m.getPlayerHand(players).getHandValue();
			Rank r = Rank.KING;
			if (x > 10) {
				m.getPlayerHand(players).addCard(new Card(r, Suit.CLUBS));
				x -= 10;
			}
			if (x <= 10) {
				switch (x) {
				case 1:
					r = Rank.ACE;
					break;
				case 2:
					r = Rank.TWO;
					break;
				case 3:
					r = Rank.THREE;
					break;
				case 4:
					r = Rank.FOUR;
					break;
				case 5:
					r = Rank.FIVE;
					break;
				case 6:
					r = Rank.SIX;
					break;
				case 7:
					r = Rank.SEVEN;
					break;
				case 8:
					r = Rank.EIGHT;
					break;
				case 9:
					r = Rank.NINE;
					break;
				case 10:
					r = Rank.TEN;
					break;
				default:
					break;
				}
				m.getPlayerHand(players).addCard(new Card(r, Suit.CLUBS));
				Assert.assertEquals(m.getPlayerHand(players).getHandValue(), 21);
				if (m.getDealerHand().getHandValue() == 21 && m.getDealerHand().getSize() == 2) {// dealer
																									// blackjack
					m.checkWinner(players);
					Assert.assertEquals(m.getWinStatus(players), WinStatus.DEALERWIN);
				} else {
					m.dealerAI();
					if (m.getDealerHand().getHandValue() == 21) {
						Assert.assertEquals(m.getWinStatus(players), WinStatus.PUSH);
					} else
						Assert.assertEquals(m.getWinStatus(players), WinStatus.PLAYERWIN);
				}
			}
		}
	}

	@Test
	public void testHitCard() {
		for (int players = 1; players < 4; players++) {
			int temp;
			BlackjackModel m = new BlackjackModel(players);
			temp = m.getPlayerHand(players).getSize();
			m.hitCard(players);
			Assert.assertNotEquals(m.getPlayerHand(players).getSize(), temp);
		}
	}

	@Test
	public void testDealerAi() {
		for (int players = 1; players < 4; players++) {
			boolean condition1 = false;
			boolean condition2 = false;
			while (condition1 == false || condition2 == false) {
				BlackjackModel m = new BlackjackModel(players);
				int temp = m.getDealerHand().getSize();
				if (m.getDealerHand().getHandValue() < 17) {
					m.dealerAI();
					condition1 = true;
					Assert.assertNotEquals(m.getDealerHand().getSize(), temp);
				} else if (m.getDealerHand().getHandValue() >= 17) {
					m.dealerAI();
					condition2 = true;
					Assert.assertEquals(m.getDealerHand().getSize(), temp);
				}

			}
		}
	}
}
