package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import main.Card;
import main.Set;

class SetTest {
	
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
	public void setIsCreated() {
		set.add(card1);
		set.add(card2);
		set.add(card3);
		set.add(card4);
		set.add(card5);
		set.add(card6);
		
		Card[] actual = set.getSet();
		Card[] expected = { card1, card2, card3, card4, card5, card6 };
		
		assertArrayEquals(expected, actual);
	}
	
	@Nested
	class addToTheSet {
		@Test 
		public void aSingleCardToAnEmptySet() {
			set.add(card3);
			Card[] expected = { card3 };
			Card[] actual = set.getSet();
			
			assertEquals(expected, actual);
		}
		
		@Test
		public void aSingleCardToAPartialSet() {
			Card[] cardsForTheSet = { card1, card2 };
			set.createSet(cardsForTheSet);
			set.add(card5);
			
			Card[] expected = { card1, card2, card5 };
			Card[] actual = set.getSet();
			
			assertArrayEquals(expected, actual);
		}
		
		@Test
		public void cardCannotBeAddedToACompleteSet() {
			Card[] cardsForTheSet = { card1, card2, card3, card4, card5, card6 };
			set.createSet(cardsForTheSet);
			
			assertThrows(IndexOutOfBoundsException.class, () -> {
				set.add(card5);
			});
		}
	}
	
	@Nested
	class removeFromTheSet {
		
		@BeforeEach
		public void setUp() {
			set.add(card1);
			set.add(card2);
			set.add(card3);
			set.add(card4);
			set.add(card5);
			set.add(card6);
		}
		
		@Test
		public void aCard() {
			set.remove(card2);
			Card[] actual = set.getSet();
			Card[] expected = { card1, card3, card4, card5, card6 };
			
			assertArrayEquals(expected, actual);
		}
		
		@Test
		public void aNotExistingCard() {
			brand = "Ford";
			model = "Focus";
			displacement = 1.6;
			zeroToHundred = 10.8;
			maxSpeed = 180; 
			horsepower = 120;
			card = new Card();
			card.setCard(brand, model, displacement, zeroToHundred, maxSpeed, horsepower);
			
			set.remove(card);
			Card[] actual = set.getSet();
			Card[] expected = { card1, card2, card3, card4, card5, card6 };
			
			assertArrayEquals(expected, actual);
		}
		
		@Test
		public void lastCardCannotBeRemoved() {
			set.remove(card6);
			set.remove(card5);
			set.remove(card4);
			set.remove(card3);
			set.remove(card2);
			
			assertThrows(IndexOutOfBoundsException.class, () -> {
				set.remove(card1);
			});
		}
	}
	
	
}
