package com.pro.sudhi;
//object creation

public class LightFactory {
	public static Iswitch getLight(String type){
		if(type.equalsIgnoreCase("Tubelight")) {
			System.out.println("Tubelight object is created");
			return new Tubelight();
		}
		else if(type.equalsIgnoreCase("Ledlight")){
			System.out.println("Ledlight object is created");
			return new Ledlight();
		}
		else {
			System.err.println("invalid");
			return null;
		}
		
	}
	
}
