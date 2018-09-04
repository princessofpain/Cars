package main;

import java.util.ArrayList;

import com.sun.istack.internal.NotNull;

// how to add the picture?

public class Card {
	
	private int id;
	
	public String brand;
	public String model;
	public Double displacement;
	public Double zeroToHundred;
	public Integer maxSpeed;
	public Integer horsepower;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setCard(String brand, String model, Double displacement, Double zeroToHundred, Integer maxSpeed, Integer horsepower) {	
		
		if(brand == null || model == null || displacement == null || zeroToHundred == null || maxSpeed == null || horsepower == null) {
			throw new IllegalArgumentException(); 
		} else {
			this.brand = brand;
			this.model = model;
			this.displacement = displacement;
			this.zeroToHundred = zeroToHundred;
			this.maxSpeed = maxSpeed;
			this.horsepower = horsepower;
		}
	}
}
