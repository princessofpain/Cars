package main;

// how to add the picture?

public class Card {
	
	private String[] information = new String[6];
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	// String[]  information = {brand, model, engine, 0To100, maxSpeed}
	public void setCard(String[] information) {	
		for(int i = 0; i < 6; i++) {
			this.information[i] = information[i];
		}
	}
	
	public String[] getCardInformation() {
		return information;
	}
}
