package main;

import java.util.ArrayList;

public class GameLogic {
	
	public String compareCards(String[] myCard, String[] opponentsCard) {
		int allPoints = compareEachValue(myCard, opponentsCard);
		String result = evaluate(allPoints);
		
		return result;
	}
	
	private int compareEachValue(String[] myCard, String[] opponentsCard) {
		int points = 0;
		boolean isTheSame = true;
		
		for(int i = 2; i < 6; i++) {	
			double myValue = Double.parseDouble(myCard[i]);
			double opponentsValue = Double.parseDouble(opponentsCard[i]);
			
			if(myValue > opponentsValue) {
				points++;
				isTheSame = false;
			} 
		}
		
		if(isTheSame) {
			return 7;
		}
		
		return points;
	}
	
	private String evaluate(int allPoints) {
		String result = "";
		
		if(allPoints == 7) {
			result = "It is equal.";
		} else if(allPoints > 2) {
			result = "You win.";
		} else {
			result = "You lose.";
		}
		
		return result;
	}
	
	public String[] calculateRankingOf(String[][] remainingCards) {
		ArrayList<String[]> ranking = new ArrayList<String[]>();
		
		for(String[] card: remainingCards) {
			for(int i = 2; i < 7; i++) {
				
			}
		}
		return null;
	}
}
