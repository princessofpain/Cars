package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Card;

class CardTest {
	
	private Card card;
	
	@BeforeEach
	public void setUp() {
		card =  new Card();
	}

	@Test
	void idIsSet() {
		card.setId(1);
		
		assertEquals(1, card.getId());
	}
	
	@Test
	void cardIsSet() {
		String[] information = {"VW", "Golf Plus", "1.6", "12.0", "180", "120"};
		card.setCard(information);
		
		assertArrayEquals(card.getCardInformation(), information);
	}
}
