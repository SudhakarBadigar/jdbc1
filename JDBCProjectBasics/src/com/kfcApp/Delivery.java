package com.kfcApp;

public class Delivery implements kfc{

	@Override
	public void payment() {
		System.out.println("upi allowed ");
		System.out.println("Debit/credit card allowed");
		System.out.println("No cash-on-delivery");
	}

	@Override
	public void offer() {
		System.out.println("20% off on all Thalis");
	}

	@Override
	public void quantity() {
		System.out.println("extra sides will be added in the pack");
	}

}
