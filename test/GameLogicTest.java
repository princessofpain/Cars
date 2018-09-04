package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Card;
import main.GameLogic;
import main.Set;

class GameLogicTest {
	
	private GameLogic game;
	private Set set;
	
	private Card card;
	private Card card1;
	private Card card2;
	private Card card3;
	private Card card4;
	private Card card5;
	private Card card6;
	
	private String brand;
	private String model;
	private Double displacement;
	private Double zeroToHundred;
	private Integer maxSpeed;
	private Integer horsepower;

	@BeforeEach
	public void setUp() {
		game = new GameLogic();
		set = new Set();
		
		brand = "Ford";
		model = "Mustang Shelby GT 640 Golden Snake";
		displacement = 5.5;
		zeroToHundred = 4.5;
		maxSpeed = 140;
		horsepower  = 548;
		card1 = new Card();
		card1.setCard(brand, model, displacement, zeroToHundred, maxSpeed, horsepower);
		
		brand = "Dodge";
		model = "Challenger SRT8";
		displacement = 6.1;
		zeroToHundred = 4.7;
		maxSpeed = 278;
		horsepower  = 431;
		card2 = new Card();
		card2.setCard(brand, model, displacement, zeroToHundred, maxSpeed, horsepower);
		
		brand = "Chevrolet";
		model = "Camaro 2SS Geiger Compressor";
		displacement = 6.2;
		zeroToHundred = 4.8;
		maxSpeed = 250;
		horsepower  = 568;
		card3 = new Card();
		card3.setCard(brand, model, displacement, zeroToHundred, maxSpeed, horsepower);
		
		brand = "Corvette";
		model = "C7 Stingray";
		displacement = 6.2;
		zeroToHundred = 4.2;
		maxSpeed = 290;
		horsepower  = 466;
		card4 = new Card();
		card4.setCard(brand, model, displacement, zeroToHundred, maxSpeed, horsepower);
		
		brand = "Dodge";
		model = "Charger SRT Helicat";
		displacement = 6.2;
		zeroToHundred = 3.7;
		maxSpeed = 320;
		horsepower  = 717;
		card5 = new Card();
		card5.setCard(brand, model, displacement, zeroToHundred, maxSpeed, horsepower);
		
		brand = "Ford";
		model = "Mustang Bullit";
		displacement = 5.0;
		zeroToHundred = 3.9;
		maxSpeed = 262;
		horsepower  = 464;
		card6 = new Card();
		card6.setCard(brand, model, displacement, zeroToHundred, maxSpeed, horsepower);
	}
	
	@Test
	public void myCardIsBetterAndWins() {
		String expected = "You win.";
		String actual = game.compare(card4, card1);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void myCardIsWeakerAndLoses() {
		String expected = "You lose.";
		String actual = game.compare(card1, card4);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void sameValuesMakeCardsEqual() {
		brand = "Dodge";
		model = "Challenger SRT8";
		displacement = 5.5;
		zeroToHundred = 4.5;
		maxSpeed = 140;
		horsepower  = 548;
		Card card7 = new Card();
		card7.setCard(brand, model, displacement, zeroToHundred, maxSpeed, horsepower);
		
		String expected = "It is equal.";
		String actual = game.compare(card1, card7);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void twoWinningValuesMakeCardsEqual() {
		String expected = "It is equal.";
		String actual = game.compare(card1, card2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void rankingOfRemainingCardsIsCorrect() {
		Card[] remainingCards = { card1, card2, card3, card4, card5, card6 };
		Card[] expected = { card5, card4, card3, card2, card1, card6 };
		Card[] actual = game.calculateRankingOf(remainingCards);
		
		assertArrayEquals(expected, actual);
	}
}
