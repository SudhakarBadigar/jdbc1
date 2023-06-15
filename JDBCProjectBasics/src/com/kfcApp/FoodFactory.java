package com.kfcApp;

public class FoodFactory {
	
	public static kfc getFood(String type){
		if(type.equalsIgnoreCase("Dinning")) {
			System.out.println("Dinning object created");
			return new Dinning();
		}
		else if(type.equalsIgnoreCase("Delivery")) {
			System.out.println("Delivery object created");
			return new Delivery();
			
		}
		else {
			System.out.println("Invalid");
			return null;
		}
		
	}

}
