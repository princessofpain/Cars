package main;

import java.util.ArrayList;

public class GameLogic {
	
	public String compare(String[] myCard, String[] opponentsCard) {
		int allPoints = compareEachValue(myCard, opponentsCard);
		String result = evaluate(allPoints);
		
		return result;
	}
	
	private int compareEachValue(String[] myCard, String[] opponentsCard) {
		int points = 0;
		int hasTheSameValues = 0;
		
		for(int i = 2; i < 6; i++) {	
			double myValue = Double.parseDouble(myCard[i]);
			double opponentsValue = Double.parseDouble(opponentsCard[i]);
			
			if(i == 3 && myValue < opponentsValue) {
				points++;
			} else if(i != 3 && myValue > opponentsValue) {
				points++;
			} else if(myValue == opponentsValue) {
				hasTheSameValues++;
				if(hasTheSameValues == 4) {
					points = 2;
				}
			}
		}

		return points;
	}
	
	private String evaluate(int allPoints) {
		String result = "";
		
		if(allPoints == 2) {
			result = "It is equal.";
		} else if(allPoints > 2) {
			result = "You win.";
		} else {
			result = "You lose.";
		}
		
		return result;
	}
	
	public String[][] calculateRankingOf(String[][] remainingCards) {
		ArrayList<String[]> rankings = new ArrayList<String[]>();
		
		for(String[] card: remainingCards) {
			rankings.add(card);
		}
		
		for(int i = 0; i < remainingCards.length; i++) {
			String[] card = remainingCards[i];
			
			for(int j = 0; j < 6; j++) {
				if(j != i) {
					String[] cardToCompare = remainingCards[j];
					String result = compare(card,cardToCompare);
					
					int indexOriginal = rankings.indexOf(card);
					int indexChange = rankings.indexOf(cardToCompare);

					if(result == "You win." && indexChange < indexOriginal || 
					   result == "You lose." && indexChange > indexOriginal) {
						rankings.set(indexOriginal, cardToCompare);
						rankings.set(indexChange, card);
					} 
				}		
			}
		}
		
		String[][] ranking = rankings.toArray(new String[rankings.size()][6]);
		return ranking;
	}
}
