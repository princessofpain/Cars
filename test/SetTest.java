package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Card;
import main.Set;

class SetTest {
	
	private Set set;
	private String[][] details = {
		{"Ford", "Mustang Shelby GT 640 Golden Snake", "5.5", "4.5", "250", "548"},
		{"Dodge", "Challenger SRT8", "6.1", "4.7", "278", "431"},
		{"Chevrolet", "Camaro 2SS Geiger Compressor", "6.2", "4.8", "250", "568"},
		{"Corvette", "C7 Stingray", "6.2", "4.2", "290", "466"},
		{"Dodge", "Charger SRT Helicat", "6.2", "3.7", "320", "717"},
		{"Ford", "Mustang Bullitt", "5.0", "3.9", "262", "464"}
	};
	
	@BeforeEach
	public void setUp() {
		set = new Set();
	}

	@Test
	public void nullIsDetectedInInput() {
		details[5][4] = null;
		set.createSet(details);
		String[][] allCardsOfASet = set.getAllCards();

		assertNull(allCardsOfASet);
	}
	
	@Test
	public void setIsCreated() {
		set.createSet(details);
		String[][] allCardsOfASet = set.getAllCards();

		assertNotNull(allCardsOfASet);
	}
	
	@Test
	public void setIsFilledWithInformation() {
		boolean isTheSame = true;
		set.createSet(details);
		String[][] cardDetails = set.getAllCards();
		
		for(int i = 0; i < 6 && isTheSame; i++) {
			for(int j = 0; j < 6 && isTheSame; j++) {
					if(details[i][j] != cardDetails[i][j]) {
					isTheSame = false;
				}
			}
		}
		
		assertTrue(isTheSame);
	}
}
