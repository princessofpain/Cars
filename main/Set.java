package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Set {
	
	private ArrayList<Card> set = new ArrayList<Card>();
	
	public void createSet(Card[] set) {	
		for(Card card: set) {
			this.set.add(card);
		}
	}
	
	public Card[] getSet() {
		Card[] finalSet = set.toArray(new Card[set.size()]);
		return finalSet;
	}
	
	public void add(Card cardToAdd) {
		if(set.size() < 6) {
			set.add(cardToAdd);
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public void remove(Card cardToRemove) {
		if(set.size() > 1) {
			set.remove(cardToRemove);
		} else {
			throw new IndexOutOfBoundsException();
		}

	}
}
