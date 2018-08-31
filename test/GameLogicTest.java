package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.GameLogic;

class GameLogicTest {
	
	private GameLogic game;

	@BeforeEach
	public void setUp() {
		game = new GameLogic();
	}
	
	@Test
	public void myCardIsBetterAndWins() {
		String[] myCard = {"Dodge", "Challenger SRT8", "6.1", "4.7", "278", "431"};
		String[] opponentsCard = {"Ford", "Mustang Shelby GT 640 Golden Snake", "5.5", "4.5", "250", "420"};
		
		String expected = "You win.";
		String actual = game.compare(myCard, opponentsCard);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void myCardIsWeakerAndLoses() {
		String[] myCard = {"Ford", "Mustang Shelby GT 640 Golden Snake", "5.5", "4.5", "250", "420"};
		String[] opponentsCard = {"Dodge", "Challenger SRT8", "6.1", "4.7", "278", "431"};
		
		String expected = "You lose.";
		String actual = game.compare(myCard, opponentsCard);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void sameValuesMakeCardsEqual() {
		String[] myCard = {"Ford", "Mustang Shelby GT 640 Golden Snake", "5.5", "4.5", "250", "548"};
		String[] opponentsCard = {"Dodge", "Challenger SRT8", "5.5", "4.5", "250", "548"};
		
		String expected = "It is equal.";
		String actual = game.compare(myCard, opponentsCard);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void rankingOfRemainingCardsIsCorrect() {
		String[][] remainingCards = {
			{"Ford", "Mustang Shelby GT 640 Golden Snake", "5.5", "4.5", "250", "548"},
			{"Dodge", "Challenger SRT8", "6.1", "4.7", "278", "431"},
			{"Chevrolet", "Camaro 2SS Geiger Compressor", "6.2", "4.8", "250", "568"},
			{"Corvette", "C7 Stingray", "6.2", "4.2", "290", "466"},
			{"Dodge", "Charger SRT Helicat", "6.2", "3.7", "320", "717"},
			{"Ford", "Mustang Bullitt", "5.0", "3.9", "262", "464"}
		};
		
		String[][] expected = {
			{"Dodge", "Charger SRT Helicat", "6.2", "3.7", "320", "717"},
			{"Corvette", "C7 Stingray", "6.2", "4.2", "290", "466"},
			{"Chevrolet", "Camaro 2SS Geiger Compressor", "6.2", "4.8", "250", "568"},
			{"Dodge", "Challenger SRT8", "6.1", "4.7", "278", "431"},
			{"Ford", "Mustang Shelby GT 640 Golden Snake", "5.5", "4.5", "250", "548"},
			{"Ford", "Mustang Bullitt", "5.0", "3.9", "262", "464"}
		};
		
		String[][] actual = game.calculateRankingOf(remainingCards);
		
		assertArrayEquals(expected, actual);
	}
}
