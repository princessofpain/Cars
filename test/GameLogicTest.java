package test;

import static org.junit.jupiter.api.Assertions.*;

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
		String[] opponentsCard = {"Ford", "Mustang Shelby GT 640 Golden Snake", "5.5", "4.5", "250", "548"};
		
		String expected = "You win.";
		String actual = game.compareCards(myCard, opponentsCard);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void myCardIsWeakerAndLoses() {
		String[] myCard = {"Ford", "Mustang Shelby GT 640 Golden Snake", "5.5", "4.5", "250", "548"};
		String[] opponentsCard = {"Dodge", "Challenger SRT8", "6.1", "4.7", "278", "431"};
		
		String expected = "You lose.";
		String actual = game.compareCards(myCard, opponentsCard);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void sameValuesMakeCardsEqual() {
		String[] myCard = {"Ford", "Mustang Shelby GT 640 Golden Snake", "5.5", "4.5", "250", "548"};
		String[] opponentsCard = {"Dodge", "Challenger SRT8", "5.5", "4.5", "250", "548"};
		
		String expected = "It is equal.";
		String actual = game.compareCards(myCard, opponentsCard);
		
		assertEquals(expected, actual);
	}
}
