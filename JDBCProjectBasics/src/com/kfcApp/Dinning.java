package com.kfcApp;

public class Dinning implements kfc{

	@Override
	public void payment() {
		System.out.println("cash allowed");
		System.out.println("upi allowed");
		System.out.println("Debit/Credit card  allowed");
	}

	@Override
	public void offer() {
		System.out.println("No Offers for Dinning-in");
	}

	@Override
	public void quantity() {
		System.out.println("Pay for extra items");
	}
	

}
