package com.kfcApp;

import java.util.Scanner;

public class Customer {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How do you like to dine? \n1.Dinning\n2.Delivery");
		String choice = scan.next();
		kfc food = FoodFactory.getFood(choice);
		if(food!=null) 
		{
		food.payment();
		food.offer();
		food.quantity();
		}
	}

}
