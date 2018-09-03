package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import main.Card;

class CardTest {
	
	private Card card;
	
	@BeforeEach
	public void setUp() {
		card = new Card();
	}

	@Test
	void idIsSet() {
		card.setId(1);
		
		assertEquals(1, card.getId());
	}
	
	@Test
	public void nullIsNotProcessed() {
		String brand = "VW";
		String model = "Golf Plus";
		Double displacement = 1.6;
		Double zeroToHundred = null;
		Integer maxSpeed = 180;
		Integer horsepower = 120;
		
		assertThrows(IllegalArgumentException.class, () -> {
			card.setCard(brand, model, displacement, zeroToHundred, maxSpeed, horsepower);
		});
	}
	
	@Nested
	class cardIsSet {	
		private String brand = "VW";
		private String model = "Golf Plus";
		private Double displacement = 1.6;
		private Double zeroToHundred = 12.0;
		private Integer maxSpeed = 180;
		private Integer horsepower = 120;
		
		@BeforeEach
		public void setUp() {
			card.setCard(brand, model, displacement, zeroToHundred, maxSpeed, horsepower);
		}
		
		@Test
		public void brandIsSet() {
			String actualBrand = card.brand;
			assertEquals(brand, actualBrand);
		}

		@Test
		public void modelIsSet() {
			String actualModel = card.model;
			assertEquals(model, actualModel);
		}
		
		@Test
		public void DisplacementIsSet() {
			Double actualDisplacement = card.displacement;
			assertEquals(displacement, actualDisplacement);
		}
		
		@Test
		public void zeroToHundredIsSet() {
			Double actualZeroToHundred = card.zeroToHundred;
			assertEquals(zeroToHundred, actualZeroToHundred);
		}
		
		@Test
		public void maxSpeedIsSet() {
			Integer actualMaxSpeed = card.maxSpeed;
			assertEquals(maxSpeed, actualMaxSpeed);
		}
		
		@Test
		public void horsepowerIsSet() {
			Integer actualHorsepower = card.horsepower;
			assertEquals(horsepower, actualHorsepower);
		}
	}
}
