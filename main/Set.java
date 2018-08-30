package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Set {
	
	private String[][] allCards;
	
	public void createSet(String[][] details) {	
		if(detailsAreNotNull(details)) {
			fillSetWithDetails(details);
		} 
	}
	
	private boolean detailsAreNotNull(String[][] details) {
		boolean isNotNull = true;
		
		for(int i = 0; i < 6 && isNotNull; i++) {
			if(Arrays.asList(details[i]).contains(null)) {
				isNotNull = false;
			}
		}
		
		return isNotNull;
	}
	
	private void fillSetWithDetails(String[][] details) {
		ArrayList<String[]> cardInput = new ArrayList<String[]>();
		Card card = new Card();
		
		for(String[] singleCardInformation: details) {
			card.setCard(singleCardInformation);	
			cardInput.add(singleCardInformation);
		}
		
		allCards = cardInput.toArray(new String[6][6]);
	}
	
	public String[][] getAllCards() {
		return allCards;
	}
}
